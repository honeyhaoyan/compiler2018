public class IRPrinter {
    public void print(IRRoot root){
        for (basicBlock item : root.basicBlocks){
            printBasicBlock(item);
        }
    }
    public void printBasicBlock(basicBlock B){
        IRInstruction pointer= B.getHead();
        pointer.print();
        while(pointer.getNext()!=null) {

            pointer = pointer.getNext();
            pointer.print();
        }
    }

}
