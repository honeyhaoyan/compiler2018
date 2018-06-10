//import io.netty.util.internal.chmv8.ConcurrentHashMapV8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.*;

/*
hint name
functionName
for
afterIf
forInformation
afterFor
whileInformation
afterBreak
afterContinue
 */
public class IRBuilder implements IRBasicBuilder {

    private IRRoot root = new IRRoot();
    private basicBlock curBasicBlock;
    private Function curFunction;
    private List<basicBlock> basicBlockList = new ArrayList<basicBlock>();
    private List<IRInstruction> instructions = new ArrayList<IRInstruction>();
    boolean single = true;
    int registerNumber = 0;
    private Map<String,virtualRegister> registerMap = new HashMap<>();
    private Map<String,Function> functionMap = new HashMap<>();
    private Stack<basicBlock> otherwise = new Stack<>();
    Jump globalJump;
    boolean ifJump = false;

    public IRRoot getIRRoot() {
        return root;
    }

//----------------------------------------------------------------------------------------------------

    @Override
    public virtualRegister visit(Node node) {
        //virtualRegister register = new virtualRegister(null,registerNumber++);
        if (node instanceof variable) return visit((variable)node);
        if (node instanceof type) return visit((type)node);
        if (node instanceof callFunctionExpression) return visit((callFunctionExpression)node);
        if (node instanceof constant) return visit((constant)node);
        if (node instanceof expression) return visit((expression)node);
        virtualRegister register = new virtualRegister(null,registerNumber++);
        return register;
    }

    @Override
    public void visit(Program node) {
        node.sequenceSons.forEach(x -> x.accept(this));
        dealBlockList();
    }

    @Override
    public void visit(classDefinition node) {

    }

    @Override
    public void visit(functionDefinition node) {
        Function function = new Function(node.functionName);
        curFunction = function;
        functionMap.put(node.functionName,function);
        //node.inputVariableSons.forEach(x->x.accept(this));
        for (variable item : node.inputVariableSons){
            virtualRegister reg = visit(item);
            stackSlot tmp = new stackSlot(curFunction,reg);
            function.params.add(tmp);
        }
        curBasicBlock = new basicBlock(curFunction, node.functionName);
        function.blockStart = curBasicBlock;
        visit(node.blockSon);
        function.blockEnd = curBasicBlock;
        root.functions.add(function);
        //Function function1 = function;

    }

    @Override
    public void visit(blockDefinition node) {
        //curBasicBlock = new basicBlock(curFunction, curFunction.functionName);
        //if (ifJump) globalJump.setJumpTo(curBasicBlock);
        //ifJump = false;

        node.statementSons.forEach(x -> x.accept(this));
        basicBlock tmp = curBasicBlock;
        basicBlockList.add(tmp);
    }

    public void dealBlockList(){
        int number = 0;
        for (basicBlock item : basicBlockList){
            item.setLabel(number++);
            item.getParent().append(item);
        }
        root.basicBlocks = basicBlockList;
    }

//-----------------------------------------------------------------------------------------------------


    @Override
    public void visit(statement node) {
        if (node instanceof definitionStatement) visit((definitionStatement )node);
        if (node instanceof assignmentStatement) visit((assignmentStatement) node);
        if (node instanceof ifStatement) visit((ifStatement) node);
        if (node instanceof forStatement) visit((forStatement) node);
        if (node instanceof whileStatement) visit((whileStatement) node);
        if (node instanceof breakStatement) visit((breakStatement) node);
        if (node instanceof returnStatement) visit((returnStatement) node);
        if (node instanceof continueStatement)visit((continueStatement) node);
        if (node instanceof newStatement) visit((newStatement) node);
       if (node instanceof valuebleSingleStatement) visit((valuebleSingleStatement) node);

    }

    @Override
    public void visit(definitionStatement node) {
        //virtualRegister register = visit(node.exp);
        virtualRegister registerVa;
        if ((node.variableSon.ty.arrExp.size()==0)) {
            registerVa = visit(node.variableSon);
            //registerMap.put(registerVa.getRegisterName(),registerVa);
            int a = node.exp.sons.size();
            if (node.exp.sons.size() != 0) {
                virtualRegister registerExp = visit(node.exp);
                Move move = new Move(curBasicBlock, registerVa, registerExp);
                curBasicBlock.append(move);
            }
        }
        if (node.variableSon.ty.arrExp.size()>1) {
            alloca(node.variableSon);
        }

    }

    @Override
    public void visit(assignmentStatement node) {
        virtualRegister registerLe = visit(node.expLe);
        virtualRegister registerRi = visit(node.expRi);
        Move move = new Move(curBasicBlock, registerLe, registerRi);
        curBasicBlock.append(move);
    }

