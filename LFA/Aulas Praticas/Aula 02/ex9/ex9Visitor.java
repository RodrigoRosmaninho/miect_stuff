// Generated from ex9.g4 by ANTLR 4.7.2

    import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ex9Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ex9Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ex9Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ex9Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statExpr}
	 * labeled alternative in {@link ex9Parser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatExpr(ex9Parser.StatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link ex9Parser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssign(ex9Parser.StatAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ignore}
	 * labeled alternative in {@link ex9Parser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnore(ex9Parser.IgnoreContext ctx);
	/**
	 * Visit a parse tree produced by {@link ex9Parser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(ex9Parser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprDifference}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDifference(ex9Parser.ExprDifferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSet}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSet(ex9Parser.ExprSetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprVar}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVar(ex9Parser.ExprVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprUnion}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnion(ex9Parser.ExprUnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprPriority}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPriority(ex9Parser.ExprPriorityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprInterception}
	 * labeled alternative in {@link ex9Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInterception(ex9Parser.ExprInterceptionContext ctx);
}