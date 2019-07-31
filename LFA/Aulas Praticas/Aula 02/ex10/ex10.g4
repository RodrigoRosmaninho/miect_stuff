grammar ex10;

@parser::header {
    import java.util.HashMap;
}

@parser::members {
    static HashMap<String, Fraction> vars = new HashMap();
}

program:
    stat* EOF
    ;

stat:
    'print' expr ';' NEWLINE    #statExpr
    | assign ';' NEWLINE        #statAssign
    | NEWLINE                   #ignore
    ;

assign:
    val=expr '->' n=VAR;


fraction:
    op1=factor '/' op2=factor;

factor:
    INT       #factorInt
    | VAR     #factorVar
    ;

expr:
    op1=expr op=('*'|':') op2=expr      #exprOp
    | fraction                          #exprFraction
    | op1=expr op=('+'|'-') op2=expr    #exprOp
    | factor                            #exprFactor
    | '(' expr ')'                      #exprPriority
    ;

INT: [0-9]+;
COMMENT: '--' ~'\n'* -> skip;
VAR: [a-zA-Z_]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;