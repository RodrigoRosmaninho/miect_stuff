grammar ex3a;

program:
    stat* EOF;

stat:
    expr NEWLINE
    | NEWLINE;

expr returns[double v]:
    expr op=('+'|'-'|'*'|'/') expr
    | INT 
    | '(' expr ')';

INT: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;