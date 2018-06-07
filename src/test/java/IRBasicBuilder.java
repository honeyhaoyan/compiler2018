public interface IRBasicBuilder {
    virtualRegister visit(Node node);
    void visit(Program node);
    void visit(classDefinition node);
    void visit(functionDefinition node);
    void visit(blockDefinition node);

    void visit(statement node);
    void visit(definitionStatement node);
    void visit(assignmentStatement node);
    void visit(ifStatement node);
    void visit(forStatement node);
    void visit(whileStatement node);
    void visit(breakStatement node);
    void visit(returnStatement node);
    void visit(continueStatement node);
    void visit(newStatement node);
    void visit(valuebleSingleStatement node);

    virtualRegister visit(expression node);
    virtualRegister visit(type node);
    virtualRegister visit(variable node);
    virtualRegister visit(constant node);
    void visit(Op node);
    void visit(This node);
    virtualRegister visit(callFunctionExpression node);

}
