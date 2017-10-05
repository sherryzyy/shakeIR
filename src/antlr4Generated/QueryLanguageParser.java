// Generated from D:\code\shakeIR\src\antlr4Generated\QueryLanguage.g by ANTLR 4.7

package antlr4Generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QueryLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, AND=3, OR=4, NOT=5, LPAR=6, RPAR=7, TERM=8, WS=9;
	public static final int
		RULE_parse = 0, RULE_expr = 1, RULE_nestedExpr = 2, RULE_unaryExpr = 3, 
		RULE_literalExpr = 4, RULE_termExpr = 5, RULE_unaryOp = 6, RULE_binaryOp = 7, 
		RULE_boolean_literal = 8;
	public static final String[] ruleNames = {
		"parse", "expr", "nestedExpr", "unaryExpr", "literalExpr", "termExpr", 
		"unaryOp", "binaryOp", "boolean_literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'true'", "'false'", "'and'", "'or'", "'not'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TRUE", "FALSE", "AND", "OR", "NOT", "LPAR", "RPAR", "TERM", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "QueryLanguage.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QueryLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QueryLanguageParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			expr(0);
			setState(19);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public NestedExprContext nestedExpr() {
			return getRuleContext(NestedExprContext.class,0);
		}
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public LiteralExprContext literalExpr() {
			return getRuleContext(LiteralExprContext.class,0);
		}
		public TermExprContext termExpr() {
			return getRuleContext(TermExprContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryOpContext binaryOp() {
			return getRuleContext(BinaryOpContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(22);
				nestedExpr();
				}
				break;
			case NOT:
				{
				setState(23);
				unaryExpr();
				}
				break;
			case TRUE:
			case FALSE:
				{
				setState(24);
				literalExpr();
				}
				break;
			case TERM:
				{
				setState(25);
				termExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(28);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(29);
					binaryOp();
					setState(30);
					expr(4);
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NestedExprContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(QueryLanguageParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(QueryLanguageParser.RPAR, 0); }
		public NestedExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).enterNestedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).exitNestedExpr(this);
		}
	}

	public final NestedExprContext nestedExpr() throws RecognitionException {
		NestedExprContext _localctx = new NestedExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nestedExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(LPAR);
			setState(38);
			expr(0);
			setState(39);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).exitUnaryExpr(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_unaryExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			unaryOp();
			setState(42);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralExprContext extends ParserRuleContext {
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public LiteralExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).enterLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).exitLiteralExpr(this);
		}
	}

	public final LiteralExprContext literalExpr() throws RecognitionException {
		LiteralExprContext _localctx = new LiteralExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_literalExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			boolean_literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermExprContext extends ParserRuleContext {
		public TerminalNode TERM() { return getToken(QueryLanguageParser.TERM, 0); }
		public TermExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).enterTermExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).exitTermExpr(this);
		}
	}

	public final TermExprContext termExpr() throws RecognitionException {
		TermExprContext _localctx = new TermExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_termExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(TERM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOpContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(QueryLanguageParser.NOT, 0); }
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).exitUnaryOp(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_unaryOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(NOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(QueryLanguageParser.AND, 0); }
		public TerminalNode OR() { return getToken(QueryLanguageParser.OR, 0); }
		public BinaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).enterBinaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).exitBinaryOp(this);
		}
	}

	public final BinaryOpContext binaryOp() throws RecognitionException {
		BinaryOpContext _localctx = new BinaryOpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_binaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_literalContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(QueryLanguageParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(QueryLanguageParser.FALSE, 0); }
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).enterBoolean_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryLanguageListener ) ((QueryLanguageListener)listener).exitBoolean_literal(this);
		}
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\139\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\5\3\35\n\3\3\3\3\3\3\3\3\3\7\3#\n\3\f\3\16\3&\13"+
		"\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\n\2\3\4\13\2\4\6\b\n\f\16\20\22\2\4\3\2\5\6\3\2\3\4\2\63\2\24\3\2\2"+
		"\2\4\34\3\2\2\2\6\'\3\2\2\2\b+\3\2\2\2\n.\3\2\2\2\f\60\3\2\2\2\16\62\3"+
		"\2\2\2\20\64\3\2\2\2\22\66\3\2\2\2\24\25\5\4\3\2\25\26\7\2\2\3\26\3\3"+
		"\2\2\2\27\30\b\3\1\2\30\35\5\6\4\2\31\35\5\b\5\2\32\35\5\n\6\2\33\35\5"+
		"\f\7\2\34\27\3\2\2\2\34\31\3\2\2\2\34\32\3\2\2\2\34\33\3\2\2\2\35$\3\2"+
		"\2\2\36\37\f\5\2\2\37 \5\20\t\2 !\5\4\3\6!#\3\2\2\2\"\36\3\2\2\2#&\3\2"+
		"\2\2$\"\3\2\2\2$%\3\2\2\2%\5\3\2\2\2&$\3\2\2\2\'(\7\b\2\2()\5\4\3\2)*"+
		"\7\t\2\2*\7\3\2\2\2+,\5\16\b\2,-\5\4\3\2-\t\3\2\2\2./\5\22\n\2/\13\3\2"+
		"\2\2\60\61\7\n\2\2\61\r\3\2\2\2\62\63\7\7\2\2\63\17\3\2\2\2\64\65\t\2"+
		"\2\2\65\21\3\2\2\2\66\67\t\3\2\2\67\23\3\2\2\2\4\34$";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}