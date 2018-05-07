
public class ASTvisitor {
    public void visit(Program node) throws Exception{
        topScope top = new topScope();
        buildInlineFunctions(top);
        for (Node item : node.sequenceSons){
            if (item instanceof classDefinition) {
                //get className and put it into top nameset
                visitClass1((classDefinition)item,top);
            }
        }
        for (Node item : node.sequenceSons){
            //get function name and function head
            if (item instanceof functionDefinition) visitFunction1((functionDefinition)item,top);
            //get class variable definition (to be used in class functions) and class function definition
            if (item instanceof classDefinition) visitClass2((classDefinition)item,top);
        }
        for (Node item : node.sequenceSons){
            //visit global variable
            if (item instanceof variable) visitVariable((variable)item,top);
            //visit statements in global function
            if (item instanceof functionDefinition) visitFunction2((functionDefinition)item,top);
            //visit statements in class function
            if (item instanceof classDefinition) visitClass3((classDefinition)item,top);
        }
    }

    public void visitClass1(classDefinition node, topScope scope) throws Exception{
        String className = node.selfName;
        if (scope.name.contains(className)) throw new Exception("In program, classname conflicts with names that have already existed.");
        else{
            classScope tmp = new classScope();
            tmp.scopeFather = scope;
            tmp.className = className;
            scope.classes.put(className,tmp);
            scope.name.add(className);
        }
    }

    public void visitFunction1(functionDefinition node, Scope scope) throws Exception{
        String functionName = node.functionName;
        //System.out.println(functionName);
        if (scope.name.contains(functionName)) throw new Exception("FunctionName conflicts with names that have already existed.");
        else {
            functionScope tmp = new functionScope();
            tmp.scopeFather = scope;
            tmp.functionName = functionName;
            tmp.name.add(tmp.functionName);
            tmp.returnType = node.returnType;
            if (node.inputVariableSons!=null){
            for (variable item : node.inputVariableSons){
                //System.out.println(item.name);
                if (tmp.name.contains(item.name)) throw new Exception("In function, inputVariableName conflicts with names that have already existed.");
                else {
                    tmp.name.add(item.name);
                    tmp.inputVariable.put(item.ty.typeName,item);
                    System.out.println("--------------------------------------");
                    System.out.println(item.ty.typeName);
                    System.out.println(tmp.functionName);
                }
            }}
            scope.function.put(functionName,tmp);
            scope.name.add(functionName);
        }
    }

    public void visitClass2(classDefinition node, topScope scope) throws Exception{
        if (scope.classes.containsKey(node.selfName)){
            for (definitionStatement item : node.variableSons){
                if (scope.classes.get(node.selfName).name.contains(item.variableSon.name)) throw new Exception("In class, variableName conflicts with names that have already existed.");
                visitVariable(item.variableSon,scope.classes.get(node.selfName));
            }
            for (functionDefinition item : node.functionSons){
                if (scope.classes.get(node.selfName).name.contains(item.functionName)) throw new Exception("In class, functionName conflicts with names that have already existed.");
                visitFunction1(item,scope.classes.get(node.selfName));
            }
        }
    }

    public void visitFunction2(functionDefinition node,Scope scope) throws Exception{
        if (scope.function.containsKey(node.functionName)){
            visitBlock(node.blockSon,scope.function.get(node.functionName),"Function",false,node.returnType);
        }
    }

    public void visitVariable(variable node,Scope scope) throws Exception{
        if (scope.name.contains(node.name)) throw new Exception("VariableName conflicts with names that have already existed.");
        else{
            scope.variable.put(node.name,node);
            scope.name.add(node.name);
        }
    }

    public void visitClass3(classDefinition node, topScope scope) throws Exception{
        if (scope.classes.containsKey(node.selfName)){
            for (functionDefinition item : node.functionSons){
                visitFunction2(item,scope.classes.get(node.selfName));
            }
        }
    }

