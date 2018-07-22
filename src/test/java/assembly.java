import java.io.PrintStream;

//The .bss section is for writable data.
public abstract class assembly {
    public abstract void print(PrintStream fout);
}

class Address extends assembly{
    String op;
    int offset;
    Phyregister reg;
    public Address(String op, int offset, Phyregister reg){
        this.op = op;
        this.offset = offset;
        this.reg = reg;
    }
    @Override
    public void print(PrintStream fout){
        System.out.print("qword[");fout.print("qword[");
        //123456.print("qword[");
        reg.print(fout);
        System.out.print(op);fout.print(op);
        //123456.print(op);
        System.out.print(offset);fout.print(offset);
        //123456.print(offset);
        System.out.print("]");fout.print("]");
        //123456.print("]");
    }
}
class Imm extends assembly{
    int data;
    public Imm(int data){this.data = data;}
    public void print(PrintStream fout){
        System.out.print(data);fout.print(data);
        //123456.print(data);
    }
}
class Label extends assembly{
    String la;
    public Label(String la){this.la = la;}
    public void print(PrintStream fout){
        System.out.print(la+":"+'\n');fout.print(la+":"+'\n');
        //123456.print(la+":"+'\n');
    }
}
class Phyregister extends assembly{
    /*public enum names{
        // 64 bits wide
        R0 , R1 , R2 , R3 , R4 , R5 , R6 , R7 , R8 , R9 , R10 , R11 , R12 , R13 , R14 , R15,
        rax , rcx , rdx , rbx , rsp , rbp , rsi , rdi ,

        // the lowest 32-bits of each register
        //R0D , R1D , R2D , R3D , R4D , R5D , R6D , R7D , R8D , R9D , R10D , R11D , R12D , R13D ,
        //R14D , R15D, EAX , ECX , EDX , EBX , ESP , EBP , ESI , EDI,

        //the lowest 16-bits of each register
        //R0W , R1W , R2W , R3W , R4W , R5W , R6W , R7W , R8W , R9W , R10W , R11W , R12W , R13W , R14W , R15W,
        //AX , CX , DX , BX , SP , BP , SI , DI,

        //the lowest 8-bits of each register
        //R0B , R1B , R2B , R3B , R4B , R5B , R6B , R7B , R8B , R9B , R10B , R11B , R12B , R13B , R14B , R15B,
        //AL , CL , DL , BL , SPL , BPL , SIL , DIL,

        // bits 15 through 8 of R0..R3
        //AH , CH , DH , BH,
    };*/
    String registername;
    public Phyregister(String na){
        this.registername = na;
    }
    @Override public void print(PrintStream fout){
        System.out.print(registername);fout.print(registername);
        //123456.print(registername);
    }
}
class Two extends assembly{
    assembly left;
    assembly right;
    String type;
    public Two(assembly left, assembly right){
        this.left = left;
        this.right = right;
    }
    public void print(PrintStream fout){
        System.out.print(type+" ");fout.print(type+" ");
        //123456.print(type+" ");
        left.print(fout);
        System.out.print(" , ");fout.print(" , ");
        //123456.print(" , ");
        right.print(fout);
        System.out.print('\n');fout.print('\n');
        //123456.print('\n');
    }
}
class Mov extends Two{
    //x : y
    public Mov(assembly left,assembly right){super(left,right);type = "mov";}
}
class Movzlb extends Two{
    public Movzlb(assembly left, assembly right){super(left,right);type = "movzlb";}
}
class And extends Two{
    //x : x and y
    public And(assembly left,assembly right){super(left,right);type = "and";}
}
class Or extends Two{
    //x : x or y
    public Or(assembly left,assembly right){super(left,right);type = "or";}
}
class Xor extends Two{
    //x : x xor y
    public Xor(assembly left,assembly right){super(left,right);type = "xor";}
}
class Add extends Two{
    //x : x + y
    public Add(assembly left,assembly right){super(left,right);type = "add";}
}
class Sub extends Two{
    //x : x - y
    Phyregister regLe;
    public Sub(assembly left,assembly right){super(left,right);type = "sub";}
}
class Imul extends Two{
    public Imul(assembly left, assembly right){super(left,right);type = "imul";}
}
class Sal extends Two{
    public Sal(assembly left, assembly right){
        super(left,right);
        //type = "sal";
        type = "shl";
    }
}
class Sar extends Two{
    public Sar(assembly left, assembly right){
        super(left,right);
        //type = "sar";
        type = "shr";
    }
}
/*
class one extends assembly{
    assembly item;
    public one(assembly item){
        this.item = item;
    }
    public void print(){
        item.print();
    }
}*/
class Inc{
    //x : x + 1

}
class Dec{
    //x :x - 1

}
class Syscall{
    //Invoke an operating system routine

}
class Db{
    //A pseudo-instruction that declares bytes that will be in memory when the program runs

}
class Not extends assembly{
    assembly node;
    public Not(assembly node){
        this.node = node;
    }
    public void print(PrintStream fout){
        System.out.print("not ");
        //123456.print("not ");
        node.print(fout);
        System.out.println();
        //123456.println();
    }
}
class Neg extends assembly{
    assembly node;
    public Neg(assembly node){this.node = node;}
    public void print(PrintStream fout){
        System.out.print("neg ");
        //123456.print("neg ");
        node.print(fout);
        System.out.println();
        //123456.println();
    }
}
class Cmp extends assembly{
    //does a comparison
    assembly left;
    assembly right;
    public Cmp(assembly left, assembly right){
        this.left = left;
        this.right = right;
    }
    public void print(PrintStream fout){
        System.out.print("cmp ");fout.print("cmp ");
        //123456.print("cmp ");
        left.print(fout);
        System.out.print(" , ");fout.print(" , ");
        //123456.print(" , ");
        right.print(fout);
        System.out.print('\n');fout.print('\n');
        //123456.print('\n');
    }
}
class JJump extends assembly{
    String type;
    String label;
    public JJump(String label){
        this.label = label;
    }
    @Override
    public void print(PrintStream ps){
        System.out.print(type+" ");
        //123456.print(type+" ");
        System.out.print(label);
        //123456.print(label);
        System.out.println();
        //123456.println();
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
class Je extends JJump{
    //jumps to a label if the previous comparison was equal
    Je(String label){ super(label);type = "je"; }
}
class Jne extends JJump{
    //jump if not equal
    Jne(String label){ super(label);type = "jne"; }
}
class Jl extends JJump{
    //jump if less
    Jl(String label){ super(label);type = "jl"; }
}
class Jnl extends JJump{
    //jump if not less
    Jnl(String label){ super(label);type = "jnl"; }
}
class Jg extends JJump{
    //jump if greater
    Jg(String label){ super(label);type = "jg"; }
}
class Jng extends JJump{
    //jump if not greater
    Jng(String label){ super(label);type = "jle"; }
}
class Jle extends JJump{
    //jump if less or equal
    Jle(String label){ super(label);type = "jle"; }
}
class Jnle extends JJump{
    //jump if not less or equal
    Jnle(String label){ super(label);type = "jnle"; }
}
class Jge extends JJump{
    //jump if greater or equal
    Jge(String label){ super(label);type = "jge"; }
}
class Jnge extends JJump{
    //jump if not greater or equal
    Jnge(String label){ super(label);type = "jnge"; }
}
class Push extends assembly{
    //Decrement rsp by the size of the operand, then store x in [rsp]
    Phyregister reg;
    public Push(Phyregister name){
        reg = name;
    }
    public void print(PrintStream fout){
        System.out.print("push ");fout.print("push ");
        //123456.print("push ");
        reg.print(fout);
        System.out.print("\n");fout.print("\n");
        //123456.print("\n");
    }
}
class Pop extends assembly{
    Phyregister reg;
    public Pop(Phyregister name){
        reg = name;
    }
    public void print(PrintStream fout){
        System.out.print("pop ");fout.print("pop ");
        //123456.print("pop ");
        reg.print(fout);
        System.out.print("\n");fout.print("\n");
        //123456.print("\n");
    }
}
class Jmp extends JJump{

    //String label;
    Jmp(String label){ super(label);type = "jmp"; }
}
class CallF extends assembly{
    String fun;
    public CallF(String fun){this.fun =fun;}
    public void print(PrintStream fout){
        /*if (!fun.equals("println")&&!fun.equals("print")&&!fun.equals("_malloc")){System.out.println("push R12");
        System.out.println("push R13");
        System.out.println("push R14");
        System.out.println("push R15");}*/
        System.out.println("call "+fun);fout.println("call "+fun);
        /*if(!fun.equals("println")&&!fun.equals("print")&&!fun.equals("_malloc")){System.out.println("pop R15");
        System.out.println("pop R14");
        System.out.println("pop R13");
        System.out.println("pop R12");}*/
        //123456.println("call "+fun);
    }
}
class Ret extends assembly{
    public Ret(){}
    public void print(PrintStream fout){
        System.out.println("ret");fout.println("ret");
        //123456.println("ret");
    }
}
class Leave extends assembly{
    public Leave(){}
    public void print(PrintStream fout){
        System.out.println("leave");fout.println("leave");
        //123456.println("leave");
    }
}
class Memory extends assembly{
    Phyregister reg;
    int offset;
    String op;
    public Memory(Phyregister reg, String op,int offset){this.reg = reg; this.op = op;this.offset = offset;}
    public void print(PrintStream fout){
        System.out.print("[");
        //123456.print("[");
        reg.print(fout);
        System.out.print(op);
        //123456.print(op);
        System.out.print(offset);
        //123456.print(offset);
        System.out.print("]");
        //123456.print("]");
        //System.out.println();
    }
}
class Set extends assembly{
    String type;
    assembly dest;
    public Set(String type, assembly dest){
        this.type = type;
        this.dest = dest;
    }
    public void print(PrintStream fout){
        System.out.print(type+" ");//123456.print(type+" ");
        dest.print(fout);
        System.out.println();//123456.println();
    }
}
class Sete extends Set{
    public Sete(assembly dest){
        super("sete",dest);
    }
}
class Setne extends Set{
    public Setne(assembly dest){
        super("setne",dest);
    }
}
class Setg extends Set{
    public Setg(assembly dest){
        super("setg",dest);
    }
}
class Setge extends Set{
    public Setge(assembly dest){
        super("setge",dest);
    }
}
class Setl extends Set{
    public Setl(assembly dest){
        super("setl",dest);
    }
}
class Setle extends Set{
    public Setle(assembly dest){
        super("setle",dest);
    }
}
class Cqo extends assembly{
    public Cqo(){}
    public void print(PrintStream fout){
        System.out.println("cqo");
        //123456.println("cqo");
    }
}
class Idiv extends assembly{
    assembly item;
    public Idiv(assembly item){
        this.item = item;
    }
    public void print(PrintStream fout){
        System.out.print("idiv ");
        //123456.print("idiv ");
        item.print(fout);
        System.out.println();
        //123456.println();
    }
}