// Generated from D:\code\shakeIR\src\antlr4Generated\QueryLanguage.g by ANTLR 4.7

package src.antlr4Generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QueryLanguageParser}.
 */
public interface QueryLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QueryLanguageParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(QueryLanguageParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryLanguageParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(QueryLanguageParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(QueryLanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(QueryLanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryLanguageParser#nestedExpr}.
	 * @param ctx the parse tree
	 */
	void enterNestedExpr(QueryLanguageParser.NestedExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryLanguageParser#nestedExpr}.
	 * @param ctx the parse tree
	 */
	void exitNestedExpr(QueryLanguageParser.NestedExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryLanguageParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(QueryLanguageParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryLanguageParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(QueryLanguageParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryLanguageParser#literalExpr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(QueryLanguageParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryLanguageParser#literalExpr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(QueryLanguageParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryLanguageParser#termExpr}.
	 * @param ctx the parse tree
	 */
	void enterTermExpr(QueryLanguageParser.TermExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryLanguageParser#termExpr}.
	 * @param ctx the parse tree
	 */
	void exitTermExpr(QueryLanguageParser.TermExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryLanguageParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(QueryLanguageParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryLanguageParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(QueryLanguageParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryLanguageParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(QueryLanguageParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryLanguageParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(QueryLanguageParser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryLanguageParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(QueryLanguageParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryLanguageParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(QueryLanguageParser.Boolean_literalContext ctx);
}