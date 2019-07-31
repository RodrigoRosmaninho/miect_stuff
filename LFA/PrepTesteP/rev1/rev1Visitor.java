// Generated from rev1.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link rev1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface rev1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link rev1Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(rev1Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printString}
	 * labeled alternative in {@link rev1Parser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintString(rev1Parser.PrintStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignID}
	 * labeled alternative in {@link rev1Parser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignID(rev1Parser.AssignIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concatString}
	 * labeled alternative in {@link rev1Parser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatString(rev1Parser.ConcatStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inputString}
	 * labeled alternative in {@link rev1Parser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputString(rev1Parser.InputStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idString}
	 * labeled alternative in {@link rev1Parser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdString(rev1Parser.IdStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code replaceString}
	 * labeled alternative in {@link rev1Parser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceString(rev1Parser.ReplaceStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link rev1Parser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(rev1Parser.LiteralContext ctx);
}