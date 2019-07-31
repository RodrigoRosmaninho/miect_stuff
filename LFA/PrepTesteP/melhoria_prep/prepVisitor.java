// Generated from prep.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link prepParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface prepVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link prepParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(prepParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statShow}
	 * labeled alternative in {@link prepParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatShow(prepParser.StatShowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link prepParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssign(prepParser.StatAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueVector}
	 * labeled alternative in {@link prepParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueVector(prepParser.ValueVectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueSign}
	 * labeled alternative in {@link prepParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueSign(prepParser.ValueSignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueProd}
	 * labeled alternative in {@link prepParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueProd(prepParser.ValueProdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueNum}
	 * labeled alternative in {@link prepParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueNum(prepParser.ValueNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueId}
	 * labeled alternative in {@link prepParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueId(prepParser.ValueIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueMult}
	 * labeled alternative in {@link prepParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueMult(prepParser.ValueMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValuePar}
	 * labeled alternative in {@link prepParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuePar(prepParser.ValueParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueSumSub}
	 * labeled alternative in {@link prepParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueSumSub(prepParser.ValueSumSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link prepParser#vector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector(prepParser.VectorContext ctx);
}