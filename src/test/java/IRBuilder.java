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
    private Map<String,virtualRegister> functionRegister;
    private Map<String,Function> functionMap = new HashMap<>();
    private Stack<basicBlock> otherwise = new Stack<>();
    Jump globalJump;
    boolean ifJump = false;
    Map<String, staticSpace> classTable = new HashMap<>();
    List<String>className = new ArrayList<>();
    Map<String, String> classVariableTable = new HashMap<>();
    List<variable> globalVariable = new ArrayList<>();

    boolean isClassFunction;
    //virtualRegister classRegister;
    Stack<virtualRegister> classRegister = new Stack<>();
    staticSpace classSpace;

    //boolean isBranch = false;
    boolean loop = false;
    int stringNumber = 0;
    List<String> stringList = new ArrayList<>();

    List<virtualRegister> registerList = new ArrayList<>();

    Stack<Branch> Branchs = new Stack<>();

    public IRRoot getIRRoot() {
        return root;
    }

//----------------------------------------------------------------------------------------------------

    @Override
    public void visit(Node node) {
        //virtualRegister register = new virtualRegister(null,registerNumber++);
        if (node instanceof variable) {visit((variable)node);return;}
        if (node instanceof type) {visit((type)node);return;}
        if (node instanceof callFunctionExpression) {visit((callFunctionExpression)node);return;}
        if (node instanceof constant) {visit((constant)node);return;}
        if (node instanceof expression) {visit((expression)node);return;}
        if (node instanceof assignmentStatement) {visit((assignmentStatement)node);return;}
        if (node instanceof This){node.registerValue = classRegister.peek();return;}
        //if (node instanceof expression) visit((expression)node);
        //virtualRegister register = new virtualRegister(null,registerNumber++);
        //return register;
    }

    @Override
    public void visit(Program node) {
        //node.sequenceSons.forEach(x -> x.accept(this));
        for (classDefinition item : node.classSons){
            visit(item);
        }
        for (classDefinition item : node.classSons){
            visit(item);
        }
        for (variable item:node.variableSons){

            globalVariable.add(item);

        }
        for (functionDefinition item : node.functionSons){
            if (item.functionName.equals("main")) visit(item);
        }
        for (functionDefinition item : node.functionSons){
            if (!item.functionName.equals("main")) visit(item);
        }
        dealBlockList();
    }

    @Override
    public void visit(classDefinition node) {
        if (!classTable.containsKey(node.selfName)) {staticSpace space = new staticSpace(node.selfName);
            int offset = 0;
            for (definitionStatement defi : node.variableSons){
                variable va = defi.variableSon;
                space.memberOffset.put(va.name,offset);
                offset = offset+8;
            }
            //space.length = offset;
            space.nArray.add(new Immediate(offset/8));
            classTable.put(node.selfName,space);
            classSpace = space;
            className.add(node.selfName);
            //isClassFunction = true;
        }
        else {
            isClassFunction = true;
            for (functionDefinition fun : node.functionSons){
                String name =fun.functionName;
                if (name.equals("tostring")){
                    int y = 1;
                }
                Function function = new Function(name);
                functionRegister = new HashMap<>();
                curFunction = function;
                functionMap.put(name,function);
                //node.inputVariableSons.forEach(x->x.accept(this));
                //classRegister = new virtualRegister("rdi",registerNumber++);
                classRegister.push(new virtualRegister("rdi",registerNumber++));
                function.params.add(new stackSlot(function,classRegister.peek()));
                for (variable item : fun.inputVariableSons){
                    visit(item);
                    virtualRegister reg = item.registerValue;
                    stackSlot tmp = new stackSlot(curFunction,reg);
                    function.params.add(tmp);
                }
                //virtualRegister classRegister = new virtualRegister()
                //function.params.add()
                function.isClassFunction = true;
                function.classSpace = classTable.get(node.selfName);
                curBasicBlock = new basicBlock(curFunction, name);
                function.blockStart = curBasicBlock;


                visit(fun.blockSon);

                function.blockEnd = curBasicBlock;
                root.functions.add(function);
            }
            isClassFunction = false;
        }
    }

    @Override
    public void visit(functionDefinition node) {
        Function function = new Function(node.functionName);
        functionRegister = new HashMap<>();
        curFunction = function;
        functionMap.put(node.functionName,function);
        //node.inputVariableSons.forEach(x->x.accept(this));
        for (variable item : node.inputVariableSons){
            //visit(item);

            virtualRegister register;
            register = new virtualRegister(null, registerNumber++);
            register.setName(item.name);
            /*if ((item.ty.typeName.equals("String"))||(className.contains(item.ty.typeName)&&item.ty.arrExp.size()==0)||item.ty.arrExp.size()!=0){
                Mem mem = new Mem(register);
                item.registerValue = mem;
                functionRegister.put(item.name,mem);
            }
            else {
                item.registerValue = register;
                functionRegister.put(item.name,register);
            }*/
            item.registerValue = register;
            functionRegister.put(item.name,register);
            /*if ((item.ty.typeName.equals("String"))||(className.contains(item.ty.typeName)&&item.ty.arrExp.size()==0)||item.ty.arrExp.size()!=0){
                register.islabel = true;
            }*/

            virtualRegister reg = item.registerValue;
            stackSlot tmp = new stackSlot(curFunction,reg);
            function.params.add(tmp);
        }
        curBasicBlock = new basicBlock(curFunction, node.functionName);
        function.blockStart = curBasicBlock;
        if (node.functionName.equals("main")) {
            //globalVariable.forEach(x->x.accept(this));

            for (variable item : globalVariable){
                //item.accept(this);
                newGlobal(item);
                item.registerValue.islabel = true;
                if (item.globalExpression.sons.size()!=0){
                    item.globalExpression.accept(this);
                    curBasicBlock.append(new Move(curBasicBlock,item.registerValue,item.globalExpression.registerValue));
                }
            }
        }
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
        if (!basicBlockList.contains(tmp)) basicBlockList.add(tmp);
    }

    public void dealBlockList(){
        int number = 0;
        for (basicBlock item : basicBlockList){
            item.setLabel(number++);
            item.getParent().append(item);
        }
        root.basicBlocks = basicBlockList;
        root.globalVariable = globalVariable;
        root.stringList = stringList;
    }

