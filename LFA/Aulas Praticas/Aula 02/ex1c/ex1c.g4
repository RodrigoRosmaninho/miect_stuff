grammar ex1c;                   // Define a grammar called Hello
main : greetings | bye;
greetings : 'hello' ID 
    { System.out.println("Ola " + $ID.text); };        // match keyword hello followed by an identifier
bye : 'bye' ID 
    { System.out.println("Bye " + $ID.text); };        // match keyword hello followed by an identifier
ID : [a-z]+ ;                   // match lower−case identifiers
WS : [ \t\r\n]+ -> skip ;       // skip spaces , tabs , newlines , \r (Windows)