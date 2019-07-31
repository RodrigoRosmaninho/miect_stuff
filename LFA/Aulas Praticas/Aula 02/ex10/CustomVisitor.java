public class CustomVisitor extends ex10BaseVisitor<Fraction>{
    public Fraction visitStatExpr(ex10Parser.StatExprContext ctx) {
        System.out.println(visit(ctx.expr()).toString());
        return null; 
    }

    public Fraction visitStatAssign(ex10Parser.StatAssignContext ctx) {
        System.out.println(visit(ctx.assign()).toString());
        return null; 
    }

    public Fraction visitAssign(ex10Parser.AssignContext ctx) { 
        Fraction obj = visit(ctx.val);
        ex10Parser.vars.put(ctx.n.getText(), obj);
        return obj;
    }

    public Fraction visitFraction(ex10Parser.FractionContext ctx) {
        return visit(ctx.op1).divide(visit(ctx.op2));
    }

    public Fraction visitFactorInt(ex10Parser.FactorIntContext ctx) {
        return Fraction.parseFraction(ctx.INT().getText());
    }

    public Fraction visitFactorVar(ex10Parser.FactorVarContext ctx) {
        return ex10Parser.vars.get(ctx.VAR().getText());
    }

    public Fraction visitExprFraction(ex10Parser.ExprFractionContext ctx) {
        return visit(ctx.fraction());
    }

    public Fraction visitExprFactor(ex10Parser.ExprFactorContext ctx) {
        return visit(ctx.factor()); 
    }

    public Fraction visitExprPriority(ex10Parser.ExprPriorityContext ctx) {
        return visit(ctx.expr()); 
    }

    public Fraction visitExprOp(ex10Parser.ExprOpContext ctx) {
        switch(ctx.op.getText() + "") {
            case "+":
                return visit(ctx.op1).add(visit(ctx.op2));
            case "-":
                return visit(ctx.op1).subtract(visit(ctx.op2));
            case "*":
                return visit(ctx.op1).multiply(visit(ctx.op2));
            case ":":
                return visit(ctx.op1).divide(visit(ctx.op2));
        }
        return null;
    }
}