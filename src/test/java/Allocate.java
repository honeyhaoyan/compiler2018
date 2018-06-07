import java.io.IOException;

/*
    1. Stack Frame
        low address
    | ...             |
    | temporary[n]    | <--- callee's rsp
    | ...             |
    | temporary[1]    | [rbp - 16]
    | temporary[0]    | [rbp - 8]
    | caller's rbp    | <--- callee's rbp
    | return address  | [rbp + 8]
    | arg[6]          | [rbp + 16]
    | arg[7]          | [rbp + 24]
    | ...             |
        high address
    call(a,b,c,d,e,f,g,h,i)
    2. The first 6 arguments are passed by registers:
    arg[0]  arg[1]  arg[2]  arg[3]  arg[4]  arg[5]
    rdi     rsi     rdx     rcx     r8      r9
     */
public class Allocate implements IRBasicVisitor {
    public void visit(IRRoot node)throws IOException {


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

    }
    public void visit(Function node){

    }
    public void visit(Branch node){

    }
    public void visit(Jump node){

    }
    public void visit(Return node){

    }
    public void visit(Move node){

    }
    public void visit(Store node){

    }/*
    public void visit(Load node){

    }*/
    public void visit(callFunction node){

    }
    public void visit(SystemCall node){

    }
    public void visit(unaryOperation node){

    }
    public void visit(binaryOperation node){

    }
    public void visit(Comparison node){

    }
    public void visit(HeapAllocate node){

    }
    public void visit(IRInstruction node){

    }

}
