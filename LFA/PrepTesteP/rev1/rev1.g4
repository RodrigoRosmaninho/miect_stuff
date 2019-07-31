grammar rev1;

program : stat* EOF;

stat : 'print' string   #printString
     | ID ':' string    #assignID
     ;

// a ordem das sub-regras é importante neste caso? o enunciado não especifica prioridades
string : LiteralString                                  #literal
       | 'input(' string ')'                            #inputString
       | ID                                             #idString
       | s1=string '+' s2=string                        #concatString
       | '(' s1=string '/' s2=string '/' s3=string ')'  #replaceString
       ;

LiteralString : '"' .*? '"';
ID : [a-zA-Z] [a-zA-Z0-9]*;
WS : [ \t\n] -> skip;
COMMENT : '//'  .*? '\n' -> skip;
