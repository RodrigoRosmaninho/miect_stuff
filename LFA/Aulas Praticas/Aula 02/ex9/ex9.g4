grammar ex9;

@parser::header {
    import java.util.HashMap;
}

@parser::members {
    static HashMap<String, CustomSet> vars = new HashMap();
}

program:
    stat* EOF
    ;

stat:
    expr NEWLINE     #statExpr
    | assign NEWLINE #statAssign
    | NEWLINE        #ignore
    ;

assign:
    n=VAR '=' val=expr;

expr:
    op1=expr '+' op2=expr       #exprUnion
    | op1=expr '&' op2=expr     #exprInterception
    | op1=expr '\\' op2=expr    #exprDifference
    | VAR                       #exprVar
    | SET                       #exprSet
    | '(' expr ')'              #exprPriority
    ;

SET:
    '{' [a-z0-9]* (',' [a-z0-9])*  '}';

COMMENT: '--' ~'\n'* -> skip;
VAR: [A-Z]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;