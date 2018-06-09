import java.io.IOException;
import java.io.PrintStream;

public class registerRename implements IRBasicVisitor{
    Function currentFunction;
    int offset;
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
    public void visit(virtualRegister node){
        if (!currentFunction.registers.contains(node)){
            if (node.ifRenamed == false) {
                offset = offset+8;
                //System.out.println(offset);
                //System.out.println(node.getRegisterName());
                //System.out.println(node.id);
                //System.out.println("------------------------------");
                node.offset = offset;
                currentFunction.registers.add(node);
            }

        }
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
        offset = 0;
        for (stackSlot item:node.params){
            visit(item.va);
        }
        node.basicBlocks.forEach(x -> x.accept(this));
        node.totalOffset = offset;
    }
    public void visit(Branch node){

    }
    public void visit(Jump node){

    }
    public void visit(Return node){
        node.getRegister().setName("eax");
        visit(node.getRegister());
    }
    public void visit(Move node){
        visit(node.getDest());
        if (node.getSource() instanceof virtualRegister) visit((virtualRegister)node.getSource());
    }
    public void visit(Store node){

    }/*
    public void visit(Load node){

    }*/
    public void visit(callFunction node){
        node.params.forEach(x -> x.accept(this));
        node.off = offset;
    }
    public void visit(SystemCall node){

    }
    public void visit(unaryOperation node){
        if (node.getDest().getRegisterName()!=null) visit(node.getDest());
        if (node.getInitialValue() instanceof virtualRegister) visit((virtualRegister)node.getInitialValue());
    }
    public void visit(binaryOperation node){
        visit(node.getDest());
        if (node.getLhs() instanceof virtualRegister) visit((virtualRegister) node.getLhs());
        if (node.getRhs() instanceof virtualRegister) visit((virtualRegister)node.getRhs());
    }
    public void visit(Comparison node){
        visit(node.getDest());
        if (node.getLhs() instanceof virtualRegister) visit((virtualRegister) node.getLhs());
        if (node.getRhs() instanceof virtualRegister) visit((virtualRegister)node.getRhs());
    }
    public void visit(HeapAllocate node){

    }
}
