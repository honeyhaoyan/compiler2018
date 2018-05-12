// Generated from /Users/honey/Documents/compiler/Mx/src/test/java/Mx.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OpenParen=1, CloseParen=2, OpenCurly=3, CloseCurly=4, OpenBlacket=5, CloseBlacket=6, 
		Semi=7, Comma=8, Dot=9, Assign=10, Inc=11, Dec=12, Add=13, Sub=14, Mul=15, 
		Div=16, Mod=17, Land=18, Lor=19, Lnot=20, Lshift=21, Rshift=22, Not=23, 
		Or=24, And=25, Xor=26, Lt=27, Gt=28, Equal=29, Le=30, Ge=31, Notequal=32, 
		If=33, Else=34, For=35, While=36, Break=37, Continue=38, Return=39, Class=40, 
		New=41, This=42, Bool=43, Int=44, String=45, Void=46, LogicConstant=47, 
		IntegerConstant=48, StringConstant=49, NullConstant=50, Identifier=51, 
		WhiteSpace=52, NewLine=53, LineComment=54, BlockComment=55;
	public static final int
		RULE_program = 0, RULE_programItem = 1, RULE_classDefinition = 2, RULE_className = 3, 
		RULE_classBody = 4, RULE_constructionDefinition = 5, RULE_functionDefinition = 6, 
		RULE_globalVariable = 7, RULE_blockStatement = 8, RULE_statement = 9, 
		RULE_valuebleSingleStatement = 10, RULE_emptyStatement = 11, RULE_definitionStatement = 12, 
		RULE_newStatement = 13, RULE_assignStatement = 14, RULE_ifStatement = 15, 
		RULE_forStatement = 16, RULE_whileStatement = 17, RULE_breakStatement = 18, 
		RULE_returnStatement = 19, RULE_continueStatement = 20, RULE_selfOperationStatement = 21, 
		RULE_callFunctionStatement = 22, RULE_dotFunctionStatement = 23, RULE_valuebleSingleExpression = 24, 
		RULE_newExpression = 25, RULE_variableTypeExpression = 26, RULE_variableNormalTypeExpression = 27, 
		RULE_variableArrayTypeExpression = 28, RULE_dotExpression = 29, RULE_dotVariableExpression = 30, 
		RULE_dotFunctionExpression = 31, RULE_functionName = 32, RULE_subscriptExpression = 33, 
		RULE_callFunctionExpression = 34, RULE_valuebleListExpression = 35, RULE_definitionExpression = 36, 
		RULE_definitionNormalExpression = 37, RULE_definitionArrayExpression = 38, 
		RULE_assignExpression = 39, RULE_primaryType = 40, RULE_constant = 41;
	public static final String[] ruleNames = {
		"program", "programItem", "classDefinition", "className", "classBody", 
		"constructionDefinition", "functionDefinition", "globalVariable", "blockStatement", 
		"statement", "valuebleSingleStatement", "emptyStatement", "definitionStatement", 
		"newStatement", "assignStatement", "ifStatement", "forStatement", "whileStatement", 
		"breakStatement", "returnStatement", "continueStatement", "selfOperationStatement", 
		"callFunctionStatement", "dotFunctionStatement", "valuebleSingleExpression", 
		"newExpression", "variableTypeExpression", "variableNormalTypeExpression", 
		"variableArrayTypeExpression", "dotExpression", "dotVariableExpression", 
		"dotFunctionExpression", "functionName", "subscriptExpression", "callFunctionExpression", 
		"valuebleListExpression", "definitionExpression", "definitionNormalExpression", 
		"definitionArrayExpression", "assignExpression", "primaryType", "constant"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", "'='", 
		"'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", 
		"'<<'", "'>>'", "'~'", "'|'", "'&'", "'^'", "'<'", "'>'", "'=='", "'<='", 
		"'>='", "'!='", "'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", 
		"'return'", "'class'", "'new'", "'this'", "'bool'", "'int'", "'string'", 
		"'void'", null, null, null, "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "OpenParen", "CloseParen", "OpenCurly", "CloseCurly", "OpenBlacket", 
		"CloseBlacket", "Semi", "Comma", "Dot", "Assign", "Inc", "Dec", "Add", 
		"Sub", "Mul", "Div", "Mod", "Land", "Lor", "Lnot", "Lshift", "Rshift", 
		"Not", "Or", "And", "Xor", "Lt", "Gt", "Equal", "Le", "Ge", "Notequal", 
		"If", "Else", "For", "While", "Break", "Continue", "Return", "Class", 
		"New", "This", "Bool", "Int", "String", "Void", "LogicConstant", "IntegerConstant", 
		"StringConstant", "NullConstant", "Identifier", "WhiteSpace", "NewLine", 
		"LineComment", "BlockComment"
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
	public String getGrammarFileName() { return "Mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<ProgramItemContext> programItem() {
			return getRuleContexts(ProgramItemContext.class);
		}
		public ProgramItemContext programItem(int i) {
			return getRuleContext(ProgramItemContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << Inc) | (1L << Dec) | (1L << Sub) | (1L << Lnot) | (1L << Not) | (1L << Class) | (1L << New) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
				{
				{
				setState(84);
				programItem();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ProgramItemContext extends ParserRuleContext {
		public ClassDefinitionContext classDefinition() {
			return getRuleContext(ClassDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public GlobalVariableContext globalVariable() {
			return getRuleContext(GlobalVariableContext.class,0);
		}
		public ProgramItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterProgramItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitProgramItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitProgramItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramItemContext programItem() throws RecognitionException {
		ProgramItemContext _localctx = new ProgramItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(90);
				classDefinition();
				}
				break;
			case 2:
				{
				setState(91);
				functionDefinition();
				}
				break;
			case 3:
				{
				setState(92);
				globalVariable();
				}
				break;
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

	public static class ClassDefinitionContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode OpenCurly() { return getToken(MxParser.OpenCurly, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TerminalNode CloseCurly() { return getToken(MxParser.CloseCurly, 0); }
		public ClassDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefinitionContext classDefinition() throws RecognitionException {
		ClassDefinitionContext _localctx = new ClassDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(Class);
			setState(96);
			className();
			setState(97);
			match(OpenCurly);
			setState(98);
			classBody();
			setState(99);
			match(CloseCurly);
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

	public static class ClassNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_className);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(Identifier);
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

	public static class ClassBodyContext extends ParserRuleContext {
		public List<DefinitionStatementContext> definitionStatement() {
			return getRuleContexts(DefinitionStatementContext.class);
		}
		public DefinitionStatementContext definitionStatement(int i) {
			return getRuleContext(DefinitionStatementContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<ConstructionDefinitionContext> constructionDefinition() {
			return getRuleContexts(ConstructionDefinitionContext.class);
		}
		public ConstructionDefinitionContext constructionDefinition(int i) {
			return getRuleContext(ConstructionDefinitionContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(106);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(103);
					definitionStatement();
					}
					break;
				case 2:
					{
					setState(104);
					functionDefinition();
					}
					break;
				case 3:
					{
					setState(105);
					constructionDefinition();
					}
					break;
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ConstructionDefinitionContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(MxParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(MxParser.CloseParen, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public List<DefinitionExpressionContext> definitionExpression() {
			return getRuleContexts(DefinitionExpressionContext.class);
		}
		public DefinitionExpressionContext definitionExpression(int i) {
			return getRuleContext(DefinitionExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public ConstructionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterConstructionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitConstructionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitConstructionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructionDefinitionContext constructionDefinition() throws RecognitionException {
		ConstructionDefinitionContext _localctx = new ConstructionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constructionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			className();
			setState(112);
			match(OpenParen);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(113);
				definitionExpression();
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(114);
					match(Comma);
					setState(115);
					definitionExpression();
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(CloseParen);
			setState(127);
			blockStatement();
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

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public VariableTypeExpressionContext variableTypeExpression() {
			return getRuleContext(VariableTypeExpressionContext.class,0);
		}
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(MxParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(MxParser.CloseParen, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public List<DefinitionExpressionContext> definitionExpression() {
			return getRuleContexts(DefinitionExpressionContext.class);
		}
		public DefinitionExpressionContext definitionExpression(int i) {
			return getRuleContext(DefinitionExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			variableTypeExpression();
			setState(130);
			functionName();
			setState(131);
			match(OpenParen);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(132);
				definitionExpression();
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(133);
					match(Comma);
					setState(134);
					definitionExpression();
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			match(CloseParen);
			setState(146);
			blockStatement();
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

	public static class GlobalVariableContext extends ParserRuleContext {
		public DefinitionStatementContext definitionStatement() {
			return getRuleContext(DefinitionStatementContext.class,0);
		}
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public NewStatementContext newStatement() {
			return getRuleContext(NewStatementContext.class,0);
		}
		public GlobalVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterGlobalVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitGlobalVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitGlobalVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalVariableContext globalVariable() throws RecognitionException {
		GlobalVariableContext _localctx = new GlobalVariableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_globalVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(148);
				definitionStatement();
				}
				break;
			case 2:
				{
				setState(149);
				assignStatement();
				}
				break;
			case 3:
				{
				setState(150);
				newStatement();
				}
				break;
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

	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode OpenCurly() { return getToken(MxParser.OpenCurly, 0); }
		public TerminalNode CloseCurly() { return getToken(MxParser.CloseCurly, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_blockStatement);
		int _la;
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenCurly:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(OpenCurly);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << OpenCurly) | (1L << Semi) | (1L << Inc) | (1L << Dec) | (1L << Sub) | (1L << Lnot) | (1L << Not) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
					{
					setState(156);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(154);
						statement();
						}
						break;
					case 2:
						{
						setState(155);
						blockStatement();
						}
						break;
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161);
				match(CloseCurly);
				}
				break;
			case OpenParen:
			case Semi:
			case Inc:
			case Dec:
			case Sub:
			case Lnot:
			case Not:
			case If:
			case For:
			case While:
			case Break:
			case Continue:
			case Return:
			case New:
			case This:
			case Bool:
			case Int:
			case String:
			case Void:
			case LogicConstant:
			case IntegerConstant:
			case StringConstant:
			case NullConstant:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				statement();
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

	public static class StatementContext extends ParserRuleContext {
		public NewStatementContext newStatement() {
			return getRuleContext(NewStatementContext.class,0);
		}
		public DefinitionStatementContext definitionStatement() {
			return getRuleContext(DefinitionStatementContext.class,0);
		}
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public SelfOperationStatementContext selfOperationStatement() {
			return getRuleContext(SelfOperationStatementContext.class,0);
		}
		public CallFunctionStatementContext callFunctionStatement() {
			return getRuleContext(CallFunctionStatementContext.class,0);
		}
		public DotFunctionStatementContext dotFunctionStatement() {
			return getRuleContext(DotFunctionStatementContext.class,0);
		}
		public ValuebleSingleStatementContext valuebleSingleStatement() {
			return getRuleContext(ValuebleSingleStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				newStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				definitionStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				assignStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(169);
				forStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(170);
				whileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(171);
				breakStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(172);
				returnStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(173);
				continueStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(174);
				selfOperationStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(175);
				callFunctionStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(176);
				dotFunctionStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(177);
				valuebleSingleStatement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(178);
				emptyStatement();
				}
				break;
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

	public static class ValuebleSingleStatementContext extends ParserRuleContext {
		public ValuebleSingleExpressionContext valuebleSingleExpression() {
			return getRuleContext(ValuebleSingleExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ValuebleSingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuebleSingleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterValuebleSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitValuebleSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitValuebleSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuebleSingleStatementContext valuebleSingleStatement() throws RecognitionException {
		ValuebleSingleStatementContext _localctx = new ValuebleSingleStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_valuebleSingleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			valuebleSingleExpression(0);
			setState(182);
			match(Semi);
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

	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(Semi);
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

	public static class DefinitionStatementContext extends ParserRuleContext {
		public DefinitionExpressionContext definitionExpression() {
			return getRuleContext(DefinitionExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public DefinitionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDefinitionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDefinitionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDefinitionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionStatementContext definitionStatement() throws RecognitionException {
		DefinitionStatementContext _localctx = new DefinitionStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_definitionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			definitionExpression();
			setState(187);
			match(Semi);
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

	public static class NewStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public List<VariableTypeExpressionContext> variableTypeExpression() {
			return getRuleContexts(VariableTypeExpressionContext.class);
		}
		public VariableTypeExpressionContext variableTypeExpression(int i) {
			return getRuleContext(VariableTypeExpressionContext.class,i);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public SubscriptExpressionContext subscriptExpression() {
			return getRuleContext(SubscriptExpressionContext.class,0);
		}
		public DotVariableExpressionContext dotVariableExpression() {
			return getRuleContext(DotVariableExpressionContext.class,0);
		}
		public NewStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewStatementContext newStatement() throws RecognitionException {
		NewStatementContext _localctx = new NewStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_newStatement);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(189);
					variableTypeExpression();
					}
					break;
				}
				setState(192);
				match(Identifier);
				setState(193);
				match(Assign);
				setState(194);
				match(New);
				setState(195);
				variableTypeExpression();
				setState(196);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				subscriptExpression();
				setState(199);
				match(Assign);
				setState(200);
				match(New);
				setState(201);
				variableTypeExpression();
				setState(202);
				match(Semi);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				dotVariableExpression();
				setState(205);
				match(Assign);
				setState(206);
				match(New);
				setState(207);
				variableTypeExpression();
				setState(208);
				match(Semi);
				}
				break;
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

	public static class AssignStatementContext extends ParserRuleContext {
		public AssignExpressionContext assignExpression() {
			return getRuleContext(AssignExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public AssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAssignStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAssignStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAssignStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStatementContext assignStatement() throws RecognitionException {
		AssignStatementContext _localctx = new AssignStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_assignStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			assignExpression();
			setState(213);
			match(Semi);
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(MxParser.If, 0); }
		public TerminalNode OpenParen() { return getToken(MxParser.OpenParen, 0); }
		public ValuebleSingleExpressionContext valuebleSingleExpression() {
			return getRuleContext(ValuebleSingleExpressionContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(MxParser.CloseParen, 0); }
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxParser.Else, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(If);
			setState(216);
			match(OpenParen);
			setState(217);
			valuebleSingleExpression(0);
			setState(218);
			match(CloseParen);
			setState(219);
			blockStatement();
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(220);
				match(Else);
				setState(221);
				blockStatement();
				}
				break;
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

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode OpenParen() { return getToken(MxParser.OpenParen, 0); }
		public List<TerminalNode> Semi() { return getTokens(MxParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(MxParser.Semi, i);
		}
		public TerminalNode CloseParen() { return getToken(MxParser.CloseParen, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public DefinitionStatementContext definitionStatement() {
			return getRuleContext(DefinitionStatementContext.class,0);
		}
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public List<ValuebleSingleExpressionContext> valuebleSingleExpression() {
			return getRuleContexts(ValuebleSingleExpressionContext.class);
		}
		public ValuebleSingleExpressionContext valuebleSingleExpression(int i) {
			return getRuleContext(ValuebleSingleExpressionContext.class,i);
		}
		public AssignExpressionContext assignExpression() {
			return getRuleContext(AssignExpressionContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forStatement);
		int _la;
		try {
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				match(For);
				setState(225);
				match(OpenParen);
				setState(228);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(226);
					definitionStatement();
					}
					break;
				case 2:
					{
					setState(227);
					assignStatement();
					}
					break;
				}
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << Inc) | (1L << Dec) | (1L << Sub) | (1L << Lnot) | (1L << Not) | (1L << New) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
					{
					setState(230);
					valuebleSingleExpression(0);
					}
				}

				setState(233);
				match(Semi);
				setState(236);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(234);
					assignExpression();
					}
					break;
				case 2:
					{
					setState(235);
					valuebleSingleExpression(0);
					}
					break;
				}
				setState(238);
				match(CloseParen);
				setState(239);
				blockStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(For);
				setState(241);
				match(OpenParen);
				setState(242);
				match(Semi);
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << Inc) | (1L << Dec) | (1L << Sub) | (1L << Lnot) | (1L << Not) | (1L << New) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
					{
					setState(243);
					valuebleSingleExpression(0);
					}
				}

				setState(246);
				match(Semi);
				setState(249);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(247);
					assignExpression();
					}
					break;
				case 2:
					{
					setState(248);
					valuebleSingleExpression(0);
					}
					break;
				}
				setState(251);
				match(CloseParen);
				setState(254);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(252);
					match(Semi);
					}
					break;
				case 2:
					{
					setState(253);
					blockStatement();
					}
					break;
				}
				}
				break;
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

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode OpenParen() { return getToken(MxParser.OpenParen, 0); }
		public ValuebleSingleExpressionContext valuebleSingleExpression() {
			return getRuleContext(ValuebleSingleExpressionContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(MxParser.CloseParen, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(While);
			setState(259);
			match(OpenParen);
			setState(260);
			valuebleSingleExpression(0);
			setState(261);
			match(CloseParen);
			setState(262);
			blockStatement();
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

	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(MxParser.Break, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(Break);
			setState(265);
			match(Semi);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ValuebleSingleExpressionContext valuebleSingleExpression() {
			return getRuleContext(ValuebleSingleExpressionContext.class,0);
		}
		public ValuebleListExpressionContext valuebleListExpression() {
			return getRuleContext(ValuebleListExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(Return);
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(268);
				valuebleSingleExpression(0);
				}
				break;
			case 2:
				{
				setState(269);
				valuebleListExpression();
				}
				break;
			}
			setState(272);
			match(Semi);
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

	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(MxParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(Continue);
			setState(275);
			match(Semi);
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

	public static class SelfOperationStatementContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public TerminalNode Inc() { return getToken(MxParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(MxParser.Dec, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public DotVariableExpressionContext dotVariableExpression() {
			return getRuleContext(DotVariableExpressionContext.class,0);
		}
		public SelfOperationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selfOperationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSelfOperationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSelfOperationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSelfOperationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfOperationStatementContext selfOperationStatement() throws RecognitionException {
		SelfOperationStatementContext _localctx = new SelfOperationStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_selfOperationStatement);
		int _la;
		try {
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Inc:
			case Dec:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(280);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(278);
					match(Identifier);
					}
					break;
				case 2:
					{
					setState(279);
					dotVariableExpression();
					}
					break;
				}
				setState(282);
				match(Semi);
				}
				break;
			case This:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(283);
					match(Identifier);
					}
					break;
				case 2:
					{
					setState(284);
					dotVariableExpression();
					}
					break;
				}
				setState(287);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(288);
				match(Semi);
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

	public static class CallFunctionStatementContext extends ParserRuleContext {
		public CallFunctionExpressionContext callFunctionExpression() {
			return getRuleContext(CallFunctionExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public CallFunctionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callFunctionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCallFunctionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCallFunctionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCallFunctionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallFunctionStatementContext callFunctionStatement() throws RecognitionException {
		CallFunctionStatementContext _localctx = new CallFunctionStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_callFunctionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			callFunctionExpression();
			setState(292);
			match(Semi);
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

	public static class DotFunctionStatementContext extends ParserRuleContext {
		public DotFunctionExpressionContext dotFunctionExpression() {
			return getRuleContext(DotFunctionExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public DotFunctionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotFunctionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDotFunctionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDotFunctionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDotFunctionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotFunctionStatementContext dotFunctionStatement() throws RecognitionException {
		DotFunctionStatementContext _localctx = new DotFunctionStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_dotFunctionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			dotFunctionExpression();
			setState(295);
			match(Semi);
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

	public static class ValuebleSingleExpressionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public VariableTypeExpressionContext variableTypeExpression() {
			return getRuleContext(VariableTypeExpressionContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode This() { return getToken(MxParser.This, 0); }
		public DotExpressionContext dotExpression() {
			return getRuleContext(DotExpressionContext.class,0);
		}
		public SubscriptExpressionContext subscriptExpression() {
			return getRuleContext(SubscriptExpressionContext.class,0);
		}
		public List<ValuebleSingleExpressionContext> valuebleSingleExpression() {
			return getRuleContexts(ValuebleSingleExpressionContext.class);
		}
		public ValuebleSingleExpressionContext valuebleSingleExpression(int i) {
			return getRuleContext(ValuebleSingleExpressionContext.class,i);
		}
		public TerminalNode Inc() { return getToken(MxParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(MxParser.Dec, 0); }
		public TerminalNode Not() { return getToken(MxParser.Not, 0); }
		public TerminalNode Lnot() { return getToken(MxParser.Lnot, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
		public CallFunctionExpressionContext callFunctionExpression() {
			return getRuleContext(CallFunctionExpressionContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(MxParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(MxParser.CloseParen, 0); }
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public TerminalNode Mul() { return getToken(MxParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
		public TerminalNode Lshift() { return getToken(MxParser.Lshift, 0); }
		public TerminalNode Rshift() { return getToken(MxParser.Rshift, 0); }
		public TerminalNode Le() { return getToken(MxParser.Le, 0); }
		public TerminalNode Ge() { return getToken(MxParser.Ge, 0); }
		public TerminalNode Lt() { return getToken(MxParser.Lt, 0); }
		public TerminalNode Gt() { return getToken(MxParser.Gt, 0); }
		public TerminalNode Equal() { return getToken(MxParser.Equal, 0); }
		public TerminalNode Notequal() { return getToken(MxParser.Notequal, 0); }
		public TerminalNode And() { return getToken(MxParser.And, 0); }
		public TerminalNode Xor() { return getToken(MxParser.Xor, 0); }
		public TerminalNode Or() { return getToken(MxParser.Or, 0); }
		public TerminalNode Land() { return getToken(MxParser.Land, 0); }
		public TerminalNode Lor() { return getToken(MxParser.Lor, 0); }
		public ValuebleSingleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuebleSingleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterValuebleSingleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitValuebleSingleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitValuebleSingleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuebleSingleExpressionContext valuebleSingleExpression() throws RecognitionException {
		return valuebleSingleExpression(0);
	}

	private ValuebleSingleExpressionContext valuebleSingleExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValuebleSingleExpressionContext _localctx = new ValuebleSingleExpressionContext(_ctx, _parentState);
		ValuebleSingleExpressionContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_valuebleSingleExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(298);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(299);
				variableTypeExpression();
				}
				break;
			case 3:
				{
				setState(300);
				constant();
				}
				break;
			case 4:
				{
				setState(301);
				match(This);
				}
				break;
			case 5:
				{
				setState(302);
				dotExpression();
				}
				break;
			case 6:
				{
				setState(303);
				subscriptExpression();
				}
				break;
			case 7:
				{
				setState(304);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(305);
				valuebleSingleExpression(17);
				}
				break;
			case 8:
				{
				setState(306);
				_la = _input.LA(1);
				if ( !(_la==Lnot || _la==Not) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(307);
				valuebleSingleExpression(15);
				}
				break;
			case 9:
				{
				setState(308);
				match(Sub);
				setState(309);
				valuebleSingleExpression(13);
				}
				break;
			case 10:
				{
				setState(310);
				callFunctionExpression();
				}
				break;
			case 11:
				{
				setState(311);
				match(OpenParen);
				setState(312);
				valuebleSingleExpression(0);
				setState(313);
				match(CloseParen);
				}
				break;
			case 12:
				{
				setState(315);
				newExpression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(350);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(318);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(319);
						_la = _input.LA(1);
						if ( !(_la==Mul || _la==Div) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(320);
						valuebleSingleExpression(15);
						}
						break;
					case 2:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(321);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(322);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << Mod))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(323);
						valuebleSingleExpression(13);
						}
						break;
					case 3:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(324);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(325);
						_la = _input.LA(1);
						if ( !(_la==Lshift || _la==Rshift) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(326);
						valuebleSingleExpression(12);
						}
						break;
					case 4:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(327);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(328);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lt) | (1L << Gt) | (1L << Le) | (1L << Ge))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(329);
						valuebleSingleExpression(11);
						}
						break;
					case 5:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(330);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(331);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==Notequal) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(332);
						valuebleSingleExpression(10);
						}
						break;
					case 6:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(333);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(334);
						match(And);
						setState(335);
						valuebleSingleExpression(9);
						}
						break;
					case 7:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(336);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(337);
						match(Xor);
						setState(338);
						valuebleSingleExpression(8);
						}
						break;
					case 8:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(339);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(340);
						match(Or);
						setState(341);
						valuebleSingleExpression(7);
						}
						break;
					case 9:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(342);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(343);
						match(Land);
						setState(344);
						valuebleSingleExpression(6);
						}
						break;
					case 10:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(345);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(346);
						match(Lor);
						setState(347);
						valuebleSingleExpression(5);
						}
						break;
					case 11:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(348);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(349);
						_la = _input.LA(1);
						if ( !(_la==Inc || _la==Dec) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	public static class NewExpressionContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public VariableTypeExpressionContext variableTypeExpression() {
			return getRuleContext(VariableTypeExpressionContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(MxParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(MxParser.CloseParen, 0); }
		public NewExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpressionContext newExpression() throws RecognitionException {
		NewExpressionContext _localctx = new NewExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_newExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(New);
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(356);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(357);
				variableTypeExpression();
				}
				break;
			}
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(360);
				match(OpenParen);
				setState(361);
				match(CloseParen);
				}
				break;
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

	public static class VariableTypeExpressionContext extends ParserRuleContext {
		public VariableNormalTypeExpressionContext variableNormalTypeExpression() {
			return getRuleContext(VariableNormalTypeExpressionContext.class,0);
		}
		public VariableArrayTypeExpressionContext variableArrayTypeExpression() {
			return getRuleContext(VariableArrayTypeExpressionContext.class,0);
		}
		public VariableTypeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableTypeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVariableTypeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVariableTypeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVariableTypeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableTypeExpressionContext variableTypeExpression() throws RecognitionException {
		VariableTypeExpressionContext _localctx = new VariableTypeExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_variableTypeExpression);
		try {
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				variableNormalTypeExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				variableArrayTypeExpression();
				}
				break;
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

	public static class VariableNormalTypeExpressionContext extends ParserRuleContext {
		public PrimaryTypeContext primaryType() {
			return getRuleContext(PrimaryTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public VariableNormalTypeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableNormalTypeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVariableNormalTypeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVariableNormalTypeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVariableNormalTypeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableNormalTypeExpressionContext variableNormalTypeExpression() throws RecognitionException {
		VariableNormalTypeExpressionContext _localctx = new VariableNormalTypeExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_variableNormalTypeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
			case Int:
			case String:
			case Void:
				{
				setState(368);
				primaryType();
				}
				break;
			case Identifier:
				{
				setState(369);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class VariableArrayTypeExpressionContext extends ParserRuleContext {
		public PrimaryTypeContext primaryType() {
			return getRuleContext(PrimaryTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public List<TerminalNode> OpenBlacket() { return getTokens(MxParser.OpenBlacket); }
		public TerminalNode OpenBlacket(int i) {
			return getToken(MxParser.OpenBlacket, i);
		}
		public List<TerminalNode> CloseBlacket() { return getTokens(MxParser.CloseBlacket); }
		public TerminalNode CloseBlacket(int i) {
			return getToken(MxParser.CloseBlacket, i);
		}
		public List<ValuebleSingleExpressionContext> valuebleSingleExpression() {
			return getRuleContexts(ValuebleSingleExpressionContext.class);
		}
		public ValuebleSingleExpressionContext valuebleSingleExpression(int i) {
			return getRuleContext(ValuebleSingleExpressionContext.class,i);
		}
		public VariableArrayTypeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableArrayTypeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVariableArrayTypeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVariableArrayTypeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVariableArrayTypeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableArrayTypeExpressionContext variableArrayTypeExpression() throws RecognitionException {
		VariableArrayTypeExpressionContext _localctx = new VariableArrayTypeExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_variableArrayTypeExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
			case Int:
			case String:
			case Void:
				{
				setState(372);
				primaryType();
				}
				break;
			case Identifier:
				{
				setState(373);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(386);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(383);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(376);
						match(OpenBlacket);
						setState(378);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << Inc) | (1L << Dec) | (1L << Sub) | (1L << Lnot) | (1L << Not) | (1L << New) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
							{
							setState(377);
							valuebleSingleExpression(0);
							}
						}

						setState(380);
						match(CloseBlacket);
						}
						} 
					}
					setState(385);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				}
				}
				break;
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

	public static class DotExpressionContext extends ParserRuleContext {
		public DotVariableExpressionContext dotVariableExpression() {
			return getRuleContext(DotVariableExpressionContext.class,0);
		}
		public DotFunctionExpressionContext dotFunctionExpression() {
			return getRuleContext(DotFunctionExpressionContext.class,0);
		}
		public DotExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDotExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotExpressionContext dotExpression() throws RecognitionException {
		DotExpressionContext _localctx = new DotExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_dotExpression);
		try {
			setState(390);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(388);
				dotVariableExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(389);
				dotFunctionExpression();
				}
				break;
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

	public static class DotVariableExpressionContext extends ParserRuleContext {
		public TerminalNode Dot() { return getToken(MxParser.Dot, 0); }
		public List<ClassNameContext> className() {
			return getRuleContexts(ClassNameContext.class);
		}
		public ClassNameContext className(int i) {
			return getRuleContext(ClassNameContext.class,i);
		}
		public SubscriptExpressionContext subscriptExpression() {
			return getRuleContext(SubscriptExpressionContext.class,0);
		}
		public CallFunctionExpressionContext callFunctionExpression() {
			return getRuleContext(CallFunctionExpressionContext.class,0);
		}
		public TerminalNode This() { return getToken(MxParser.This, 0); }
		public DotExpressionContext dotExpression() {
			return getRuleContext(DotExpressionContext.class,0);
		}
		public DotVariableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotVariableExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDotVariableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDotVariableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDotVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotVariableExpressionContext dotVariableExpression() throws RecognitionException {
		DotVariableExpressionContext _localctx = new DotVariableExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_dotVariableExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(392);
				className();
				}
				break;
			case 2:
				{
				setState(393);
				subscriptExpression();
				}
				break;
			case 3:
				{
				setState(394);
				callFunctionExpression();
				}
				break;
			case 4:
				{
				setState(395);
				match(This);
				}
				break;
			}
			setState(398);
			match(Dot);
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(399);
				dotExpression();
				}
				break;
			case 2:
				{
				setState(400);
				className();
				}
				break;
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

	public static class DotFunctionExpressionContext extends ParserRuleContext {
		public TerminalNode Dot() { return getToken(MxParser.Dot, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public SubscriptExpressionContext subscriptExpression() {
			return getRuleContext(SubscriptExpressionContext.class,0);
		}
		public TerminalNode StringConstant() { return getToken(MxParser.StringConstant, 0); }
		public List<CallFunctionExpressionContext> callFunctionExpression() {
			return getRuleContexts(CallFunctionExpressionContext.class);
		}
		public CallFunctionExpressionContext callFunctionExpression(int i) {
			return getRuleContext(CallFunctionExpressionContext.class,i);
		}
		public TerminalNode This() { return getToken(MxParser.This, 0); }
		public DotFunctionExpressionContext dotFunctionExpression() {
			return getRuleContext(DotFunctionExpressionContext.class,0);
		}
		public DotFunctionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotFunctionExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDotFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDotFunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDotFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotFunctionExpressionContext dotFunctionExpression() throws RecognitionException {
		DotFunctionExpressionContext _localctx = new DotFunctionExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_dotFunctionExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(403);
				className();
				}
				break;
			case 2:
				{
				setState(404);
				subscriptExpression();
				}
				break;
			case 3:
				{
				setState(405);
				match(StringConstant);
				}
				break;
			case 4:
				{
				setState(406);
				callFunctionExpression();
				}
				break;
			case 5:
				{
				setState(407);
				match(This);
				}
				break;
			}
			setState(410);
			match(Dot);
			setState(413);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(411);
				dotFunctionExpression();
				}
				break;
			case 2:
				{
				setState(412);
				callFunctionExpression();
				}
				break;
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

	public static class FunctionNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFunctionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(Identifier);
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

	public static class SubscriptExpressionContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public List<TerminalNode> OpenBlacket() { return getTokens(MxParser.OpenBlacket); }
		public TerminalNode OpenBlacket(int i) {
			return getToken(MxParser.OpenBlacket, i);
		}
		public List<TerminalNode> CloseBlacket() { return getTokens(MxParser.CloseBlacket); }
		public TerminalNode CloseBlacket(int i) {
			return getToken(MxParser.CloseBlacket, i);
		}
		public List<ValuebleSingleExpressionContext> valuebleSingleExpression() {
			return getRuleContexts(ValuebleSingleExpressionContext.class);
		}
		public ValuebleSingleExpressionContext valuebleSingleExpression(int i) {
			return getRuleContext(ValuebleSingleExpressionContext.class,i);
		}
		public SubscriptExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSubscriptExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSubscriptExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSubscriptExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubscriptExpressionContext subscriptExpression() throws RecognitionException {
		SubscriptExpressionContext _localctx = new SubscriptExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_subscriptExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			className();
			setState(424);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(418);
					match(OpenBlacket);
					{
					setState(419);
					valuebleSingleExpression(0);
					}
					setState(420);
					match(CloseBlacket);
					}
					} 
				}
				setState(426);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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

	public static class CallFunctionExpressionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode OpenParen() { return getToken(MxParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(MxParser.CloseParen, 0); }
		public ValuebleListExpressionContext valuebleListExpression() {
			return getRuleContext(ValuebleListExpressionContext.class,0);
		}
		public ValuebleSingleExpressionContext valuebleSingleExpression() {
			return getRuleContext(ValuebleSingleExpressionContext.class,0);
		}
		public CallFunctionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callFunctionExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCallFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCallFunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCallFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallFunctionExpressionContext callFunctionExpression() throws RecognitionException {
		CallFunctionExpressionContext _localctx = new CallFunctionExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_callFunctionExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			match(Identifier);
			setState(428);
			match(OpenParen);
			setState(431);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(429);
				valuebleListExpression();
				}
				break;
			case 2:
				{
				setState(430);
				valuebleSingleExpression(0);
				}
				break;
			}
			setState(433);
			match(CloseParen);
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

	public static class ValuebleListExpressionContext extends ParserRuleContext {
		public List<ValuebleSingleExpressionContext> valuebleSingleExpression() {
			return getRuleContexts(ValuebleSingleExpressionContext.class);
		}
		public ValuebleSingleExpressionContext valuebleSingleExpression(int i) {
			return getRuleContext(ValuebleSingleExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public ValuebleListExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuebleListExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterValuebleListExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitValuebleListExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitValuebleListExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuebleListExpressionContext valuebleListExpression() throws RecognitionException {
		ValuebleListExpressionContext _localctx = new ValuebleListExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_valuebleListExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			valuebleSingleExpression(0);
			setState(438); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(436);
				match(Comma);
				setState(437);
				valuebleSingleExpression(0);
				}
				}
				setState(440); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Comma );
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

	public static class DefinitionExpressionContext extends ParserRuleContext {
		public DefinitionNormalExpressionContext definitionNormalExpression() {
			return getRuleContext(DefinitionNormalExpressionContext.class,0);
		}
		public DefinitionArrayExpressionContext definitionArrayExpression() {
			return getRuleContext(DefinitionArrayExpressionContext.class,0);
		}
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public DefinitionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitionExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDefinitionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDefinitionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDefinitionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionExpressionContext definitionExpression() throws RecognitionException {
		DefinitionExpressionContext _localctx = new DefinitionExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_definitionExpression);
		try {
			setState(445);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(442);
				definitionNormalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(443);
				definitionArrayExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(444);
				match(New);
				}
				break;
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

	public static class DefinitionNormalExpressionContext extends ParserRuleContext {
		public VariableNormalTypeExpressionContext variableNormalTypeExpression() {
			return getRuleContext(VariableNormalTypeExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public ValuebleSingleExpressionContext valuebleSingleExpression() {
			return getRuleContext(ValuebleSingleExpressionContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(MxParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(MxParser.CloseParen, 0); }
		public DefinitionNormalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitionNormalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDefinitionNormalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDefinitionNormalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDefinitionNormalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionNormalExpressionContext definitionNormalExpression() throws RecognitionException {
		DefinitionNormalExpressionContext _localctx = new DefinitionNormalExpressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_definitionNormalExpression);
		int _la;
		try {
			setState(461);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(447);
				variableNormalTypeExpression();
				setState(448);
				match(Identifier);
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(449);
					match(Assign);
					setState(450);
					valuebleSingleExpression(0);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(453);
				variableNormalTypeExpression();
				setState(454);
				match(Identifier);
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OpenParen) {
					{
					setState(455);
					match(OpenParen);
					setState(456);
					valuebleSingleExpression(0);
					setState(457);
					match(CloseParen);
					}
				}

				}
				break;
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

	public static class DefinitionArrayExpressionContext extends ParserRuleContext {
		public VariableArrayTypeExpressionContext variableArrayTypeExpression() {
			return getRuleContext(VariableArrayTypeExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public DefinitionArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitionArrayExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterDefinitionArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitDefinitionArrayExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitDefinitionArrayExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionArrayExpressionContext definitionArrayExpression() throws RecognitionException {
		DefinitionArrayExpressionContext _localctx = new DefinitionArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_definitionArrayExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			variableArrayTypeExpression();
			setState(464);
			match(Identifier);
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

	public static class AssignExpressionContext extends ParserRuleContext {
		public List<ValuebleSingleExpressionContext> valuebleSingleExpression() {
			return getRuleContexts(ValuebleSingleExpressionContext.class);
		}
		public ValuebleSingleExpressionContext valuebleSingleExpression(int i) {
			return getRuleContext(ValuebleSingleExpressionContext.class,i);
		}
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public AssignExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAssignExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAssignExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAssignExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignExpressionContext assignExpression() throws RecognitionException {
		AssignExpressionContext _localctx = new AssignExpressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_assignExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			valuebleSingleExpression(0);
			setState(467);
			match(Assign);
			setState(468);
			valuebleSingleExpression(0);
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

	public static class PrimaryTypeContext extends ParserRuleContext {
		public TerminalNode Bool() { return getToken(MxParser.Bool, 0); }
		public TerminalNode Int() { return getToken(MxParser.Int, 0); }
		public TerminalNode String() { return getToken(MxParser.String, 0); }
		public TerminalNode Void() { return getToken(MxParser.Void, 0); }
		public PrimaryTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPrimaryType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPrimaryType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPrimaryType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryTypeContext primaryType() throws RecognitionException {
		PrimaryTypeContext _localctx = new PrimaryTypeContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_primaryType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void))) != 0)) ) {
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode LogicConstant() { return getToken(MxParser.LogicConstant, 0); }
		public TerminalNode IntegerConstant() { return getToken(MxParser.IntegerConstant, 0); }
		public TerminalNode StringConstant() { return getToken(MxParser.StringConstant, 0); }
		public TerminalNode NullConstant() { return getToken(MxParser.NullConstant, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant))) != 0)) ) {
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
		case 24:
			return valuebleSingleExpression_sempred((ValuebleSingleExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean valuebleSingleExpression_sempred(ValuebleSingleExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u01dd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\7\2X\n\2\f\2\16\2[\13\2\3\3\3\3\3\3\5\3`\n\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\6\7\6m\n\6\f\6\16\6p\13\6\3\7\3\7\3\7\3\7\3\7\7\7"+
		"w\n\7\f\7\16\7z\13\7\7\7|\n\7\f\7\16\7\177\13\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\7\b\u008a\n\b\f\b\16\b\u008d\13\b\7\b\u008f\n\b\f\b\16"+
		"\b\u0092\13\b\3\b\3\b\3\b\3\t\3\t\3\t\5\t\u009a\n\t\3\n\3\n\3\n\7\n\u009f"+
		"\n\n\f\n\16\n\u00a2\13\n\3\n\3\n\5\n\u00a6\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b6\n\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\16\3\17\5\17\u00c1\n\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5"+
		"\17\u00d5\n\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00e1\n\21\3\22\3\22\3\22\3\22\5\22\u00e7\n\22\3\22\5\22\u00ea\n\22\3"+
		"\22\3\22\3\22\5\22\u00ef\n\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00f7"+
		"\n\22\3\22\3\22\3\22\5\22\u00fc\n\22\3\22\3\22\3\22\5\22\u0101\n\22\5"+
		"\22\u0103\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\5\25\u0111\n\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u011b"+
		"\n\27\3\27\3\27\3\27\5\27\u0120\n\27\3\27\3\27\5\27\u0124\n\27\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u013f\n\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\7\32\u0161\n\32\f\32\16\32\u0164\13\32\3\33\3\33\3\33"+
		"\5\33\u0169\n\33\3\33\3\33\5\33\u016d\n\33\3\34\3\34\5\34\u0171\n\34\3"+
		"\35\3\35\5\35\u0175\n\35\3\36\3\36\5\36\u0179\n\36\3\36\3\36\5\36\u017d"+
		"\n\36\3\36\7\36\u0180\n\36\f\36\16\36\u0183\13\36\5\36\u0185\n\36\3\37"+
		"\3\37\5\37\u0189\n\37\3 \3 \3 \3 \5 \u018f\n \3 \3 \3 \5 \u0194\n \3!"+
		"\3!\3!\3!\3!\5!\u019b\n!\3!\3!\3!\5!\u01a0\n!\3\"\3\"\3#\3#\3#\3#\3#\7"+
		"#\u01a9\n#\f#\16#\u01ac\13#\3$\3$\3$\3$\5$\u01b2\n$\3$\3$\3%\3%\3%\6%"+
		"\u01b9\n%\r%\16%\u01ba\3&\3&\3&\5&\u01c0\n&\3\'\3\'\3\'\3\'\5\'\u01c6"+
		"\n\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01ce\n\'\5\'\u01d0\n\'\3(\3(\3(\3)\3"+
		")\3)\3)\3*\3*\3+\3+\3+\2\3\62,\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT\2\13\3\2\r\16\4\2\26\26\31\31\3\2"+
		"\21\22\4\2\17\20\23\23\3\2\27\30\4\2\35\36 !\4\2\37\37\"\"\3\2-\60\3\2"+
		"\61\64\2\u0212\2Y\3\2\2\2\4_\3\2\2\2\6a\3\2\2\2\bg\3\2\2\2\nn\3\2\2\2"+
		"\fq\3\2\2\2\16\u0083\3\2\2\2\20\u0099\3\2\2\2\22\u00a5\3\2\2\2\24\u00b5"+
		"\3\2\2\2\26\u00b7\3\2\2\2\30\u00ba\3\2\2\2\32\u00bc\3\2\2\2\34\u00d4\3"+
		"\2\2\2\36\u00d6\3\2\2\2 \u00d9\3\2\2\2\"\u0102\3\2\2\2$\u0104\3\2\2\2"+
		"&\u010a\3\2\2\2(\u010d\3\2\2\2*\u0114\3\2\2\2,\u0123\3\2\2\2.\u0125\3"+
		"\2\2\2\60\u0128\3\2\2\2\62\u013e\3\2\2\2\64\u0165\3\2\2\2\66\u0170\3\2"+
		"\2\28\u0174\3\2\2\2:\u0178\3\2\2\2<\u0188\3\2\2\2>\u018e\3\2\2\2@\u019a"+
		"\3\2\2\2B\u01a1\3\2\2\2D\u01a3\3\2\2\2F\u01ad\3\2\2\2H\u01b5\3\2\2\2J"+
		"\u01bf\3\2\2\2L\u01cf\3\2\2\2N\u01d1\3\2\2\2P\u01d4\3\2\2\2R\u01d8\3\2"+
		"\2\2T\u01da\3\2\2\2VX\5\4\3\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2"+
		"Z\3\3\2\2\2[Y\3\2\2\2\\`\5\6\4\2]`\5\16\b\2^`\5\20\t\2_\\\3\2\2\2_]\3"+
		"\2\2\2_^\3\2\2\2`\5\3\2\2\2ab\7*\2\2bc\5\b\5\2cd\7\5\2\2de\5\n\6\2ef\7"+
		"\6\2\2f\7\3\2\2\2gh\7\65\2\2h\t\3\2\2\2im\5\32\16\2jm\5\16\b\2km\5\f\7"+
		"\2li\3\2\2\2lj\3\2\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\13\3\2"+
		"\2\2pn\3\2\2\2qr\5\b\5\2r}\7\3\2\2sx\5J&\2tu\7\n\2\2uw\5J&\2vt\3\2\2\2"+
		"wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y|\3\2\2\2zx\3\2\2\2{s\3\2\2\2|\177\3\2"+
		"\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\4\2"+
		"\2\u0081\u0082\5\22\n\2\u0082\r\3\2\2\2\u0083\u0084\5\66\34\2\u0084\u0085"+
		"\5B\"\2\u0085\u0090\7\3\2\2\u0086\u008b\5J&\2\u0087\u0088\7\n\2\2\u0088"+
		"\u008a\5J&\2\u0089\u0087\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2"+
		"\2\u008b\u008c\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0086"+
		"\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7\4\2\2\u0094\u0095\5\22"+
		"\n\2\u0095\17\3\2\2\2\u0096\u009a\5\32\16\2\u0097\u009a\5\36\20\2\u0098"+
		"\u009a\5\34\17\2\u0099\u0096\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u0098\3"+
		"\2\2\2\u009a\21\3\2\2\2\u009b\u00a0\7\5\2\2\u009c\u009f\5\24\13\2\u009d"+
		"\u009f\5\22\n\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3"+
		"\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a3\u00a6\7\6\2\2\u00a4\u00a6\5\24\13\2\u00a5\u009b\3"+
		"\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\23\3\2\2\2\u00a7\u00b6\5\34\17\2\u00a8"+
		"\u00b6\5\32\16\2\u00a9\u00b6\5\36\20\2\u00aa\u00b6\5 \21\2\u00ab\u00b6"+
		"\5\"\22\2\u00ac\u00b6\5$\23\2\u00ad\u00b6\5&\24\2\u00ae\u00b6\5(\25\2"+
		"\u00af\u00b6\5*\26\2\u00b0\u00b6\5,\27\2\u00b1\u00b6\5.\30\2\u00b2\u00b6"+
		"\5\60\31\2\u00b3\u00b6\5\26\f\2\u00b4\u00b6\5\30\r\2\u00b5\u00a7\3\2\2"+
		"\2\u00b5\u00a8\3\2\2\2\u00b5\u00a9\3\2\2\2\u00b5\u00aa\3\2\2\2\u00b5\u00ab"+
		"\3\2\2\2\u00b5\u00ac\3\2\2\2\u00b5\u00ad\3\2\2\2\u00b5\u00ae\3\2\2\2\u00b5"+
		"\u00af\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b5\u00b2\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\25\3\2\2\2\u00b7\u00b8"+
		"\5\62\32\2\u00b8\u00b9\7\t\2\2\u00b9\27\3\2\2\2\u00ba\u00bb\7\t\2\2\u00bb"+
		"\31\3\2\2\2\u00bc\u00bd\5J&\2\u00bd\u00be\7\t\2\2\u00be\33\3\2\2\2\u00bf"+
		"\u00c1\5\66\34\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3"+
		"\2\2\2\u00c2\u00c3\7\65\2\2\u00c3\u00c4\7\f\2\2\u00c4\u00c5\7+\2\2\u00c5"+
		"\u00c6\5\66\34\2\u00c6\u00c7\7\t\2\2\u00c7\u00d5\3\2\2\2\u00c8\u00c9\5"+
		"D#\2\u00c9\u00ca\7\f\2\2\u00ca\u00cb\7+\2\2\u00cb\u00cc\5\66\34\2\u00cc"+
		"\u00cd\7\t\2\2\u00cd\u00d5\3\2\2\2\u00ce\u00cf\5> \2\u00cf\u00d0\7\f\2"+
		"\2\u00d0\u00d1\7+\2\2\u00d1\u00d2\5\66\34\2\u00d2\u00d3\7\t\2\2\u00d3"+
		"\u00d5\3\2\2\2\u00d4\u00c0\3\2\2\2\u00d4\u00c8\3\2\2\2\u00d4\u00ce\3\2"+
		"\2\2\u00d5\35\3\2\2\2\u00d6\u00d7\5P)\2\u00d7\u00d8\7\t\2\2\u00d8\37\3"+
		"\2\2\2\u00d9\u00da\7#\2\2\u00da\u00db\7\3\2\2\u00db\u00dc\5\62\32\2\u00dc"+
		"\u00dd\7\4\2\2\u00dd\u00e0\5\22\n\2\u00de\u00df\7$\2\2\u00df\u00e1\5\22"+
		"\n\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1!\3\2\2\2\u00e2\u00e3"+
		"\7%\2\2\u00e3\u00e6\7\3\2\2\u00e4\u00e7\5\32\16\2\u00e5\u00e7\5\36\20"+
		"\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9"+
		"\3\2\2\2\u00e8\u00ea\5\62\32\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2"+
		"\u00ea\u00eb\3\2\2\2\u00eb\u00ee\7\t\2\2\u00ec\u00ef\5P)\2\u00ed\u00ef"+
		"\5\62\32\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2"+
		"\u00ef\u00f0\3\2\2\2\u00f0\u00f1\7\4\2\2\u00f1\u0103\5\22\n\2\u00f2\u00f3"+
		"\7%\2\2\u00f3\u00f4\7\3\2\2\u00f4\u00f6\7\t\2\2\u00f5\u00f7\5\62\32\2"+
		"\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fb"+
		"\7\t\2\2\u00f9\u00fc\5P)\2\u00fa\u00fc\5\62\32\2\u00fb\u00f9\3\2\2\2\u00fb"+
		"\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0100\7\4"+
		"\2\2\u00fe\u0101\7\t\2\2\u00ff\u0101\5\22\n\2\u0100\u00fe\3\2\2\2\u0100"+
		"\u00ff\3\2\2\2\u0101\u0103\3\2\2\2\u0102\u00e2\3\2\2\2\u0102\u00f2\3\2"+
		"\2\2\u0103#\3\2\2\2\u0104\u0105\7&\2\2\u0105\u0106\7\3\2\2\u0106\u0107"+
		"\5\62\32\2\u0107\u0108\7\4\2\2\u0108\u0109\5\22\n\2\u0109%\3\2\2\2\u010a"+
		"\u010b\7\'\2\2\u010b\u010c\7\t\2\2\u010c\'\3\2\2\2\u010d\u0110\7)\2\2"+
		"\u010e\u0111\5\62\32\2\u010f\u0111\5H%\2\u0110\u010e\3\2\2\2\u0110\u010f"+
		"\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\7\t\2\2\u0113"+
		")\3\2\2\2\u0114\u0115\7(\2\2\u0115\u0116\7\t\2\2\u0116+\3\2\2\2\u0117"+
		"\u011a\t\2\2\2\u0118\u011b\7\65\2\2\u0119\u011b\5> \2\u011a\u0118\3\2"+
		"\2\2\u011a\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u0124\7\t\2\2\u011d"+
		"\u0120\7\65\2\2\u011e\u0120\5> \2\u011f\u011d\3\2\2\2\u011f\u011e\3\2"+
		"\2\2\u0120\u0121\3\2\2\2\u0121\u0122\t\2\2\2\u0122\u0124\7\t\2\2\u0123"+
		"\u0117\3\2\2\2\u0123\u011f\3\2\2\2\u0124-\3\2\2\2\u0125\u0126\5F$\2\u0126"+
		"\u0127\7\t\2\2\u0127/\3\2\2\2\u0128\u0129\5@!\2\u0129\u012a\7\t\2\2\u012a"+
		"\61\3\2\2\2\u012b\u012c\b\32\1\2\u012c\u013f\7\65\2\2\u012d\u013f\5\66"+
		"\34\2\u012e\u013f\5T+\2\u012f\u013f\7,\2\2\u0130\u013f\5<\37\2\u0131\u013f"+
		"\5D#\2\u0132\u0133\t\2\2\2\u0133\u013f\5\62\32\23\u0134\u0135\t\3\2\2"+
		"\u0135\u013f\5\62\32\21\u0136\u0137\7\20\2\2\u0137\u013f\5\62\32\17\u0138"+
		"\u013f\5F$\2\u0139\u013a\7\3\2\2\u013a\u013b\5\62\32\2\u013b\u013c\7\4"+
		"\2\2\u013c\u013f\3\2\2\2\u013d\u013f\5\64\33\2\u013e\u012b\3\2\2\2\u013e"+
		"\u012d\3\2\2\2\u013e\u012e\3\2\2\2\u013e\u012f\3\2\2\2\u013e\u0130\3\2"+
		"\2\2\u013e\u0131\3\2\2\2\u013e\u0132\3\2\2\2\u013e\u0134\3\2\2\2\u013e"+
		"\u0136\3\2\2\2\u013e\u0138\3\2\2\2\u013e\u0139\3\2\2\2\u013e\u013d\3\2"+
		"\2\2\u013f\u0162\3\2\2\2\u0140\u0141\f\20\2\2\u0141\u0142\t\4\2\2\u0142"+
		"\u0161\5\62\32\21\u0143\u0144\f\16\2\2\u0144\u0145\t\5\2\2\u0145\u0161"+
		"\5\62\32\17\u0146\u0147\f\r\2\2\u0147\u0148\t\6\2\2\u0148\u0161\5\62\32"+
		"\16\u0149\u014a\f\f\2\2\u014a\u014b\t\7\2\2\u014b\u0161\5\62\32\r\u014c"+
		"\u014d\f\13\2\2\u014d\u014e\t\b\2\2\u014e\u0161\5\62\32\f\u014f\u0150"+
		"\f\n\2\2\u0150\u0151\7\33\2\2\u0151\u0161\5\62\32\13\u0152\u0153\f\t\2"+
		"\2\u0153\u0154\7\34\2\2\u0154\u0161\5\62\32\n\u0155\u0156\f\b\2\2\u0156"+
		"\u0157\7\32\2\2\u0157\u0161\5\62\32\t\u0158\u0159\f\7\2\2\u0159\u015a"+
		"\7\24\2\2\u015a\u0161\5\62\32\b\u015b\u015c\f\6\2\2\u015c\u015d\7\25\2"+
		"\2\u015d\u0161\5\62\32\7\u015e\u015f\f\22\2\2\u015f\u0161\t\2\2\2\u0160"+
		"\u0140\3\2\2\2\u0160\u0143\3\2\2\2\u0160\u0146\3\2\2\2\u0160\u0149\3\2"+
		"\2\2\u0160\u014c\3\2\2\2\u0160\u014f\3\2\2\2\u0160\u0152\3\2\2\2\u0160"+
		"\u0155\3\2\2\2\u0160\u0158\3\2\2\2\u0160\u015b\3\2\2\2\u0160\u015e\3\2"+
		"\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"\63\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0168\7+\2\2\u0166\u0169\7\65\2"+
		"\2\u0167\u0169\5\66\34\2\u0168\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169"+
		"\u016c\3\2\2\2\u016a\u016b\7\3\2\2\u016b\u016d\7\4\2\2\u016c\u016a\3\2"+
		"\2\2\u016c\u016d\3\2\2\2\u016d\65\3\2\2\2\u016e\u0171\58\35\2\u016f\u0171"+
		"\5:\36\2\u0170\u016e\3\2\2\2\u0170\u016f\3\2\2\2\u0171\67\3\2\2\2\u0172"+
		"\u0175\5R*\2\u0173\u0175\7\65\2\2\u0174\u0172\3\2\2\2\u0174\u0173\3\2"+
		"\2\2\u01759\3\2\2\2\u0176\u0179\5R*\2\u0177\u0179\7\65\2\2\u0178\u0176"+
		"\3\2\2\2\u0178\u0177\3\2\2\2\u0179\u0184\3\2\2\2\u017a\u017c\7\7\2\2\u017b"+
		"\u017d\5\62\32\2\u017c\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3"+
		"\2\2\2\u017e\u0180\7\b\2\2\u017f\u017a\3\2\2\2\u0180\u0183\3\2\2\2\u0181"+
		"\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2"+
		"\2\2\u0184\u0181\3\2\2\2\u0184\u0185\3\2\2\2\u0185;\3\2\2\2\u0186\u0189"+
		"\5> \2\u0187\u0189\5@!\2\u0188\u0186\3\2\2\2\u0188\u0187\3\2\2\2\u0189"+
		"=\3\2\2\2\u018a\u018f\5\b\5\2\u018b\u018f\5D#\2\u018c\u018f\5F$\2\u018d"+
		"\u018f\7,\2\2\u018e\u018a\3\2\2\2\u018e\u018b\3\2\2\2\u018e\u018c\3\2"+
		"\2\2\u018e\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0193\7\13\2\2\u0191"+
		"\u0194\5<\37\2\u0192\u0194\5\b\5\2\u0193\u0191\3\2\2\2\u0193\u0192\3\2"+
		"\2\2\u0194?\3\2\2\2\u0195\u019b\5\b\5\2\u0196\u019b\5D#\2\u0197\u019b"+
		"\7\63\2\2\u0198\u019b\5F$\2\u0199\u019b\7,\2\2\u019a\u0195\3\2\2\2\u019a"+
		"\u0196\3\2\2\2\u019a\u0197\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u0199\3\2"+
		"\2\2\u019b\u019c\3\2\2\2\u019c\u019f\7\13\2\2\u019d\u01a0\5@!\2\u019e"+
		"\u01a0\5F$\2\u019f\u019d\3\2\2\2\u019f\u019e\3\2\2\2\u01a0A\3\2\2\2\u01a1"+
		"\u01a2\7\65\2\2\u01a2C\3\2\2\2\u01a3\u01aa\5\b\5\2\u01a4\u01a5\7\7\2\2"+
		"\u01a5\u01a6\5\62\32\2\u01a6\u01a7\7\b\2\2\u01a7\u01a9\3\2\2\2\u01a8\u01a4"+
		"\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab"+
		"E\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01ae\7\65\2\2\u01ae\u01b1\7\3\2\2"+
		"\u01af\u01b2\5H%\2\u01b0\u01b2\5\62\32\2\u01b1\u01af\3\2\2\2\u01b1\u01b0"+
		"\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\7\4\2\2\u01b4"+
		"G\3\2\2\2\u01b5\u01b8\5\62\32\2\u01b6\u01b7\7\n\2\2\u01b7\u01b9\5\62\32"+
		"\2\u01b8\u01b6\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb"+
		"\3\2\2\2\u01bbI\3\2\2\2\u01bc\u01c0\5L\'\2\u01bd\u01c0\5N(\2\u01be\u01c0"+
		"\7+\2\2\u01bf\u01bc\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01be\3\2\2\2\u01c0"+
		"K\3\2\2\2\u01c1\u01c2\58\35\2\u01c2\u01c5\7\65\2\2\u01c3\u01c4\7\f\2\2"+
		"\u01c4\u01c6\5\62\32\2\u01c5\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01d0"+
		"\3\2\2\2\u01c7\u01c8\58\35\2\u01c8\u01cd\7\65\2\2\u01c9\u01ca\7\3\2\2"+
		"\u01ca\u01cb\5\62\32\2\u01cb\u01cc\7\4\2\2\u01cc\u01ce\3\2\2\2\u01cd\u01c9"+
		"\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d0\3\2\2\2\u01cf\u01c1\3\2\2\2\u01cf"+
		"\u01c7\3\2\2\2\u01d0M\3\2\2\2\u01d1\u01d2\5:\36\2\u01d2\u01d3\7\65\2\2"+
		"\u01d3O\3\2\2\2\u01d4\u01d5\5\62\32\2\u01d5\u01d6\7\f\2\2\u01d6\u01d7"+
		"\5\62\32\2\u01d7Q\3\2\2\2\u01d8\u01d9\t\t\2\2\u01d9S\3\2\2\2\u01da\u01db"+
		"\t\n\2\2\u01dbU\3\2\2\2\64Y_lnx}\u008b\u0090\u0099\u009e\u00a0\u00a5\u00b5"+
		"\u00c0\u00d4\u00e0\u00e6\u00e9\u00ee\u00f6\u00fb\u0100\u0102\u0110\u011a"+
		"\u011f\u0123\u013e\u0160\u0162\u0168\u016c\u0170\u0174\u0178\u017c\u0181"+
		"\u0184\u0188\u018e\u0193\u019a\u019f\u01aa\u01b1\u01ba\u01bf\u01c5\u01cd"+
		"\u01cf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}