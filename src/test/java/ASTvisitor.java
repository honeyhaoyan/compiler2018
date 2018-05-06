
public class ASTvisitor {
    public void visit(Program node) throws Exception{
        topScope top = new topScope();
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
        }
    }
/*
    public type visitExpression (expression node, Scope scope) throws Exception{
        type tmp = new type();
        //type functionTy = new type();
        //functionTy = null;
        //System.out.println("visit expression.");
        System.out.println("============================================");
        System.out.println(node.sons.toString());
        System.out.println("============================================");

        for (Node item : node.sons){
            if (item instanceof expression){
                type subType = visitExpression((expression) item,scope);
                if (tmp.typeName==null) tmp = subType;
                else {
                    System.out.println(subType.typeName);
                    if ((!tmp.typeName.equals(subType.typeName))||(!tmp.arr.equals(subType.arr))) throw new Exception("Expression type conflict.");

                }
            }
            if (item instanceof Op){
                System.out.println("visit Op.");
                //System.out.println(((Op) item).op);
                //System.out.println(((Op) item).op.getClass());
                if (((Op) item).op.equals("==")||((Op) item).op.equals("!=")||((Op) item).op.equals("<")||((Op) item).op.equals(">")){
                    tmp.typeName="Bool";
                    //System.out.println("Be in if.");
                    return tmp;
                }
                //System.out.println("Before return.");
                //System.out.println(tmp.typeName);
                //return tmp;
            }
            if (item instanceof variable){
                //System.out.println(((variable) item).name);
                //type subType = scope.variable.get(((variable) item).name).ty;
                System.out.println("In variable");
                if (((variable) item).ty!=null) {
                    type subType = ((variable) item).ty;
                    System.out.println(((variable) item).name);
                    System.out.println(((variable) item).ty.typeName);
                    if (tmp.typeName == null) tmp = subType;
                    else {
                        if (!tmp.equals(subType)) throw new Exception("Expression type conflict.");
                    }
                }
            }
            if (item instanceof constant){
                System.out.println("visit constant");
                String subType = ((constant) item).type;
                if (tmp.typeName==null) {
                    tmp.typeName = subType;
                    //System.out.println(tmp.typeName);
                }
                else {
                    if (subType!=tmp.typeName) {
                        //System.out.println(tmp.typeName);
                        throw new Exception("Expression type conflict.");
                    }
                }
            }
            if (item instanceof This){

            }
            if (item instanceof type){

            }
            if (item instanceof dotVariableExpression){
                String fatherName = ((dotVariableExpression) item).father.name;
                String sonName = ((dotVariableExpression)item).son.name;
                Scope scopeTmp = scope;
                String className=null;
                while (scopeTmp.scopleType!="top") {
                    if (scopeTmp.variable.containsKey(fatherName)){
                        className = scopeTmp.variable.get(fatherName).ty.typeName;
                    }
                    //System.out.println(scopeTmp.name);
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
            }
            if (item instanceof dotFunctionExpression){
                //if (item.)
            }
            if (item instanceof subscriptExpression){

            }
            if (item instanceof callFunctionExpression){
                System.out.println("visit callFunctionExpression");
                type subType = visitCallFunctionExpression((callFunctionExpression) item,scope);
                if (tmp.typeName==null) tmp=subType;
                else {
                    if (tmp.typeName!=subType.typeName||!tmp.arr.equals(subType.arr)){
                        throw new Exception("In callFunction, expression type conflicts.");
                    }
                }
            }

        }
        //tmp = functionTy;
        System.out.println(tmp.typeName);
        return tmp;
    }

    public type visitCallFunctionExpression(callFunctionExpression exp,Scope scope) throws Exception{
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
*/

    public type visitExpression (expression node, Scope scope) throws Exception{
        type globalType = new type();
        type subType = new type();
        for (Node item : node.sons) {
            if (item instanceof expression){
                subType = visitExpression((expression) item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof Op){
                subType = visitOp((Op)item,scope);
                if (subType.typeName=="Bool") return subType;
                globalType = checkException(globalType,subType);
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
        return globalType;
    }

    public type visitOp(Op op, Scope scope)throws Exception{
        type tmp = new type();
        if (op.op.equals("==")||op.op.equals("!=")||op.op.equals("<")||op.op.equals(">")){
            tmp.typeName="Bool";
            return tmp;
        }
        return tmp;
    }

    public type visitExpressionVariable(variable va, Scope scope)throws Exception{
        //System.out.println(va.name);
        type tmp = new type();
        //System.out.println(va.ty.typeName);
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
        else{
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
