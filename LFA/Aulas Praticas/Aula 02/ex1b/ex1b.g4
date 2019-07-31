grammar ex1b;                   // Define a grammar called Hello
greetings : 'hello' ID 
    { System.out.println("Ola " + $ID.text); };        // match keyword hello followed by an identifier
ID : [a-z]+ ;                   // match lower−case identifiers
WS : [ \t\r\n]+ -> skip ;       // skip spaces , tabs , newlines , \r (Windows)