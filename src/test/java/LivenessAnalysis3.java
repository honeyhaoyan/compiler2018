import java.util.*;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class LivenessAnalysis3 {
    private IRRoot ir;
    public LivenessAnalysis3(IRRoot ir) {
        this.ir = ir;
    }

    /*
    private void addRegister(IRInstruction instr, Value value){
        if (value instanceof virtualRegister&&((virtualRegister) value).ifRenamed==false){
            instr.registers.add((virtualRegister) value);
        }
    }*/
    /*
    private void setRegisters(){
        for (basicBlock block : ir.basicBlocks){
            for (IRInstruction inst : block.irInstructions){

                if (inst instanceof Move){
                    //inst.registers.add(((Move) inst).getDest());
                    addRegister(inst,((Move) inst).getDest());
                    addRegister(inst,((Move) inst).getSource());
                }
                if (inst instanceof callFunction){
                    for (virtualRegister reg : ((callFunction) inst).params){
                        //inst.registers.add(reg);
                        addRegister(inst,reg);
                    }
                }
                if (inst instanceof unaryOperation){
                    //inst.registers.add(((unaryOperation) inst).getDest());
                    addRegister(inst,((unaryOperation) inst).getDest());
                    addRegister(inst,((unaryOperation) inst).getInitialValue());
                }
                if (inst instanceof binaryOperation){
                    addRegister(inst,((binaryOperation) inst).getLhs());
                    addRegister(inst,((binaryOperation) inst).getRhs());
                    //inst.registers.add(((binaryOperation) inst).getDest());
                    addRegister(inst,((binaryOperation) inst).getDest());
                }
                if (inst instanceof Comparison){
                    addRegister(inst,((Comparison) inst).getRhs());
                    addRegister(inst,((Comparison) inst).getLhs());
                    //inst.registers.add(((Comparison) inst).getDest());
                    addRegister(inst,((Comparison) inst).getDest());
                }
                if (inst instanceof HeapAllocate){
                    //inst.registers.add(((HeapAllocate) inst).dest);
                    addRegister(inst,((HeapAllocate) inst).dest);
                    for (Value value:((HeapAllocate)inst).space.nArray){
                        addRegister(inst,value);
                    }
                }

            }
        }
    }*/
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

        for (basicBlock BB:func.basicBlocks){
            int p = 0;
            for (p=0;p<BB.irInstructions.size()-1;++p){
                BB.irInstructions.get(p).next = BB.irInstructions.get(p+1);
            }
        }

        while(changed){
            changed = false;
            for (basicBlock B : Block){
                List<IRInstruction> reOrderBlock = reverseInstructions(B);
                for (IRInstruction inst : reOrderBlock){

                    in.clear();
                    out.clear();

                    if (inst instanceof Branch) {
                        if (((Branch) inst).findThen()!=null&&((Branch) inst).findThen().irInstructions.size()!=0) out.addAll(((Branch) inst).findThen().irInstructions.get(0).liveIn);
                        if (((Branch) inst).findOtherwise()!=null&&((Branch) inst).findOtherwise().irInstructions.size()!=0) {
                            Set<virtualRegister>list = ((Branch) inst).findOtherwise().irInstructions.get(0).liveIn;
                            out.addAll(((Branch) inst).findOtherwise().irInstructions.get(0).liveIn);
                        }
                    } else if (inst instanceof Jump) {
                        if (((Jump) inst).getJumpTo()!=null&&((Jump) inst).getJumpTo().irInstructions.size()!=0) out.addAll(((Jump) inst).getJumpTo().irInstructions.get(0).liveIn);
                    } else if (!(inst instanceof Return)) {
                        if (inst.getNext()!=null) // inst is not a branch, thus inst.getNext() not null
                            out.addAll(inst.getNext().liveIn);
                    }
                    in.addAll(out);
                    for (virtualRegister define : inst.defined) {
                        //virtualRegister defined = inst.defined;
                        if (define instanceof virtualRegister)
                            if (define != null)
                                in.remove(define);
                    }
                    List<virtualRegister> usedRegisterList = inst.registers;
                    if (usedRegisterList != null) {
                        in.addAll(usedRegisterList);
                    }
                    for (virtualRegister define : inst.defined) {
                        //virtualRegister defined = inst.defined;
                        if (define instanceof virtualRegister)
                            if (define != null)
                                in.remove(define);
                    }
                    // System.out.println("in: "+in.size());
                    // System.out.println("out: "+out.size());
                    /*if (inst.getLiveInSet() == null) {
                        throw new RuntimeException();
                    }*/
                    if (!inst.liveOut.equals(out)|| !inst.liveIn.equals(in)) {
                        changed = true;
                        inst.liveOut.clear();
                        inst.liveIn.clear();
                        inst.liveOut.addAll(out);
                        inst.liveIn.addAll(in);
                    }



                }

            }
        }
        /*for (basicBlock B : func.basicBlocks){
            for (IRInstruction instruction : B.irInstructions){
                instruction.live.addAll(instruction.liveIn);
                instruction.live.addAll(instruction.liveOut);
                B.live.addAll(instruction.live);
            }

        }*/

    }

    Map<virtualRegister,Integer>registerIntegerMap;
    virtualRegister [] registerList;
    int[]registerNumber;
    int[] edge;
    double[]registerValue;
    boolean [][] graph;
    boolean [] visit;
    int global = 0;
    List<String>registers;

    public void graphBuild(){
        registerIntegerMap = new HashMap<>();

        for (Function function:ir.functions){
            for (basicBlock block:function.basicBlocks){
                //IRInstruction inst = block.getTail();
                for (IRInstruction inst : block.irInstructions){
                /*for (virtualRegister register:inst.registers){
                //for (virtualRegister register:block.live){
                    if (!registerIntegerMap.containsKey(register)) registerIntegerMap.put(register,global++);
                }*/
                    //inst.live.addAll()
                    for (virtualRegister define:inst.defined) {
                        if (!registerIntegerMap.containsKey(define)) registerIntegerMap.put(define,global++);
                        //System.out.println("global"+global);
                        //System.out.println("size"+registerIntegerMap.size());
                    }
                }
            }
        }

        //global--;

        registerNumber = new int[global];
        registerValue = new double[global];
        graph = new boolean[global][global];
        visit = new boolean[global];
        edge = new int [global];
        registerList = new virtualRegister[global];

        for (virtualRegister regs : registerIntegerMap.keySet()){
            registerList[registerIntegerMap.get(regs)] = regs;
        }

        for (int i = 0;i<global;++i) {registerNumber[i] = 0;visit[i] = false;edge[i] = 0;}

        /*for (Function function:ir.functions){
            for (basicBlock block:function.basicBlocks){
                //IRInstruction inst = block.getTail();
                //for (virtualRegister register:inst.live){
                for (virtualRegister register:block.live){
                   int number = registerIntegerMap.get(register);
                   registerNumber[number]++;
                   //for (virtualRegister register2:inst.registers){
                    for (virtualRegister register2:block.live){
                       int number2 = registerIntegerMap.get(register2);
                       if (number!=number2){
                           if(graph[number][number2]==false){
                               edge[number]++;
                               edge[number2]++;
                           }
                           graph[number][number2] = true;
                           graph[number2][number] = true;
                       }
                   }
                }
            }
        }*/
        for (Function function:ir.functions){
            for (basicBlock block:function.basicBlocks){
                for (IRInstruction inst : block.irInstructions){
                    if (inst instanceof HeapAllocate){
                        inst.liveOut.addAll(inst.liveIn);
                    }
                    for (virtualRegister define:inst.defined) {
                        int number = registerIntegerMap.get(define);
                        for (virtualRegister define2:inst.defined){
                            int number3 = registerIntegerMap.get(define2);
                            graph[number][number3] = true;
                            graph[number3][number] = true;
                        }
                        registerNumber[number]++;
                        //System.out.println(registerNumber[number]);
                        for (virtualRegister register2:inst.liveOut){
                            if (!registerIntegerMap.containsKey(register2)){
                                int h = 1;
                            }
                            if (register2.ifRenamed==false){
                                int number2 = registerIntegerMap.get(register2);
                                registerNumber[number2]++;
                                if (number!=number2){
                                    if(graph[number][number2]==false){
                                        edge[number]++;
                                        edge[number2]++;
                                    }
                                    graph[number][number2] = true;
                                    graph[number2][number] = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int j = 0;j<global;++j){
            //System.out.println(registerNumber[j]+" "+edge[j]);
            if (edge[j] == 0) registerValue[j] = registerNumber[j];
            else registerValue[j] = (double) registerNumber[j]/(double) edge[j];
            /*if (registerList[j]==null){
                int t=0;
            }*/
            registerList[j].registerValue = registerValue[j];
            //System.out.println("---------"+registerValue[j]);
            //if (j!=global) registerList[j].registerValue = registerValue[j];
        }

        double max = -1;
        virtualRegister registerMax = null;
        boolean[] visited = new boolean[global];
        virtualRegister [] registerList2 = new virtualRegister[global];
        for (int l = 0;l<global;++l) visited[l] = false;
        for (int k = 0;k<global;++k){
            max = -1;
            for (int j = 0;j<global;++j){
                //max = -1;
                if (registerList[j].registerValue>max&&visited[j]==false){
                    max = registerList[j].registerValue;
                    registerMax = registerList[j];
                }
            }
            registerList2[k] = registerMax;
            visited[registerIntegerMap.get(registerMax)] = true;
            //System.out.println(list2[k].registerValue);
        }

        //R12,R13,R14,R15,R10,R11
        boolean [] color = new boolean[4];
        //boolean [] color = new boolean[6];
        for (virtualRegister register : registerList){
            if (register.ifRenamed==false){
                int number = registerIntegerMap.get(register);
                int y =1;
                //for (int i = 0;i<6;++i){
                for (int i = 0;i<4;++i)  {
                    color[i] = true;
                }
                for (int p = 0;p<global;++p){
                    if (graph[number][p]==true){
                        if(registerList[p].ifRenamed==true){
                            switch (registerList[p].getNewName()){
                                case "R12":
                                    color[0] = false;
                                    break;
                                case "R13":
                                    color[1] = false;
                                    break;
                                case "R14":
                                    color[2] = false;
                                    break;
                                case "R15":
                                    color[3] = false;
                                    break;
                            /*case "R10":
                                color[4] = false;
                            case "R11":
                                color[5] = false;*/

                            }
                        }
                    }
                }
                //for (int i = 0;i<6;++i){
                for (int i = 0;i<4;++i)  {
                    if (color[i]==true){
                        switch (i){
                            case 0:
                                register.setNewName("R12");
                                break;
                            case 1:
                                register.setNewName("R13");
                                break;
                            case 2:
                                register.setNewName("R14");
                                break;
                            case 3:
                                register.setNewName("R15");
                                break;
                        /*case 4:
                            register.setNewName("R10");
                        case 5:
                            register.setNewName("R11");*/
                        }
                        break;
                    }
                }
            }}
    }

   /* public List<virtualRegister> dfs(virtualRegister register){
        int num = registerIntegerMap.get(register);
        List<virtualRegister> list = new ArrayList<>();
        list.add(register);
        visit[num] = true;
        for (int h = 0; h<global;++h){
            if (graph[num][h] == true&&visit[h]==false){
                visit[h] = true;
                list.add(registerList[h]);
                List<virtualRegister>list2 = dfs(registerList[h]);
                for (virtualRegister reg:list2){
                    if (!list.contains(reg)) list.add(reg);
                }
            }
        }
        return list;
    }*/

    public void graphColor(List<virtualRegister> list){
        /*for(virtualRegister register:list){
            //Collections.sort(list,Collections.reverseOrder());
            Collections.sort(list,new Comparator<virtualRegister>(){
                public int compare(virtualRegister arg0, virtualRegister arg1) {
                    //return arg0.registerValue.compareTo(arg1.registerValue);
                    if (arg0.registerValue>arg1.registerValue) return arg0.registerValue;
                    else return arg1.registerValue;
                }
            });
        for (int y = 0; y<list.size();++y) System.out.println(list.get(y).registerValue);}*/
        //List<virtualRegister>list2 = new ArrayList<>();
        virtualRegister list2[] = new virtualRegister[list.size()];
        double max = -1;
        virtualRegister registerMax = null;
        boolean[] visited = new boolean[list.size()];
        for (int l = 0;l<list.size();++l) visited[l] = false;
        for (int k = 0;k<list.size();++k){
            max = -1;
            for (int j = 0;j<list.size();++j){
                //max = -1;
                if (list.get(j).registerValue>max&&visited[j]==false){
                    max = list.get(j).registerValue;
                    registerMax = list.get(j);
                }
            }
            list2[k] = registerMax;
            visited[k] = true;
            //System.out.println(list2[k].registerValue);
        }
        /*for (int i = 0;i<registers.size()&&i<list.size();++i){
            list2[i].setNewName(registers.get(i));
        }*/

    }

    private void physicalRegister(){
        registers = new ArrayList<>();
        registers.add("R12");
        registers.add("r13");
        registers.add("r14");
        registers.add("r15");
    }

    public void run(){
        //this.setRegisters();
        for (Function function:ir.functions) processFunction(function);
        physicalRegister();
        graphBuild();
    }

}