//-----------------------------------------------------------------------------------------------------


    @Override
    public void visit(statement node) {
        //registerList.clear();
        if (node instanceof definitionStatement) {visit((definitionStatement )node);}
        if (node instanceof assignmentStatement) {visit((assignmentStatement) node);}
        if (node instanceof ifStatement) {visit((ifStatement) node);}
        if (node instanceof forStatement) {visit((forStatement) node);}
        if (node instanceof whileStatement) {visit((whileStatement) node);}
        if (node instanceof breakStatement) {visit((breakStatement) node);}
        if (node instanceof returnStatement) {visit((returnStatement) node);}
        if (node instanceof continueStatement) {visit((continueStatement) node);}
        if (node instanceof newStatement) {visit((newStatement) node);}
        if (node instanceof valuebleSingleStatement) {visit((valuebleSingleStatement) node);}
    }

    @Override
    public void visit(definitionStatement node) {
        virtualRegister registerVa;


        //visit(node.variableSon);


        virtualRegister register;
        register = new virtualRegister(null, registerNumber++);
        register.setName(node.variableSon.name);
        functionRegister.put(node.variableSon.name,register);
        node.variableSon.registerValue = register;



            registerVa = node.variableSon.registerValue;

            if (node.exp.sons.size() != 0) {
                //virtualRegister registerExp = visit(node.exp);
                visit(node.exp);
                virtualRegister registerExp = node.exp.registerValue;
                Move move = new Move(curBasicBlock, registerVa, registerExp);
                //move.defined = registerVa;
                curBasicBlock.append(move);
            }
        //}
        /*
        if (node.variableSon.ty.arrExp.size()>1) {
            alloca(node.variableSon);
        }*/

    }

    @Override
    public void visit(assignmentStatement node) {
        visit(node.expLe);
        visit(node.expRi);
        virtualRegister registerLe = node.expLe.registerValue;
        virtualRegister registerRi = node.expRi.registerValue;
        Move move = new Move(curBasicBlock, registerLe, registerRi);
        curBasicBlock.append(move);
    }

    @Override
    public void visit(ifStatement node) {
        basicBlock tmpEnd;
        basicBlock tmpIf;
        basicBlock tmpElse;

        //end the current block with a branch: take the then or take the else

        /*
        visit(node.ifcondition);
        virtualRegister register =node.ifcondition.registerValue;
        */

        basicBlock ifBlock = new basicBlock(curFunction,"if");
        basicBlock elseBlock = new basicBlock(curFunction, "else");

        /*
        Branch branch = new Branch(curBasicBlock, register, null, null);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(branch);*/
        if (node.ifcondition.sons.size()==3&&(((Op)node.ifcondition.sons.get(0)).op.equals("&&")||((Op)node.ifcondition.sons.get(0)).op.equals("||"))) {
            //if (((Op)node.ifcondition.sons.get(0)).op.equals("&&")||((Op)node.ifcondition.sons.get(0)).op.equals("||")) {
            //isBranch = true;
            loop = true;
            logicOperation(node.ifcondition,ifBlock,elseBlock);
            loop = false;
            //}
            //else visit(node.ifcondition);
        }
        else{
            //isBranch = true;
            loop = true;
            visit(node.ifcondition);
            loop = false;
            if (node.ifcondition.sons.size() == 1){
                //visit(node.ifcondition);
                Comparison comp = new Comparison(curBasicBlock,node.ifcondition.registerValue,Comparison.Condition.EQ,node.ifcondition.registerValue,new Immediate(1));
                curBasicBlock.append(comp);
            }
            virtualRegister register =node.ifcondition.registerValue;
            Branch branch = new Branch(curBasicBlock, register, ifBlock, elseBlock);
            if (!curBasicBlock.isEnded()) curBasicBlock.end(branch);
        }

        tmpEnd = curBasicBlock;
        if (!basicBlockList.contains(tmpEnd)) basicBlockList.add(tmpEnd);

        //start a new block for the statements after ifblock in advance
        basicBlock newBlock = new basicBlock(curFunction, "afterIf");

        //visit ifblock
        curBasicBlock = ifBlock;
        tmpIf = curBasicBlock;
        visit(node.ifblock);
        Jump jumpIf;
        jumpIf = new Jump(tmpIf,newBlock);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(jumpIf);

        //visit elseblock
        if (node.elseblock != null) {
            curBasicBlock = elseBlock;
            visit(node.elseblock);
            tmpElse = curBasicBlock;
            Jump jumpElse;
            jumpElse = new Jump(tmpElse,newBlock);
            if (!curBasicBlock.isEnded())curBasicBlock.end(jumpElse);
        }

        //visit elseblock
        /*if (node.elseblock != null) {
            curBasicBlock = elseBlock;
            visit(node.elseblock);
            tmpElse = curBasicBlock;
            Jump jumpElse;
            jumpElse = new Jump(tmpElse,newBlock);
            if (!curBasicBlock.isEnded())curBasicBlock.end(jumpElse);
        }

        //visit ifblock
        curBasicBlock = ifBlock;
        tmpIf = curBasicBlock;
        visit(node.ifblock);
        Jump jumpIf;
        jumpIf = new Jump(tmpIf,newBlock);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(jumpIf);*/

        curBasicBlock = newBlock;

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
        if (!basicBlockList.contains(tmpEnd)) basicBlockList.add(tmpEnd);

        //start a new block for loop information
        curBasicBlock = new basicBlock(curFunction, "forInformation");
        basicBlock forBlock = new basicBlock(curFunction,"for");
        basicBlock newBlock = new basicBlock(curFunction, "afterFor");
        /*loop = true;
        visit(node.variableCondition);
        loop = false;*/
        boolean flag = true;
        basicBlock tmp = null;
        if (node.variableCondition!=null&&node.variableCondition.ty!=null&&!node.variableCondition.ty.typeName.equals("Bool")&&node.operateVariable.sons.size()==0){
            flag = false;
            tmp = curBasicBlock;
            curBasicBlock = new basicBlock(curFunction,"null");
            visit(node.variableCondition);
            basicBlock ttmp = curBasicBlock;
            curBasicBlock = tmp;
            tmp = ttmp;
        }
        if (node.variableCondition.sons.size()==3&&(((Op)node.variableCondition.sons.get(0)).op.equals("&&")||((Op)node.variableCondition.sons.get(0)).op.equals("||"))) {
            loop = true;
            logicOperation(node.variableCondition,forBlock,newBlock);
            loop = false;
        }
        else{
            loop = true;
            if (flag==true) visit(node.variableCondition);
            loop = false;
        }


        /*if (node.variableCondition.sons.size()==3&&(((Op)node.variableCondition.sons.get(0)).op.equals("&&")||((Op)node.variableCondition.sons.get(0)).op.equals("||"))) {
            loop = true;
            logicOperation(node.variableCondition,forBlock,tmpInfor);
            loop = false;
        }*/

        virtualRegister register = node.variableCondition.registerValue;
        Branch branch = new Branch(curBasicBlock, register, null, null);
        Branchs.push(branch);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(branch);
        tmpInfor = curBasicBlock;
        if (!basicBlockList.contains(tmpInfor)) basicBlockList.add(tmpInfor);
        jump.setJumpTo(tmpInfor);


        //start a new block for statements after for
        //basicBlock newBlock = new basicBlock(curFunction, "afterFor");
        branch.addOtherWise(newBlock);

        //start a new block for loop content
        //curBasicBlock = new basicBlock(curFunction,"for");
        curBasicBlock = forBlock;
        basicBlock tmpfor = curBasicBlock;
        branch.addThen(tmpfor);
        //if (flag == false) visit(node.variableCondition);
        visit(node.forBlock);

        visit(node.operateVariable);
        if (flag == false) {
            for (IRInstruction item : tmp.irInstructions){
                curBasicBlock.append(item);
            }
        }
        Jump jumpReturn = new Jump(curBasicBlock, tmpInfor);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(jumpReturn);
        tmpLoop = curBasicBlock;

        //basicBlockList.add(tmpInfor);

        curBasicBlock = newBlock;
        otherwise.push(newBlock);
        //branch.addOtherWise(otherwise.peek());
        Branchs.pop();
    }

    @Override
    public void visit(whileStatement node) {
        basicBlock tmpEnd;
        basicBlock tmpInfor;
        basicBlock tmpLoop;
        basicBlock tmpNew ;

        //end the current block with a jump: jump to the loop information
        Jump jump = new Jump(curBasicBlock, null);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(jump);
        tmpEnd = curBasicBlock;
        if (!basicBlockList.contains(tmpEnd)) basicBlockList.add(tmpEnd);

        //visit(node.whileCondition);
        //virtualRegister register = node.whileCondition.registerValue;
        //Branch branch = new Branch(curBasicBlock, register, null, null);

        //start a new block for loop information
        curBasicBlock = new basicBlock(curFunction, "whileInformation");
        basicBlock whileBlock = new basicBlock(curFunction,"while");
        basicBlock newBlock = new basicBlock(curFunction, "afterFor");
        //isBranch = true;
        tmpInfor = curBasicBlock;

        /*loop = true;
        visit(node.whileCondition);
        loop = false;*/
        if (node.whileCondition.sons.size()==3&&(((Op)node.whileCondition.sons.get(0)).op.equals("&&")||((Op)node.whileCondition.sons.get(0)).op.equals("||"))) {
            loop = true;
            logicOperation(node.whileCondition,whileBlock,newBlock);
            loop = false;
        }
        else{
            loop = true;
            visit(node.whileCondition);
            loop = false;
        }

        virtualRegister register = node.whileCondition.registerValue;
        Branch branch = new Branch(curBasicBlock, register, null, newBlock);
        Branchs.push(branch);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(branch);
        //tmpInfor = curBasicBlock;
        if (!basicBlockList.contains(tmpInfor)) basicBlockList.add(tmpInfor);
        jump.setJumpTo(tmpInfor);

        //start a new block for statements after for
        //basicBlock newBlock = new basicBlock(curFunction, "afterFor");

        //start a new block for loop content
        //curBasicBlock = new basicBlock(curFunction,"while");
        curBasicBlock = whileBlock;
        visit(node.whileBlock);
        Jump jumpReturn = new Jump(curBasicBlock, tmpInfor);
        if (!curBasicBlock.isEnded()) curBasicBlock.end(jumpReturn);
        tmpLoop = curBasicBlock;
        branch.addThen(tmpLoop);
        //basicBlockList.add(whileBlock);

        //basicBlockList.add(tmpInfor);

        curBasicBlock = newBlock;
        tmpNew = curBasicBlock;
        //branch.addOtherWise(tmpNew);
        Branchs.pop();
    }

    public basicBlock findContinueBlock() {
        int size = basicBlockList.size();
        while (!basicBlockList.get(size - 1).getName().equals("forInformation") && !basicBlockList.get(size - 1).getName().equals("whileInformation"))
            size--;
        return basicBlockList.get(size - 1);
    }

    public basicBlock findBreakBlock() {
        /*int size = basicBlockList.size();
        while (!basicBlockList.get(size - 1).getName().equals("forInformation") && !basicBlockList.get(size - 1).getName().equals("whileInformation"))
            size--;
        basicBlock tmp = basicBlockList.get(size - 1);
        Branch branch = (Branch) tmp.getTail();
        return branch.findOtherwise();*/
        return ((Branch)Branchs.peek()).findOtherwise();
    }

    public void endCurBasicBlock() {
        basicBlock tmp = curBasicBlock;
        if (!basicBlockList.contains(tmp)) basicBlockList.add(tmp);
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
        visit(node.returnExpression);
        virtualRegister register = node.returnExpression.registerValue;
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

        //if (registerMap.containsKey(node.name)&&registerMap.get(node.name).islabel==true){
         if (findRegister(node.name)&&getRegister(node.name).islabel == true){
            variable va = new variable();
            va.name = node.name;
            va.ty = node.newType2;
            va.globalExpression = node.exp;
            newGlobal(va);
            node.registerValue = va.registerValue;
            return;
        }


        if (node.name!=null){
        /*variable va = new variable();
        va.ty = node.newType2;
        va.name = node.name;*/
            virtualRegister register = new virtualRegister(node.name,registerNumber++);
            if (isClassFunction){
                if (classSpace.memberOffset.containsKey(node.name)){
                    virtualRegister register1 = new virtualRegister(null,registerNumber++);
                    binaryOperation binary = new binaryOperation(curBasicBlock,register1, binaryOperation.Op.ADD,classRegister.peek(),new Immediate(classSpace.memberOffset.get(node.name)+8));
                    Mem mem = new Mem(register1);
                    curBasicBlock.append(binary);
                    newArrayClass(register,node.newType2,node.name);
                    curBasicBlock.append(new Move(curBasicBlock,mem,register));
                    node.registerValue = mem;
                    return;
                }
            }
            //else register = new virtualRegister(node.name,registerNumber++);
            newArrayClass(register,node.newType2,node.name);
            node.registerValue = register;
            functionRegister.put(node.name,register);
         }
        else{
            visit(node.exp);
            newArrayClass(node.exp.registerValue,node.newType2,null);
        }

        //virtualRegister register = null;
        //register = new virtualRegister(va.name,registerNumber++);


        /*if (className.contains(va.ty.typeName)&&va.ty.arrExp.size()==0){
            //staticSpace space = new staticSpace(node.ty.typeName);
            //space.memberOffset =
            HeapAllocate allocate = new HeapAllocate(curBasicBlock,register,classTable.get(va.ty.typeName));
            curBasicBlock.append(allocate);
            classVariableTable.put(node.name,va.ty.typeName);
        }
        if (node.newType2.arrExp.size()!=0){
            //virtualRegister tmpRegister = new virtualRegister(null,registerNumber++);
            staticSpace space = new staticSpace(node.name);
            boolean flag= false;
            for(expression item : node.newType2.arrExp){
                //if (item!=null) flag = true;
                visit(item);
                //virtualRegister tmpRegister = item.registerValue;
                //curBasicBlock.append(new binaryOperation(curBasicBlock,tmpRegister, binaryOperation.Op.ADD,tmpRegister,new Immediate(8)));
                if (item.registerValue!=null) flag = true;
                space.nArray.add(item.registerValue);
            }
            if (flag==true){
                HeapAllocate allocateArray = new HeapAllocate(curBasicBlock,register,space);
                curBasicBlock.append(allocateArray);}
        }*/


        //node.registerValue = register;
        //va.registerValue = register;
        //registerMap.put(node.name,register);
        //functionRegister.put(node.name,register);

        /*if(va.ty.arrExp.size()==0&&node.exp.sons.size()!=0){
            va.ty.arrExp.add(node.exp);
        }*/
        //visit(va);
    }

    private void newArrayClass(virtualRegister register, type ty,String name){
        if (className.contains(ty.typeName)&&ty.arrExp.size()==0){
            //staticSpace space = new staticSpace(node.ty.typeName);
            //space.memberOffset =
            HeapAllocate allocate = new HeapAllocate(curBasicBlock,register,classTable.get(ty.typeName));
            curBasicBlock.append(allocate);
            if (name!=null) classVariableTable.put(name,ty.typeName);
        }
        if (ty.arrExp.size()!=0){
            //virtualRegister tmpRegister = new virtualRegister(null,registerNumber++);
            staticSpace space = new staticSpace(name);
            boolean flag= false;
            for(expression item : ty.arrExp){
                visit(item);
                if (item.registerValue!=null) flag = true;
                space.nArray.add(item.registerValue);
            }
            if (flag==true){
                HeapAllocate allocateArray = new HeapAllocate(curBasicBlock,register,space);
                curBasicBlock.append(allocateArray);}
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
        if (op.equals("~")) newop = unaryOperation.Op.NOT;
        else newop = null;
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
        if (op.equals("&")) newop = binaryOperation.Op.AND;
        if (op.equals("|")) newop = binaryOperation.Op.OR;
        if (op.equals("^")) newop = binaryOperation.Op.XOR;
        //if (op.equals("||")) newop = binaryOperation.Op.LOR;
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
    /*
    public void alloca(variable va){

    }*/

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
/*
    public void visitDot(expression node){

        if (node.sons.get(2) instanceof variable){

        }
        if (node.sons.get(2) instanceof callFunctionExpression){

        }
    }*/

    @Override
    public void visit(expression node) {
        if (node.sons.size() == 0) return;
        if (node.sons.size() == 1){
           visit(node.sons.get(0));
           node.registerValue = node.sons.get(0).registerValue;
           return;
        }

        virtualRegister register = new virtualRegister(null, registerNumber++);

        virtualRegister registerLe = null,registerRi;
        String op = null;

        Op expressionOp = null;
        for (Node item : node.sons) if (item instanceof Op) {op =((Op) item).op;expressionOp = (Op)item;}

        if (op!=null) if (op.equals("&&")||op.equals("||")) {expressionLogic(node);return;}
        if (isString(node.sons.get(1))||(node.sons.size()==3&&isString(node.sons.get(2)))||(node.ty!=null && node.ty.typeName!=null &&node.ty.typeName.equals("String"))) {
            if (!op.equals("[")) {StringOperation(node);return;}
        }
        visit((expression) node.sons.get(1));
        registerRi = node.sons.get(1).registerValue;

        //if (isString(node.sons.get(1))||(node.sons.size()==3&&isString(node.sons.get(2)))) {StringOperation(node);return;}
        switch (op){
            case "." :
                if (node.sons.get(2).sons.get(0) instanceof variable){
                    boolean flag = false;
                    if (node.sons.get(1).sons.get(0) instanceof This){
                        //classRegister = curFunction.params.get(0).va;
                        isClassFunction = true;
                    }
                    else {
                        //classRegister = registerRi;
                        classRegister.push(registerRi);
                        if (isClassFunction==false){isClassFunction = true;
                        flag = true;}
                    }
                    //classSpace = classTable.get(registerRi.getRegisterName());
                    visit(node.sons.get(2));
                    if ((!(node.sons.get(1).sons.get(0) instanceof This)&&flag == true)||!classRegister.peek().getRegisterName().equals("rdi")) classRegister.pop();
                    if (flag==true) isClassFunction = false;
                    node.registerValue = node.sons.get(2).registerValue;
                }
                else{
                    callFunctionExpression fun = (callFunctionExpression) node.sons.get(2).sons.get(0);
                    if (fun.functionName.equals("size")){
                        /*virtualRegister registerTmp = registerRi;
                        registerTmp.content = true;
                        registerTmp.base = new Immediate(0);
                        registerTmp.base = new Immediate(0);*/
                        virtualRegister registerSize = new virtualRegister(null,registerNumber++);
                        Move move = new Move(curBasicBlock,registerSize,registerRi);
                        move.sourceAddress = true;
                        node.registerValue = registerSize;
                        curBasicBlock.append(move);
                        break;
                    }
                    callFunction call = new callFunction(curBasicBlock,functionMap.get(fun.functionName));
                    call.addParam(registerRi);
                    for (expression item : fun.expressionSons){
                        visit(item);
                        call.addParam(item.registerValue);
                    }
                    curBasicBlock.append(call);
                    virtualRegister reg = new virtualRegister(null,registerNumber++);
                    reg.setNewName("rax");
                    virtualRegister reg2 = new virtualRegister(null,registerNumber++);
                    curBasicBlock.append(new Move(curBasicBlock,reg2,reg));
                    node.registerValue = reg2;
                   // node.registerValue = reg2;
                }
                break;

            case "~" :
            case "!" :
                //registerLe = new virtualRegister(null,registerNumber++);
                unaryOperation.Op newop;
                newop = visitUnaryOp(op);
                if (newop!=null){unaryOperation unary = new unaryOperation(curBasicBlock,register,newop,registerRi);
                curBasicBlock.append(unary);
                }
                else{
                    binaryOperation binaryNot = new binaryOperation(curBasicBlock,register,binaryOperation.Op.XOR,registerRi,new Immediate(1));
                    curBasicBlock.append(binaryNot);
                }
                node.registerValue = register;
                break;
            //case "!":
                //unaryOperation.Op newop4;
                //newop4 = visitUnaryOp(op);
                //unaryOperation unary = new unaryOperation(curBasicBlock,registerRi,newop,registerRi);
                //curBasicBlock.append(unary);
                //binaryOperation binaryNot = new binaryOperation(curBasicBlock,registerRi,)
                //register = registerRi;
                //node.registerValue = register;
            case "==":
            case "!=":
            case "<":
            case ">":
            case "<=":
            case ">=":
                //if (isString(node.sons.get(2))) {StringOperation(node);return;}
                Comparison.Condition newop2;
                newop2 = visitComparison(op);
                visit((expression)node.sons.get(2));
                registerLe = node.sons.get(2).registerValue;
                Comparison com = new Comparison(curBasicBlock,register,newop2,registerRi,registerLe);
                //if (isBranch) {com.isBranch = true;isBranch = false;}
                curBasicBlock.append(com);

                if (!loop) {expressionLogic(node);return;}
                //expressionLogic(node);

                node.registerValue = register;
                break;

            case "++":
            case "--":
                Immediate imm = new Immediate(1);
                binaryOperation.Op newop3 = null;
                if (op.equals("++")) {
                    newop3 = visitBinaryOp("+");
                    if (expressionOp.left == true) {
                        curBasicBlock.append(new Move(curBasicBlock,register,registerRi));
                        node.registerValue = register;
                    }
                    else node.registerValue = registerRi;
                    binaryOperation binary = new binaryOperation(curBasicBlock,registerRi,newop3,registerRi,imm);
                    curBasicBlock.append(binary);
                }
                if (op.equals("--")) {
                    if (expressionOp.left == true) {
                        curBasicBlock.append(new Move(curBasicBlock,register,registerRi));
                        node.registerValue = register;
                    }
                    else node.registerValue = registerRi;
                    newop3 = visitBinaryOp("-");
                    binaryOperation binary = new binaryOperation(curBasicBlock,registerRi,newop3,imm,registerRi);
                    curBasicBlock.append(binary);
                }
                //curBasicBlock.append(binary);
                //return registerRi;
                //node.registerValue = registerRi;
                break;

            case "+":
            case "-":
            case "%":
            case "*":
            case "/":
            case "<<":
            case ">>":
            case "&":
            case "|":
            case "^":
                binaryOperation.Op newop4;
                newop4 = visitBinaryOp(op);
                if (node.sons.size()==3) visit((expression)node.sons.get(2));
                else{
                    unaryOperation unaryNeg = new unaryOperation(curBasicBlock,register,unaryOperation.Op.NEG,registerRi);
                    curBasicBlock.append(unaryNeg);
                    node.registerValue = register;
                    break;
                }
                registerLe = node.sons.get(2).registerValue;
                binaryOperation binary2 = new binaryOperation(curBasicBlock,register,newop4,registerLe,registerRi);
                curBasicBlock.append(binary2);
                node.registerValue = register;
                break;
            /*case "&&" :
            case "||" :
                expressionLogic(node);
                break;*/
            case "[":
                visit(node.sons.get(2));
                //virtualRegister registerTmp = node.sons.get(2).registerValue;
                //curBasicBlock.append(new Move(curBasicBlock,registerLe,registerTmp));
                /*virtualRegister register1 = node.sons.get(2).registerValue;
                registerLe = new virtualRegister(null,registerNumber++);
                curBasicBlock.append(new Move(curBasicBlock,registerLe,register1));*/
                registerLe = node.sons.get(2).registerValue;
                virtualRegister registerOffset1 = new virtualRegister(null,registerNumber++);
                virtualRegister registerOffset2 = new virtualRegister(null,registerNumber++);
                binaryOperation binary5 = new binaryOperation(curBasicBlock,registerOffset1,binaryOperation.Op.ADD,registerLe,new Immediate(1));
                binaryOperation binary3 = new binaryOperation(curBasicBlock,registerOffset2, binaryOperation.Op.MUL,registerOffset1,new Immediate(8));
                binaryOperation binary4 = new binaryOperation(curBasicBlock,register, binaryOperation.Op.ADD,registerOffset2,registerRi);
                //binaryOperation binary4 = new binaryOperation(curBasicBlock,register, binaryOperation.Op.MUL,register,new Immediate(8));
                curBasicBlock.append(binary5);
                curBasicBlock.append(binary3);
                curBasicBlock.append(binary4);
                Mem mem = new Mem(register);
                node.registerValue = mem;
        }
        //node.registerValue = register;
        //return register;
    }

    boolean isString(Node node){
        //return false;
        if (node instanceof variable){
            if (((variable) node).ty.typeName.equals("String")) return true;
            else return false;

        }
        if (node instanceof constant){
            if(((constant) node).type.equals("String")) return true;
            else return false;
        }
        if (node instanceof callFunctionExpression){
            if (((callFunctionExpression) node).va.ty.typeName.equals("String")) return true;
            else return false;
        }
        if (node.sons.get(0)!=null){

            if (node.sons.get(0) instanceof variable){
                if (((variable)node.sons.get(0)).ty.typeName==null)  return false;
                if (((variable) node.sons.get(0)).ty.typeName.equals("String")) return true;
                else return false;
            }
            if (node.sons.get(0) instanceof constant){
                if(((constant) node.sons.get(0)).type.equals("String")) return true;
                else return false;
            }
            if (node.sons.get(0) instanceof callFunctionExpression){
                if (((callFunctionExpression) node.sons.get(0)).va.ty.typeName!=null && ((callFunctionExpression)node.sons.get(0)).va.ty.typeName.equals("String")) return true;
                else return false;
            }

        }
        return false;
    }

    void StringOperation(expression node){
        String op = null;
        for (Node item : node.sons) if (item instanceof Op) op =((Op) item).op;
        virtualRegister regRi = null;
        virtualRegister regLe = null;
        if (!op.equals(".")){visit(node.sons.get(1));
        regRi = node.sons.get(1).registerValue;
        visit(node.sons.get(2));
        regLe = node.sons.get(2).registerValue;}
        //visit(node.sons.get(2));
        //virtualRegister regRi = node.sons.get(2).registerValue;
        switch (op){
            case "+":
                callFunction callAdd = new callFunction(curBasicBlock,new Function("_strADD"));
                callAdd.addParam(regRi);
                callAdd.addParam(regLe);
                curBasicBlock.append(callAdd);
                break;
            case "<":
                callFunction callLt = new callFunction(curBasicBlock,new Function("_strLT"));
                callLt.addParam(regRi);
                callLt.addParam(regLe);
                curBasicBlock.append(callLt);
                break;
            case ">=":
                callFunction callGt = new callFunction(curBasicBlock,new Function("_strGT"));
                callGt.addParam(regRi);
                callGt.addParam(regLe);
                curBasicBlock.append(callGt);
                break;
            case "<=":
                callFunction callLe = new callFunction(curBasicBlock, new Function("_strLE"));
                callLe.addParam(regRi);
                callLe.addParam(regLe);
                curBasicBlock.append(callLe);
                break;
            case ">":
                callFunction callGe = new callFunction(curBasicBlock, new Function("_strGE"));
                callGe.addParam(regRi);
                callGe.addParam(regLe);
                curBasicBlock.append(callGe);
                break;
            case "==":
                callFunction callEq = new callFunction(curBasicBlock, new Function("_strEQ"));
                callEq.addParam(regRi);
                callEq.addParam(regLe);
                curBasicBlock.append(callEq);
                break;
            case "!=":
                callFunction callNe = new callFunction(curBasicBlock, new Function("_strNE"));
                callNe.addParam(regRi);
                callNe.addParam(regLe);
                curBasicBlock.append(callNe);
                break;
            case ".":
                if (node.sons.get(2).sons.get(0) instanceof callFunctionExpression){
                callFunctionExpression fun = (callFunctionExpression) node.sons.get(2).sons.get(0);
                visit((expression) node.sons.get(1));
                virtualRegister registerRi = node.sons.get(1).registerValue;
                callFunction call = new callFunction(curBasicBlock,new Function(fun.functionName));
                call.addParam(registerRi);
                for (expression item : fun.expressionSons){
                    visit(item);
                    call.addParam(item.registerValue);
                }
                curBasicBlock.append(call);
                virtualRegister reg = new virtualRegister(null,registerNumber++);
                reg.setNewName("rax");
                node.registerValue = reg;}
                else{
                    visit(node.sons.get(1));
                    virtualRegister registerRi = node.sons.get(1).registerValue;
                    //classRegister = registerRi;
                    classRegister.push(registerRi);
                    isClassFunction = true;
                    //classSpace = classTable.get(registerRi.getRegisterName());
                    visit(node.sons.get(2));
                    classRegister.pop();
                    isClassFunction = false;
                    node.registerValue = node.sons.get(2).registerValue;
                    return;
                }
        }
        virtualRegister reg = new virtualRegister(null,registerNumber++);
        reg.setNewName("rax");
        //node.registerValue = reg;
        //curBasicBlock.append(new Move(curBasicBlock,reg,));
        virtualRegister reg2 = new virtualRegister(null,registerNumber++);
        curBasicBlock.append(new Move(curBasicBlock,reg2,reg));
        node.registerValue = reg2;
    }

    void expressionLogic(expression node){
        virtualRegister register = new virtualRegister(null,registerNumber++);
        node.registerValue = register;
        basicBlock resultTrue = new basicBlock(curFunction, "resultTrue");
        basicBlock resultFalse = new basicBlock(curFunction,"resultFalse");
        resultTrue.append(new Move(resultTrue,register,new Immediate(1)));
        resultFalse.append(new Move(resultFalse,register,new Immediate(0)));
        if (((Op)node.sons.get(0)).op.equals("&&")||((Op)node.sons.get(0)).op.equals("||")) logicOperation(node,resultTrue,resultFalse);
        else{
            curBasicBlock.append(new Branch(curBasicBlock,register,resultTrue,resultFalse));

        }
        basicBlock tmp = curBasicBlock;
        if (!basicBlockList.contains(tmp)) basicBlockList.add(tmp);
        if (!basicBlockList.contains(resultTrue)) basicBlockList.add(resultTrue);
        if (!basicBlockList.contains(resultFalse)) basicBlockList.add(resultFalse);
        curBasicBlock = new basicBlock(curFunction,"afterLogic");
        basicBlock tmpBlock = curBasicBlock;
        resultTrue.end(new Jump(resultTrue,tmpBlock));
        resultFalse.end(new Jump(resultFalse,tmpBlock));
       // curBasicBlock = new basicBlock(curFunction,"afterLogic");
    }

    void logicOperation(expression node, basicBlock resultTrue, basicBlock resultFalse){
        basicBlock currentBlock = new basicBlock(curFunction,"logicBlock");
        visit(node.sons.get(1));
        virtualRegister register = node.sons.get(1).registerValue;
        if (((Op)node.sons.get(0)).op.equals("&&")){
            /*basicBlock currentBlock = new basicBlock(curFunction,"logicBlock");
            visit(node.sons.get(1));
            virtualRegister register = node.sons.get(1).registerValue;*/
            Branch branch = new Branch(curBasicBlock,register,currentBlock,resultFalse);
            curBasicBlock.end(branch);
            /*curBasicBlock.end(branch);
            //basicBlock currentBlock = new basicBlock(curFunction,"logicBlock");
            curBasicBlock = currentBlock;
            visit(node.sons.get(2));
            virtualRegister register1 = node.sons.get(2).registerValue;
            Branch branch1 = new Branch(curBasicBlock,register1,resultTrue,resultFalse);*/
        }
        else if (((Op)node.sons.get(0)).op.equals("||")){
            /*basicBlock currentBlock = new basicBlock(curFunction,"logicBlock");
            visit(node.sons.get(1));
            virtualRegister register = node.sons.get(1).registerValue;*/
            Branch branch = new Branch(curBasicBlock,register,resultTrue,currentBlock);
            branch.or = true;
            curBasicBlock.end(branch);
            /*curBasicBlock.end(branch);
            curBasicBlock = currentBlock;
            visit(node.sons.get(2));
            virtualRegister register1 = node.sons.get(2).registerValue;
            Branch branch1 = new Branch(curBasicBlock,register1,resultTrue,resultFalse);*/
        }
        basicBlock tmp = curBasicBlock;
        if (!basicBlockList.contains(tmp)) basicBlockList.add(tmp);
        //curBasicBlock.end(branch);
        //basicBlock currentBlock = new basicBlock(curFunction,"logicBlock");
        curBasicBlock = currentBlock;
        visit(node.sons.get(2));
        virtualRegister register1 = node.sons.get(2).registerValue;
        Branch branch1 = new Branch(curBasicBlock,register1,resultTrue,resultFalse);
        curBasicBlock.end(branch1);
        basicBlock tmp1 = curBasicBlock;
        if (!basicBlockList.contains(tmp1)) basicBlockList.add(tmp1);
        //curBasicBlock =
    }

    @Override
    public void visit(Op node) {
        //virtualRegister register = new virtualRegister(null, registerNumber);
        //return register;
    }

    @Override
    public void visit(type node) {
       virtualRegister register = new virtualRegister(null, registerNumber++);
       /*Immediate imm = new Immediate(0);
       if (node.typeName.equals("Bool")) imm.setImmediateValue(node.arrExp.size());
       if (node.typeName.equals("String")) imm.setImmediateValue(4);
       if (node.typeName.equals("Int")) imm.setImmediateValue(node.arrExp.size());
       if (!node.typeName.equals("Bool")&&!node.typeName.equals("String")&&!node.typeName.equals("Int")) imm.setImmediateValue(4);
       HeapAllocate heap = new HeapAllocate(curBasicBlock,register,imm);
       curBasicBlock.append(heap);*/
       //getSize(node,register);
       //return register;
        node.registerValue = register;
    }

    public void newGlobal (variable node){
        //if ((!((node.ty.arrExp.size()!=0)))&&(!(className.contains(node.ty.typeName)&&node.ty.arrExp.size()==0))) return false;
        virtualRegister register = new virtualRegister("_"+node.name, registerNumber++);
        //Mem register = new Mem(register1);
        register.ifRenamed = true;
        register.setNewName("_"+node.name);
        Mem mem = new Mem(register);
        /*if (className.contains(node.ty.typeName)&&node.ty.arrExp.size()==0){
            //staticSpace space = new staticSpace(node.ty.typeName);
            //space.memberOffset =
            HeapAllocate allocate = new HeapAllocate(curBasicBlock,mem,classTable.get(node.ty.typeName));
            curBasicBlock.append(allocate);
            classVariableTable.put(node.name,node.ty.typeName);
        }

        if (node.ty.arrExp.size()!=0){
            //virtualRegister tmpRegister = new virtualRegister(null,registerNumber++);
            //virtualRegister register = new virtualRegister(null, registerNumber++);
            staticSpace space = new staticSpace(node.name);
            boolean flag= false;
            for(expression item : node.ty.arrExp){
                //if (item!=null) flag = true;
                visit(item);
                //virtualRegister tmpRegister = item.registerValue;
                //curBasicBlock.append(new binaryOperation(curBasicBlock,tmpRegister, binaryOperation.Op.ADD,tmpRegister,new Immediate(8)));
                if (item.registerValue!=null) flag = true;
                space.nArray.add(item.registerValue);
            }
            if (flag==true){
                HeapAllocate allocateArray = new HeapAllocate(curBasicBlock,mem,space);
                curBasicBlock.append(allocateArray);}
        }*/
        newArrayClass(mem,node.ty,node.name);

        registerMap.put(node.name,mem);
        node.registerValue = mem;
        //return true;
        //else return;
    }
    @Override
    public void visit(variable node) {

        //if (registerMap.containsKey(node.name)){
         if (findRegister(node.name)){
             if (isClassFunction){
                 if (classSpace.memberOffset.containsKey(node.name)){
                    /*register.content = true;
                    register.base = classRegister;
                    register.memberoffset = new Immediate(classSpace.memberOffset.get(node.name));*/
                     //virtualRegister reg = new virtualRegister(node.name,registerNumber++);
                     virtualRegister register;
                     register = new virtualRegister(null, registerNumber++);
                     binaryOperation binary = new binaryOperation(curBasicBlock,register, binaryOperation.Op.ADD,classRegister.peek(),new Immediate(classSpace.memberOffset.get(node.name)+8));
                     curBasicBlock.append(binary);
                     Mem mem = new Mem(register);
                     node.registerValue = mem;
                     return;
                     //register.content = true;

                 }
             }
            //if (registerMap.get(node.name).islabel==true){
             if (getRegister(node.name).islabel == true){
                virtualRegister reg = new virtualRegister("_"+node.name,registerNumber++);
                reg.ifRenamed  =true;
                reg.setNewName("_"+node.name);
                Mem mem = new Mem(reg);
                node.registerValue = mem;
                return;
            }
            //node.registerValue = registerMap.get(node.name);
             node.registerValue = getRegister(node.name);
            if (classVariableTable.containsKey(node.name)){
                classSpace = classTable.get(classVariableTable.get(node.name));
                //??????????????????????????????????*****************************************************
                //classRegister.push(getRegister(node.name));
            }
        }
        else{
            //if(newGlobal(node)) return;
            virtualRegister register;
            register = new virtualRegister(null, registerNumber++);
            /*if (node.ty.typeName.equals("String")){
                virtualRegister reg = new virtualRegister("_"+node.name,registerNumber++);
                reg.ifRenamed  =true;
                reg.setNewName("_"+node.name);
                Mem mem = new Mem(reg);
                node.registerValue = mem;
                return;
            }*/
            /*if (className.contains(node.ty.typeName)&&node.ty.arrExp.size()==0){
                //staticSpace space = new staticSpace(node.ty.typeName);
                //space.memberOffset =
                HeapAllocate allocate = new HeapAllocate(curBasicBlock,register,classTable.get(node.ty.typeName));
                curBasicBlock.append(allocate);
                classVariableTable.put(node.name,node.ty.typeName);
            }
            if (node.ty.arrExp.size()!=0){
                //virtualRegister tmpRegister = new virtualRegister(null,registerNumber++);
                staticSpace space = new staticSpace(node.name);
                boolean flag= false;
                for(expression item : node.ty.arrExp){
                    //if (item!=null) flag = true;
                    visit(item);
                    //virtualRegister tmpRegister = item.registerValue;
                    //curBasicBlock.append(new binaryOperation(curBasicBlock,tmpRegister, binaryOperation.Op.ADD,tmpRegister,new Immediate(8)));
                    if (item.registerValue!=null) flag = true;
                    space.nArray.add(item.registerValue);
                }
                if (flag==true){
                HeapAllocate allocateArray = new HeapAllocate(curBasicBlock,register,space);
                curBasicBlock.append(allocateArray);}
            }*/
            if (isClassFunction){
                if (classSpace.memberOffset.containsKey(node.name)){
                    /*register.content = true;
                    register.base = classRegister;
                    register.memberoffset = new Immediate(classSpace.memberOffset.get(node.name));*/
                    //virtualRegister reg = new virtualRegister(node.name,registerNumber++);
                    binaryOperation binary = new binaryOperation(curBasicBlock,register, binaryOperation.Op.ADD,classRegister.peek(),new Immediate(classSpace.memberOffset.get(node.name)+8));
                    curBasicBlock.append(binary);
                    Mem mem = new Mem(register);
                    node.registerValue = mem;
                    return;
                    //register.content = true;

                }
            }
            register.setName(node.name);
           // registerMap.put(node.name,register);
             functionRegister.put(node.name,register);
            node.registerValue = register;
        }
        //node.registerValue = register;
        //return register;
    }

    @Override
    public void visit(constant node) {
        if (node.type.equals("String")){
            virtualRegister reg = new virtualRegister("_"+(stringNumber++),registerNumber++);
            reg.ifRenamed  =true;
            reg.setNewName("_"+(stringNumber-1));
            //Mem mem = new Mem(reg);
            //node.registerValue = mem;
            node.registerValue = reg;
            stringList.add(node.value);
            return ;
        }

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

        node.registerValue = register;
        //return register;
        //node.registerValue = register;
    }

    @Override
    public void visit(This node) {
        //virtualRegister register = new virtualRegister(null, registerNumber);
        // return register;
    }

    @Override
    public void visit(callFunctionExpression node) {
        //virtualRegister register = new virtualRegister("eax", registerNumber++);
        callFunction call;
        String name = node.functionName;
        /*if (isClassFunction&&node.isClassFunction==true){
            if (!ifInlineFunction(node.functionName)) {
                name = "__"+name;
            }
        }*/
        if(functionMap.containsKey(node.functionName)) call = new callFunction(curBasicBlock,functionMap.get(name));
        else call = new callFunction(curBasicBlock,new Function(name));
        //node.expressionSons.forEach(x->call.addParam(visit(x)));
       /* if (node.functionName.equals("getDim")){
            int what = 0;
        }*/
       /*if (curFunction.functionName.equals("add")&&node.functionName.equals("getDim")){
           int t = 1;
       }*/
        if (isClassFunction&&node.isClassFunction==true){
            if (!ifInlineFunction(node.functionName)) {
                call.addParam(classRegister.peek());
            }
        }
        for (expression item : node.expressionSons){
            visit(item);
            call.addParam(item.registerValue);
        }

        curBasicBlock.append(call);
        virtualRegister reg = new virtualRegister(null,registerNumber++);
        reg.setNewName("rax");
        //return reg;
        //curBasicBlock.append(new Move(curBasicBlock,reg,new virtualRegister("rax",registerNumber++)));
        //node.registerValue = reg;
        virtualRegister reg2 = new virtualRegister(null,registerNumber++);
        curBasicBlock.append(new Move(curBasicBlock,reg2,reg));
        node.registerValue = reg2;
    }
    public boolean ifInlineFunction(String name){
        switch (name) {
            case("print"):
            case("println"):
            case("getString"):
            case("getInt"):
            case("toString"):
            case("length"):
            case("substring"):
            case("parseInt"):
            case("ord"):
            case("address"):
            case("_malloc"):
            case("_newArray"):
            case("newArray"):
            case("size"):
            case("_strADD"):
            case("_strLT"):
            case("_strGT"):
            case("_strLE"):
            case("_strGE"):
            case("_strEQ"):
            case("_strNE"):
                return true;
        }
        return false;
    }
    private boolean findRegister(String name){
        virtualRegister register = getRegister(name);
        if (register==null) return false;
        else return true;
    }
    private virtualRegister getRegister(String name){
        if (functionRegister.containsKey(name)){
            return functionRegister.get(name);
        }
        else{
            if (registerMap.containsKey(name)){
                return registerMap.get(name);
            }
            else return null;
        }
    }
}


