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
		RULE_classBody = 4, RULE_functionDefinition = 5, RULE_globalVariable = 6, 
		RULE_blockStatement = 7, RULE_statement = 8, RULE_emptyStatement = 9, 
		RULE_definitionStatement = 10, RULE_newStatement = 11, RULE_assignStatement = 12, 
		RULE_ifStatement = 13, RULE_forStatement = 14, RULE_whileStatement = 15, 
		RULE_breakStatement = 16, RULE_returnStatement = 17, RULE_continueStatement = 18, 
		RULE_selfOperationStatement = 19, RULE_callFunctionStatement = 20, RULE_dotFunctionStatement = 21, 
		RULE_valuebleSingleExpression = 22, RULE_variableTypeExpression = 23, 
		RULE_variableNormalTypeExpression = 24, RULE_variableArrayTypeExpression = 25, 
		RULE_dotExpression = 26, RULE_dotVariableExpression = 27, RULE_dotFunctionExpression = 28, 
		RULE_functionName = 29, RULE_subscriptExpression = 30, RULE_callFunctionExpression = 31, 
		RULE_valuebleListExpression = 32, RULE_definitionExpression = 33, RULE_definitionNormalExpression = 34, 
		RULE_definitionArrayExpression = 35, RULE_assignExpression = 36, RULE_primaryType = 37, 
		RULE_constant = 38;
	public static final String[] ruleNames = {
		"program", "programItem", "classDefinition", "className", "classBody", 
		"functionDefinition", "globalVariable", "blockStatement", "statement", 
		"emptyStatement", "definitionStatement", "newStatement", "assignStatement", 
		"ifStatement", "forStatement", "whileStatement", "breakStatement", "returnStatement", 
		"continueStatement", "selfOperationStatement", "callFunctionStatement", 
		"dotFunctionStatement", "valuebleSingleExpression", "variableTypeExpression", 
		"variableNormalTypeExpression", "variableArrayTypeExpression", "dotExpression", 
		"dotVariableExpression", "dotFunctionExpression", "functionName", "subscriptExpression", 
		"callFunctionExpression", "valuebleListExpression", "definitionExpression", 
		"definitionNormalExpression", "definitionArrayExpression", "assignExpression", 
		"primaryType", "constant"
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
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << Inc) | (1L << Dec) | (1L << Div) | (1L << Lnot) | (1L << Not) | (1L << Class) | (1L << New) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
				{
				{
				setState(78);
				programItem();
				}
				}
				setState(83);
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
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(84);
				classDefinition();
				}
				break;
			case 2:
				{
				setState(85);
				functionDefinition();
				}
				break;
			case 3:
				{
				setState(86);
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
			setState(89);
			match(Class);
			setState(90);
			className();
			setState(91);
			match(OpenCurly);
			setState(92);
			classBody();
			setState(93);
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
			setState(95);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(97);
					definitionStatement();
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(103);
				functionDefinition();
				}
				}
				setState(108);
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
		enterRule(_localctx, 10, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			variableTypeExpression();
			setState(110);
			functionName();
			setState(111);
			match(OpenParen);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(112);
				definitionExpression();
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(113);
					match(Comma);
					setState(114);
					definitionExpression();
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			match(CloseParen);
			setState(126);
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
		enterRule(_localctx, 12, RULE_globalVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(128);
				definitionStatement();
				}
				break;
			case 2:
				{
				setState(129);
				assignStatement();
				}
				break;
			case 3:
				{
				setState(130);
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
		enterRule(_localctx, 14, RULE_blockStatement);
		int _la;
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenCurly:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				match(OpenCurly);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << Semi) | (1L << Inc) | (1L << Dec) | (1L << Div) | (1L << Lnot) | (1L << Not) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
					{
					{
					setState(134);
					statement();
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(140);
				match(CloseCurly);
				}
				break;
			case OpenParen:
			case Semi:
			case Inc:
			case Dec:
			case Div:
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
				setState(141);
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
		public ValuebleSingleExpressionContext valuebleSingleExpression() {
			return getRuleContext(ValuebleSingleExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
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
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				newStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				definitionStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				assignStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(148);
				forStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(149);
				whileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(150);
				breakStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(151);
				returnStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(152);
				continueStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(153);
				selfOperationStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(154);
				callFunctionStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(155);
				dotFunctionStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(156);
				valuebleSingleExpression(0);
				setState(157);
				match(Semi);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(159);
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
		enterRule(_localctx, 18, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
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
		enterRule(_localctx, 20, RULE_definitionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			definitionExpression();
			setState(165);
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
		enterRule(_localctx, 22, RULE_newStatement);
		try {
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(167);
					variableTypeExpression();
					}
					break;
				}
				setState(170);
				match(Identifier);
				setState(171);
				match(Assign);
				setState(172);
				match(New);
				setState(173);
				variableTypeExpression();
				setState(174);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				subscriptExpression();
				setState(177);
				match(Assign);
				setState(178);
				match(New);
				setState(179);
				variableTypeExpression();
				setState(180);
				match(Semi);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				dotVariableExpression();
				setState(183);
				match(Assign);
				setState(184);
				match(New);
				setState(185);
				variableTypeExpression();
				setState(186);
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
		enterRule(_localctx, 24, RULE_assignStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			assignExpression();
			setState(191);
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
		enterRule(_localctx, 26, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(If);
			setState(194);
			match(OpenParen);
			setState(195);
			valuebleSingleExpression(0);
			setState(196);
			match(CloseParen);
			setState(197);
			blockStatement();
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(198);
				match(Else);
				setState(199);
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
		enterRule(_localctx, 28, RULE_forStatement);
		int _la;
		try {
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(For);
				setState(203);
				match(OpenParen);
				setState(206);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(204);
					definitionStatement();
					}
					break;
				case 2:
					{
					setState(205);
					assignStatement();
					}
					break;
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << Inc) | (1L << Dec) | (1L << Div) | (1L << Lnot) | (1L << Not) | (1L << New) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
					{
					setState(208);
					valuebleSingleExpression(0);
					}
				}

				setState(211);
				match(Semi);
				setState(214);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(212);
					assignExpression();
					}
					break;
				case 2:
					{
					setState(213);
					valuebleSingleExpression(0);
					}
					break;
				}
				setState(216);
				match(CloseParen);
				setState(217);
				blockStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(For);
				setState(219);
				match(OpenParen);
				setState(220);
				match(Semi);
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << Inc) | (1L << Dec) | (1L << Div) | (1L << Lnot) | (1L << Not) | (1L << New) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
					{
					setState(221);
					valuebleSingleExpression(0);
					}
				}

				setState(224);
				match(Semi);
				setState(227);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(225);
					assignExpression();
					}
					break;
				case 2:
					{
					setState(226);
					valuebleSingleExpression(0);
					}
					break;
				}
				setState(229);
				match(CloseParen);
				setState(232);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(230);
					match(Semi);
					}
					break;
				case 2:
					{
					setState(231);
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
		enterRule(_localctx, 30, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(While);
			setState(237);
			match(OpenParen);
			setState(238);
			valuebleSingleExpression(0);
			setState(239);
			match(CloseParen);
			setState(240);
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
		enterRule(_localctx, 32, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(Break);
			setState(243);
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
		enterRule(_localctx, 34, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(Return);
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(246);
				valuebleSingleExpression(0);
				}
				break;
			case 2:
				{
				setState(247);
				valuebleListExpression();
				}
				break;
			}
			setState(250);
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
		enterRule(_localctx, 36, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(Continue);
			setState(253);
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
		enterRule(_localctx, 38, RULE_selfOperationStatement);
		int _la;
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Inc:
			case Dec:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(258);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(256);
					match(Identifier);
					}
					break;
				case 2:
					{
					setState(257);
					dotVariableExpression();
					}
					break;
				}
				setState(260);
				match(Semi);
				}
				break;
			case This:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(261);
					match(Identifier);
					}
					break;
				case 2:
					{
					setState(262);
					dotVariableExpression();
					}
					break;
				}
				setState(265);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(266);
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
		enterRule(_localctx, 40, RULE_callFunctionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			callFunctionExpression();
			setState(270);
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
		enterRule(_localctx, 42, RULE_dotFunctionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			dotFunctionExpression();
			setState(273);
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
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
		public CallFunctionExpressionContext callFunctionExpression() {
			return getRuleContext(CallFunctionExpressionContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(MxParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(MxParser.CloseParen, 0); }
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TerminalNode Mul() { return getToken(MxParser.Mul, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_valuebleSingleExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(276);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(277);
				variableTypeExpression();
				}
				break;
			case 3:
				{
				setState(278);
				constant();
				}
				break;
			case 4:
				{
				setState(279);
				match(This);
				}
				break;
			case 5:
				{
				setState(280);
				dotExpression();
				}
				break;
			case 6:
				{
				setState(281);
				subscriptExpression();
				}
				break;
			case 7:
				{
				setState(282);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(283);
				valuebleSingleExpression(17);
				}
				break;
			case 8:
				{
				setState(284);
				_la = _input.LA(1);
				if ( !(_la==Lnot || _la==Not) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(285);
				valuebleSingleExpression(15);
				}
				break;
			case 9:
				{
				setState(286);
				match(Div);
				setState(287);
				valuebleSingleExpression(13);
				}
				break;
			case 10:
				{
				setState(288);
				callFunctionExpression();
				}
				break;
			case 11:
				{
				setState(289);
				match(OpenParen);
				setState(290);
				valuebleSingleExpression(0);
				setState(291);
				match(CloseParen);
				}
				break;
			case 12:
				{
				setState(293);
				match(New);
				setState(294);
				match(Identifier);
				setState(297);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(295);
					match(OpenParen);
					setState(296);
					match(CloseParen);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(335);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(333);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(301);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(302);
						_la = _input.LA(1);
						if ( !(_la==Mul || _la==Div) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(303);
						valuebleSingleExpression(15);
						}
						break;
					case 2:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(304);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(305);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << Mod))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(306);
						valuebleSingleExpression(13);
						}
						break;
					case 3:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(307);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(308);
						_la = _input.LA(1);
						if ( !(_la==Lshift || _la==Rshift) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(309);
						valuebleSingleExpression(12);
						}
						break;
					case 4:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(310);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(311);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lt) | (1L << Gt) | (1L << Le) | (1L << Ge))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(312);
						valuebleSingleExpression(11);
						}
						break;
					case 5:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(313);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(314);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==Notequal) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(315);
						valuebleSingleExpression(10);
						}
						break;
					case 6:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(316);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(317);
						match(And);
						setState(318);
						valuebleSingleExpression(9);
						}
						break;
					case 7:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(319);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(320);
						match(Xor);
						setState(321);
						valuebleSingleExpression(8);
						}
						break;
					case 8:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(322);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(323);
						match(Or);
						setState(324);
						valuebleSingleExpression(7);
						}
						break;
					case 9:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(325);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(326);
						match(Land);
						setState(327);
						valuebleSingleExpression(6);
						}
						break;
					case 10:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(328);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(329);
						match(Lor);
						setState(330);
						valuebleSingleExpression(5);
						}
						break;
					case 11:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(331);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(332);
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
				setState(337);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		enterRule(_localctx, 46, RULE_variableTypeExpression);
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
				variableNormalTypeExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
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
		enterRule(_localctx, 48, RULE_variableNormalTypeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
			case Int:
			case String:
			case Void:
				{
				setState(342);
				primaryType();
				}
				break;
			case Identifier:
				{
				setState(343);
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
		enterRule(_localctx, 50, RULE_variableArrayTypeExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
			case Int:
			case String:
			case Void:
				{
				setState(346);
				primaryType();
				}
				break;
			case Identifier:
				{
				setState(347);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(357);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(350);
						match(OpenBlacket);
						setState(352);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << Inc) | (1L << Dec) | (1L << Div) | (1L << Lnot) | (1L << Not) | (1L << New) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
							{
							setState(351);
							valuebleSingleExpression(0);
							}
						}

						setState(354);
						match(CloseBlacket);
						}
						} 
					}
					setState(359);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		enterRule(_localctx, 52, RULE_dotExpression);
		try {
			setState(364);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(362);
				dotVariableExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(363);
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
		enterRule(_localctx, 54, RULE_dotVariableExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(366);
				className();
				}
				break;
			case 2:
				{
				setState(367);
				subscriptExpression();
				}
				break;
			case 3:
				{
				setState(368);
				callFunctionExpression();
				}
				break;
			case 4:
				{
				setState(369);
				match(This);
				}
				break;
			}
			setState(372);
			match(Dot);
			setState(375);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(373);
				dotExpression();
				}
				break;
			case 2:
				{
				setState(374);
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
		public List<CallFunctionExpressionContext> callFunctionExpression() {
			return getRuleContexts(CallFunctionExpressionContext.class);
		}
		public CallFunctionExpressionContext callFunctionExpression(int i) {
			return getRuleContext(CallFunctionExpressionContext.class,i);
		}
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public SubscriptExpressionContext subscriptExpression() {
			return getRuleContext(SubscriptExpressionContext.class,0);
		}
		public TerminalNode StringConstant() { return getToken(MxParser.StringConstant, 0); }
		public TerminalNode This() { return getToken(MxParser.This, 0); }
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
		enterRule(_localctx, 56, RULE_dotFunctionExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(377);
				className();
				}
				break;
			case 2:
				{
				setState(378);
				subscriptExpression();
				}
				break;
			case 3:
				{
				setState(379);
				match(StringConstant);
				}
				break;
			case 4:
				{
				setState(380);
				callFunctionExpression();
				}
				break;
			case 5:
				{
				setState(381);
				match(This);
				}
				break;
			}
			setState(384);
			match(Dot);
			setState(385);
			callFunctionExpression();
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
		enterRule(_localctx, 58, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
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
		enterRule(_localctx, 60, RULE_subscriptExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			className();
			setState(396);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(390);
					match(OpenBlacket);
					{
					setState(391);
					valuebleSingleExpression(0);
					}
					setState(392);
					match(CloseBlacket);
					}
					} 
				}
				setState(398);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
		enterRule(_localctx, 62, RULE_callFunctionExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			match(Identifier);
			setState(400);
			match(OpenParen);
			setState(403);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(401);
				valuebleListExpression();
				}
				break;
			case 2:
				{
				setState(402);
				valuebleSingleExpression(0);
				}
				break;
			}
			setState(405);
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
		enterRule(_localctx, 64, RULE_valuebleListExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			valuebleSingleExpression(0);
			setState(410); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(408);
				match(Comma);
				setState(409);
				valuebleSingleExpression(0);
				}
				}
				setState(412); 
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
		enterRule(_localctx, 66, RULE_definitionExpression);
		try {
			setState(417);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(414);
				definitionNormalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(415);
				definitionArrayExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(416);
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
		enterRule(_localctx, 68, RULE_definitionNormalExpression);
		int _la;
		try {
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				variableNormalTypeExpression();
				setState(420);
				match(Identifier);
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(421);
					match(Assign);
					setState(422);
					valuebleSingleExpression(0);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(425);
				variableNormalTypeExpression();
				setState(426);
				match(Identifier);
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OpenParen) {
					{
					setState(427);
					match(OpenParen);
					setState(428);
					valuebleSingleExpression(0);
					setState(429);
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
		enterRule(_localctx, 70, RULE_definitionArrayExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			variableArrayTypeExpression();
			setState(436);
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
		enterRule(_localctx, 72, RULE_assignExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			valuebleSingleExpression(0);
			setState(439);
			match(Assign);
			setState(440);
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
		enterRule(_localctx, 74, RULE_primaryType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
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
		enterRule(_localctx, 76, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
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
		case 22:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u01c1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\7\2R\n\2\f\2\16"+
		"\2U\13\2\3\3\3\3\3\3\5\3Z\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\7\6"+
		"e\n\6\f\6\16\6h\13\6\3\6\7\6k\n\6\f\6\16\6n\13\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\7\7v\n\7\f\7\16\7y\13\7\7\7{\n\7\f\7\16\7~\13\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\5\b\u0086\n\b\3\t\3\t\7\t\u008a\n\t\f\t\16\t\u008d\13\t\3\t\3\t\5"+
		"\t\u0091\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u00a3\n\n\3\13\3\13\3\f\3\f\3\f\3\r\5\r\u00ab\n\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00bf"+
		"\n\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00cb\n\17"+
		"\3\20\3\20\3\20\3\20\5\20\u00d1\n\20\3\20\5\20\u00d4\n\20\3\20\3\20\3"+
		"\20\5\20\u00d9\n\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e1\n\20\3\20"+
		"\3\20\3\20\5\20\u00e6\n\20\3\20\3\20\3\20\5\20\u00eb\n\20\5\20\u00ed\n"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\5\23\u00fb"+
		"\n\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u0105\n\25\3\25\3\25"+
		"\3\25\5\25\u010a\n\25\3\25\3\25\5\25\u010e\n\25\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u012c\n\30\5\30"+
		"\u012e\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0150\n\30\f\30\16\30\u0153\13\30"+
		"\3\31\3\31\5\31\u0157\n\31\3\32\3\32\5\32\u015b\n\32\3\33\3\33\5\33\u015f"+
		"\n\33\3\33\3\33\5\33\u0163\n\33\3\33\7\33\u0166\n\33\f\33\16\33\u0169"+
		"\13\33\5\33\u016b\n\33\3\34\3\34\5\34\u016f\n\34\3\35\3\35\3\35\3\35\5"+
		"\35\u0175\n\35\3\35\3\35\3\35\5\35\u017a\n\35\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u0181\n\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \7 \u018d\n \f"+
		" \16 \u0190\13 \3!\3!\3!\3!\5!\u0196\n!\3!\3!\3\"\3\"\3\"\6\"\u019d\n"+
		"\"\r\"\16\"\u019e\3#\3#\3#\5#\u01a4\n#\3$\3$\3$\3$\5$\u01aa\n$\3$\3$\3"+
		"$\3$\3$\3$\5$\u01b2\n$\5$\u01b4\n$\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3(\3("+
		"\3(\2\3.)\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLN\2\13\3\2\r\16\4\2\26\26\31\31\3\2\21\22\4\2\17\20\23\23\3"+
		"\2\27\30\4\2\35\36 !\4\2\37\37\"\"\3\2-\60\3\2\61\64\2\u01f3\2S\3\2\2"+
		"\2\4Y\3\2\2\2\6[\3\2\2\2\ba\3\2\2\2\nf\3\2\2\2\fo\3\2\2\2\16\u0085\3\2"+
		"\2\2\20\u0090\3\2\2\2\22\u00a2\3\2\2\2\24\u00a4\3\2\2\2\26\u00a6\3\2\2"+
		"\2\30\u00be\3\2\2\2\32\u00c0\3\2\2\2\34\u00c3\3\2\2\2\36\u00ec\3\2\2\2"+
		" \u00ee\3\2\2\2\"\u00f4\3\2\2\2$\u00f7\3\2\2\2&\u00fe\3\2\2\2(\u010d\3"+
		"\2\2\2*\u010f\3\2\2\2,\u0112\3\2\2\2.\u012d\3\2\2\2\60\u0156\3\2\2\2\62"+
		"\u015a\3\2\2\2\64\u015e\3\2\2\2\66\u016e\3\2\2\28\u0174\3\2\2\2:\u0180"+
		"\3\2\2\2<\u0185\3\2\2\2>\u0187\3\2\2\2@\u0191\3\2\2\2B\u0199\3\2\2\2D"+
		"\u01a3\3\2\2\2F\u01b3\3\2\2\2H\u01b5\3\2\2\2J\u01b8\3\2\2\2L\u01bc\3\2"+
		"\2\2N\u01be\3\2\2\2PR\5\4\3\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2"+
		"T\3\3\2\2\2US\3\2\2\2VZ\5\6\4\2WZ\5\f\7\2XZ\5\16\b\2YV\3\2\2\2YW\3\2\2"+
		"\2YX\3\2\2\2Z\5\3\2\2\2[\\\7*\2\2\\]\5\b\5\2]^\7\5\2\2^_\5\n\6\2_`\7\6"+
		"\2\2`\7\3\2\2\2ab\7\65\2\2b\t\3\2\2\2ce\5\26\f\2dc\3\2\2\2eh\3\2\2\2f"+
		"d\3\2\2\2fg\3\2\2\2gl\3\2\2\2hf\3\2\2\2ik\5\f\7\2ji\3\2\2\2kn\3\2\2\2"+
		"lj\3\2\2\2lm\3\2\2\2m\13\3\2\2\2nl\3\2\2\2op\5\60\31\2pq\5<\37\2q|\7\3"+
		"\2\2rw\5D#\2st\7\n\2\2tv\5D#\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2"+
		"x{\3\2\2\2yw\3\2\2\2zr\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2"+
		"\2\2~|\3\2\2\2\177\u0080\7\4\2\2\u0080\u0081\5\20\t\2\u0081\r\3\2\2\2"+
		"\u0082\u0086\5\26\f\2\u0083\u0086\5\32\16\2\u0084\u0086\5\30\r\2\u0085"+
		"\u0082\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086\17\3\2\2"+
		"\2\u0087\u008b\7\5\2\2\u0088\u008a\5\22\n\2\u0089\u0088\3\2\2\2\u008a"+
		"\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2"+
		"\2\2\u008d\u008b\3\2\2\2\u008e\u0091\7\6\2\2\u008f\u0091\5\22\n\2\u0090"+
		"\u0087\3\2\2\2\u0090\u008f\3\2\2\2\u0091\21\3\2\2\2\u0092\u00a3\5\30\r"+
		"\2\u0093\u00a3\5\26\f\2\u0094\u00a3\5\32\16\2\u0095\u00a3\5\34\17\2\u0096"+
		"\u00a3\5\36\20\2\u0097\u00a3\5 \21\2\u0098\u00a3\5\"\22\2\u0099\u00a3"+
		"\5$\23\2\u009a\u00a3\5&\24\2\u009b\u00a3\5(\25\2\u009c\u00a3\5*\26\2\u009d"+
		"\u00a3\5,\27\2\u009e\u009f\5.\30\2\u009f\u00a0\7\t\2\2\u00a0\u00a3\3\2"+
		"\2\2\u00a1\u00a3\5\24\13\2\u00a2\u0092\3\2\2\2\u00a2\u0093\3\2\2\2\u00a2"+
		"\u0094\3\2\2\2\u00a2\u0095\3\2\2\2\u00a2\u0096\3\2\2\2\u00a2\u0097\3\2"+
		"\2\2\u00a2\u0098\3\2\2\2\u00a2\u0099\3\2\2\2\u00a2\u009a\3\2\2\2\u00a2"+
		"\u009b\3\2\2\2\u00a2\u009c\3\2\2\2\u00a2\u009d\3\2\2\2\u00a2\u009e\3\2"+
		"\2\2\u00a2\u00a1\3\2\2\2\u00a3\23\3\2\2\2\u00a4\u00a5\7\t\2\2\u00a5\25"+
		"\3\2\2\2\u00a6\u00a7\5D#\2\u00a7\u00a8\7\t\2\2\u00a8\27\3\2\2\2\u00a9"+
		"\u00ab\5\60\31\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3"+
		"\2\2\2\u00ac\u00ad\7\65\2\2\u00ad\u00ae\7\f\2\2\u00ae\u00af\7+\2\2\u00af"+
		"\u00b0\5\60\31\2\u00b0\u00b1\7\t\2\2\u00b1\u00bf\3\2\2\2\u00b2\u00b3\5"+
		"> \2\u00b3\u00b4\7\f\2\2\u00b4\u00b5\7+\2\2\u00b5\u00b6\5\60\31\2\u00b6"+
		"\u00b7\7\t\2\2\u00b7\u00bf\3\2\2\2\u00b8\u00b9\58\35\2\u00b9\u00ba\7\f"+
		"\2\2\u00ba\u00bb\7+\2\2\u00bb\u00bc\5\60\31\2\u00bc\u00bd\7\t\2\2\u00bd"+
		"\u00bf\3\2\2\2\u00be\u00aa\3\2\2\2\u00be\u00b2\3\2\2\2\u00be\u00b8\3\2"+
		"\2\2\u00bf\31\3\2\2\2\u00c0\u00c1\5J&\2\u00c1\u00c2\7\t\2\2\u00c2\33\3"+
		"\2\2\2\u00c3\u00c4\7#\2\2\u00c4\u00c5\7\3\2\2\u00c5\u00c6\5.\30\2\u00c6"+
		"\u00c7\7\4\2\2\u00c7\u00ca\5\20\t\2\u00c8\u00c9\7$\2\2\u00c9\u00cb\5\20"+
		"\t\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\35\3\2\2\2\u00cc\u00cd"+
		"\7%\2\2\u00cd\u00d0\7\3\2\2\u00ce\u00d1\5\26\f\2\u00cf\u00d1\5\32\16\2"+
		"\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3"+
		"\3\2\2\2\u00d2\u00d4\5.\30\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d8\7\t\2\2\u00d6\u00d9\5J&\2\u00d7\u00d9\5.\30"+
		"\2\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da"+
		"\3\2\2\2\u00da\u00db\7\4\2\2\u00db\u00ed\5\20\t\2\u00dc\u00dd\7%\2\2\u00dd"+
		"\u00de\7\3\2\2\u00de\u00e0\7\t\2\2\u00df\u00e1\5.\30\2\u00e0\u00df\3\2"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e5\7\t\2\2\u00e3"+
		"\u00e6\5J&\2\u00e4\u00e6\5.\30\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2\2"+
		"\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00ea\7\4\2\2\u00e8\u00eb"+
		"\7\t\2\2\u00e9\u00eb\5\20\t\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2"+
		"\u00eb\u00ed\3\2\2\2\u00ec\u00cc\3\2\2\2\u00ec\u00dc\3\2\2\2\u00ed\37"+
		"\3\2\2\2\u00ee\u00ef\7&\2\2\u00ef\u00f0\7\3\2\2\u00f0\u00f1\5.\30\2\u00f1"+
		"\u00f2\7\4\2\2\u00f2\u00f3\5\20\t\2\u00f3!\3\2\2\2\u00f4\u00f5\7\'\2\2"+
		"\u00f5\u00f6\7\t\2\2\u00f6#\3\2\2\2\u00f7\u00fa\7)\2\2\u00f8\u00fb\5."+
		"\30\2\u00f9\u00fb\5B\"\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\7\t\2\2\u00fd%\3\2\2\2"+
		"\u00fe\u00ff\7(\2\2\u00ff\u0100\7\t\2\2\u0100\'\3\2\2\2\u0101\u0104\t"+
		"\2\2\2\u0102\u0105\7\65\2\2\u0103\u0105\58\35\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u010e\7\t\2\2\u0107\u010a\7\65"+
		"\2\2\u0108\u010a\58\35\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010c\t\2\2\2\u010c\u010e\7\t\2\2\u010d\u0101\3\2"+
		"\2\2\u010d\u0109\3\2\2\2\u010e)\3\2\2\2\u010f\u0110\5@!\2\u0110\u0111"+
		"\7\t\2\2\u0111+\3\2\2\2\u0112\u0113\5:\36\2\u0113\u0114\7\t\2\2\u0114"+
		"-\3\2\2\2\u0115\u0116\b\30\1\2\u0116\u012e\7\65\2\2\u0117\u012e\5\60\31"+
		"\2\u0118\u012e\5N(\2\u0119\u012e\7,\2\2\u011a\u012e\5\66\34\2\u011b\u012e"+
		"\5> \2\u011c\u011d\t\2\2\2\u011d\u012e\5.\30\23\u011e\u011f\t\3\2\2\u011f"+
		"\u012e\5.\30\21\u0120\u0121\7\22\2\2\u0121\u012e\5.\30\17\u0122\u012e"+
		"\5@!\2\u0123\u0124\7\3\2\2\u0124\u0125\5.\30\2\u0125\u0126\7\4\2\2\u0126"+
		"\u012e\3\2\2\2\u0127\u0128\7+\2\2\u0128\u012b\7\65\2\2\u0129\u012a\7\3"+
		"\2\2\u012a\u012c\7\4\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"\u012e\3\2\2\2\u012d\u0115\3\2\2\2\u012d\u0117\3\2\2\2\u012d\u0118\3\2"+
		"\2\2\u012d\u0119\3\2\2\2\u012d\u011a\3\2\2\2\u012d\u011b\3\2\2\2\u012d"+
		"\u011c\3\2\2\2\u012d\u011e\3\2\2\2\u012d\u0120\3\2\2\2\u012d\u0122\3\2"+
		"\2\2\u012d\u0123\3\2\2\2\u012d\u0127\3\2\2\2\u012e\u0151\3\2\2\2\u012f"+
		"\u0130\f\20\2\2\u0130\u0131\t\4\2\2\u0131\u0150\5.\30\21\u0132\u0133\f"+
		"\16\2\2\u0133\u0134\t\5\2\2\u0134\u0150\5.\30\17\u0135\u0136\f\r\2\2\u0136"+
		"\u0137\t\6\2\2\u0137\u0150\5.\30\16\u0138\u0139\f\f\2\2\u0139\u013a\t"+
		"\7\2\2\u013a\u0150\5.\30\r\u013b\u013c\f\13\2\2\u013c\u013d\t\b\2\2\u013d"+
		"\u0150\5.\30\f\u013e\u013f\f\n\2\2\u013f\u0140\7\33\2\2\u0140\u0150\5"+
		".\30\13\u0141\u0142\f\t\2\2\u0142\u0143\7\34\2\2\u0143\u0150\5.\30\n\u0144"+
		"\u0145\f\b\2\2\u0145\u0146\7\32\2\2\u0146\u0150\5.\30\t\u0147\u0148\f"+
		"\7\2\2\u0148\u0149\7\24\2\2\u0149\u0150\5.\30\b\u014a\u014b\f\6\2\2\u014b"+
		"\u014c\7\25\2\2\u014c\u0150\5.\30\7\u014d\u014e\f\22\2\2\u014e\u0150\t"+
		"\2\2\2\u014f\u012f\3\2\2\2\u014f\u0132\3\2\2\2\u014f\u0135\3\2\2\2\u014f"+
		"\u0138\3\2\2\2\u014f\u013b\3\2\2\2\u014f\u013e\3\2\2\2\u014f\u0141\3\2"+
		"\2\2\u014f\u0144\3\2\2\2\u014f\u0147\3\2\2\2\u014f\u014a\3\2\2\2\u014f"+
		"\u014d\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2"+
		"\2\2\u0152/\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0157\5\62\32\2\u0155\u0157"+
		"\5\64\33\2\u0156\u0154\3\2\2\2\u0156\u0155\3\2\2\2\u0157\61\3\2\2\2\u0158"+
		"\u015b\5L\'\2\u0159\u015b\7\65\2\2\u015a\u0158\3\2\2\2\u015a\u0159\3\2"+
		"\2\2\u015b\63\3\2\2\2\u015c\u015f\5L\'\2\u015d\u015f\7\65\2\2\u015e\u015c"+
		"\3\2\2\2\u015e\u015d\3\2\2\2\u015f\u016a\3\2\2\2\u0160\u0162\7\7\2\2\u0161"+
		"\u0163\5.\30\2\u0162\u0161\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\3\2"+
		"\2\2\u0164\u0166\7\b\2\2\u0165\u0160\3\2\2\2\u0166\u0169\3\2\2\2\u0167"+
		"\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2"+
		"\2\2\u016a\u0167\3\2\2\2\u016a\u016b\3\2\2\2\u016b\65\3\2\2\2\u016c\u016f"+
		"\58\35\2\u016d\u016f\5:\36\2\u016e\u016c\3\2\2\2\u016e\u016d\3\2\2\2\u016f"+
		"\67\3\2\2\2\u0170\u0175\5\b\5\2\u0171\u0175\5> \2\u0172\u0175\5@!\2\u0173"+
		"\u0175\7,\2\2\u0174\u0170\3\2\2\2\u0174\u0171\3\2\2\2\u0174\u0172\3\2"+
		"\2\2\u0174\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0179\7\13\2\2\u0177"+
		"\u017a\5\66\34\2\u0178\u017a\5\b\5\2\u0179\u0177\3\2\2\2\u0179\u0178\3"+
		"\2\2\2\u017a9\3\2\2\2\u017b\u0181\5\b\5\2\u017c\u0181\5> \2\u017d\u0181"+
		"\7\63\2\2\u017e\u0181\5@!\2\u017f\u0181\7,\2\2\u0180\u017b\3\2\2\2\u0180"+
		"\u017c\3\2\2\2\u0180\u017d\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u017f\3\2"+
		"\2\2\u0181\u0182\3\2\2\2\u0182\u0183\7\13\2\2\u0183\u0184\5@!\2\u0184"+
		";\3\2\2\2\u0185\u0186\7\65\2\2\u0186=\3\2\2\2\u0187\u018e\5\b\5\2\u0188"+
		"\u0189\7\7\2\2\u0189\u018a\5.\30\2\u018a\u018b\7\b\2\2\u018b\u018d\3\2"+
		"\2\2\u018c\u0188\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f?\3\2\2\2\u0190\u018e\3\2\2\2\u0191\u0192\7\65\2\2"+
		"\u0192\u0195\7\3\2\2\u0193\u0196\5B\"\2\u0194\u0196\5.\30\2\u0195\u0193"+
		"\3\2\2\2\u0195\u0194\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197"+
		"\u0198\7\4\2\2\u0198A\3\2\2\2\u0199\u019c\5.\30\2\u019a\u019b\7\n\2\2"+
		"\u019b\u019d\5.\30\2\u019c\u019a\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019c"+
		"\3\2\2\2\u019e\u019f\3\2\2\2\u019fC\3\2\2\2\u01a0\u01a4\5F$\2\u01a1\u01a4"+
		"\5H%\2\u01a2\u01a4\7+\2\2\u01a3\u01a0\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3"+
		"\u01a2\3\2\2\2\u01a4E\3\2\2\2\u01a5\u01a6\5\62\32\2\u01a6\u01a9\7\65\2"+
		"\2\u01a7\u01a8\7\f\2\2\u01a8\u01aa\5.\30\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa"+
		"\3\2\2\2\u01aa\u01b4\3\2\2\2\u01ab\u01ac\5\62\32\2\u01ac\u01b1\7\65\2"+
		"\2\u01ad\u01ae\7\3\2\2\u01ae\u01af\5.\30\2\u01af\u01b0\7\4\2\2\u01b0\u01b2"+
		"\3\2\2\2\u01b1\u01ad\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b4\3\2\2\2\u01b3"+
		"\u01a5\3\2\2\2\u01b3\u01ab\3\2\2\2\u01b4G\3\2\2\2\u01b5\u01b6\5\64\33"+
		"\2\u01b6\u01b7\7\65\2\2\u01b7I\3\2\2\2\u01b8\u01b9\5.\30\2\u01b9\u01ba"+
		"\7\f\2\2\u01ba\u01bb\5.\30\2\u01bbK\3\2\2\2\u01bc\u01bd\t\t\2\2\u01bd"+
		"M\3\2\2\2\u01be\u01bf\t\n\2\2\u01bfO\3\2\2\2/SYflw|\u0085\u008b\u0090"+
		"\u00a2\u00aa\u00be\u00ca\u00d0\u00d3\u00d8\u00e0\u00e5\u00ea\u00ec\u00fa"+
		"\u0104\u0109\u010d\u012b\u012d\u014f\u0151\u0156\u015a\u015e\u0162\u0167"+
		"\u016a\u016e\u0174\u0179\u0180\u018e\u0195\u019e\u01a3\u01a9\u01b1\u01b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}