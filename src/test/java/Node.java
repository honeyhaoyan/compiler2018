//package AST;
import java.util.ArrayList;
import java.util.List;

public class Node {
    public List<Node> sons;
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
    type ty;
    //String father;
    String name;
    public variable()
    {
        super();
        ty = new type();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}

class constant extends expression{
    public String type;
    public String value;
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
    //variable newVariable;
    String name;
    //String method;
    type newType1;
    type newType2;
    //subscriptExpression subscri;
    //dotVariableExpression dotVa;
    expression exp;
    public newStatement(){
        super();
        newType1 = new type();
        newType2 = new type();
        //subscri = new subscriptExpression();
        //dotVa = new dotVariableExpression();
        exp = new expression();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}
/*
class selfOperationStatement extends statement{
    Op op;
    variable va;
    expression exp;
    selfOperationStatement(){
        super();
        op = new Op();
        exp = new expression();
        va = new variable();
    }
}
class callFunctionStatement extends statement{
    callFunctionExpression callFunc;
    callFunctionStatement(){
        super();
        callFunc = new callFunctionExpression();
    }
}

class dotFunctionStatement extends statement{
    dotFunctionExpression dotFunc;
    dotFunctionStatement(){
        super();
        dotFunc = new dotFunctionExpression();
    }
}
*/
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

/*
class dotExpression extends expression{
    dotExpression(){
        super();
    }
}
class dotVariableExpression extends dotExpression{

    String father;
    String son;

    String classNameF;
    subscriptExpression subscript;
    callFunctionExpression callFun;

    String classNameS;
     //dotVariableExpression dotVa;
    //dotFunctionExpression dotFun;
    //dotVariableExpression dotVariable;
    dotExpression dotEx;
    dotVariableExpression (){
        super();
        subscript = new subscriptExpression();
        callFun = new callFunctionExpression();
        //dotVa = new dotVariableExpression();
        //dotFun = new dotFunctionExpression();
        dotEx = new dotExpression();

    }
}

class dotFunctionExpression extends dotExpression{

    String father;
    String son;

    String classNameF;
    subscriptExpression subscript;
    callFunctionExpression callFunF;
    String constantStr;

    callFunctionExpression callFunS;
    dotExpression dotEx;
    //List<callFunctionExpression>callFun;

    dotFunctionExpression(){
        super();
        subscript = new subscriptExpression();
        callFunF = new callFunctionExpression();
        //callFun = new ArrayList<callFunctionExpression>();
        callFunS = new callFunctionExpression();
        dotEx = new dotExpression();
    }

}

class subscriptExpression extends expression{
    variable father;
    //expression son;
    type typeFather;
    List<expression>Son;

    subscriptExpression(){
        super();
        father = new variable();
        //fatherExp = new expression();
        //son = new expression();
        typeFather = new type();
        Son = new ArrayList<expression>();
    }
}
*/
class callFunctionExpression extends expression{
    public variable va;
    public String functionName;
    public List<expression>expressionSons;
    callFunctionExpression(){
        super();
        expressionSons = new ArrayList<expression>();
        va = new variable();
    }
    public void accept(IRBuilder visitor){
        visitor.visit(this);
    }
}