    //scope
    public void visitBlock(blockDefinition node, Scope scope,String blockType,boolean returnNum,type returnType) throws Exception{
        for (statement item : node.statementSons){
            if (item instanceof assignmentStatement){
                type ty1 = new type();
                type ty2 = new type();
                ty1 = visitExpression(((assignmentStatement) item).expLe,scope);
                ty2 = visitExpression(((assignmentStatement) item).expRi,scope);
                System.out.println("*************************");
                System.out.println(ty1.typeName);
                System.out.println(ty2.typeName);
                if (!ty1.typeName.equals(ty2.typeName)||!ty1.arr.equals(ty2.arr)) throw new Exception("Illegal assignment.");
            }

            if (item instanceof definitionStatement){
                variable va = new variable();
                va = ((definitionStatement) item).variableSon;
                scope.variable.put(va.name,va);
                scope.name.add(va.name);
                //System.out.println("*************************");
                System.out.println("visit definitionStatement");
                visitExpression(((definitionStatement) item).exp,scope);
                if (va.name.equals("n")) System.out.println(va.ty.typeName);
            }

            if (item instanceof ifStatement){
                visitIf((ifStatement)item,scope);
            }

            if (item instanceof forStatement){
                visitFor((forStatement)item,scope);
            }

            if (item instanceof whileStatement){
                visitWhile((whileStatement)item,scope);
            }

            if (item instanceof breakStatement){
                Scope scopeTmp = scope;
                while (scopeTmp.scopleType!="top"){
                    if (scopeTmp.scopleType == "Function") throw new Exception("In function, illegal break");
                    else {
                        if (scopeTmp.scopleType == "while"||blockType=="for") break;
                    }
                    scopeTmp=scopeTmp.scopeFather;
                }
                if (scopeTmp.scopleType=="top") throw new Exception("Illegal break");
            }

            if (item instanceof returnStatement){
                if (returnNum == true){
                    throw new Exception("In function, more than one return.");
                }
                else {
                    returnNum = true;
                    if (returnType!=visitExpression(((returnStatement) item).returnExpression,scope));
                }
            }

            if (item instanceof continueStatement){
                Scope scopeTmp = scope;
                while (scopeTmp.scopleType!="top"){
                    if (scopeTmp.scopleType == "Function") throw new Exception("In function, illegal continue");
                    else {
                        if (scopeTmp.scopleType == "while"||blockType=="for") break;
                    }
                    scopeTmp=scopeTmp.scopeFather;
                }
                if (scopeTmp.scopleType=="top") throw new Exception("Illegal continue");
            }

            if (item instanceof newStatement){
                type ty1 = ((newStatement) item).newType1;
                type ty2 = ((newStatement) item).newType2;
                //System.out.println(ty1.typeName);
                //System.out.println(ty2.typeName);
                //System.out.println(ty1.arr.size());
                //System.out.println(ty2.arr.size());
                if ((!ty1.typeName.equals(ty2.typeName))||ty1.arr.size()!=ty2.arr.size()) throw new Exception("NewStatement type conflict.");
                variable va = new variable();
                va.ty=ty2;
                va.name = ((newStatement) item).name;
                scope.name.add(va.name);
                scope.variable.put(va.name,va);
            }

            if (item instanceof selfOperationStatement){
                type ty = new type();
                if (((selfOperationStatement) item).va!=null) {
                    variable va = ((selfOperationStatement) item).va;
                    ty = visitExpressionVariable(va,scope);
                }
                else{
                    if (((selfOperationStatement) item).exp!=null){
                        ty = visitExpression( ((selfOperationStatement) item).exp,scope);
                    }
                }
                if (ty.typeName!="Int"&&ty.arr==null) throw new Exception("Illegal selfOperation.");
            }

            if (item instanceof callFunctionStatement){
                visitExpression(((callFunctionStatement) item).callFunc,scope);
            }
        }
    }

