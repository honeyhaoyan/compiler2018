//package AST;
import java.util.ArrayList;
import java.util.List;

public class Node {
    public List<Node> sons;
    virtualRegister registerValue;
    public Node(){
        sons = new ArrayList<Node>();
    }
    public void addSon(Node son){
        sons.add(son);
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class Program extends Node{
    public List<classDefinition> classSons;
    public List<variable>variableSons;
    public List<functionDefinition>functionSons;
    public List<Node>sequenceSons;
    public Program(){
        super();
        classSons = new ArrayList<classDefinition>();
        variableSons = new ArrayList<variable>();
        functionSons = new ArrayList<functionDefinition>();
        sequenceSons = new ArrayList<Node>();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class classDefinition extends Node{
    public String selfName;
    public List<definitionStatement> variableSons;
    public List<functionDefinition>functionSons;
    public classDefinition(){
        super();
        variableSons = new ArrayList<definitionStatement>();
        functionSons = new ArrayList<functionDefinition>();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class functionDefinition extends Node{
    public type returnType;
    public List<variable>inputVariableSons;
    public blockDefinition blockSon;
    public String functionName;
    public functionDefinition(){
        super();
        inputVariableSons = new ArrayList<variable>();
        returnType = new type();
        blockSon = new blockDefinition();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class blockDefinition extends Node{
    public List<Node>statementSons;
    public blockDefinition(){
        super();
        statementSons = new ArrayList<Node>();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class statement extends Node{
    public statement son;
    public statement(){
        super();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class type extends expression{
    public String typeName;
    //List<String>arr;
    List<expression>arrExp;
    //virtualRegister registerValue;
    type(){
        super();
        //arr=new ArrayList<>();
        arrExp = new ArrayList<expression>();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class variable extends expression{
    //virtualRegister registerValue;
    type ty;
    //String father;
    String name;
    expression globalExpression;
    public variable()
    {
        super();
        ty = new type();
        globalExpression = new expression();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class constant extends expression{
    public String type;
    public String value;
    //virtualRegister registerValue;
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class illegal extends Node{
    illegal(){
        super();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class definitionStatement extends statement{
    public variable variableSon;
    public expression exp;
    public definitionStatement(){
        super();
        variableSon = new variable();
        exp = new expression();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class assignmentStatement extends statement{
    //public variable variableLe;
    public expression expLe;
    public expression expRi;
    public assignmentStatement(){
        super();
        expLe = new expression();
        expRi = new expression();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class ifStatement extends statement{
    public expression ifcondition;
    public blockDefinition ifblock;
    public blockDefinition elseblock;
    public ifStatement(){
        super();
        ifcondition = new expression();
        ifblock = new blockDefinition();
        elseblock = new blockDefinition();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class forStatement extends statement{
    public statement circleVariable;
    public expression variableCondition;
    public Node operateVariable;
    public blockDefinition forBlock;
    public boolean ifEmptyCon;
    public boolean ifEmptyBlock;
    public forStatement(){
        super();
        circleVariable = new statement();
        variableCondition = new expression();
        operateVariable = new Node();
        forBlock = new blockDefinition();
        ifEmptyCon = false;
        ifEmptyBlock = false;
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class whileStatement extends statement{
    public expression whileCondition;
    public blockDefinition whileBlock;
    public whileStatement(){
        super();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class breakStatement extends statement{
    public breakStatement(){
        super();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class returnStatement extends statement{
    public expression returnExpression;
    public returnStatement(){
        super();
        returnExpression = new expression();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class continueStatement extends statement{
    public continueStatement(){
        super();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}


class newStatement extends statement{
    String name;
    type newType1;
    type newType2;
    expression exp;
    public newStatement(){
        super();
        newType1 = new type();
        newType2 = new type();
        exp = new expression();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class valuebleSingleStatement extends statement{
    expression exp;
    valuebleSingleStatement(){
        super();
        exp = new expression();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class emptyStatement extends statement{
    boolean islegal;
    emptyStatement(){
        super();
        islegal = true;
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}


class expression extends Node {
    //virtualRegister registerValue;
    type ty;
    public expression(){
        super();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class Op extends Node{
    String op;
    Op(){
        super();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class This extends Node{
    This(){
        super();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}


class callFunctionExpression extends expression{
    public variable va;
    public String functionName;
    public List<expression>expressionSons;
    //virtualRegister registerValue;
    callFunctionExpression(){
        super();
        expressionSons = new ArrayList<expression>();
        va = new variable();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}
