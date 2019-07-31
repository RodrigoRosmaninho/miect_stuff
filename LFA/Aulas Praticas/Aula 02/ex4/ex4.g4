grammar ex4;

program:
    stat* EOF;

stat:
    number* NEWLINE;

number:
    NUM;

NUM:
    [a-z]+
    | [a-z]+ '-' [a-z]+;

NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;

