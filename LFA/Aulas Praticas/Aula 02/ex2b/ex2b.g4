grammar ex2b;

program:
    stat* EOF;

stat:
    expr? v=expr NEWLINE {
        System.out.println($v.v);
    };

expr returns[double v]:
    op1=expr op2=expr op=('*'|'/'|'+'|'-') {   
        switch($op.text + ""){
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
    | n=Number {
        $v = Integer.parseInt($n.text);
    };

    

Number: [0-9]+('.'[0-9]+)?;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;