    @Override
    public void visit(ifStatement node) {
        basicBlock tmpEnd;
        basicBlock tmpIf;
        basicBlock tmpElse;

        //end the current block with a branch: take the then or take the else
        virtualRegister register = visit(node.ifcondition);
        Branch branch = new Branch(curBasicBlock, register, null, null);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(branch);
        tmpEnd = curBasicBlock;
        basicBlockList.add(tmpEnd);

        //start a new block for the statements after ifblock in advance
        basicBlock newBlock = new basicBlock(curFunction, "afterIf");

        //visit ifblock
        curBasicBlock = new basicBlock(curFunction,"if");
        tmpIf = curBasicBlock;
        branch.addThen(tmpIf);
        visit(node.ifblock);
        //tmpIf = curBasicBlock;
        //branch.addThen(tmpIf);
        Jump jumpIf;
        //if (!otherwise.empty()) jumpIf = new Jump(tmpIf,otherwise.peek());
        jumpIf = new Jump(tmpIf,newBlock);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(jumpIf);

        //visit elseblock
        if (node.elseblock != null) {
            curBasicBlock = new basicBlock(curFunction,"otherwise");
            visit(node.elseblock);
            tmpElse = curBasicBlock;
            branch.addOtherWise(tmpElse);
            Jump jumpElse;
            //if (!otherwise.empty()) jumpElse = new Jump(tmpElse, otherwise.peek());
            jumpElse = new Jump(tmpElse,newBlock);
            if (!curBasicBlock.isEnded())curBasicBlock.end(jumpElse);
        }

        curBasicBlock = newBlock;
        //otherwise.push(newBlock);
        //branch.addOtherWise(otherwise.peek());
    }

    @Override
    public void visit(forStatement node) {
        basicBlock tmpEnd;
        basicBlock tmpInfor;
        basicBlock tmpLoop;
        basicBlock tmpNew;

        //end the current block with a jump: jump to the loop information
        visit(node.circleVariable);
        Jump jump = new Jump(curBasicBlock, null);
        if (!curBasicBlock.isEnded())curBasicBlock.end(jump);
        tmpEnd = curBasicBlock;
        basicBlockList.add(tmpEnd);

        //start a new block for loop information
        curBasicBlock = new basicBlock(curFunction, "forInformation");
        //visit(node.operateVariable);
        virtualRegister register = visit(node.variableCondition);
        Branch branch = new Branch(curBasicBlock, register, null, null);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(branch);
        tmpInfor = curBasicBlock;
        basicBlockList.add(tmpInfor);
        jump.setJumpTo(tmpInfor);

        //start a new block for statements after for
        basicBlock newBlock = new basicBlock(curFunction, "afterFor");

        //start a new block for loop content
        curBasicBlock = new basicBlock(curFunction,"for");
        basicBlock tmpfor = curBasicBlock;
        branch.addThen(tmpfor);
        visit(node.forBlock);

        visit(node.operateVariable);
        Jump jumpReturn = new Jump(curBasicBlock, tmpInfor);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(jumpReturn);
        tmpLoop = curBasicBlock;

        curBasicBlock = newBlock;
        otherwise.push(newBlock);
        branch.addOtherWise(otherwise.peek());
    }

    @Override
    public void visit(whileStatement node) {
        basicBlock tmpEnd;
        basicBlock tmpInfor;
        basicBlock tmpLoop;
        basicBlock tmpNew;

        //end the current block with a jump: jump to the loop information
        Jump jump = new Jump(curBasicBlock, null);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(jump);
        tmpEnd = curBasicBlock;
        basicBlockList.add(tmpEnd);

        //start a new block for loop information
        curBasicBlock = new basicBlock(curFunction, "whileInformation");
        virtualRegister register = visit(node.whileCondition);
        Branch branch = new Branch(curBasicBlock, register, null, null);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(branch);
        tmpInfor = curBasicBlock;
        basicBlockList.add(tmpInfor);
        jump.setJumpTo(tmpInfor);

        //start a new block for statements after for
        basicBlock newBlock = new basicBlock(curFunction, "afterFor");

        //start a new block for loop content
        visit(node.whileBlock);
        Jump jumpReturn = new Jump(curBasicBlock, tmpInfor);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(jumpReturn);
        tmpLoop = curBasicBlock;
        branch.addThen(tmpLoop);

        curBasicBlock = newBlock;
        tmpNew = curBasicBlock;
        branch.addOtherWise(tmpNew);
    }

    public basicBlock findContinueBlock() {
        int size = basicBlockList.size();
        while (!basicBlockList.get(size - 1).getName().equals("forInformation") && !basicBlockList.get(size - 1).getName().equals("whileInformation"))
            size--;
        return basicBlockList.get(size - 1);
    }

