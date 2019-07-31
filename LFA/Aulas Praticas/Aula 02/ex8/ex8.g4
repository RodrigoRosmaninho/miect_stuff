grammar ex8;

program: 
    stat* EOF;

stat:
    question;

question:
    a=ID '.' b=ID '(' nome=STRING ')' '{' answer+ '}';

answer:
    STRING ':' POINTS ';';


STRING: '"' (ESC | .)*? '"';
POINTS: [0-9] [0-9]? [0-9]?;
ID: [a-zA-Z0-9]+;
fragment ESC: '\\"' | '\\\\'; 
COMMENT: '#' .*? '\n' -> skip;
NEWLINE: '\r'? '\n' -> skip;
WS: [ \t]+ -> skip;
