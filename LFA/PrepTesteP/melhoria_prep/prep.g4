grammar prep;

program: stat+  EOF;

stat: 'show' value ';'  #statShow
    | value '->' ID ';' #statAssign
    ;

value: '(' value ')'                        #ValuePar
     | op=('+'|'-') value                   #ValueSign
     | op1=value '*' op2=value              #ValueMult
     | op1=value '.' op2=value              #ValueProd
     | op1=value op=('+'|'-') op2=value     #ValueSumSub
     | vector                               #ValueVector
     | NUM                                  #ValueNum
     | ID                                   #ValueId
     ;

vector: '[' NUM (',' NUM)* ']';

// LEXER RULES
NUM: [0-9]+('.'[0-9]+)?;
ID: [a-z][a-z0-9]*;
COMMENT: '#' .*? '\n' -> skip;
WS: [ \t\n] -> skip;
