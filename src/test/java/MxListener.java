// Generated from /Users/honey/Documents/compiler/Mx/src/test/java/Mx.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#programItem}.
	 * @param ctx the parse tree
	 */
	void enterProgramItem(MxParser.ProgramItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#programItem}.
	 * @param ctx the parse tree
	 */
	void exitProgramItem(MxParser.ProgramItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(MxParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(MxParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(MxParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(MxParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(MxParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(MxParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#constructionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterConstructionDefinition(MxParser.ConstructionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#constructionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitConstructionDefinition(MxParser.ConstructionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#globalVariable}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVariable(MxParser.GlobalVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#globalVariable}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVariable(MxParser.GlobalVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MxParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MxParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#valuebleSingleStatement}.
	 * @param ctx the parse tree
	 */
	void enterValuebleSingleStatement(MxParser.ValuebleSingleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#valuebleSingleStatement}.
	 * @param ctx the parse tree
	 */
	void exitValuebleSingleStatement(MxParser.ValuebleSingleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(MxParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(MxParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#definitionStatement}.
	 * @param ctx the parse tree
	 */
	void enterDefinitionStatement(MxParser.DefinitionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#definitionStatement}.
	 * @param ctx the parse tree
	 */
	void exitDefinitionStatement(MxParser.DefinitionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#newStatement}.
	 * @param ctx the parse tree
	 */
	void enterNewStatement(MxParser.NewStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newStatement}.
	 * @param ctx the parse tree
	 */
	void exitNewStatement(MxParser.NewStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(MxParser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(MxParser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#selfOperationStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelfOperationStatement(MxParser.SelfOperationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#selfOperationStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelfOperationStatement(MxParser.SelfOperationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#callFunctionStatement}.
	 * @param ctx the parse tree
	 */
	void enterCallFunctionStatement(MxParser.CallFunctionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#callFunctionStatement}.
	 * @param ctx the parse tree
	 */
	void exitCallFunctionStatement(MxParser.CallFunctionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#dotFunctionStatement}.
	 * @param ctx the parse tree
	 */
	void enterDotFunctionStatement(MxParser.DotFunctionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#dotFunctionStatement}.
	 * @param ctx the parse tree
	 */
	void exitDotFunctionStatement(MxParser.DotFunctionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#valuebleSingleExpression}.
	 * @param ctx the parse tree
	 */
	void enterValuebleSingleExpression(MxParser.ValuebleSingleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#valuebleSingleExpression}.
	 * @param ctx the parse tree
	 */
	void exitValuebleSingleExpression(MxParser.ValuebleSingleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(MxParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(MxParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#variableTypeExpression}.
	 * @param ctx the parse tree
	 */
	void enterVariableTypeExpression(MxParser.VariableTypeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#variableTypeExpression}.
	 * @param ctx the parse tree
	 */
	void exitVariableTypeExpression(MxParser.VariableTypeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#variableNormalTypeExpression}.
	 * @param ctx the parse tree
	 */
	void enterVariableNormalTypeExpression(MxParser.VariableNormalTypeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#variableNormalTypeExpression}.
	 * @param ctx the parse tree
	 */
	void exitVariableNormalTypeExpression(MxParser.VariableNormalTypeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#variableArrayTypeExpression}.
	 * @param ctx the parse tree
	 */
	void enterVariableArrayTypeExpression(MxParser.VariableArrayTypeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#variableArrayTypeExpression}.
	 * @param ctx the parse tree
	 */
	void exitVariableArrayTypeExpression(MxParser.VariableArrayTypeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#dotExpression}.
	 * @param ctx the parse tree
	 */
	void enterDotExpression(MxParser.DotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#dotExpression}.
	 * @param ctx the parse tree
	 */
	void exitDotExpression(MxParser.DotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#dotVariableExpression}.
	 * @param ctx the parse tree
	 */
	void enterDotVariableExpression(MxParser.DotVariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#dotVariableExpression}.
	 * @param ctx the parse tree
	 */
	void exitDotVariableExpression(MxParser.DotVariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#dotFunctionExpression}.
	 * @param ctx the parse tree
	 */
	void enterDotFunctionExpression(MxParser.DotFunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#dotFunctionExpression}.
	 * @param ctx the parse tree
	 */
	void exitDotFunctionExpression(MxParser.DotFunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(MxParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(MxParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#subscriptExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptExpression(MxParser.SubscriptExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#subscriptExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptExpression(MxParser.SubscriptExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#callFunctionExpression}.
	 * @param ctx the parse tree
	 */
	void enterCallFunctionExpression(MxParser.CallFunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#callFunctionExpression}.
	 * @param ctx the parse tree
	 */
	void exitCallFunctionExpression(MxParser.CallFunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#valuebleListExpression}.
	 * @param ctx the parse tree
	 */
	void enterValuebleListExpression(MxParser.ValuebleListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#valuebleListExpression}.
	 * @param ctx the parse tree
	 */
	void exitValuebleListExpression(MxParser.ValuebleListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#definitionExpression}.
	 * @param ctx the parse tree
	 */
	void enterDefinitionExpression(MxParser.DefinitionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#definitionExpression}.
	 * @param ctx the parse tree
	 */
	void exitDefinitionExpression(MxParser.DefinitionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#definitionNormalExpression}.
	 * @param ctx the parse tree
	 */
	void enterDefinitionNormalExpression(MxParser.DefinitionNormalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#definitionNormalExpression}.
	 * @param ctx the parse tree
	 */
	void exitDefinitionNormalExpression(MxParser.DefinitionNormalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#definitionArrayExpression}.
	 * @param ctx the parse tree
	 */
	void enterDefinitionArrayExpression(MxParser.DefinitionArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#definitionArrayExpression}.
	 * @param ctx the parse tree
	 */
	void exitDefinitionArrayExpression(MxParser.DefinitionArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#assignExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(MxParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#assignExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(MxParser.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#primaryType}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryType(MxParser.PrimaryTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#primaryType}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryType(MxParser.PrimaryTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MxParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MxParser.ConstantContext ctx);
}