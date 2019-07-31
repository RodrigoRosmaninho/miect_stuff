// Generated from /home/rrosmaninho/Repos/miect-stuff/LFA/Aulas Praticas/Aula 02/ex4/ex4.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ex4Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUM=1, NEWLINE=2, WS=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NUM", "NEWLINE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NUM", "NEWLINE", "WS"
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


	public ex4Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ex4.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\5\'\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\3\2\6\2\13\n\2\r\2\16\2\f\3\2\6\2\20\n\2\r\2\16\2\21\3"+
		"\2\3\2\6\2\26\n\2\r\2\16\2\27\5\2\32\n\2\3\3\5\3\35\n\3\3\3\3\3\3\4\6"+
		"\4\"\n\4\r\4\16\4#\3\4\3\4\2\2\5\3\3\5\4\7\5\3\2\4\3\2c|\4\2\13\13\"\""+
		"\2,\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\3\31\3\2\2\2\5\34\3\2\2\2\7!\3"+
		"\2\2\2\t\13\t\2\2\2\n\t\3\2\2\2\13\f\3\2\2\2\f\n\3\2\2\2\f\r\3\2\2\2\r"+
		"\32\3\2\2\2\16\20\t\2\2\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21"+
		"\22\3\2\2\2\22\23\3\2\2\2\23\25\7/\2\2\24\26\t\2\2\2\25\24\3\2\2\2\26"+
		"\27\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\n\3\2\2\2\31"+
		"\17\3\2\2\2\32\4\3\2\2\2\33\35\7\17\2\2\34\33\3\2\2\2\34\35\3\2\2\2\35"+
		"\36\3\2\2\2\36\37\7\f\2\2\37\6\3\2\2\2 \"\t\3\2\2! \3\2\2\2\"#\3\2\2\2"+
		"#!\3\2\2\2#$\3\2\2\2$%\3\2\2\2%&\b\4\2\2&\b\3\2\2\2\t\2\f\21\27\31\34"+
		"#\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}