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
		RULE_selfOperationStatement = 19, RULE_valuebleSingleExpression = 20, 
		RULE_variableTypeExpression = 21, RULE_variableNormalTypeExpression = 22, 
		RULE_variableArrayTypeExpression = 23, RULE_dotExpression = 24, RULE_dotVariableExpression = 25, 
		RULE_dotFunctionExpression = 26, RULE_functionName = 27, RULE_subscriptExpression = 28, 
		RULE_callFunctionExpression = 29, RULE_valuebleListExpression = 30, RULE_definitionExpression = 31, 
		RULE_definitionNormalExpression = 32, RULE_definitionArrayExpression = 33, 
		RULE_assignExpression = 34, RULE_primaryType = 35, RULE_constant = 36;
	public static final String[] ruleNames = {
		"program", "programItem", "classDefinition", "className", "classBody", 
		"functionDefinition", "globalVariable", "blockStatement", "statement", 
		"emptyStatement", "definitionStatement", "newStatement", "assignStatement", 
		"ifStatement", "forStatement", "whileStatement", "breakStatement", "returnStatement", 
		"continueStatement", "selfOperationStatement", "valuebleSingleExpression", 
		"variableTypeExpression", "variableNormalTypeExpression", "variableArrayTypeExpression", 
		"dotExpression", "dotVariableExpression", "dotFunctionExpression", "functionName", 
		"subscriptExpression", "callFunctionExpression", "valuebleListExpression", 
		"definitionExpression", "definitionNormalExpression", "definitionArrayExpression", 
		"assignExpression", "primaryType", "constant"
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
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << Inc) | (1L << Dec) | (1L << Lnot) | (1L << Not) | (1L << Class) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
				{
				{
				setState(74);
				programItem();
				}
				}
				setState(79);
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
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(80);
				classDefinition();
				}
				break;
			case 2:
				{
				setState(81);
				functionDefinition();
				}
				break;
			case 3:
				{
				setState(82);
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
			setState(85);
			match(Class);
			setState(86);
			className();
			setState(87);
			match(OpenCurly);
			setState(88);
			classBody();
			setState(89);
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
			setState(91);
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
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(93);
					definitionStatement();
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(99);
				functionDefinition();
				}
				}
				setState(104);
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
			setState(105);
			variableTypeExpression();
			setState(106);
			functionName();
			setState(107);
			match(OpenParen);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(108);
				definitionExpression();
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(109);
					match(Comma);
					setState(110);
					definitionExpression();
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			match(CloseParen);
			setState(122);
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
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(124);
				definitionStatement();
				}
				break;
			case 2:
				{
				setState(125);
				assignStatement();
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
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenCurly:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(OpenCurly);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << Semi) | (1L << Inc) | (1L << Dec) | (1L << Lnot) | (1L << Not) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
					{
					{
					setState(129);
					statement();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135);
				match(CloseCurly);
				}
				break;
			case OpenParen:
			case Semi:
			case Inc:
			case Dec:
			case Lnot:
			case Not:
			case If:
			case For:
			case While:
			case Break:
			case Continue:
			case Return:
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
				setState(136);
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
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public DefinitionStatementContext definitionStatement() {
			return getRuleContext(DefinitionStatementContext.class,0);
		}
		public NewStatementContext newStatement() {
			return getRuleContext(NewStatementContext.class,0);
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
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				emptyStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				definitionStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				newStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				assignStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
				ifStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(144);
				forStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(145);
				whileStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(146);
				breakStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(147);
				returnStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(148);
				continueStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(149);
				selfOperationStatement();
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
			setState(152);
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
			setState(154);
			definitionExpression();
			setState(155);
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
		public List<VariableTypeExpressionContext> variableTypeExpression() {
			return getRuleContexts(VariableTypeExpressionContext.class);
		}
		public VariableTypeExpressionContext variableTypeExpression(int i) {
			return getRuleContext(VariableTypeExpressionContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			variableTypeExpression();
			setState(158);
			match(Identifier);
			setState(159);
			match(Assign);
			setState(160);
			match(New);
			setState(161);
			variableTypeExpression();
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
			setState(164);
			assignExpression();
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
			setState(167);
			match(If);
			setState(168);
			match(OpenParen);
			setState(169);
			valuebleSingleExpression(0);
			setState(170);
			match(CloseParen);
			setState(171);
			blockStatement();
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(172);
				match(Else);
				setState(173);
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
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
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
		public AssignExpressionContext assignExpression() {
			return getRuleContext(AssignExpressionContext.class,0);
		}
		public List<ValuebleSingleExpressionContext> valuebleSingleExpression() {
			return getRuleContexts(ValuebleSingleExpressionContext.class);
		}
		public ValuebleSingleExpressionContext valuebleSingleExpression(int i) {
			return getRuleContext(ValuebleSingleExpressionContext.class,i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(For);
			setState(177);
			match(OpenParen);
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(178);
				definitionStatement();
				}
				break;
			case 2:
				{
				setState(179);
				assignStatement();
				}
				break;
			}
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpenParen) | (1L << Inc) | (1L << Dec) | (1L << Lnot) | (1L << Not) | (1L << This) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << LogicConstant) | (1L << IntegerConstant) | (1L << StringConstant) | (1L << NullConstant) | (1L << Identifier))) != 0)) {
				{
				setState(182);
				valuebleSingleExpression(0);
				}
			}

			setState(185);
			match(Semi);
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(186);
				assignExpression();
				}
				break;
			case 2:
				{
				setState(187);
				valuebleSingleExpression(0);
				}
				break;
			}
			setState(190);
			match(CloseParen);
			setState(191);
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
			setState(193);
			match(While);
			setState(194);
			match(OpenParen);
			setState(195);
			valuebleSingleExpression(0);
			setState(196);
			match(CloseParen);
			setState(197);
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
			setState(199);
			match(Break);
			setState(200);
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
			setState(202);
			match(Return);
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(203);
				valuebleSingleExpression(0);
				}
				break;
			case 2:
				{
				setState(204);
				valuebleListExpression();
				}
				break;
			}
			setState(207);
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
			setState(209);
			match(Continue);
			setState(210);
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
		public TerminalNode Not() { return getToken(MxParser.Not, 0); }
		public TerminalNode Lnot() { return getToken(MxParser.Lnot, 0); }
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
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Inc:
			case Dec:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(215);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(213);
					match(Identifier);
					}
					break;
				case 2:
					{
					setState(214);
					dotVariableExpression();
					}
					break;
				}
				setState(217);
				match(Semi);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(218);
					match(Identifier);
					}
					break;
				case 2:
					{
					setState(219);
					dotVariableExpression();
					}
					break;
				}
				setState(222);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(223);
				match(Semi);
				}
				break;
			case Lnot:
			case Not:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				_la = _input.LA(1);
				if ( !(_la==Lnot || _la==Not) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(227);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(225);
					match(Identifier);
					}
					break;
				case 2:
					{
					setState(226);
					dotVariableExpression();
					}
					break;
				}
				setState(229);
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
		public CallFunctionExpressionContext callFunctionExpression() {
			return getRuleContext(CallFunctionExpressionContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(MxParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(MxParser.CloseParen, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
		public TerminalNode Mul() { return getToken(MxParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_valuebleSingleExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(233);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(234);
				variableTypeExpression();
				}
				break;
			case 3:
				{
				setState(235);
				constant();
				}
				break;
			case 4:
				{
				setState(236);
				match(This);
				}
				break;
			case 5:
				{
				setState(237);
				dotExpression();
				}
				break;
			case 6:
				{
				setState(238);
				subscriptExpression();
				}
				break;
			case 7:
				{
				setState(239);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(240);
				valuebleSingleExpression(15);
				}
				break;
			case 8:
				{
				setState(241);
				_la = _input.LA(1);
				if ( !(_la==Lnot || _la==Not) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(242);
				valuebleSingleExpression(13);
				}
				break;
			case 9:
				{
				setState(243);
				callFunctionExpression();
				}
				break;
			case 10:
				{
				setState(244);
				match(OpenParen);
				setState(245);
				valuebleSingleExpression(0);
				setState(246);
				match(CloseParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(284);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(282);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(250);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(251);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << Mod))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(252);
						valuebleSingleExpression(13);
						}
						break;
					case 2:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(253);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(254);
						_la = _input.LA(1);
						if ( !(_la==Mul || _la==Div) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(255);
						valuebleSingleExpression(12);
						}
						break;
					case 3:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(256);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(257);
						_la = _input.LA(1);
						if ( !(_la==Lshift || _la==Rshift) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(258);
						valuebleSingleExpression(11);
						}
						break;
					case 4:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(259);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(260);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lt) | (1L << Gt) | (1L << Le) | (1L << Ge))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(261);
						valuebleSingleExpression(10);
						}
						break;
					case 5:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(262);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(263);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==Notequal) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(264);
						valuebleSingleExpression(9);
						}
						break;
					case 6:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(265);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(266);
						match(And);
						setState(267);
						valuebleSingleExpression(8);
						}
						break;
					case 7:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(268);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(269);
						match(Xor);
						setState(270);
						valuebleSingleExpression(7);
						}
						break;
					case 8:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(271);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(272);
						match(Or);
						setState(273);
						valuebleSingleExpression(6);
						}
						break;
					case 9:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(274);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(275);
						match(Land);
						setState(276);
						valuebleSingleExpression(5);
						}
						break;
					case 10:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(277);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(278);
						match(Lor);
						setState(279);
						valuebleSingleExpression(4);
						}
						break;
					case 11:
						{
						_localctx = new ValuebleSingleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_valuebleSingleExpression);
						setState(280);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(281);
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
				setState(286);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		enterRule(_localctx, 42, RULE_variableTypeExpression);
		try {
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				variableNormalTypeExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
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
		enterRule(_localctx, 44, RULE_variableNormalTypeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
			case Int:
			case String:
			case Void:
				{
				setState(291);
				primaryType();
				}
				break;
			case Identifier:
				{
				setState(292);
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
		public List<TerminalNode> IntegerConstant() { return getTokens(MxParser.IntegerConstant); }
		public TerminalNode IntegerConstant(int i) {
			return getToken(MxParser.IntegerConstant, i);
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
		enterRule(_localctx, 46, RULE_variableArrayTypeExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
			case Int:
			case String:
			case Void:
				{
				setState(295);
				primaryType();
				}
				break;
			case Identifier:
				{
				setState(296);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(306);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(299);
						match(OpenBlacket);
						setState(301);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==IntegerConstant) {
							{
							setState(300);
							match(IntegerConstant);
							}
						}

						setState(303);
						match(CloseBlacket);
						}
						} 
					}
					setState(308);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
		enterRule(_localctx, 48, RULE_dotExpression);
		try {
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				dotVariableExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
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
		public List<ClassNameContext> className() {
			return getRuleContexts(ClassNameContext.class);
		}
		public ClassNameContext className(int i) {
			return getRuleContext(ClassNameContext.class,i);
		}
		public TerminalNode Dot() { return getToken(MxParser.Dot, 0); }
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
		enterRule(_localctx, 50, RULE_dotVariableExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			className();
			setState(316);
			match(Dot);
			setState(317);
			className();
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
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode Dot() { return getToken(MxParser.Dot, 0); }
		public CallFunctionExpressionContext callFunctionExpression() {
			return getRuleContext(CallFunctionExpressionContext.class,0);
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
		enterRule(_localctx, 52, RULE_dotFunctionExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			className();
			setState(320);
			match(Dot);
			setState(321);
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
		enterRule(_localctx, 54, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
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
		public TerminalNode OpenBlacket() { return getToken(MxParser.OpenBlacket, 0); }
		public TerminalNode CloseBlacket() { return getToken(MxParser.CloseBlacket, 0); }
		public ValuebleSingleExpressionContext valuebleSingleExpression() {
			return getRuleContext(ValuebleSingleExpressionContext.class,0);
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
		enterRule(_localctx, 56, RULE_subscriptExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			className();
			setState(326);
			match(OpenBlacket);
			{
			setState(327);
			valuebleSingleExpression(0);
			}
			setState(328);
			match(CloseBlacket);
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
		enterRule(_localctx, 58, RULE_callFunctionExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(Identifier);
			setState(331);
			match(OpenParen);
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(332);
				valuebleListExpression();
				}
				break;
			case 2:
				{
				setState(333);
				valuebleSingleExpression(0);
				}
				break;
			}
			setState(336);
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
		enterRule(_localctx, 60, RULE_valuebleListExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			valuebleSingleExpression(0);
			setState(341); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(339);
				match(Comma);
				setState(340);
				valuebleSingleExpression(0);
				}
				}
				setState(343); 
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
		enterRule(_localctx, 62, RULE_definitionExpression);
		try {
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				definitionNormalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
				definitionArrayExpression();
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
		enterRule(_localctx, 64, RULE_definitionNormalExpression);
		int _la;
		try {
			setState(363);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				variableNormalTypeExpression();
				setState(350);
				match(Identifier);
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(351);
					match(Assign);
					setState(352);
					valuebleSingleExpression(0);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				variableNormalTypeExpression();
				setState(356);
				match(Identifier);
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OpenParen) {
					{
					setState(357);
					match(OpenParen);
					setState(358);
					valuebleSingleExpression(0);
					setState(359);
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
		enterRule(_localctx, 66, RULE_definitionArrayExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			variableArrayTypeExpression();
			setState(366);
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
		enterRule(_localctx, 68, RULE_assignExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			valuebleSingleExpression(0);
			setState(369);
			match(Assign);
			setState(370);
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
		enterRule(_localctx, 70, RULE_primaryType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
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
		enterRule(_localctx, 72, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
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
		case 20:
			return valuebleSingleExpression_sempred((ValuebleSingleExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean valuebleSingleExpression_sempred(ValuebleSingleExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u017b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\7\2N\n\2\f\2\16\2Q\13\2\3\3\3"+
		"\3\3\3\5\3V\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\7\6a\n\6\f\6\16\6"+
		"d\13\6\3\6\7\6g\n\6\f\6\16\6j\13\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7r\n\7\f"+
		"\7\16\7u\13\7\7\7w\n\7\f\7\16\7z\13\7\3\7\3\7\3\7\3\b\3\b\5\b\u0081\n"+
		"\b\3\t\3\t\7\t\u0085\n\t\f\t\16\t\u0088\13\t\3\t\3\t\5\t\u008c\n\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0099\n\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00b1\n\17\3\20\3\20\3\20\3\20\5\20\u00b7\n\20\3"+
		"\20\5\20\u00ba\n\20\3\20\3\20\3\20\5\20\u00bf\n\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\5\23\u00d0\n\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u00da\n\25\3\25\3\25\3\25"+
		"\5\25\u00df\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u00e6\n\25\3\25\5\25\u00e9"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\5\26\u00fb\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u011d\n\26\f\26"+
		"\16\26\u0120\13\26\3\27\3\27\5\27\u0124\n\27\3\30\3\30\5\30\u0128\n\30"+
		"\3\31\3\31\5\31\u012c\n\31\3\31\3\31\5\31\u0130\n\31\3\31\7\31\u0133\n"+
		"\31\f\31\16\31\u0136\13\31\5\31\u0138\n\31\3\32\3\32\5\32\u013c\n\32\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\5\37\u0151\n\37\3\37\3\37\3 \3 \3 \6 \u0158\n"+
		" \r \16 \u0159\3!\3!\5!\u015e\n!\3\"\3\"\3\"\3\"\5\"\u0164\n\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\5\"\u016c\n\"\5\"\u016e\n\"\3#\3#\3#\3$\3$\3$\3$\3%\3"+
		"%\3&\3&\3&\2\3*\'\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJ\2\13\3\2\r\16\4\2\26\26\31\31\4\2\17\20\23\23\3\2\21"+
		"\22\3\2\27\30\4\2\35\36 !\4\2\37\37\"\"\3\2-\60\3\2\61\64\2\u0195\2O\3"+
		"\2\2\2\4U\3\2\2\2\6W\3\2\2\2\b]\3\2\2\2\nb\3\2\2\2\fk\3\2\2\2\16\u0080"+
		"\3\2\2\2\20\u008b\3\2\2\2\22\u0098\3\2\2\2\24\u009a\3\2\2\2\26\u009c\3"+
		"\2\2\2\30\u009f\3\2\2\2\32\u00a6\3\2\2\2\34\u00a9\3\2\2\2\36\u00b2\3\2"+
		"\2\2 \u00c3\3\2\2\2\"\u00c9\3\2\2\2$\u00cc\3\2\2\2&\u00d3\3\2\2\2(\u00e8"+
		"\3\2\2\2*\u00fa\3\2\2\2,\u0123\3\2\2\2.\u0127\3\2\2\2\60\u012b\3\2\2\2"+
		"\62\u013b\3\2\2\2\64\u013d\3\2\2\2\66\u0141\3\2\2\28\u0145\3\2\2\2:\u0147"+
		"\3\2\2\2<\u014c\3\2\2\2>\u0154\3\2\2\2@\u015d\3\2\2\2B\u016d\3\2\2\2D"+
		"\u016f\3\2\2\2F\u0172\3\2\2\2H\u0176\3\2\2\2J\u0178\3\2\2\2LN\5\4\3\2"+
		"ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\3\3\2\2\2QO\3\2\2\2RV\5\6\4"+
		"\2SV\5\f\7\2TV\5\16\b\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2V\5\3\2\2\2WX\7*"+
		"\2\2XY\5\b\5\2YZ\7\5\2\2Z[\5\n\6\2[\\\7\6\2\2\\\7\3\2\2\2]^\7\65\2\2^"+
		"\t\3\2\2\2_a\5\26\f\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ch\3\2\2"+
		"\2db\3\2\2\2eg\5\f\7\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\13\3\2"+
		"\2\2jh\3\2\2\2kl\5,\27\2lm\58\35\2mx\7\3\2\2ns\5@!\2op\7\n\2\2pr\5@!\2"+
		"qo\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tw\3\2\2\2us\3\2\2\2vn\3\2\2\2"+
		"wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7\4\2\2|}\5\20\t"+
		"\2}\r\3\2\2\2~\u0081\5\26\f\2\177\u0081\5\32\16\2\u0080~\3\2\2\2\u0080"+
		"\177\3\2\2\2\u0081\17\3\2\2\2\u0082\u0086\7\5\2\2\u0083\u0085\5\22\n\2"+
		"\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008c\7\6\2\2\u008a"+
		"\u008c\5\22\n\2\u008b\u0082\3\2\2\2\u008b\u008a\3\2\2\2\u008c\21\3\2\2"+
		"\2\u008d\u0099\5\24\13\2\u008e\u0099\5\26\f\2\u008f\u0099\5\30\r\2\u0090"+
		"\u0099\5\32\16\2\u0091\u0099\5\34\17\2\u0092\u0099\5\36\20\2\u0093\u0099"+
		"\5 \21\2\u0094\u0099\5\"\22\2\u0095\u0099\5$\23\2\u0096\u0099\5&\24\2"+
		"\u0097\u0099\5(\25\2\u0098\u008d\3\2\2\2\u0098\u008e\3\2\2\2\u0098\u008f"+
		"\3\2\2\2\u0098\u0090\3\2\2\2\u0098\u0091\3\2\2\2\u0098\u0092\3\2\2\2\u0098"+
		"\u0093\3\2\2\2\u0098\u0094\3\2\2\2\u0098\u0095\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0097\3\2\2\2\u0099\23\3\2\2\2\u009a\u009b\7\t\2\2\u009b\25"+
		"\3\2\2\2\u009c\u009d\5@!\2\u009d\u009e\7\t\2\2\u009e\27\3\2\2\2\u009f"+
		"\u00a0\5,\27\2\u00a0\u00a1\7\65\2\2\u00a1\u00a2\7\f\2\2\u00a2\u00a3\7"+
		"+\2\2\u00a3\u00a4\5,\27\2\u00a4\u00a5\7\t\2\2\u00a5\31\3\2\2\2\u00a6\u00a7"+
		"\5F$\2\u00a7\u00a8\7\t\2\2\u00a8\33\3\2\2\2\u00a9\u00aa\7#\2\2\u00aa\u00ab"+
		"\7\3\2\2\u00ab\u00ac\5*\26\2\u00ac\u00ad\7\4\2\2\u00ad\u00b0\5\20\t\2"+
		"\u00ae\u00af\7$\2\2\u00af\u00b1\5\20\t\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\35\3\2\2\2\u00b2\u00b3\7%\2\2\u00b3\u00b6\7\3\2\2\u00b4"+
		"\u00b7\5\26\f\2\u00b5\u00b7\5\32\16\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5"+
		"\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00ba\5*\26\2\u00b9\u00b8\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00be\7\t\2\2\u00bc\u00bf\5F"+
		"$\2\u00bd\u00bf\5*\26\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c1\7\4\2\2\u00c1\u00c2\5\20\t\2\u00c2\37\3\2\2"+
		"\2\u00c3\u00c4\7&\2\2\u00c4\u00c5\7\3\2\2\u00c5\u00c6\5*\26\2\u00c6\u00c7"+
		"\7\4\2\2\u00c7\u00c8\5\20\t\2\u00c8!\3\2\2\2\u00c9\u00ca\7\'\2\2\u00ca"+
		"\u00cb\7\t\2\2\u00cb#\3\2\2\2\u00cc\u00cf\7)\2\2\u00cd\u00d0\5*\26\2\u00ce"+
		"\u00d0\5> \2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2"+
		"\2\u00d1\u00d2\7\t\2\2\u00d2%\3\2\2\2\u00d3\u00d4\7(\2\2\u00d4\u00d5\7"+
		"\t\2\2\u00d5\'\3\2\2\2\u00d6\u00d9\t\2\2\2\u00d7\u00da\7\65\2\2\u00d8"+
		"\u00da\5\64\33\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00db\3"+
		"\2\2\2\u00db\u00e9\7\t\2\2\u00dc\u00df\7\65\2\2\u00dd\u00df\5\64\33\2"+
		"\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1"+
		"\t\2\2\2\u00e1\u00e9\7\t\2\2\u00e2\u00e5\t\3\2\2\u00e3\u00e6\7\65\2\2"+
		"\u00e4\u00e6\5\64\33\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7"+
		"\3\2\2\2\u00e7\u00e9\7\t\2\2\u00e8\u00d6\3\2\2\2\u00e8\u00de\3\2\2\2\u00e8"+
		"\u00e2\3\2\2\2\u00e9)\3\2\2\2\u00ea\u00eb\b\26\1\2\u00eb\u00fb\7\65\2"+
		"\2\u00ec\u00fb\5,\27\2\u00ed\u00fb\5J&\2\u00ee\u00fb\7,\2\2\u00ef\u00fb"+
		"\5\62\32\2\u00f0\u00fb\5:\36\2\u00f1\u00f2\t\2\2\2\u00f2\u00fb\5*\26\21"+
		"\u00f3\u00f4\t\3\2\2\u00f4\u00fb\5*\26\17\u00f5\u00fb\5<\37\2\u00f6\u00f7"+
		"\7\3\2\2\u00f7\u00f8\5*\26\2\u00f8\u00f9\7\4\2\2\u00f9\u00fb\3\2\2\2\u00fa"+
		"\u00ea\3\2\2\2\u00fa\u00ec\3\2\2\2\u00fa\u00ed\3\2\2\2\u00fa\u00ee\3\2"+
		"\2\2\u00fa\u00ef\3\2\2\2\u00fa\u00f0\3\2\2\2\u00fa\u00f1\3\2\2\2\u00fa"+
		"\u00f3\3\2\2\2\u00fa\u00f5\3\2\2\2\u00fa\u00f6\3\2\2\2\u00fb\u011e\3\2"+
		"\2\2\u00fc\u00fd\f\16\2\2\u00fd\u00fe\t\4\2\2\u00fe\u011d\5*\26\17\u00ff"+
		"\u0100\f\r\2\2\u0100\u0101\t\5\2\2\u0101\u011d\5*\26\16\u0102\u0103\f"+
		"\f\2\2\u0103\u0104\t\6\2\2\u0104\u011d\5*\26\r\u0105\u0106\f\13\2\2\u0106"+
		"\u0107\t\7\2\2\u0107\u011d\5*\26\f\u0108\u0109\f\n\2\2\u0109\u010a\t\b"+
		"\2\2\u010a\u011d\5*\26\13\u010b\u010c\f\t\2\2\u010c\u010d\7\33\2\2\u010d"+
		"\u011d\5*\26\n\u010e\u010f\f\b\2\2\u010f\u0110\7\34\2\2\u0110\u011d\5"+
		"*\26\t\u0111\u0112\f\7\2\2\u0112\u0113\7\32\2\2\u0113\u011d\5*\26\b\u0114"+
		"\u0115\f\6\2\2\u0115\u0116\7\24\2\2\u0116\u011d\5*\26\7\u0117\u0118\f"+
		"\5\2\2\u0118\u0119\7\25\2\2\u0119\u011d\5*\26\6\u011a\u011b\f\20\2\2\u011b"+
		"\u011d\t\2\2\2\u011c\u00fc\3\2\2\2\u011c\u00ff\3\2\2\2\u011c\u0102\3\2"+
		"\2\2\u011c\u0105\3\2\2\2\u011c\u0108\3\2\2\2\u011c\u010b\3\2\2\2\u011c"+
		"\u010e\3\2\2\2\u011c\u0111\3\2\2\2\u011c\u0114\3\2\2\2\u011c\u0117\3\2"+
		"\2\2\u011c\u011a\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f+\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0124\5.\30\2"+
		"\u0122\u0124\5\60\31\2\u0123\u0121\3\2\2\2\u0123\u0122\3\2\2\2\u0124-"+
		"\3\2\2\2\u0125\u0128\5H%\2\u0126\u0128\7\65\2\2\u0127\u0125\3\2\2\2\u0127"+
		"\u0126\3\2\2\2\u0128/\3\2\2\2\u0129\u012c\5H%\2\u012a\u012c\7\65\2\2\u012b"+
		"\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012c\u0137\3\2\2\2\u012d\u012f\7\7"+
		"\2\2\u012e\u0130\7\62\2\2\u012f\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0133\7\b\2\2\u0132\u012d\3\2\2\2\u0133\u0136\3\2"+
		"\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0138\3\2\2\2\u0136"+
		"\u0134\3\2\2\2\u0137\u0134\3\2\2\2\u0137\u0138\3\2\2\2\u0138\61\3\2\2"+
		"\2\u0139\u013c\5\64\33\2\u013a\u013c\5\66\34\2\u013b\u0139\3\2\2\2\u013b"+
		"\u013a\3\2\2\2\u013c\63\3\2\2\2\u013d\u013e\5\b\5\2\u013e\u013f\7\13\2"+
		"\2\u013f\u0140\5\b\5\2\u0140\65\3\2\2\2\u0141\u0142\5\b\5\2\u0142\u0143"+
		"\7\13\2\2\u0143\u0144\5<\37\2\u0144\67\3\2\2\2\u0145\u0146\7\65\2\2\u0146"+
		"9\3\2\2\2\u0147\u0148\5\b\5\2\u0148\u0149\7\7\2\2\u0149\u014a\5*\26\2"+
		"\u014a\u014b\7\b\2\2\u014b;\3\2\2\2\u014c\u014d\7\65\2\2\u014d\u0150\7"+
		"\3\2\2\u014e\u0151\5> \2\u014f\u0151\5*\26\2\u0150\u014e\3\2\2\2\u0150"+
		"\u014f\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\7\4"+
		"\2\2\u0153=\3\2\2\2\u0154\u0157\5*\26\2\u0155\u0156\7\n\2\2\u0156\u0158"+
		"\5*\26\2\u0157\u0155\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u0157\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a?\3\2\2\2\u015b\u015e\5B\"\2\u015c\u015e\5D#\2\u015d"+
		"\u015b\3\2\2\2\u015d\u015c\3\2\2\2\u015eA\3\2\2\2\u015f\u0160\5.\30\2"+
		"\u0160\u0163\7\65\2\2\u0161\u0162\7\f\2\2\u0162\u0164\5*\26\2\u0163\u0161"+
		"\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u016e\3\2\2\2\u0165\u0166\5.\30\2\u0166"+
		"\u016b\7\65\2\2\u0167\u0168\7\3\2\2\u0168\u0169\5*\26\2\u0169\u016a\7"+
		"\4\2\2\u016a\u016c\3\2\2\2\u016b\u0167\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		"\u016e\3\2\2\2\u016d\u015f\3\2\2\2\u016d\u0165\3\2\2\2\u016eC\3\2\2\2"+
		"\u016f\u0170\5\60\31\2\u0170\u0171\7\65\2\2\u0171E\3\2\2\2\u0172\u0173"+
		"\5*\26\2\u0173\u0174\7\f\2\2\u0174\u0175\5*\26\2\u0175G\3\2\2\2\u0176"+
		"\u0177\t\t\2\2\u0177I\3\2\2\2\u0178\u0179\t\n\2\2\u0179K\3\2\2\2%OUbh"+
		"sx\u0080\u0086\u008b\u0098\u00b0\u00b6\u00b9\u00be\u00cf\u00d9\u00de\u00e5"+
		"\u00e8\u00fa\u011c\u011e\u0123\u0127\u012b\u012f\u0134\u0137\u013b\u0150"+
		"\u0159\u015d\u0163\u016b\u016d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}