import java.util.HashMap;

public class CustomVisitor extends ex7BaseVisitor<Object> {

    public Object visitStat(ex7Parser.StatContext ctx) { 
        System.out.println(visit(ctx.expr()));
        return null;
    }

    public Object visitAssign(ex7Parser.AssignContext ctx) { 
        ex7Parser.vars.put(ctx.n.toString(), ctx.val.v);
        return visit(ctx.val);
    }
    
    public Object visitExprInt(ex7Parser.ExprIntContext ctx) { 
        ctx.v = Double.parseDouble(ctx.INT().toString());
        return ctx.v.toString();
    }

    public Object visitExprId(ex7Parser.ExprIdContext ctx) { 
        ctx.v = ex7Parser.vars.get(ctx.id.toString());
        if(ctx.v == null) { 
            System.err.printf("Erro! A variável %s não existe!\n", ctx.v);
            System.exit(1); 
        }
        return ctx.v.toString();
    }

    public Object visitExprIgnore(ex7Parser.ExprIgnoreContext ctx) { 
        return visit(ctx.expr()); 
    }

    public Object visitExprOp(ex7Parser.ExprOpContext ctx) { 
        String res = String.format("%s %s %s", visit(ctx.op1), visit(ctx.op2), ctx.op.getText());
        return res;
    }

}