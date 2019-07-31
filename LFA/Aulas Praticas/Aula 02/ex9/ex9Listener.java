// Generated from ex9.g4 by ANTLR 4.7.2

    import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ex9Parser}.
 */
public interface ex9Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ex9Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ex9Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex9Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ex9Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statExpr}
	 * labeled alternative in {@link ex9Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatExpr(ex9Parser.StatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statExpr}
	 * labeled alternative in {@link ex9Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatExpr(ex9Parser.StatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link ex9Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssign(ex9Parser.StatAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link ex9Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssign(ex9Parser.StatAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ignore}
	 * labeled alternative in {@link ex9Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIgnore(ex9Parser.IgnoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ignore}
	 * labeled alternative in {@link ex9Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIgnore(ex9Parser.IgnoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link ex9Parser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ex9Parser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex9Parser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ex9Parser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprDifference}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprDifference(ex9Parser.ExprDifferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprDifference}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprDifference(ex9Parser.ExprDifferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSet}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSet(ex9Parser.ExprSetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSet}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSet(ex9Parser.ExprSetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprVar}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprVar(ex9Parser.ExprVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprVar}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprVar(ex9Parser.ExprVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprUnion}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnion(ex9Parser.ExprUnionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprUnion}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnion(ex9Parser.ExprUnionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPriority}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPriority(ex9Parser.ExprPriorityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPriority}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPriority(ex9Parser.ExprPriorityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInterception}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInterception(ex9Parser.ExprInterceptionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInterception}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInterception(ex9Parser.ExprInterceptionContext ctx);
}