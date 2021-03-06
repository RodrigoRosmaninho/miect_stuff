// Generated from /home/rrosmaninho/Repos/miect-stuff/LFA/PrepTesteP/rev1/rev1.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class rev1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, LiteralString=8, 
		ID=9, WS=10, COMMENT=11;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_string = 2;
	public static final String[] ruleNames = {
		"program", "stat", "string"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'print'", "':'", "'input('", "')'", "'+'", "'('", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "LiteralString", "ID", 
		"WS", "COMMENT"
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
	public String getGrammarFileName() { return "rev1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public rev1Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(rev1Parser.EOF, 0); }
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
			while (_la==T__0 || _la==ID) {
				{
				{
				setState(6);
				stat();
				}
				}
				setState(11);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(12);
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
	public static class PrintStringContext extends StatContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public PrintStringContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class AssignIDContext extends StatContext {
		public TerminalNode ID() { return getToken(rev1Parser.ID, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public AssignIDContext(StatContext ctx) { copyFrom(ctx); }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(19);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new PrintStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				match(T__0);
				setState(15);
				string(0);
				}
				break;
			case ID:
				_localctx = new AssignIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(16);
				match(ID);
				setState(17);
				match(T__1);
				setState(18);
				string(0);
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

	public static class StringContext extends ParserRuleContext {
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
	 
		public StringContext() { }
		public void copyFrom(StringContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConcatStringContext extends StringContext {
		public StringContext s1;
		public StringContext s2;
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public ConcatStringContext(StringContext ctx) { copyFrom(ctx); }
	}
	public static class InputStringContext extends StringContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public InputStringContext(StringContext ctx) { copyFrom(ctx); }
	}
	public static class IdStringContext extends StringContext {
		public TerminalNode ID() { return getToken(rev1Parser.ID, 0); }
		public IdStringContext(StringContext ctx) { copyFrom(ctx); }
	}
	public static class ReplaceStringContext extends StringContext {
		public StringContext s1;
		public StringContext s2;
		public StringContext s3;
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public ReplaceStringContext(StringContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralContext extends StringContext {
		public TerminalNode LiteralString() { return getToken(rev1Parser.LiteralString, 0); }
		public LiteralContext(StringContext ctx) { copyFrom(ctx); }
	}

	public final StringContext string() throws RecognitionException {
		return string(0);
	}

	private StringContext string(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StringContext _localctx = new StringContext(_ctx, _parentState);
		StringContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_string, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LiteralString:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(22);
				match(LiteralString);
				}
				break;
			case T__2:
				{
				_localctx = new InputStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(T__2);
				setState(24);
				string(0);
				setState(25);
				match(T__3);
				}
				break;
			case ID:
				{
				_localctx = new IdStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				match(ID);
				}
				break;
			case T__5:
				{
				_localctx = new ReplaceStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(T__5);
				setState(29);
				((ReplaceStringContext)_localctx).s1 = string(0);
				setState(30);
				match(T__6);
				setState(31);
				((ReplaceStringContext)_localctx).s2 = string(0);
				setState(32);
				match(T__6);
				setState(33);
				((ReplaceStringContext)_localctx).s3 = string(0);
				setState(34);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConcatStringContext(new StringContext(_parentctx, _parentState));
					((ConcatStringContext)_localctx).s1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_string);
					setState(38);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(39);
					match(T__4);
					setState(40);
					((ConcatStringContext)_localctx).s2 = string(3);
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return string_sempred((StringContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean string_sempred(StringContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r\61\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\7\2\n\n\2\f\2\16\2\r\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\5\3\26\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4\'\n\4\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\2\3\6\5\2\4\6\2\2"+
		"\2\63\2\13\3\2\2\2\4\25\3\2\2\2\6&\3\2\2\2\b\n\5\4\3\2\t\b\3\2\2\2\n\r"+
		"\3\2\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\16\3\2\2\2\r\13\3\2\2\2\16\17\7\2"+
		"\2\3\17\3\3\2\2\2\20\21\7\3\2\2\21\26\5\6\4\2\22\23\7\13\2\2\23\24\7\4"+
		"\2\2\24\26\5\6\4\2\25\20\3\2\2\2\25\22\3\2\2\2\26\5\3\2\2\2\27\30\b\4"+
		"\1\2\30\'\7\n\2\2\31\32\7\5\2\2\32\33\5\6\4\2\33\34\7\6\2\2\34\'\3\2\2"+
		"\2\35\'\7\13\2\2\36\37\7\b\2\2\37 \5\6\4\2 !\7\t\2\2!\"\5\6\4\2\"#\7\t"+
		"\2\2#$\5\6\4\2$%\7\6\2\2%\'\3\2\2\2&\27\3\2\2\2&\31\3\2\2\2&\35\3\2\2"+
		"\2&\36\3\2\2\2\'-\3\2\2\2()\f\4\2\2)*\7\7\2\2*,\5\6\4\5+(\3\2\2\2,/\3"+
		"\2\2\2-+\3\2\2\2-.\3\2\2\2.\7\3\2\2\2/-\3\2\2\2\6\13\25&-";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}