    public basicBlock findBreakBlock() {
        int size = basicBlockList.size();
        while (!basicBlockList.get(size - 1).getName().equals("forInformation") && !basicBlockList.get(size - 1).getName().equals("whileInformation"))
            size--;
        basicBlock tmp = basicBlockList.get(size - 1);
        Branch branch = (Branch) tmp.getTail();
        return branch.findOtherwise();
    }

    public void endCurBasicBlock() {
        basicBlock tmp = curBasicBlock;
        basicBlockList.add(tmp);
    }

    @Override
    public void visit(breakStatement node) {
        Jump jump = new Jump(curBasicBlock, findBreakBlock());
        if (!curBasicBlock.isEnded()) curBasicBlock.end(jump);
        endCurBasicBlock();
        curBasicBlock = new basicBlock(curFunction, "afterBreak");
    }

    @Override
    public void visit(returnStatement node) {
        virtualRegister register = visit(node.returnExpression);
        Return ret = new Return(curBasicBlock, register);
        curBasicBlock.append(ret);
    }

    @Override
    public void visit(continueStatement node) {
        Jump jump = new Jump(curBasicBlock, findContinueBlock());
        if (!curBasicBlock.isEnded()) curBasicBlock.end(jump);
        endCurBasicBlock();
        curBasicBlock = new basicBlock(curFunction, "afterContinue");
    }

    @Override
    public void visit(newStatement node) {
        /*virtualRegister register;
        if (node.name == null) register = visit(node.exp);
        else {
            register = visit(node.newType2);
            register.setName(node.name);
            registerMap.put(node.name,register);
        }*/
        //Immediate imm = getSize();
        //HeapAllocate allocate = new HeapAllocate(curBasicBlock, register, imm);
        //curBasicBlock.append(allocate);
        if (node.newType2.arrExp.size()>1){

        }
        else{

        }
    }

    @Override
    public void visit(valuebleSingleStatement node) {
        visit(node.exp);
    }

//-----------------------------------------------------------------------------------------------

    /*public Immediate getSize() {
        Immediate imm = new Immediate(4);
        return imm;
    }*/

    public unaryOperation.Op visitUnaryOp(String op){
        unaryOperation.Op newop;
        if (op.equals("~")) newop = unaryOperation.Op.NEG;
        else newop = unaryOperation.Op.NOT;
        return newop;
    }

    public binaryOperation.Op visitBinaryOp(String op){
        binaryOperation.Op newop=null;
        if (op.equals("+")) newop = binaryOperation.Op.ADD;
        if (op.equals("-")) newop = binaryOperation.Op.SUB;
        if (op.equals("*")) newop = binaryOperation.Op.MUL;
        if (op.equals("/")) newop = binaryOperation.Op.DIV;
        if (op.equals("%")) newop = binaryOperation.Op.MOD;
        if (op.equals("<<")) newop = binaryOperation.Op.SHL;
        if (op.equals(">>")) newop = binaryOperation.Op.SHR;
        if (op.equals("&&")) newop = binaryOperation.Op.AND;
        if (op.equals("|")) newop = binaryOperation.Op.OR;
        if (op.equals("^")) newop = binaryOperation.Op.XOR;
        if (op.equals("||")) newop = binaryOperation.Op.LOR;
        return newop;
    }

    public boolean logical (String op){
        return (op.equals("!")||op.equals("||")||op.equals("&&"));
    }

    /*public int getSize(type node,virtualRegister register){
        //Immediate imm = new Immediate(0);
        int size;
        if (node.typeName.equals("Bool")) imm.setImmediateValue(node.arrExp.size());
        if (node.typeName.equals("String")) imm.setImmediateValue(4);
        if (node.typeName.equals("Int")) imm.setImmediateValue(node.arrExp.size());
        if (!node.typeName.equals("Bool")&&!node.typeName.equals("String")&&!node.typeName.equals("Int")) imm.setImmediateValue(4);
        //HeapAllocate heap = new HeapAllocate(curBasicBlock,register,imm);
        //curBasicBlock.append(heap);
        //return imm;
    }*/

    public void alloca(variable va){

    }

    public Comparison.Condition visitComparison(String op){
        Comparison.Condition newop = null;
        if (op.equals("==")) newop = Comparison.Condition.EQ;
        if (op.equals("!=")) newop = Comparison.Condition.NE;
        if (op.equals("<")) newop = Comparison.Condition.LT;
        if (op.equals(">")) newop = Comparison.Condition.GT;
        if (op.equals("<=")) newop = Comparison.Condition.LE;
        if (op.equals(">=")) newop = Comparison.Condition.GE;
        return newop;
    }

