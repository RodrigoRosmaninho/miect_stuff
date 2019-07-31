import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import java.util.*;
import java.util.stream.*;

public class prepInterp extends prepBaseVisitor<Object>{
    Map<String, Value> symbolTable = new HashMap<>();

	@Override public Object visitProgram(prepParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

	@Override public Object visitStatShow(prepParser.StatShowContext ctx) {
        Object res = visit(ctx.value());
        if(res != null) print(res.toString());
        return null;
    }

	@Override public Object visitStatAssign(prepParser.StatAssignContext ctx) {
        symbolTable.put(ctx.ID().getText(), (Value) visit(ctx.value()));
        return null;
    }

	@Override public Object visitValueVector(prepParser.ValueVectorContext ctx) {
        return visit(ctx.vector());
    }

    @Override public Object visitVector(prepParser.VectorContext ctx) {
        List<Number> nums = ctx.NUM().stream().map(t -> new Number(Double.parseDouble(t.getText()))).collect(Collectors.toList());
        return new Vector(nums);
    }

	@Override public Object visitValueNum(prepParser.ValueNumContext ctx) {
        return new Number(Double.parseDouble(ctx.NUM().getText()));
    }

	@Override public Object visitValueId(prepParser.ValueIdContext ctx) {
        String var = ctx.ID().getText();
        if(!symbolTable.containsKey(var)) {
            printError("Variable " + var + " has not been declared!");
        }
        return symbolTable.get(var);
    }

	@Override public Object visitValuePar(prepParser.ValueParContext ctx) {
        return visit(ctx.value());
    }

    @Override public Object visitValueSign(prepParser.ValueSignContext ctx) {
        Value v = (Value) visit(ctx.value());
        if(ctx.op.getText().equals("-")) v.invert();
        return v;
    }

	@Override public Object visitValueSumSub(prepParser.ValueSumSubContext ctx) {
        Value v1 = (Value) visit(ctx.op1);
        Value v2 = (Value) visit(ctx.op2);

        if(!((v1 instanceof Number && v2 instanceof Number) || (v1 instanceof Vector && v2 instanceof Vector))){
            printError("Addition e Subtraction between Number and Vector not supported.");
        }

        if(ctx.op.getText().equals("+")) return v1.sum(v2);
        else return v1.sub(v2);
    }

    @Override public Object visitValueProd(prepParser.ValueProdContext ctx) {
        Value v1 = (Value) visit(ctx.op1);
        Value v2 = (Value) visit(ctx.op2);

        if(!(v1 instanceof Vector && v2 instanceof Vector)){
            printError("Prod only supported between Vectors");
        }

        return ((Vector) v1).prod((Vector) v2);
    }

	@Override public Object visitValueMult(prepParser.ValueMultContext ctx) {
        Value v1 = (Value) visit(ctx.op1);
        Value v2 = (Value) visit(ctx.op2);

        if(v1 instanceof Vector && v2 instanceof Vector){
            printError("Mult not supported between Vectors");
        }

        return v1.mult(v2);

    }

    // AUX METHODS
    public void print(String str) {
        System.out.println(str);
    }

    public void printError(String str){
        print("Error! " + str);
        System.exit(1);
    }
}
