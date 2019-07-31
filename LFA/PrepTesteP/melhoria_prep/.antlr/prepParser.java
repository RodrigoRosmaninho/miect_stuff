// Generated from /home/rrosmaninho/Repos/miect-stuff/LFA/PrepTesteP/melhoria_prep/prep.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class prepParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, NUM=13, ID=14, COMMENT=15, WS=16;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_value = 2, RULE_vector = 3;
	public static final String[] ruleNames = {
		"program", "stat", "value", "vector"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'show'", "';'", "'->'", "'('", "')'", "'+'", "'-'", "'*'", "'.'", 
		"'['", "','", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "NUM", "ID", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "prep.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public prepParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(prepParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8);
				stat();
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << T__9) | (1L << NUM) | (1L << ID))) != 0) );
			setState(13);
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatAssignContext extends StatContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ID() { return getToken(prepParser.ID, 0); }
		public StatAssignContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class StatShowContext extends StatContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public StatShowContext(StatContext ctx) { copyFrom(ctx); }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(24);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new StatShowContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(15);
				match(T__0);
				setState(16);
				value(0);
				setState(17);
				match(T__1);
				}
				break;
			case T__3:
			case T__5:
			case T__6:
			case T__9:
			case NUM:
			case ID:
				_localctx = new StatAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				value(0);
				setState(20);
				match(T__2);
				setState(21);
				match(ID);
				setState(22);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueVectorContext extends ValueContext {
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public ValueVectorContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueSignContext extends ValueContext {
		public Token op;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueSignContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueProdContext extends ValueContext {
		public ValueContext op1;
		public ValueContext op2;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ValueProdContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueNumContext extends ValueContext {
		public TerminalNode NUM() { return getToken(prepParser.NUM, 0); }
		public ValueNumContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueIdContext extends ValueContext {
		public TerminalNode ID() { return getToken(prepParser.ID, 0); }
		public ValueIdContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueMultContext extends ValueContext {
		public ValueContext op1;
		public ValueContext op2;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ValueMultContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueParContext extends ValueContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueParContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueSumSubContext extends ValueContext {
		public ValueContext op1;
		public Token op;
		public ValueContext op2;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ValueSumSubContext(ValueContext ctx) { copyFrom(ctx); }
	}

	public final ValueContext value() throws RecognitionException {
		return value(0);
	}

	private ValueContext value(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueContext _localctx = new ValueContext(_ctx, _parentState);
		ValueContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_value, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				_localctx = new ValueParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(27);
				match(T__3);
				setState(28);
				value(0);
				setState(29);
				match(T__4);
				}
				break;
			case T__5:
			case T__6:
				{
				_localctx = new ValueSignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				((ValueSignContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__5 || _la==T__6) ) {
					((ValueSignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(32);
				value(7);
				}
				break;
			case T__9:
				{
				_localctx = new ValueVectorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				vector();
				}
				break;
			case NUM:
				{
				_localctx = new ValueNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new ValueIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(47);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ValueMultContext(new ValueContext(_parentctx, _parentState));
						((ValueMultContext)_localctx).op1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(38);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(39);
						match(T__7);
						setState(40);
						((ValueMultContext)_localctx).op2 = value(7);
						}
						break;
					case 2:
						{
						_localctx = new ValueProdContext(new ValueContext(_parentctx, _parentState));
						((ValueProdContext)_localctx).op1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(41);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(42);
						match(T__8);
						setState(43);
						((ValueProdContext)_localctx).op2 = value(6);
						}
						break;
					case 3:
						{
						_localctx = new ValueSumSubContext(new ValueContext(_parentctx, _parentState));
						((ValueSumSubContext)_localctx).op1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(44);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(45);
						((ValueSumSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
							((ValueSumSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(46);
						((ValueSumSubContext)_localctx).op2 = value(5);
						}
						break;
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class VectorContext extends ParserRuleContext {
		public List<TerminalNode> NUM() { return getTokens(prepParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(prepParser.NUM, i);
		}
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__9);
			setState(53);
			match(NUM);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(54);
				match(T__10);
				setState(55);
				match(NUM);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(T__11);
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
		case 2:
			return value_sempred((ValueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean value_sempred(ValueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22B\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\6\2\f\n\2\r\2\16\2\r\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4\'\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\62\n\4\f\4\16\4\65"+
		"\13\4\3\5\3\5\3\5\3\5\7\5;\n\5\f\5\16\5>\13\5\3\5\3\5\3\5\2\3\6\6\2\4"+
		"\6\b\2\3\3\2\b\t\2G\2\13\3\2\2\2\4\32\3\2\2\2\6&\3\2\2\2\b\66\3\2\2\2"+
		"\n\f\5\4\3\2\13\n\3\2\2\2\f\r\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\17"+
		"\3\2\2\2\17\20\7\2\2\3\20\3\3\2\2\2\21\22\7\3\2\2\22\23\5\6\4\2\23\24"+
		"\7\4\2\2\24\33\3\2\2\2\25\26\5\6\4\2\26\27\7\5\2\2\27\30\7\20\2\2\30\31"+
		"\7\4\2\2\31\33\3\2\2\2\32\21\3\2\2\2\32\25\3\2\2\2\33\5\3\2\2\2\34\35"+
		"\b\4\1\2\35\36\7\6\2\2\36\37\5\6\4\2\37 \7\7\2\2 \'\3\2\2\2!\"\t\2\2\2"+
		"\"\'\5\6\4\t#\'\5\b\5\2$\'\7\17\2\2%\'\7\20\2\2&\34\3\2\2\2&!\3\2\2\2"+
		"&#\3\2\2\2&$\3\2\2\2&%\3\2\2\2\'\63\3\2\2\2()\f\b\2\2)*\7\n\2\2*\62\5"+
		"\6\4\t+,\f\7\2\2,-\7\13\2\2-\62\5\6\4\b./\f\6\2\2/\60\t\2\2\2\60\62\5"+
		"\6\4\7\61(\3\2\2\2\61+\3\2\2\2\61.\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2"+
		"\63\64\3\2\2\2\64\7\3\2\2\2\65\63\3\2\2\2\66\67\7\f\2\2\67<\7\17\2\28"+
		"9\7\r\2\29;\7\17\2\2:8\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2"+
		"><\3\2\2\2?@\7\16\2\2@\t\3\2\2\2\b\r\32&\61\63<";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}