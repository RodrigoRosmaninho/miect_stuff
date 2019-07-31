import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class rev1Interp extends rev1BaseVisitor<Object> {

    Map<String, String> symbolTable = new HashMap<>();
    Scanner sc;

	public Object visitProgram(rev1Parser.ProgramContext ctx) {
        sc = new Scanner(System.in);
        return visitChildren(ctx);
    }

    public Object visitPrintString(rev1Parser.PrintStringContext ctx) {
        print((String) visit(ctx.string()));
        return null;
    }

	public Object visitIdString(rev1Parser.IdStringContext ctx) {
        String var = ctx.ID().getText();

        if(!symbolTable.containsKey(var)){
            printError("The variable \"" + var + "\" does not exist!");
            System.exit(1);
        }

        return symbolTable.get(var);
    }

    public Object visitAssignID(rev1Parser.AssignIDContext ctx) {
        String var = ctx.ID().getText();
        String val = (String) visit(ctx.string());

        symbolTable.put(var, val);
        return null;
    }

    public Object visitInputString(rev1Parser.InputStringContext ctx) {
        print((String) visit(ctx.string()));
        return sc.nextLine();
    }

    public Object visitLiteral(rev1Parser.LiteralContext ctx) {
        return getString(ctx.LiteralString().getText());
    }

    public Object visitConcatString(rev1Parser.ConcatStringContext ctx) {
        return ((String) visit(ctx.s1)) + ((String) visit(ctx.s2));
    }

    public Object visitReplaceString(rev1Parser.ReplaceStringContext ctx) {
        return ((String) visit(ctx.s1)).replaceAll(((String) visit(ctx.s2)), ((String) visit(ctx.s3)));
    }

    // AUX METHODS

    private String getString(String str){
        return str.replaceAll("\"", "");
    }

    private void printError(String err){
        System.err.println("Error! " + err);
    }

    private void print(String str){
        System.out.println(str);
    }
}
