// Generated from ex10.g4 by ANTLR 4.7.2

    import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ex10Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ex10Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ex10Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ex10Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statExpr}
	 * labeled alternative in {@link ex10Parser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatExpr(ex10Parser.StatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link ex10Parser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssign(ex10Parser.StatAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ignore}
	 * labeled alternative in {@link ex10Parser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnore(ex10Parser.IgnoreContext ctx);
	/**
	 * Visit a parse tree produced by {@link ex10Parser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(ex10Parser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ex10Parser#fraction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFraction(ex10Parser.FractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorInt}
	 * labeled alternative in {@link ex10Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorInt(ex10Parser.FactorIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorVar}
	 * labeled alternative in {@link ex10Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorVar(ex10Parser.FactorVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFactor}
	 * labeled alternative in {@link ex10Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFactor(ex10Parser.ExprFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFraction}
	 * labeled alternative in {@link ex10Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFraction(ex10Parser.ExprFractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPriority}
	 * labeled alternative in {@link ex10Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPriority(ex10Parser.ExprPriorityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOp}
	 * labeled alternative in {@link ex10Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOp(ex10Parser.ExprOpContext ctx);
}