// Generated from ex8.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ex8Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ex8Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ex8Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ex8Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ex8Parser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(ex8Parser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ex8Parser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(ex8Parser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ex8Parser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(ex8Parser.AnswerContext ctx);
}