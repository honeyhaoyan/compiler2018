import java.io.IOException;

public interface IRBasicVisitor {
    void visit(IRRoot node)throws IOException;
    void visit(Immediate node);
    void visit(virtualRegister node);

    void visit(Static node);
    void visit(staticString node);
    void visit(staticSpace node);
    void visit(stackSlot node);
    void visit(basicBlock node);
    void visit(Function node);
    void visit(IRInstruction node);
    void visit(Branch node);
    void visit(Jump node);
    void visit(Return node);
    void visit(Move node);
    void visit(Store node);
    //void visit(Load node);
    void visit(callFunction node);
    void visit(SystemCall node);
    void visit(unaryOperation node);
    void visit(binaryOperation node);
    void visit(Comparison node);
    void visit(HeapAllocate node);
}
