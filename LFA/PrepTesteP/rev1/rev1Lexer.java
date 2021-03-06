// Generated from rev1.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class rev1Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, LiteralString=8, 
		ID=9, WS=10, COMMENT=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "LiteralString", 
			"ID", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "':'", "'input('", "')'", "'+'", "'('", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "LiteralString", "ID", 
			"WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public rev1Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "rev1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\rQ\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\7\t\63\n\t\f\t\16\t\66\13\t"+
		"\3\t\3\t\3\n\3\n\7\n<\n\n\f\n\16\n?\13\n\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\7\fI\n\f\f\f\16\fL\13\f\3\f\3\f\3\f\3\f\4\64J\2\r\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\5\4\2C\\c|\5\2\62;C\\c|\4\2"+
		"\13\f\"\"\2S\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\3\31\3\2\2\2\5\37\3\2\2\2\7!\3\2\2\2\t(\3\2\2\2\13*\3\2\2"+
		"\2\r,\3\2\2\2\17.\3\2\2\2\21\60\3\2\2\2\239\3\2\2\2\25@\3\2\2\2\27D\3"+
		"\2\2\2\31\32\7r\2\2\32\33\7t\2\2\33\34\7k\2\2\34\35\7p\2\2\35\36\7v\2"+
		"\2\36\4\3\2\2\2\37 \7<\2\2 \6\3\2\2\2!\"\7k\2\2\"#\7p\2\2#$\7r\2\2$%\7"+
		"w\2\2%&\7v\2\2&\'\7*\2\2\'\b\3\2\2\2()\7+\2\2)\n\3\2\2\2*+\7-\2\2+\f\3"+
		"\2\2\2,-\7*\2\2-\16\3\2\2\2./\7\61\2\2/\20\3\2\2\2\60\64\7$\2\2\61\63"+
		"\13\2\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\65\3\2\2\2\64\62\3\2\2\2\65\67"+
		"\3\2\2\2\66\64\3\2\2\2\678\7$\2\28\22\3\2\2\29=\t\2\2\2:<\t\3\2\2;:\3"+
		"\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\24\3\2\2\2?=\3\2\2\2@A\t\4\2\2A"+
		"B\3\2\2\2BC\b\13\2\2C\26\3\2\2\2DE\7\61\2\2EF\7\61\2\2FJ\3\2\2\2GI\13"+
		"\2\2\2HG\3\2\2\2IL\3\2\2\2JK\3\2\2\2JH\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7"+
		"\f\2\2NO\3\2\2\2OP\b\f\2\2P\30\3\2\2\2\6\2\64=J\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}