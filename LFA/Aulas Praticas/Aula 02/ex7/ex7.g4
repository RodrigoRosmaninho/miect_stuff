grammar ex7;

@parser::header {
    import java.util.HashMap;
}

@parser::members {
    static HashMap<String, Double> vars = new HashMap();
}

program:
    stat* EOF;

stat:
    expr NEWLINE 
    | assign NEWLINE
    | NEWLINE
    ;

assign:
    n=ID '=' val=expr
    ;

expr returns[Double v]:
    op1=expr op=('*'|'/') op2=expr #exprOp
    | op1=expr op=('+'|'-') op2=expr #exprOp
    | n=INT #exprInt
    | id=ID #exprId
    | '(' expr ')' #exprIgnore
    ; 

INT: [0-9]+;
ID: [a-zA-Z_]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;