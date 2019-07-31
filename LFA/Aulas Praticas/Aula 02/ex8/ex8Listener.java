// Generated from ex8.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ex8Parser}.
 */
public interface ex8Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ex8Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ex8Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex8Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ex8Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ex8Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ex8Parser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex8Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ex8Parser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ex8Parser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(ex8Parser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex8Parser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(ex8Parser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ex8Parser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(ex8Parser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex8Parser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(ex8Parser.AnswerContext ctx);
}