public class CustomVisitor extends ex9BaseVisitor<CustomSet> {

    public CustomSet visitStatExpr(ex9Parser.StatExprContext ctx) { 
        System.out.println(visit(ctx.expr()).toString());
        return null;
    }

    public CustomSet visitStatAssign(ex9Parser.StatAssignContext ctx) { 
        System.out.println(visit(ctx.assign()).toString());
        return null;
    }

    public CustomSet visitAssign(ex9Parser.AssignContext ctx) {
        CustomSet obj = visit(ctx.val);
        ex9Parser.vars.put(ctx.n.getText(), obj);
        return obj;
    }

    public CustomSet visitExprUnion(ex9Parser.ExprUnionContext ctx) { 
        CustomSet op1 = visit(ctx.op1);
        CustomSet op2 = visit(ctx.op2);
        return op1.union(op2);
    }

    public CustomSet visitExprInterception(ex9Parser.ExprInterceptionContext ctx) { 
        CustomSet op1 = visit(ctx.op1);
        CustomSet op2 = visit(ctx.op2);
        return op1.interception(op2);
    }

    public CustomSet visitExprDifference(ex9Parser.ExprDifferenceContext ctx) {
        CustomSet op1 = visit(ctx.op1);
        CustomSet op2 = visit(ctx.op2);
        return op1.difference(op2);
    }

    public CustomSet visitExprSet(ex9Parser.ExprSetContext ctx) { 
        return new CustomSet(ctx.SET().getText());
    }

    public CustomSet visitExprVar(ex9Parser.ExprVarContext ctx) { 
        return ex9Parser.vars.get(ctx.VAR().getText());
    }

    public CustomSet visitExprPriority(ex9Parser.ExprPriorityContext ctx) { 
        return visit(ctx.expr());
    }

}