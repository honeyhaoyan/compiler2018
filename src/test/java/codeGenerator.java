import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class codeGenerator implements IRBasicVisitor {
    List<assembly>global = new ArrayList<assembly>();
    List<String>globalNames = new ArrayList<String>();
    BuildinPrinter builtinPrinter = new BuildinPrinter();
    BuildinPrinter2 builtinPrinter2 = new BuildinPrinter2();
    List<variable>globalVariable;
    List<String>stringList;
    PrintStream fout;
    JJump br = null;
    boolean first = false;
    int returnNum = 0;
    boolean memFlag;

    /*public register getRegister(virtualRegister node){

    }
    public address getAdress(virtualRegister node){

    }*/
    public assembly getMem(Value node){
        if (node instanceof Immediate){
            Imm imm = new Imm(((Immediate) node).immediateValue);
            return imm;
        }
        if (node instanceof Mem){
            //Address addr = new Address("-",((virtualRegister) node).offset,new Phyregister("rbp"));
            String regName;
            if (memFlag) {regName = "rdx";memFlag =false;}
            else {regName = "rbx";memFlag = true;}
            global.add(new Mov(new Phyregister(regName),(getMem(((Mem) node).reg))));
            Address address = new Address("+",0,new Phyregister(regName));
            return address;
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
        globalVariable = node.globalVariable;
        stringList = node.stringList;
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
        if (first == false) global.add(new Label("b"+Integer.toString(node.label)));
        else first = false;
        node.irInstructions.forEach(x->x.accept(this));
    }
    public void visit(Function node){
        globalNames.add(node.functionName);
        global.add(new Label(node.functionName));
        first = true;
        global.add(new Push(new Phyregister("rbp")));
        global.add(new Mov(new Phyregister("rbp"),new Phyregister("rsp")));
        global.add(new Sub(new Phyregister("rsp"),new Imm(node.totalOffset)));
        int i=1;
        int j=1;
        int num = node.params.size();
        for (stackSlot item : node.params){
            //i = num - j +1;
            if (i==1) global.add(new Mov(getMem(item.va),new Phyregister("rdi")));
            if (i==2) global.add(new Mov(getMem(item.va),new Phyregister("rsi")));
            if (i==3) global.add(new Mov(getMem(item.va),new Phyregister("rdx")));
            if (i==4) global.add(new Mov(getMem(item.va),new Phyregister("rcx")));
            if (i==5) global.add(new Mov(getMem(item.va),new Phyregister("r8")));
            if (i==6) global.add(new Mov(getMem(item.va),new Phyregister("r9")));
            if (i>6){

                Address address = new Address("+",(i-5)*8,new Phyregister("rbp"));
                global.add(new Mov(new Phyregister("rax"),address));
                global.add(new Mov(getMem(item.va),new Phyregister("rax")));
            }
            i++;
            //j++;
        }
        //node.basicBlocks.forEach(x->x.accept(this));
        int k = 0;
        for (basicBlock item : node.basicBlocks){
            item.accept(this);
            if (item.irInstructions.size()==0&&k==node.basicBlocks.size()-1){
                //item.append(new Jump(item,node.basicBlocks.get(k+1)));
                global.add(new Jmp("RE"+Integer.toString(returnNum)));
            }
            k++;
        }
        //node.basicBlocks.get(0).accept(this);
        //global.add(new Pop(new Phyregister("rbp")));
        global.add(new Label("RE"+Integer.toString(returnNum++)));
        global.add(new Leave());
        global.add(new Ret());
    }
    public void visit(Branch node){
        //int a  = node.findThen().label;
        //global.add(new Cmp(getMem(node.cond),new Imm(0)));
        //br.setLabel("b"+Integer.toString(node.findThen().label));
        //visit(node)
        if (br==null) {
            if (node.cond!=null){
                if (node.or == false){global.add(new Cmp(getMem(node.cond),new Imm(0)));
                global.add(new Je("b"+Integer.toString(node.findOtherwise().label)));}
                else{
                    global.add(new Cmp(getMem(node.cond),new Imm(1)));
                    global.add(new Je("b"+Integer.toString(node.findThen().label)));
                }
            }
            if (node.cond == null){
                global.add(new Jmp("b"+Integer.toString(node.findThen().label)));
            }
        }
        else {
            if (node.or == false) br.label = "b"+Integer.toString(node.findOtherwise().label);
            else {
                boolean flag = false;
                if (br instanceof Je&&flag==false){
                    br = new Jne(null);
                    flag = true;
                }
                if (br instanceof Jne&&flag==false){
                    br = new Je(null);flag = true;
                }
                if (br instanceof Jl&&flag==false){
                    br = new Jnl(null);flag = true;
                }
                if (br instanceof Jnl&&flag==false){
                    br = new Jl(null);flag = true;
                }
                if (br instanceof Jg&&flag==false){
                    br = new Jng(null);flag = true;
                }
                if (br instanceof Jng&&flag==false){
                    br = new Jg(null);flag = true;
                }
                br.label = "b"+Integer.toString(node.findThen().label);
            }
            global.add(br);
            br = null;
        }
        //global.add(new Jmp("b"+Integer.toString(node.findOtherwise().label)));
    }
    public void visit(Jump node){
        global.add(new Jmp("b"+Integer.toString(node.getJumpTo().label)));
    }
    public void visit(Return node){
        if (node.getRegister()!=null) global.add(new Mov(new Phyregister("rax"),getMem(node.getRegister())));
        //global.add(new Ret());
        global.add(new Jmp("RE"+Integer.toString(returnNum)));
    }
    public void visit(Move node){
        assembly left = getMem(node.getDest());
        assembly right = getMem(node.getSource());
        if (node.sourceAddress == true){
            global.add(new Mov(new Phyregister("r10"),right));
            //right = new Phyregister("r11");
            Address rightTmp = new Address("+",0,new Phyregister("r10"));
            global.add(new Mov(new Phyregister("r11"),rightTmp));
            right = new Phyregister("r11");
        }
       /* if (node.getDest().content == true){
            global.add(new Mov(new Phyregister("r9"),getMem(node.getDest())));
            global.add(new Mov(new Phyregister("r8"),new Memory(new Phyregister("r9"),"+",0)));
            left = new Phyregister("r8");
        }
        if (node.getSource() instanceof virtualRegister){
            if (((virtualRegister) node.getSource()).content == true){
                global.add(new Mov(new Phyregister("r7"),getMem(node.getSource())));
                global.add(new Mov(new Phyregister("r6"),new Memory(new Phyregister("r7"),"+",0)));
                right = new Phyregister("r6");
            }
        }*/
        if (left instanceof Address && right instanceof Address){
            //global.add(new Load(new Phyregister("r11"),(Address)right));
        global.add(new Mov(new Phyregister("r11"),(Address)right));
        right = new Phyregister("r11");
        }
        /*if (node.sourceAddress == true){
            right = new Address("+",0,new Phyregister("r11"));
        }*/
        global.add(new Mov(left,right));
    }
    public void visit(Store node){

    }/*
    public void visit(Load node){

    }*/
    public void visit(callFunction node){
        /* rdi     rsi     rdx     rcx     r8      r9*/
        /*if (node.functionName().equals("size")){
            //global.add(new Mov(new ))
        }*/
        int i=1;
        int j=1;
        Phyregister reg = new Phyregister(null);
        int num = node.params.size();
        if (num == 0){
            int k = 10;
        }
        for (virtualRegister item : node.params){
            //i = num-j+1;
            //address addr = new address("-",item.offset,new register("rbp"));
            if (i==1) reg = new Phyregister("rdi");
            if (i==2) reg = new Phyregister("rsi");
            if (i==3) reg = new Phyregister("rdx");
            if (i==4) reg = new Phyregister("rcx");
            if (i==5) reg = new Phyregister("r8");
            if (i==6) reg = new Phyregister("r9");
            /*if (i>6){
                global.add(new Mov(new Phyregister("rax"),getMem(item)));
                global.add(new Push(new Phyregister("rax")));
                j++;continue;
            }*/
            if (i<=6){global.add(new Mov(reg,getMem(item)));
            i++;
            //j++;
            }
        }
        if (node.params.size()>6){
            int k = node.params.size();
            k--;
            while(k>5){
                virtualRegister item = node.params.get(k);
                global.add(new Mov(new Phyregister("rax"),getMem(item)));
                global.add(new Push(new Phyregister("rax")));
                //global.add(new Sub(new Phyregister("rsp"),new Imm(8)));
                //global.add(new Mov(new Address("+",0,new Phyregister("rsp")),new Phyregister("rax")));
                //global.add(new Sub(new Phyregister("rsp"),new Imm(8)));
                k--;
            }
        }
        global.add(new CallF(node.functionName()));
        if (node.params.size()>6){
            int k = node.params.size();
            k--;
            while(k>5){
                //virtualRegister item = node.params.get(k);
                //global.add(new Mov(new Phyregister("rax"),getMem(item)));
                global.add(new Pop(new Phyregister("rdi")));
                //global.add(new Sub(new Phyregister("rsp"),new Imm(8)));
                //global.add(new Mov(new Address("+",0,new Phyregister("rsp")),new Phyregister("rax")));
                //global.add(new Sub(new Phyregister("rsp"),new Imm(8)));
                k--;
            }
        }
    }
    public void visit(SystemCall node){

    }
    public void visit(unaryOperation node){
        if (node.op == unaryOperation.Op.NEG){
            //global.add(new Mov(new Phyregister("rax"),getMem(node.getDest())));
            global.add(new Mov(new Phyregister("r9"),getMem(node.getInitialValue())));
            global.add(new Neg(new Phyregister("r9")));
            global.add(new Mov(getMem(node.getDest()),new Phyregister("r9")));
            //global.add(new Mov(getMem(node.getDest()),new Phyregister("rax")));

            //global.add(new Imul(getMem(node.getDest()),new Imm(-1)));
        }
        if (node.op == unaryOperation.Op.NOT){
            global.add(new Mov(new Phyregister("r11"),getMem(node.getDest())));
            //global.add(new Not(new Phyregister("r11")));
            global.add(new Xor(new Phyregister("r11"),new Imm(1)));
            global.add(new Mov(getMem(node.getDest()),new Phyregister("r11")));
        }
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
        if (node.getOp() == binaryOperation.Op.SUB){
            assembly tmp = right;
            right = left;
            left = tmp;
        }
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
            //global.add(new Sub(right,dest));
            //dest = right;
            //global.add(new Mov(getMem(node.getDest()),right));
            global.add(new Sub(dest,right));
            //global.add(new Mov(new Phyregister("rdx"),right));
            //dest = new Phyregister("rdx");
        }
        if (node.getOp() == binaryOperation.Op.MUL){
            global.add(new Imul(dest,right));
        }
        if (node.getOp() == binaryOperation.Op.DIV){
            global.add(new Mov(new Phyregister("rax"),right));
            global.add(new Cqo());
            global.add(new Idiv(dest));
            dest = new Phyregister("rax");
        }
        if (node.getOp() == binaryOperation.Op.AND){
            global.add(new And(dest,right));
        }
        if (node.getOp() == binaryOperation.Op.LOR){

        }
        if (node.getOp() == binaryOperation.Op.XOR){
            global.add(new Xor(dest,right));
        }
        if (node.getOp() == binaryOperation.Op.MOD){
            global.add(new Mov(new Phyregister("rax"),right));
            global.add(new Cqo());
            global.add(new Idiv(dest));
            dest = new Phyregister("rdx");
        }
        if (node.getOp() == binaryOperation.Op.OR){
            global.add(new Or(dest,right));
        }
        if (node.getOp() == binaryOperation.Op.SHL){
            global.add(new Mov(new Phyregister("rcx"),dest));
            global.add(new Mov(new Phyregister("rsi"),right));
            global.add(new Sal(new Phyregister("rsi"),new Phyregister("cl")));
            //global.add(new Mov(getMem(node.getDest()),right));return;
            //global.add(new Mov(new Phyregister("rsi"),right));
            dest = new Phyregister("rsi");
        }
        if (node.getOp() == binaryOperation.Op.SHR){
            global.add(new Mov(new Phyregister("rcx"),dest));
            global.add(new Mov(new Phyregister("rsi"),right));
            global.add(new Sar(new Phyregister("rsi"),new Phyregister("cl")));
            //global.add(new Mov(getMem(node.getDest()),right));return;
            //global.add(new Mov(new Phyregister("rsi"),right));
            dest = new Phyregister("rsi");
        }
        global.add(new Mov(getMem(node.getDest()),dest));
    }
    public void visit(Comparison node){
        assembly left = getMem(node.getLhs());
        assembly right = getMem(node.getRhs());
        if (left instanceof Address && right instanceof Address){
            //global.add(new Load(new Phyregister("r11"),(Address)right));
            global.add(new Mov(new Phyregister("r11"),(Address)right));
            right = new Phyregister("r11");
        }
        global.add(new Cmp(left,right));
        Comparison.Condition con = node.cond;
        if (con == Comparison.Condition.EQ){
            //if (node.isBranch)
            br = new Jne(null);
            //else global.add(new Sete(getMem(node.getDest())));
        }
        if (con == Comparison.Condition.GE){
            //if (node.isBranch)
            br = new Jl(null);
            //else global.add(new Setge(getMem(node.getDest())));
        }
        if (con == Comparison.Condition.GT){
            //if (node.isBranch)
            br = new Jng(null);

        }
        if (con == Comparison.Condition.LE){
            //if (node.isBranch)
            br = new Jg(null);
            //else global.add(new Setle(getMem(node.getDest())));
        }
        if (con == Comparison.Condition.LT){
            //if (node.isBranch)
            br = new Jnl(null);
            //else global.add(new Setl(getMem(node.getDest())));
        }
        if (con == Comparison.Condition.NE){
            //if (node.isBranch)
            br = new Je(null);
            //else global.add(new Setne(getMem(node.getDest())));
        }
    }
    public void visit(HeapAllocate node){
        //global.add(new Add(getMem(node.allocSize),new Imm(8)));
        //global.add(new Mov(new Phyregister("r11"),getMem(node.allocSize)));
        //global.add(new Mov(new Phyregister("r10"),getMem(node.allocSize)));
        /*global.add(new Imul(new Phyregister("r10"),new Imm(8)));
        global.add(new Mov(new Phyregister("rdi"),new Phyregister("r10")));
        global.add(new CallF("malloc"));
        global.add(new Mov(getMem(node.dest),new Phyregister("rax")));
        global.add(new Mov(new Phyregister("r9"),getMem(node.dest)));
        global.add(new Mov(new Memory(new Phyregister("r9"),"-",8),new Phyregister("r11")));*/
        //global.add(new Mov(new Phyregister("rdi"),getMem(node.allocSize)));
        if (node.space.nArray.get(0)==null) return;
        global.add(new Mov(new Phyregister("rdi"),new Imm(node.space.nArray.size())));
        global.add(new CallF("_malloc"));
        global.add(new Mov(getMem(node.dest),new Phyregister("rax")));
        global.add(new Mov(new Phyregister("r9"),getMem(node.dest)));
        for (Value item : node.space.nArray){
            global.add(new Add(new Phyregister("r9"),new Imm(8)));
            if (item!=null) global.add(new Mov(new Phyregister("r10"),getMem(item)));
            else global.add(new Mov(new Phyregister("r10"),new Imm(0)));
            global.add(new Mov(new Address("+",0,new Phyregister("r9")),new Phyregister("r10")));
            //global.add(new Add(new Phyregister("r9"),new Imm(8)));
        }
        //global.add(new Mov(getMem(node.dest),new Phyregister("rdi")));
        global.add(new Mov(new Phyregister("rdi"),getMem(node.dest)));
        global.add(new CallF("newArray"));
        global.add(new Mov(getMem(node.dest),new Phyregister("rax")));
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
        for (variable item : globalVariable){
            System.out.println("_"+item.name+":");
            System.out.println("resq 1");
        }
        //System.out.println("stringbuffer: \n");fout.println("stringbuffer: \n");
        System.out.println("SECTION .data");fout.println("SECTION .data");
        dealWithData();
        /*for (variable item : globalVariable){
            System.out.println("_"+item.name+":");
            System.out.println("dq 0000000000000000H");
        }*/
        //System.out.println("SECTION .bss");fout.println("SECTION .bss");
        builtinPrinter.printBuiltin("const_str");builtinPrinter2.printBuiltin("const_str",fout);
    }

    public void dealWithData(){
        /*for (variable item : globalVariable){
            System.out.println("_"+item.name+":");
            //System.out.println("dq 0000000000000000H");
        }*/
        int i = 0;
        for (String item : stringList){
            System.out.println("_"+i+":");
            i++;
            System.out.print("db ");
            for (int j = 1; j < item.length()-1; j++) {
                String result = null;
                if (item.charAt(j)=='\\'){
                    ++j;
                    if (item.charAt(j) == 'n') {
                        //str.append("  10,");
                        result = "0a";
                    }
                    if (item.charAt(j) == '\"') {
                        //str.append("  34,");
                        result = "22";
                    }
                    if (item.charAt(j) == '\\') {
                        //str.append("  92,");
                        result = "5c";
                    }
                }
                else{
                    int ch = (int) item.charAt(j);
                    String s4 = Integer.toHexString(ch);
                    result = s4;
                }
                result = result+"H, ";
                System.out.print(result);
            }
            System.out.println("00H");
        }
    }

}
/*
private String toInt(String value){
        StringBuffer str = new StringBuffer();
        int n = value.length();
        for (int j = 0; j < n; j++) {
            if (value.charAt(j) == '\\') {
                ++j;
                ++cntLen;
                if (value.charAt(j) == 'n') {
                    str.append("  10,");
                }
                if (value.charAt(j) == '\"') {
                    str.append("  34,");
                }
                if (value.charAt(j) == '\\') {
                    str.append("  92,");
                }
            } else {
                ++cntLen;
                str.append(String.format(" %3s,", (int) value.charAt(j)));
            }
        }
        str.append("   0\n");
        return str.toString();
    }
    */