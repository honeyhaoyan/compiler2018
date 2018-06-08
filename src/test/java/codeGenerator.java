import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class codeGenerator implements IRBasicVisitor {
    List<assembly>global = new ArrayList<assembly>();
    List<String>globalNames = new ArrayList<String>();
    BuildinPrinter builtinPrinter = new BuildinPrinter();
    BuildinPrinter2 builtinPrinter2 = new BuildinPrinter2();
    PrintStream fout;
    /*public register getRegister(virtualRegister node){

    }
    public address getAdress(virtualRegister node){

    }*/
    public assembly getMem(Value node){
        if (node instanceof Immediate){
            Imm imm = new Imm(((Immediate) node).immediateValue);
            return imm;
        }
        if (node instanceof virtualRegister){
            if (((virtualRegister) node).ifRenamed){
                Phyregister reg = new Phyregister(((virtualRegister) node).getNewName());
                return reg;
            }
            else {
                Address addr = new Address("-",((virtualRegister) node).offset,new Phyregister("rbp"));
                return addr;
            }
        }
        return null;
    }
    public void visit(IRRoot node,PrintStream ps) throws IOException{
        fout = ps;
        //BuiltinPrinter builtinPrinter = new BuiltinPrinter();
        node.statics.forEach(x->x.accept(this));
        node.functions.forEach(x->x.accept(this));
        finalPrint();

    }
    public void visit(Immediate node){

    }
    public void visit(virtualRegister node){

    }

    public void visit(Static node){

    }
    public void visit(staticString node){

    }
    public void visit(staticSpace node){

    }
    public void visit(stackSlot node){

    }
    public void visit(basicBlock node){
        node.irInstructions.forEach(x->x.accept(this));
    }
    public void visit(Function node){
        globalNames.add(node.functionName);
        global.add(new Label(node.functionName));
        global.add(new Push(new Phyregister("rbp")));
        global.add(new Mov(new Phyregister("rbp"),new Phyregister("rsp")));
        global.add(new Sub(new Phyregister("rsp"),new Imm(node.totalOffset)));
        node.basicBlocks.forEach(x->x.accept(this));
        global.add(new Pop(new Phyregister("rbp")));
        global.add(new Leave());
        global.add(new Ret());
    }
    public void visit(Branch node){

    }
    public void visit(Jump node){

    }
    public void visit(Return node){
        global.add(new Mov(new Phyregister("rax"),getMem(node.getRegister())));
        //global.add(new Ret());
    }
    public void visit(Move node){
        assembly left = getMem(node.getDest());
        assembly right = getMem(node.getSource());
        if (left instanceof Address && right instanceof Address){
            //global.add(new Load(new Phyregister("r11"),(Address)right));
            global.add(new Mov(new Phyregister("r11"),(Address)right));
            right = new Phyregister("r11");
        }
        global.add(new Mov(left,right));
    }
    public void visit(Store node){

    }/*
    public void visit(Load node){

    }*/
    public void visit(callFunction node){
        /* rdi     rsi     rdx     rcx     r8      r9*/
        int i=1;
        Phyregister reg = new Phyregister(null);
        for (virtualRegister item : node.params){
            //address addr = new address("-",item.offset,new register("rbp"));
            if (i==1) reg = new Phyregister("rdi");
            if (i==2) reg = new Phyregister("rsi");
            if (i==3) reg = new Phyregister("rdx");
            if (i==4) reg = new Phyregister("rcx");
            if (i==5) reg = new Phyregister("r8");
            if (i==6) reg = new Phyregister("r9");
            if (i>6){

            }
            global.add(new Mov(reg,getMem(item)));
        }
        global.add(new CallF(node.functionName()));
    }
    public void visit(SystemCall node){

    }
    public void visit(unaryOperation node){

    }
    public void visit(binaryOperation node){
        /*register left,right;
        address leftAddress,rightAddress;
        boolean leftRe,rightRe;
        if (node.getRhs() instanceof virtualRegister){
            if (( (virtualRegister)(node.getRhs())).ifRenamed) {
                right = getRegister((virtualRegister) node.getRhs());
                rightRe=true;
            }
            else {
                rightAddress = getAdress((virtualRegister)node.getRhs());
                rightRe = false;
            }
        }
        if (node.getRhs() instanceof Immediate){

        }
        if (node.getLhs() instanceof virtualRegister){

        }
        if (node.getLhs() instanceof Immediate){

        }*/
        assembly left = getMem(node.getLhs());
        assembly right = getMem(node.getRhs());
        /*if (left instanceof Address && right instanceof Address){
            global.add(new Mov(new Phyregister("r11"),(Address)right));
            right = new Phyregister("r11");
        }*/
        Phyregister dest = new Phyregister("r11");
        global.add(new Mov(dest,left));
        //right = new Phyregister("r11");
        if (node.getOp() == binaryOperation.Op.ADD){
            global.add(new Add(dest,right));
        }
        if (node.getOp() == binaryOperation.Op.SUB){
            global.add(new Sub(dest,right));
        }
        if (node.getOp() == binaryOperation.Op.MUL){
            //global.add(new mul());
        }
        if (node.getOp() == binaryOperation.Op.DIV){

        }
        if (node.getOp() == binaryOperation.Op.AND){

        }
        if (node.getOp() == binaryOperation.Op.LOR){

        }
        if (node.getOp() == binaryOperation.Op.XOR){

        }
        if (node.getOp() == binaryOperation.Op.MOD){

        }
        if (node.getOp() == binaryOperation.Op.OR){

        }
        if (node.getOp() == binaryOperation.Op.SHL){

        }
        if (node.getOp() == binaryOperation.Op.SHR){

        }
        global.add(new Mov(getMem(node.getDest()),dest));
    }
    public void visit(Comparison node){

    }
    public void visit(HeapAllocate node){

    }
    public void visit(IRInstruction node){

    }
    public void finalPrint()throws IOException{
        for (String item:globalNames){
            System.out.println("global "+item);fout.println("global "+item);
        }
        builtinPrinter.printBuiltin("extern");builtinPrinter2.printBuiltin("extern",fout);
        System.out.println();fout.println();
        System.out.println();fout.println();
        System.out.println("SECTION .text");fout.println("SECTION .text");
        //builtinPrinter.printBuiltin("method");
        for (assembly item:global){
            item.print(fout);
        }
        System.out.println();fout.println();
        builtinPrinter.printBuiltin("method");builtinPrinter2.printBuiltin("method",fout);
        //builtinPrinter.printBuiltin("extern");
        System.out.println("SECTION .bss");fout.println("SECTION .bss");
        System.out.println("stringbuffer: \n");fout.println("stringbuffer: \n");
        System.out.println("SECTION .data");fout.println("SECTION .data");
        //System.out.println("SECTION .bss");fout.println("SECTION .bss");
        builtinPrinter.printBuiltin("const_str");builtinPrinter2.printBuiltin("const_str",fout);
    }

}
