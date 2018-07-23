import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;
import java.util.HashSet;

public class registerRename implements IRBasicVisitor{
    Function currentFunction;
    int offset;
    IRInstruction irInstruction;
    Set <virtualRegister> registerSet = new HashSet<>();
    Set<virtualRegister> definedSet = new HashSet<>();
    /*boolean isClassFunction;
    virtualRegister classRegister;
    staticSpace classSpace;*/
    //virtualRegister classRegister;
    /*boolean[]r = new boolean[3];
    public void reset(){
        for (int i=0;i<=2;i++){
            if (r[i] == true) {
                r[i]=false;
                r[(i+1)%3] = true;
            }
        }
    }
    public String getTrue(){
        for(int i = 0;i<=2;++i){
            if (r[i]==true) return ("R"+Integer.toString(i));
        }
        return null;
    }*/
    public void visit(IRRoot node,PrintStream pri)throws IOException {
        node.functions.forEach(x -> x.accept(this));
    }
    public void visit(Immediate node){

    }
    public void visit(Value value){
        if (value instanceof virtualRegister) visit((virtualRegister) value);
        if (value instanceof Mem) visit(((Mem) value).reg);
    }
    public void visit(virtualRegister node){
        if (node instanceof Mem) node = ((Mem) node).reg;
        if (irInstruction!=null) {
            if(registerSet.size()!=0) {
                irInstruction.registers.addAll(registerSet);
                registerSet.clear();
            }
            irInstruction.registers.add(node);
        }
        else registerSet.add(node);

        if (!currentFunction.registers.contains(node)){
            if (node.ifRenamed == false) {
                offset = offset+8;
                node.offset = offset;
                currentFunction.registers.add(node);
                //irInstruction.defined.add(node);
                if (irInstruction!=null) {
                    if(definedSet.size()!=0) {
                        irInstruction.defined.addAll(definedSet);
                        definedSet.clear();
                    }
                    irInstruction.defined.add(node);
                }
                else definedSet.add(node);
            }

            //irInstruction.defined = node;
        }
        //else irInstruction.registers.add(node);
    }

    public void visit(Static node){

    }
    public void visit(staticString node){

    }
    public void visit(staticSpace node){

    }
    public void visit(stackSlot node){

    }
    public void visit(IRInstruction node){

    }
    public void visit(basicBlock node){
        node.irInstructions.forEach(x->x.accept(this));
    }
    public void visit(Function node){
        currentFunction = node;
        offset = 8;
        //int i = 1;
        /*if (node.isClassFunction){
            i = 0;
            isClassFunction = true;
            classRegister = node.params.get(0).va;
            visit(classRegister);
            classSpace = node.classSpace;
        }*/
        for (stackSlot item:node.params){
           visit(item.va);
            //i++;
        }
        node.basicBlocks.forEach(x -> x.accept(this));
        node.totalOffset = offset;
    }
    public void visit(Branch node){

    }
    public void visit(Jump node){

    }
    public void visit(Return node){
        if (node.getRegister()!=null) {
            irInstruction = node;
            node.getRegister().setName("eax");
            visit(node.getRegister());

        }
    }
    public void visit(Move node){
        irInstruction = node;
        visit(node.getDest());
        //if (node.getSource() instanceof virtualRegister) visit((virtualRegister)node.getSource());
        //if (node.getSource() instanceof Mem) visit(((Mem)(node.getSource())).reg);
        visit(node.getSource());
    }
    public void visit(Store node){

    }/*
    public void visit(Load node){

    }*/
    public void visit(callFunction node){
        irInstruction = node;
        node.params.forEach(x -> x.accept(this));
        node.off = offset;
    }
    public void visit(SystemCall node){

    }
    public void visit(unaryOperation node){
        irInstruction = node;
        /*if (node.getDest().getRegisterName()!=null) visit(node.getDest());
        if (node.getDest() instanceof virtualRegister) visit(node.getDest());
        if (node.getInitialValue() instanceof virtualRegister) visit((virtualRegister)node.getInitialValue());
        if (node.getInitialValue() instanceof Mem) visit(((Mem)(node.getInitialValue())).reg);*/
        visit(node.getDest());
        visit(node.getInitialValue());
    }
    public void visit(binaryOperation node){
        irInstruction = node;
        visit(node.getDest());
        /*if (node.getLhs() instanceof virtualRegister) visit((virtualRegister) node.getLhs());
        if (node.getLhs() instanceof Mem) visit(((Mem)(node.getLhs())).reg);
        if (node.getRhs() instanceof virtualRegister) visit((virtualRegister)node.getRhs());
        if (node.getRhs() instanceof Mem) visit(((Mem)(node.getRhs())).reg);*/
        visit(node.getLhs());
        visit(node.getRhs());
    }
    public void visit(Comparison node){
        irInstruction = node;
        visit(node.getDest());
        /*if (node.getLhs() instanceof virtualRegister) visit((virtualRegister) node.getLhs());
        if (node.getLhs() instanceof Mem) visit(((Mem)(node.getLhs())).reg);
        if (node.getRhs() instanceof virtualRegister) visit((virtualRegister)node.getRhs());
        if (node.getRhs() instanceof Mem) visit(((Mem)(node.getRhs())).reg);*/
        visit(node.getLhs());
        visit(node.getRhs());
    }
    public void visit(HeapAllocate node){
        irInstruction = node;
        //visit((virtualRegister) node.allocSize);
        visit(node.space);
        visit(node.dest);
    }
}
