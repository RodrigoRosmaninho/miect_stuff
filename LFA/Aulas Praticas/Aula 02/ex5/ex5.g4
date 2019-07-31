grammar ex5;

@parser::header {
    import java.util.HashMap;
}

@parser::members {
    HashMap<String, Double> vars = new HashMap();
}

program:
    stat* EOF;

stat:
    v=expr NEWLINE {
        System.out.println($v.v);
    }
    | assign NEWLINE
    | NEWLINE
    ;

assign:
    n=ID '=' val=expr {
        vars.put($n.text, $val.v);
    }
    ;

expr returns[Double v]:
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
        $v = Double.parseDouble($n.text);
    }
    | id=ID {
        $v = vars.get($id.text);
        if($v == null) { 
            System.err.printf("Erro! A variável %s não existe!\n", $v);
            System.exit(1); 
        }
    }
    | '(' expr ')';

INT: [0-9]+;
ID: [a-zA-Z_]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;