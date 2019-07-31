// Generated from ex10.g4 by ANTLR 4.7.2

    import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ex10Parser}.
 */
public interface ex10Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ex10Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ex10Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex10Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ex10Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statExpr}
	 * labeled alternative in {@link ex10Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatExpr(ex10Parser.StatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statExpr}
	 * labeled alternative in {@link ex10Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatExpr(ex10Parser.StatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link ex10Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssign(ex10Parser.StatAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link ex10Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssign(ex10Parser.StatAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ignore}
	 * labeled alternative in {@link ex10Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIgnore(ex10Parser.IgnoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ignore}
	 * labeled alternative in {@link ex10Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIgnore(ex10Parser.IgnoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link ex10Parser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ex10Parser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex10Parser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ex10Parser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ex10Parser#fraction}.
	 * @param ctx the parse tree
	 */
	void enterFraction(ex10Parser.FractionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex10Parser#fraction}.
	 * @param ctx the parse tree
	 */
	void exitFraction(ex10Parser.FractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorInt}
	 * labeled alternative in {@link ex10Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorInt(ex10Parser.FactorIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorInt}
	 * labeled alternative in {@link ex10Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorInt(ex10Parser.FactorIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorVar}
	 * labeled alternative in {@link ex10Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorVar(ex10Parser.FactorVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorVar}
	 * labeled alternative in {@link ex10Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorVar(ex10Parser.FactorVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFactor}
	 * labeled alternative in {@link ex10Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprFactor(ex10Parser.ExprFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFactor}
	 * labeled alternative in {@link ex10Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprFactor(ex10Parser.ExprFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFraction}
	 * labeled alternative in {@link ex10Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprFraction(ex10Parser.ExprFractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFraction}
	 * labeled alternative in {@link ex10Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprFraction(ex10Parser.ExprFractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPriority}
	 * labeled alternative in {@link ex10Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPriority(ex10Parser.ExprPriorityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPriority}
	 * labeled alternative in {@link ex10Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPriority(ex10Parser.ExprPriorityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOp}
	 * labeled alternative in {@link ex10Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOp(ex10Parser.ExprOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOp}
	 * labeled alternative in {@link ex10Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOp(ex10Parser.ExprOpContext ctx);
}