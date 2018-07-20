import java.util.*;
import java.util.Set;

public class LivenessAnalysis {
    /*private IRRoot ir;

    public InstructionLivenessAnalysis(IRRoot ir) {
        this.ir = ir;
    }

    private void initBlock(BasicBlock BB) {
        for (IRInstruction inst = BB.getHead(); inst != null; inst = inst.getNext())
            if (inst.liveOut == null) {
                inst.liveOut = new HashSet<>();
                inst.liveIn = new HashSet<>();
            } else {
                inst.liveOut.clear();
                inst.liveIn.clear();
            }
    }

    private void processFunction(Function func) {
        func.calcReversePreOrder();
        List<BasicBlock> RPO = func.getReversePreOrder();
        RPO.forEach(this::initBlock);

        Set<VirtualRegister> out = new HashSet<>();
        Set<VirtualRegister> in = new HashSet<>();
        boolean changed = true;
        while (changed) {
            changed = false;
            for (BasicBlock BB : RPO) {
                for (IRInstruction inst = BB.getLast(); inst != null; inst = inst.getPrev()) {
                    in.clear();
                    out.clear();
                    if (inst instanceof Branch) {
                        out.addAll(((Branch) inst).getThen().getHead().liveIn);
                        out.addAll(((Branch) inst).getElse().getHead().liveIn);
                    } else if (inst instanceof Jump) {
                        out.addAll(((Jump) inst).getTarget().getHead().liveIn);
                    } else if (!(inst instanceof Return)) {
                        assert inst.getNext() != null; // inst is not a branch, thus inst.getNext() not null
                        out.addAll(inst.getNext().liveIn);
                    }
                    in.addAll(out);
                    Register defined = inst.getDefinedRegister();
                    if (defined instanceof VirtualRegister)
                        in.remove(defined);
                    inst.getUsedRegister().stream()
                            .filter(x -> x instanceof VirtualRegister)
                            .forEach(x -> in.add((VirtualRegister) x));
                    if (!inst.liveOut.equals(out) || !inst.liveIn.equals(in)) {
                        changed = true;
                        inst.liveOut.clear();
                        inst.liveIn.clear();
                        inst.liveOut.addAll(out);
                        inst.liveIn.addAll(in);
                    }
                }
            }
        }
    }

    public void run() {
        ir.functions.values().forEach(this::processFunction);
    }*/
    private IRRoot ir;
    public LivenessAnalysis(IRRoot ir) {
        this.ir = ir;
    }

    private void addRegister(IRInstruction instr, Value value){
        if (value instanceof virtualRegister){
            instr.registers.add((virtualRegister) value);
        }
    }

    private void setRegisters(){
        for (basicBlock block : ir.basicBlocks){
            for (IRInstruction inst : block.irInstructions){
                /*if (inst instanceof Branch){

                }
                if (inst instanceof Jump){

                }
                if (inst instanceof Return){

                }*/
                if (inst instanceof Move){
                    inst.registers.add(((Move) inst).getDest());
                    addRegister(inst,((Move) inst).getSource());
                }
                if (inst instanceof callFunction){
                    for (virtualRegister reg : ((callFunction) inst).params){
                        inst.registers.add(reg);
                    }
                }
                if (inst instanceof unaryOperation){
                    inst.registers.add(((unaryOperation) inst).getDest());
                    addRegister(inst,((unaryOperation) inst).getInitialValue());
                }
                if (inst instanceof binaryOperation){
                    addRegister(inst,((binaryOperation) inst).getLhs());
                    addRegister(inst,((binaryOperation) inst).getRhs());
                    inst.registers.add(((binaryOperation) inst).getDest());
                }
                if (inst instanceof Comparison){
                    addRegister(inst,((Comparison) inst).getRhs());
                    addRegister(inst,((Comparison) inst).getLhs());
                    inst.registers.add(((Comparison) inst).getDest());
                }
                if (inst instanceof HeapAllocate){
                    inst.registers.add(((HeapAllocate) inst).dest);
                    for (Value value:((HeapAllocate)inst).space.nArray){
                        addRegister(inst,value);
                    }
                }
                for (virtualRegister register:inst.registers){
                    register.ifRenamed = true;
                }
            }
        }
    }
    private void initBlock(basicBlock BB) {
        for (IRInstruction inst = BB.getHead(); inst != null; inst = inst.getNext())
            if (inst.liveOut == null) {
                inst.liveOut = new HashSet<>();
                inst.liveIn = new HashSet<>();
            } else {
                inst.liveOut.clear();
                inst.liveIn.clear();
            }
    }
    private List<basicBlock> reverseBasicBlocks(Function function){
        List<basicBlock> BB = new ArrayList<>();
        int size = function.basicBlocks.size();
        for (int i = size-1;i>=0;--i){
            BB.add(function.basicBlocks.get(i));
        }
        return BB;
    }
    private List<IRInstruction> reverseInstructions(basicBlock block){
        List<IRInstruction> II = new ArrayList<>();
        int size = block.irInstructions.size();
        for (int i = size-1;i>=0;--i){
            II.add(block.irInstructions.get(i));
        }
        return II;
    }
    private void processFunction(Function func) {
        List<basicBlock> Block = reverseBasicBlocks(func);
        Block.forEach(x->initBlock(x));
        Set<virtualRegister> out = new HashSet<>();
        Set<virtualRegister> in = new HashSet<>();
        boolean changed = true;

        while(changed){
            changed = false;
            for (basicBlock B : Block){
                List<IRInstruction> reOrderBlock = reverseInstructions(B);
                for (IRInstruction inst : reOrderBlock){

                    in.clear();
                    out.clear();

                    if (inst instanceof Branch) {
                        out.addAll(((Branch) inst).findThen().getHead().liveIn);
                        out.addAll(((Branch) inst).findOtherwise().getHead().liveIn);
                    } else if (inst instanceof Jump) {
                        out.addAll(((Jump) inst).getJumpTo().getHead().liveIn);
                    } else if (!(inst instanceof Return)) {
                        assert inst.getNext() != null; // inst is not a branch, thus inst.getNext() not null
                        out.addAll(inst.getNext().liveIn);
                    }
                    in.addAll(out);
                    virtualRegister defined = inst.registerValue;
                    if (defined instanceof virtualRegister)
                    if (defined!=null)
                        in.remove(defined);/*
                    inst.registerValue.stream()
                            .filter(x -> x instanceof VirtualRegister)
                            .forEach(x -> in.add((VirtualRegister) x));*/
                    List<virtualRegister> usedRegisterList = inst.registers;
                    if (usedRegisterList != null) {
                        in.addAll(usedRegisterList);
                    }
                    /*if (inst.getLiveInSet() == null) {
                        throw new RuntimeException();
                    }*/
                    if (!inst.liveOut.equals(out) || !inst.liveIn.equals(in)) {
                        changed = true;
                        inst.liveOut.clear();
                        inst.liveIn.clear();
                        inst.liveOut.addAll(out);
                        inst.liveIn.addAll(in);
                    }



                }
            }
        }
    }

    public void run(){
        this.setRegisters();
        for (Function function:ir.functions) processFunction(function);
    }

}
