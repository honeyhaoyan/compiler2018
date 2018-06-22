import com.sun.org.apache.bcel.internal.generic.BranchInstruction;
//import io.netty.util.internal.chmv8.ConcurrentHashMapV8;

import java.io.IOException;
import java.util.*;
public abstract class IRNode {
    public abstract void print();

}


/*-------------------------------------value and register---------------------------------------*/
abstract class Value extends IRNode{
    public abstract Value copy();
    //public abstract void print();
}

class Immediate extends Value{
    public int immediateValue;

    public Immediate(int value){
        this.immediateValue = value;
    }
    public int getValue(){
        return immediateValue;
    }

    public void setImmediateValue(int immediateValue) {
        this.immediateValue = immediateValue;
    }

    @Override public Immediate copy(){return new Immediate(immediateValue);}
    @Override public void print(){System.out.print(immediateValue);}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

//abstract class Register extends Value{ }

class virtualRegister extends Value{
/*have no idea what to do*/
    private String name;
    int id;
    boolean ifRenamed = false;
    private String newName;
    public int offset;

    boolean content;
    //***********
    /*boolean content;
    Value base;
    Value memberoffset;*/
    //***********

    public virtualRegister(String variableName, int id){
        this.name = variableName;
        this.id = id;
        ifRenamed = false;
        content = false;
    }
    public String getRegisterName (){return name;}
    @Override public virtualRegister copy(){return new virtualRegister(name,id);}
    public void print(){
        if (content==false) System.out.print("%"+Integer.toString(id));
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNewName(String str){this.newName = str;ifRenamed = true;}

    public String getNewName(){return newName;}

    //public void setContent(){content = true;}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

class Mem extends virtualRegister{
    virtualRegister reg;
    public Mem(virtualRegister reg){
        super(reg.getRegisterName(),reg.id);
        this.reg = reg;
    }
    public void print(){
        System.out.print("[");
        reg.print();
        System.out.print("]");
    }
}
/*
class physicalRegister extends Register{
    private String name;
    private int address;
    @Override
    public void print(){

    }
    @Override
    public physicalRegister copy(){
        physicalRegister tmp = new physicalRegister();
        return tmp;
    }
}*/

// what the hell do these static do ???!!!!!??????
abstract class Static extends Value{
    protected String name;
    public Static (String staticName){
        this.name = staticName;
    }
    public String getName() {return name;}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

class staticString extends Static{
    /*have no idea what to do*/
    private String value;
    public staticString(String stringValue){
        super("string");
        this.value = stringValue;
    }
    @Override public staticString copy(){return new staticString(value);}
    @Override public void print(){System.out.print(value);}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

class staticSpace extends Static{
    /*have no idea what to do*/
    //public int length;
    Map<String,Integer> memberOffset;
    List<Value>nArray;
    public staticSpace(String name){
        super(name);
        //this.length = length;
        //memberOffset = new HashMap<>();
        memberOffset = new HashMap<>();
        nArray = new ArrayList<>();
    }
    @Override public staticSpace copy(){return new staticSpace(name);}
    @Override public void print(){
        System.out.print("staticSpace ");
        if(!nArray.isEmpty()) {
            //nArray.forEach(x->x.print());
            for (Value item : nArray) {
                if (item!=null) item.print();
            }
        }
        System.out.println();
    }
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

class stackSlot extends Value{
    private Function parent;
    virtualRegister va;

    public stackSlot(Function parent, virtualRegister va){
        this.parent = parent;
        //this.name = name;
        this.va = va;
    }
    public Function getParent(){
        return parent;
    }
    /*public String getName(){
        return name;
    }*/
    @Override
    public Value copy(){
        return null;
    }
    @Override public void print(){}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

// one more "staticSlot extends register. really do not know what it is for"

/*----------------------------------------block-----------------------------------------------*/
class basicBlock extends IRNode{
    private IRInstruction head;
    private IRInstruction tail;
    private boolean ended = false;
    private Function parent;
    private String name;
    List<IRInstruction>irInstructions;
    int label;

    public basicBlock(Function parent, String name){
        this.parent = parent;
        this.name = name;
        irInstructions = new ArrayList<IRInstruction>();
    }
    public void append (IRInstruction next){
        //if (ended) throw new Exception("append after end");
        //else {
            if (ended == true) return;
            if (next instanceof Return) ended = true;
           // if (ended == true) return;
            irInstructions.add(next);
            if (tail!=null){
                tail.linkPrev(next);
                tail = next;
            }
            else head = tail = next;
        //}
    }
    public void appendBeforeJump(IRInstruction node){
        /*have no idea*/
    }
    public void end(branchInstruction next){
        this.tail = next;
        ended = true;
        irInstructions.add(next);
    }
    public void setHead(IRInstruction node){this.head = node;}
    public IRInstruction getHead(){return head;}
    public boolean isEnded(){return ended;}
    public basicBlock copy(){
        basicBlock tmp = new basicBlock(parent,name);
        tmp.head = head;tmp.tail = tail; tmp.ended = ended;
        return tmp;
    }
    public String getName(){return name;}
    public IRInstruction getTail(){return tail;}
    /*I really have no idea what lelege is thinking about. perhaps it is the difference between dalao and zhazha.*/

    public Function getParent() {
        return parent;
    }

    public void setLabel(int label){
        this.label = label;
    }

    public int getLabel(){return label;}

    @Override
    public void print(){
        System.out.print("<label>");
        System.out.print(label);
        System.out.println();
        irInstructions.forEach(x -> x.print());
        System.out.println();
    }
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}
/*----------------------------------------function--------------------------------------------*/
class Function extends IRNode{
    //List<basicBlock>basicBlocks;
    String functionName;
    List<stackSlot>params;
    List<basicBlock>basicBlocks;
    List<virtualRegister>registers;
    basicBlock blockStart;
    basicBlock blockEnd;
    int totalOffset;
    boolean isClassFunction = false;
    //Map<String,Integer> memberMap;
    staticSpace classSpace;
    public Function(String functionName){
        super();
        //basicBlocks = new ArrayList<basicBlock>();
        params = new ArrayList<stackSlot>();
        basicBlocks = new ArrayList<basicBlock>();
        this.functionName = functionName;
        registers = new ArrayList<virtualRegister>();
        //memberMap = new HashMap<>();
    }
    public void append(basicBlock block){
        basicBlocks.add(block);
    }
    //public int getTotalOffset(){return totalOffset;}
    @Override
    public void print(){
        System.out.println("Function "+functionName);
        params.forEach(x -> x.print());

    }
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}
/*----------------------------------------instructions----------------------------------------*/
abstract class IRInstruction extends IRNode{
    private basicBlock block;
    private IRInstruction prev;
    private IRInstruction next;
    boolean removed;
    protected List<virtualRegister> registers = new ArrayList<virtualRegister>();
    /* remain to be done */
    public IRInstruction(basicBlock B, IRInstruction prev, IRInstruction next){
        this.prev = prev;
        this.next = next;
        this.block = B;
    }
    public IRInstruction(basicBlock B){this.block = B;}

    //========================================================================================
    public void linkPrev(IRInstruction node){
        prev = node;
        node.next = this;
    }
    public void linkNext(IRInstruction node){
        next = node;
        node.prev = this;
    }
    public void prepend(IRInstruction node){
        if (prev != null){
            prev.linkNext(node);
        }
        else block.setHead(node);
        this.linkPrev(node);
    }
    public void append(IRInstruction node){
        /*if next is null? why setLast?*/
        if(next!=null) next.linkPrev(node);
        else{
            /*if next is null? why setLast?*/
        }
        node.linkPrev(this);
    }
    public IRInstruction getNext(){return next;}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
    //========================================================================================
}

// what is phi instruction ???

abstract class branchInstruction extends IRInstruction{
    public branchInstruction (basicBlock B, IRInstruction prev, IRInstruction next){super(B,prev,next);}
    public branchInstruction (basicBlock B){super(B);}
    //public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

class Branch extends branchInstruction {
    public Value cond;
    private basicBlock then;
    private basicBlock otherwise;
    public Branch (basicBlock B, Value cond, basicBlock then, basicBlock otherwise){
        super(B);
        this.cond = cond;
        this.then = then;
        this.otherwise = otherwise;}
    public void addThen(basicBlock then) {this.then = then;}
    public void addOtherWise(basicBlock otherwise){this.otherwise = otherwise;}
    public basicBlock findOtherwise(){return otherwise;}
    public basicBlock findThen(){return then;}
    @Override
    public void print(){
        System.out.print("br ");
        if (cond!=null) cond.print();
        System.out.print(" label:"+Integer.toString(then.getLabel())+" "+ " label:"+Integer.toString(otherwise.getLabel())+"\n");
    }
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

class Jump extends branchInstruction{
    private basicBlock jumpTo;
    public Jump(basicBlock B, basicBlock jumpTo){
        super(B);
        this.jumpTo = jumpTo;
    }
    public basicBlock getJumpTo(){return jumpTo;}
    public void setJumpTo(basicBlock jumpTo) {
        this.jumpTo = jumpTo;
    }
    public void print(){
        System.out.print("jump " + "label:"+Integer.toString(jumpTo.getLabel())+"\n" );
    }
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

class Return extends branchInstruction{
    //private Value returnValue;
    private virtualRegister returnValue;
    public Return(basicBlock B, virtualRegister returnValue){
        super(B);
        this.returnValue = returnValue;
    }
    public void print(){
        System.out.print("Ret ");
        returnValue.print();
        System.out.println();
    }
    public virtualRegister getRegister(){return returnValue;}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

class Move extends IRInstruction{
    private virtualRegister dest;
    private Value source;
    boolean destAddress;
    boolean sourceAddress;
    public Move(basicBlock B, virtualRegister dest, Value source){
        super(B);
        this.dest = dest;
        this.source = source;
        destAddress = false;
        sourceAddress = false;
    }
    public void print(){
        if (destAddress==false&&sourceAddress==false)
        {System.out.print("Mov"+" ");dest.print();System.out.print(" ");source.print();System.out.print(" ");System.out.print('\n');}
        if (sourceAddress==true) {
            System.out.print("Mov"+" ");dest.print();System.out.print(" ");System.out.print("[");source.print();System.out.print("]");System.out.print(" ");System.out.print('\n');
        }
    }
    public virtualRegister getDest(){return dest;}
    public Value getSource(){return source;}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

class Store extends IRInstruction{
    // address, offset, value, size
    private int size;
    private Value address;
    private Value data;

    public Store(basicBlock B, Value data, int size, Value address){
        super(B);
        this.size = size;
        this.address = address;
        this.data = data;
    }
    @Override
    public void print(){}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}
/*
class Load extends IRInstruction{
    private int size;
    private virtualRegister dest;
    private Value address;
    public Load(basicBlock B, virtualRegister dest, int size, Value address){
        super(B);
        this.size = size;
        this.dest = dest;
        this.address = address;
    }
    @Override
    public void print(){}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}*/

class callFunction extends IRInstruction{
    //private Register dest;
    private Function func;
    List<virtualRegister>params;
    int off;
    //virtualRegister reg;
    public callFunction(basicBlock B, Function func){
        super(B);
        //this.dest = dest;
        this.func = func;
        params = new ArrayList<virtualRegister>();
    }
    @Override
    public void print(){
        System.out.println("call " + func.functionName);
    }
    public void addParam(virtualRegister param){
        params.add(param);
    }
    public int paramSize(){return params.size();}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
    public String functionName(){return func.functionName;}
}

class SystemCall extends IRInstruction{
    public SystemCall(basicBlock B){super(B);}
    @Override
    public void print(){}
}

class unaryOperation extends IRInstruction{
    //virtualRegister reg;
    public enum Op{NEG,NOT};
    private virtualRegister dest;
    Op op;
    private Value initialValue;
    public unaryOperation(basicBlock B, virtualRegister dest, Op op, Value initialValue){
        super(B);
        this.dest = dest;
        this.op = op;
        this.initialValue = initialValue;
    }
    @Override
    public void print(){
        System.out.print(op.toString());
        dest.print();
        //System.out.print(op.toString());
        if (initialValue!=null) initialValue.print();
        System.out.println();
    }
    public virtualRegister getDest(){return dest;}
    public Value getInitialValue(){return initialValue;}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

class binaryOperation extends IRInstruction{
    public enum Op {
        ADD, SUB, MUL, DIV, MOD,
        SHL, SHR, AND, OR, XOR, LOR
    }
    private virtualRegister dest;
    private Op op;
    private Value lhs;
    private Value rhs;
    public binaryOperation(basicBlock B, virtualRegister dest, Op op, Value lhs, Value rhs){
        super(B);
        this.dest = dest;
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
    }
    @Override
    public void print(){
        System.out.print(op.toString()+" ");
        dest.print();
        System.out.print(" ");
        lhs.print();
        System.out.print(" ");
        rhs.print();
        System.out.println();
    }
    public virtualRegister getDest(){return dest;}
    public Value getLhs(){return lhs;}
    public Value getRhs(){return rhs;}
    public binaryOperation.Op getOp(){return op;}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

class Comparison extends IRInstruction{
    public enum Condition {
        EQ, NE, GT, GE, LT, LE
    }
    private virtualRegister dest;
    public Condition cond;
    private Value lhs;
    private Value rhs;
    public Comparison (basicBlock B, virtualRegister dest, Condition cond, Value lhs, Value rhs){
        super(B);
        this.dest = dest;
        this.cond = cond;
        this.lhs = lhs;
        this.rhs = rhs;
    }
    @Override
    public void print(){
        System.out.print("compare ");
        dest.print();System.out.print(" ");
        lhs.print();System.out.print(" ");
        System.out.print(cond+" ");
        rhs.print();System.out.println(" ");
    }
    public virtualRegister getDest(){return dest;}
    public Value getLhs(){return lhs;}
    public Value getRhs(){return rhs;}
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

class HeapAllocate extends IRInstruction{
    virtualRegister dest;
    //Value allocSize;
    staticSpace space;
    public HeapAllocate(basicBlock B, virtualRegister dest, staticSpace space){
        super(B);
        this.dest = dest;
        //this.allocSize = allocSize;
        this.space = space;
    }
    @Override
    public void print(){
        System.out.print("alloca ");
        dest.print();
        //allocSize.print();
        System.out.print(" ");
        space.print();
        System.out.println();
    }
    public void accept(IRBasicVisitor visitor){visitor.visit(this);}
}

/*----------------------------------------IRRoot---------------------------------------*/
class IRRoot extends IRNode{
    List<basicBlock>basicBlocks;
    List<Function>functions;
    List<Static>statics;
    public IRRoot(){
        basicBlocks = new ArrayList<basicBlock>();
        functions = new ArrayList<Function>();
        statics = new ArrayList<Static>();
    }
    public void append(basicBlock B){
        basicBlocks.add(B);
    }
    @Override
    public void print(){
        basicBlocks.forEach(x -> x.print());
    }
    public void accept(IRBasicVisitor visitor)throws IOException {visitor.visit(this,null);}
}
















