// Generated from /home/rrosmaninho/Repos/miect-stuff/LFA/Aulas Praticas/Aula 02/ex1d/ex1d.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ex1dParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, ID=3, WS=4;
	public static final int
		RULE_main = 0, RULE_greetings = 1, RULE_bye = 2;
	public static final String[] ruleNames = {
		"main", "greetings", "bye"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'hello'", "'bye'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "ID", "WS"
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
	public String getGrammarFileName() { return "ex1d.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ex1dParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MainContext extends ParserRuleContext {
		public GreetingsContext greetings() {
			return getRuleContext(GreetingsContext.class,0);
		}
		public ByeContext bye() {
			return getRuleContext(ByeContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		try {
			setState(8);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				greetings();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(7);
				bye();
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

	public static class GreetingsContext extends ParserRuleContext {
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(ex1dParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ex1dParser.ID, i);
		}
		public GreetingsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greetings; }
	}

	public final GreetingsContext greetings() throws RecognitionException {
		GreetingsContext _localctx = new GreetingsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_greetings);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			match(T__0);
			setState(12); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(11);
				((GreetingsContext)_localctx).ID = match(ID);
				}
				}
				setState(14); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			 System.out.println("Ola " + (((GreetingsContext)_localctx).ID!=null?((GreetingsContext)_localctx).ID.getText():null)); 
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

	public static class ByeContext extends ParserRuleContext {
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(ex1dParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ex1dParser.ID, i);
		}
		public ByeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bye; }
	}

	public final ByeContext bye() throws RecognitionException {
		ByeContext _localctx = new ByeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bye);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(T__1);
			setState(20); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(19);
				((ByeContext)_localctx).ID = match(ID);
				}
				}
				setState(22); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			 System.out.println("Bye " + (((ByeContext)_localctx).ID!=null?((ByeContext)_localctx).ID.getText():null)); 
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\6\35\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\5\2\13\n\2\3\3\3\3\6\3\17\n\3\r\3\16\3\20\3\3\3\3"+
		"\3\4\3\4\6\4\27\n\4\r\4\16\4\30\3\4\3\4\3\4\2\2\5\2\4\6\2\2\2\34\2\n\3"+
		"\2\2\2\4\f\3\2\2\2\6\24\3\2\2\2\b\13\5\4\3\2\t\13\5\6\4\2\n\b\3\2\2\2"+
		"\n\t\3\2\2\2\13\3\3\2\2\2\f\16\7\3\2\2\r\17\7\5\2\2\16\r\3\2\2\2\17\20"+
		"\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21\22\3\2\2\2\22\23\b\3\1\2\23\5"+
		"\3\2\2\2\24\26\7\4\2\2\25\27\7\5\2\2\26\25\3\2\2\2\27\30\3\2\2\2\30\26"+
		"\3\2\2\2\30\31\3\2\2\2\31\32\3\2\2\2\32\33\b\4\1\2\33\7\3\2\2\2\5\n\20"+
		"\30";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}