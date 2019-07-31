grammar ex3b;

program:
    stat* EOF;

stat:
    v=expr NEWLINE {
        System.out.println($v.v);
    }
    | NEWLINE;

expr returns[double v]:
    op1=expr op=('+'|'-'|'*'|'/') op2=expr {   
        switch($op.text + "") {
            case "+":
                $v = $op1.v + $op2.v;
                break;
            case "-":
                $v = $op1.v - $op2.v;
                break;
            case "*":
                $v = $op1.v * $op2.v;
                break;
            case "/":
                $v = $op1.v / $op2.v;
                break;
        }
    }
  | n=INT {
      $v = Integer.parseInt($n.text);
  }
  | '(' expr ')';

INT: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;