    @Override
    public virtualRegister visit(expression node) {
        if (node.sons.size() == 1){return visit(node.sons.get(0));}
        virtualRegister register = new virtualRegister(null, registerNumber++);
        //if (node.sons.size() == 1){return visit(node.sons.get(0));}
        virtualRegister registerRi = visit((expression) node.sons.get(1));
        virtualRegister registerLe;
        String op = null;
        for (Node item : node.sons) if (item instanceof Op) op =((Op) item).op;
        if (op.equals("~")||op.equals("!")){
            registerLe = new virtualRegister(null,registerNumber++);
            unaryOperation.Op newop;
            newop = visitUnaryOp(op);
            unaryOperation unary = new unaryOperation(curBasicBlock,registerLe,newop,registerRi);
            curBasicBlock.append(unary);
            register = registerLe;
        }
        else{
            if (op.equals("==")||op.equals("!=")||op.equals("<")||op.equals(">")||op.equals("<=")||op.equals(">=")){
                Comparison.Condition newop;
                newop = visitComparison(op);
                registerLe = visit((expression)node.sons.get(2));
                Comparison com = new Comparison(curBasicBlock,register,newop,registerRi,registerLe);
                curBasicBlock.append(com);
                return register;
            }
            else{
                if (op.equals("++")||op.equals("--")){
                    Immediate imm = new Immediate(1);
                    binaryOperation.Op newop = null;
                    if (op.equals("++")) newop = visitBinaryOp("+");
                    if (op.equals("--")) newop = visitBinaryOp("-");
                    binaryOperation binary = new binaryOperation(curBasicBlock,registerRi,newop,registerRi,imm);
                    curBasicBlock.append(binary);
                    return registerRi;
                }
                else {
                    binaryOperation.Op newop;
                    newop = visitBinaryOp(op);
                    registerLe = visit((expression)node.sons.get(2));
                    binaryOperation binary = new binaryOperation(curBasicBlock,register,newop,registerLe,registerRi);
                    curBasicBlock.append(binary);
                }
            }
        }
        return register;
    }

    @Override
    public void visit(Op node) {
        //virtualRegister register = new virtualRegister(null, registerNumber);
        //return register;
    }

    @Override
    public virtualRegister visit(type node) {
       virtualRegister register = new virtualRegister(null, registerNumber++);
       /*Immediate imm = new Immediate(0);
       if (node.typeName.equals("Bool")) imm.setImmediateValue(node.arrExp.size());
       if (node.typeName.equals("String")) imm.setImmediateValue(4);
       if (node.typeName.equals("Int")) imm.setImmediateValue(node.arrExp.size());
       if (!node.typeName.equals("Bool")&&!node.typeName.equals("String")&&!node.typeName.equals("Int")) imm.setImmediateValue(4);
       HeapAllocate heap = new HeapAllocate(curBasicBlock,register,imm);
       curBasicBlock.append(heap);*/
       //getSize(node,register);
       return register;
    }

    @Override
    public virtualRegister visit(variable node) {
        virtualRegister register = new virtualRegister(null, registerNumber++);
        if (registerMap.containsKey(node.name)){
            return registerMap.get(node.name);
        }
        else{
            //if (node.ty.arrExp.size()!=0) getSize(node.ty,register);
            //register.setName(node.name);
            //registerMap.put(node.name,register);
            register.setName(node.name);
            registerMap.put(node.name,register);
        }
        return register;
    }

    @Override
    public virtualRegister visit(constant node) {
        virtualRegister register = new virtualRegister(null, registerNumber++);
        Immediate imm = new Immediate(0);
        if (node.type.equals("Bool")) {
            if (node.value.equals("true")) imm.setImmediateValue(1);
            else imm.setImmediateValue(0);
        }
        //if (node.type.equals("String")) imm.setImmediateValue(4);
        if (node.type.equals("Int")) imm.setImmediateValue(Integer.parseInt(node.value));
        Move move = new Move(curBasicBlock,register,imm);
        curBasicBlock.append(move);

        return register;
    }

    @Override
    public void visit(This node) {
        //virtualRegister register = new virtualRegister(null, registerNumber);
        // return register;
    }

    @Override
    public virtualRegister visit(callFunctionExpression node) {
        //virtualRegister register = new virtualRegister("eax", registerNumber++);
        callFunction call = new callFunction(curBasicBlock,functionMap.get(node.functionName));
        node.expressionSons.forEach(x->call.addParam(visit(x)));
        curBasicBlock.append(call);
        virtualRegister reg = new virtualRegister(null,registerNumber++);
        reg.setNewName("rax");
        return reg;
    }
}


