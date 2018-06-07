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
        reg.print(fout);
        System.out.print(op);fout.print(op);
        System.out.print(offset);fout.print(offset);
        System.out.print("]");fout.print("]");
    }
}
class Imm extends assembly{
    int data;
    public Imm(int data){this.data = data;}
    public void print(PrintStream fout){
        System.out.print(data);fout.print(data);
    }
}
class Label extends assembly{
    String la;
    public Label(String la){this.la = la;}
    public void print(PrintStream fout){
        System.out.print(la+":"+'\n');fout.print(la+":"+'\n');
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
        left.print(fout);
        System.out.print(" , ");fout.print(" , ");
        right.print(fout);
        System.out.print('\n');fout.print('\n');
    }
}
class Mov extends Two{
    //x : y
    public Mov(assembly left,assembly right){super(left,right);type = "mov";}
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
class Cmp{
    //does a comparison
}
class Je{
    //jumps to a label if the previous comparison was equal
}
class Jne{
    //jump if not equal
}
class Jl{
    //jump if less

}
class Jnl{
    //jump if not less

}
class Jg{
    //jump if greater
}
class Jng{
    //jump if not greater

}
class Jle{
    //jump if less or equal

}
class Jnle{
    //jump if not less or equal

}
class Jge{
    //jump if greater or equal

}
class Jnge{
    //jump if not greater or equal

}
class Push extends assembly{
    //Decrement rsp by the size of the operand, then store x in [rsp]
    Phyregister reg;
    public Push(Phyregister name){
        reg = name;
    }
    public void print(PrintStream fout){
        System.out.print("push ");fout.print("push ");
        reg.print(fout);
        System.out.print("\n");fout.print("\n");
    }
}
class Pop extends assembly{
    Phyregister reg;
    public Pop(Phyregister name){
        reg = name;
    }
    public void print(PrintStream fout){
        System.out.print("pop ");fout.print("pop ");
        reg.print(fout);
        System.out.print("\n");fout.print("\n");
    }
}
class Jnz{

}
class CallF extends assembly{
    String fun;
    public CallF(String fun){this.fun =fun;}
    public void print(PrintStream fout){
        System.out.print("call "+fun);fout.print("call "+fun);
    }
}
class Ret extends assembly{
    public Ret(){}
    public void print(PrintStream fout){
        System.out.println("ret");fout.println("ret");
    }
}
/*
class Load extends assembly{
    Address right;
    Phyregister left;
    public Load( Phyregister left,Address right){
        this.right = right;
        this.left = left;
    }
    public void print(PrintStream fout){
        System.out.print("load ");fout.print("load ");
        left.print(fout);
        System.out.print(" , "); fout.print(" , ");
        right.print(fout);
        System.out.println();fout.println();
    }
}*/
