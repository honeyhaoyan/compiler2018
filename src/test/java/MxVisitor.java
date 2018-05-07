// Generated from /Users/honey/Documents/compiler/Mx/src/test/java/Mx.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#programItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramItem(MxParser.ProgramItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefinition(MxParser.ClassDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(MxParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(MxParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#globalVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalVariable(MxParser.GlobalVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(MxParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MxParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(MxParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#definitionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitionStatement(MxParser.DefinitionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#newStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewStatement(MxParser.NewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#assignStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatement(MxParser.AssignStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#selfOperationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfOperationStatement(MxParser.SelfOperationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#callFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallFunctionStatement(MxParser.CallFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#valuebleSingleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuebleSingleExpression(MxParser.ValuebleSingleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#variableTypeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableTypeExpression(MxParser.VariableTypeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#variableNormalTypeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableNormalTypeExpression(MxParser.VariableNormalTypeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#variableArrayTypeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableArrayTypeExpression(MxParser.VariableArrayTypeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#dotExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotExpression(MxParser.DotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#dotVariableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotVariableExpression(MxParser.DotVariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#dotFunctionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotFunctionExpression(MxParser.DotFunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(MxParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#subscriptExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptExpression(MxParser.SubscriptExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#callFunctionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallFunctionExpression(MxParser.CallFunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#valuebleListExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuebleListExpression(MxParser.ValuebleListExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#definitionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitionExpression(MxParser.DefinitionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#definitionNormalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitionNormalExpression(MxParser.DefinitionNormalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#definitionArrayExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitionArrayExpression(MxParser.DefinitionArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#assignExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpression(MxParser.AssignExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#primaryType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryType(MxParser.PrimaryTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(MxParser.ConstantContext ctx);
}