    public void  buildInlineFunctions(topScope scope){
        variable va = new variable();

        functionScope print = new functionScope();
        va.ty.typeName="String";
        print.inputVariable.put("String",va);
        print.functionName = "print";
        print.returnType.typeName = "void";

        functionScope println = new functionScope();
        va.ty.typeName="String";
        println.inputVariable.put("String",va);
        println.functionName = "println";
        println.returnType.typeName = "void";

        functionScope getString = new functionScope();
        getString.functionName = "getString";
        getString.returnType.typeName = "String";

        functionScope getInt = new functionScope();
        getInt.functionName = "getInt";
        getInt.returnType.typeName = "Int";

        functionScope toString = new functionScope();
        va.ty.typeName="Int";
        toString.inputVariable.put("Int",va);
        toString.functionName = "toString";
        toString.returnType.typeName = "String";
    }

    public type visitExpression (expression node, Scope scope) throws Exception{
        System.out.println("************************************");
        System.out.println(node.toString());
        type globalType = new type();
        type subType = new type();
        Op op = new Op();
        for (Node item : node.sons) {
            if (item instanceof expression){
                subType = visitExpression((expression) item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof Op){
                subType = visitOp((Op)item,scope);
                if (subType.typeName=="Bool") return subType;
                globalType = checkException(globalType,subType);
                op = (Op)item;
                System.out.println(op.op);
            }
            if (item instanceof variable){
                System.out.println("variable");
                subType = visitExpressionVariable((variable)item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof constant){
                subType = visitConstant((constant)item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof This){
                subType = visitThis(scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof type){
                subType = visitType((type)item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof dotVariableExpression){
                subType = visitDotVariableExpression((dotVariableExpression)item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof dotFunctionExpression){
                subType = visitDotFunctionExpression((dotFunctionExpression)item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof subscriptExpression){
                subType = visitSubsciptionExpression((subscriptExpression)item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof callFunctionExpression){
                subType = visitCallFunctionExpression((callFunctionExpression)item,scope);
                globalType = checkException(globalType,subType);
            }
        }
        if (op.op!=null){
            if (op.op.equals("+")){
                System.out.println("============================================================");
                System.out.println(globalType.typeName);
                if (!globalType.typeName.equals("String")&&!globalType.typeName.equals("Int")) throw new Exception("Expression type conflicts.");
            }
        }
        return globalType;
    }

    public type visitOp(Op op, Scope scope)throws Exception{
        type tmp = new type();
        if (op.op.equals("==")||op.op.equals("!=")||op.op.equals("<")||op.op.equals(">")||op.op.equals("&&")||op.op.equals("||")||op.op.equals("!")){
            tmp.typeName="Bool";
            return tmp;
        }
        if (op.op.equals("-")||op.op.equals("/")||op.op.equals("*")||op.op.equals("++")||op.op.equals("--")||op.op.equals("&")||op.op.equals("|")||op.op.equals("^")||op.op.equals("~")||op.op.equals("<<")||op.op.equals(">>")){
            tmp.typeName="Int";
            return tmp;
        }
        return tmp;
    }

    public type visitExpressionVariable(variable va, Scope scope)throws Exception{
        System.out.println(va.name);
        type tmp = new type();
        System.out.println(va.ty.typeName);
        if (va.ty.typeName!=null) {
            tmp = va.ty;
        }
        else{
            //System.out.println("be in else");
            Scope scopeTmp = scope;
            while (scopeTmp.scopleType!="top") {
                //System.out.println(scopeTmp.name);
                if (scopeTmp.variable.containsKey(va.name)){
                    tmp = scopeTmp.variable.get(va.name).ty;
                }
                scopeTmp = scopeTmp.scopeFather;
            }
            if (scopeTmp.variable.containsKey(va.name)){
                tmp = scopeTmp.variable.get(va.name).ty;
            }
        }
        return tmp;
    }

    public type visitConstant(constant con, Scope scope)throws Exception{
        type tmp = new type();
        tmp.typeName = con.type;
        System.out.println(tmp.typeName);
        return tmp;
    }

    public type visitThis(Scope scope)throws Exception{
        type tmp = new type();
        /*remain to be finished.*/
        return tmp;
    }

    public type visitType(type ty, Scope scope)throws Exception{
        type tmp = new type();
        tmp = ty;
        return tmp;
    }

    public type visitDotVariableExpression(dotVariableExpression dotVa, Scope scope)throws Exception{
        type tmp = new type();
        String fatherName = dotVa.father.name;
        String sonName = dotVa.son.name;
        Scope scopeTmp = scope;
        String className=null;
        while (scopeTmp.scopleType!="top") {
            if (scopeTmp.variable.containsKey(fatherName)){
                className = scopeTmp.variable.get(fatherName).ty.typeName;
            }
            scopeTmp = scopeTmp.scopeFather;
        }
        if (className!=null){
            if (!((topScope)scopeTmp).classes.containsKey(className)) throw new Exception("Class not found");
            else {
                if (!((topScope)scopeTmp).classes.get(className).variable.containsKey(sonName)) throw new Exception("In class, variety name not found");
                else {
                    tmp = ((topScope)scopeTmp).classes.get(className).variable.get(sonName).ty;
                    System.out.println(tmp.typeName);
                }
            }
        }
        else throw new Exception("variable not define");
        return tmp;
    }

    public type visitDotFunctionExpression(dotFunctionExpression dotFun, Scope scope)throws Exception{
        type tmp = new type();
        type ty = new type();
        System.out.println(dotFun.father.ty.typeName);
        System.out.println(dotFun.father.name);
        System.out.println(ty.arr);
        if (dotFun.father.ty.typeName!="String") {
            System.out.println("in if");
            ty = visitExpressionVariable(dotFun.father,scope);
        }
        if (ty.arr.isEmpty()) {
            if (dotFun.son.functionName=="size") throw new Exception("variable that is not a string uses size().");
            else {
                if (ty.typeName!="String"&&dotFun.father.ty.typeName!="String"){
                Scope scopeTmp = scope;
                while (scopeTmp.scopleType!="top") scopeTmp = scopeTmp.scopeFather;
                //scopeTmp = (topScope)scopeTmp;
                if (((topScope) scopeTmp).classes.containsKey(ty.typeName)){
                    functionScope func = new functionScope();
                    func = ((topScope) scopeTmp).classes.get(ty.typeName).function.get(dotFun.son.functionName);
                    tmp = func.returnType;
                    int num1 = dotFun.son.expressionSons.size();
                    int num2 = func.inputVariable.size();
                    if (num1!=num2) throw new Exception("function input size error");
                    if (num1!=0){
                        System.out.println(num1);
                        type variableType = new type();
                        //System.out.println(exp.functionName);
                        for (expression item : dotFun.son.expressionSons ){
                            variableType = visitExpression((expression) item,scope);
                            System.out.println(variableType.typeName);
                            if (!func.inputVariable.containsKey(variableType.typeName)){
                                System.out.println(variableType.typeName);
                                throw new Exception("function input variable type error.");
                            }
                        }

                    }
                }
                else throw new Exception("program does not contain the class required by this variable.");
            }
            else {
                    if (dotFun.son.functionName=="length"){
                        tmp.typeName = "Int";
                    }
                    if (dotFun.son.functionName=="subString"){
                        if (dotFun.son.expressionSons.size()==2){
                        if (visitExpression(dotFun.son.expressionSons.get(0),scope).typeName!="Int"||visitExpression(dotFun.son.expressionSons.get(1),scope).typeName!="Int"){
                            throw new Exception("For String function subString, input variable error.");
                        }
                        }
                        else throw new Exception("For String function subString, input variable error.");
                        tmp.typeName = "String";
                    }
                    if (dotFun.son.functionName=="parseInt"){
                        tmp.typeName = "Int";
                    }
                    if (dotFun.son.functionName=="ord"){
                        if (dotFun.son.expressionSons.size()==1&&dotFun.son.expressionSons.contains("Int")){}
                        else throw new Exception("For String inline function ord, input variable error.");
                        tmp.typeName = "Int";
                    }
                }
            }
        }
        else if (dotFun.son.functionName!="size") {
            System.out.println(dotFun.son.functionName);
            System.out.println(ty.arr);
            throw new Exception("an array uses function wrongly.");
        }
        return tmp;
    }

    public type visitSubsciptionExpression(subscriptExpression subExp, Scope scope)throws Exception{
        type tmp = new type();
        return tmp;
    }

    public type visitCallFunctionExpression(callFunctionExpression exp, Scope scope)throws Exception{
        type tmp = new type();
        type variableType = new type();
        Scope scopeTmp = scope;
        while (scopeTmp.scopleType!="top") scopeTmp = scopeTmp.scopeFather;
        if (scopeTmp.function.containsKey(exp.functionName)){
            tmp = scopeTmp.function.get(exp.functionName).returnType;
            int num1 = exp.expressionSons.size();
            int num2 = scopeTmp.function.get(exp.functionName).inputVariable.size();
            if (num1!=num2) throw new Exception("function input size error");
            if (num1!=0){
                System.out.println(num1);
                System.out.println(exp.functionName);
                for (expression item : exp.expressionSons ){
                    variableType = visitExpression((expression) item,scope);
                    System.out.println(variableType.typeName);
                    if (!scopeTmp.function.get(exp.functionName).inputVariable.containsKey(variableType.typeName)){
                        System.out.println(variableType.typeName);
                        throw new Exception("function input variable type error.");
                    }
                }

            }
        }
        else throw new Exception("call function does not exist.");
        return tmp;
    }

    public type checkException (type ty1,type ty2) throws Exception{
        type ty = new type();
        if (ty1.typeName==null) {ty1=ty2;ty=ty2;}
        else if (ty2.typeName!=null){
            System.out.println(ty1.typeName);
            System.out.println(ty2.typeName);
            System.out.println(ty1.arr.size());
            System.out.println(ty2.arr.size());
            if (!ty1.typeName.equals(ty2.typeName)||!ty1.arr.equals(ty2.arr)) throw new Exception("expression type conflict.");
            else ty=ty1;
        }
        return ty;
    }

    public void visitIf(ifStatement node, Scope scope) throws Exception{
        if (visitExpression(node.ifcondition,scope).typeName!="Bool") {
            //System.out.println(node.ifcondition.toString());
            throw new Exception("If condition is not bool.");
        }
        Scope ifScope = new Scope();
        ifScope.scopleType = "If";
        ifScope.scopeFather = scope;
        visitBlock(node.ifblock,ifScope,"If",true,null);
        Scope elseScope = new Scope();
        elseScope.scopleType = "If";
        elseScope.scopeFather = scope;
        visitBlock(node.elseblock,elseScope,"If",true,null);
    }

    public void visitFor(forStatement node, Scope scope) throws Exception{
        if (visitExpression(node.variableCondition,scope)!=null) throw new Exception("For condition is not bool.");
        Scope forScope = new Scope();
        forScope.scopleType = "For";
        forScope.scopeFather = scope;
        visitBlock(node.forBlock,forScope,"For",true,null);
    }

    public void visitWhile(whileStatement node,Scope scope) throws Exception{
        if (visitExpression(node.whileCondition,scope).typeName!="Bool") throw new Exception("While condition is not bool");
        Scope whileScope = new Scope();
        whileScope.scopleType = "While";
        whileScope.scopeFather = scope;
        visitBlock(node.whileBlock,whileScope,"While",true,null);
    }

}
