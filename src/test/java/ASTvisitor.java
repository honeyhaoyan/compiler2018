
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
        if (scope.name.contains(functionName)) throw new Exception("FunctionName conflicts with names that have already existed.");
        else {
            functionScope tmp = new functionScope();
            tmp.scopeFather = scope;
            tmp.functionName = functionName;
            tmp.name.add(tmp.functionName);
            tmp.returnType = node.returnType;
            for (variable item : node.inputVariableSons){
                if (tmp.name.contains(item.name)) throw new Exception("In function, inputVariableName conflicts with names that have already existed.");
                else {
                    tmp.name.add(item.name);
                    tmp.inputVariable.put(item.name,item);
                }
            }
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
                ty1 =((assignmentStatement) item).variableLe.ty;
                ty2 = visitExpression(((assignmentStatement) item).exp,scope);
                if (ty1!=ty2) throw new Exception("Illegal assignment.");
            }

            if (item instanceof definitionStatement){
                variable va = new variable();
                va = ((definitionStatement) item).variableSon;
                scope.variable.put(va.name,va);
                scope.name.add(va.name);
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
                if (!ty1.equals(ty2)) throw new Exception("NewStatement type conflict.");
                variable va = new variable();
                va.ty=ty1;
                va.name = ((newStatement) item).name;
            }

            if (item instanceof selfOperationStatement){
                variable va = ((selfOperationStatement) item).va;
                if (va.ty.typeName!="Int") throw new Exception("Illegal selfOperation.");
            }
        }
    }

    public type visitExpression (expression node, Scope scope) throws Exception{
        type tmp = new type();
        type functionTy = new type();
        functionTy = null;
        for (Node item : node.sons){
            /*if (item instanceof Op){

            }*/
            if (item instanceof variable){
                type subType = scope.variable.get(((variable) item).name).ty;
                if (functionTy==null) functionTy = subType;
                else {
                    if (!functionTy.equals(subType)) throw new Exception("Expression type conflict.");
                }
            }
            if (item instanceof constant){
                String subType = ((constant) item).type;
                if (functionTy==null) functionTy.typeName = subType;
                else {
                    if (subType!=functionTy.typeName) throw new Exception("Expression type conflict.");
                }
            }
            /*if (item instanceof This){

            }*/
            /*if (item instanceof type){

            }*/
            if (item instanceof dotVariableExpression){
                String fatherName = ((dotVariableExpression) item).father.name;
                String sonName = ((dotVariableExpression)item).son.name;
                Scope scopeTmp = scope;
                while (scopeTmp.scopleType!="top") scopeTmp = scopeTmp.scopeFather;
                if (!((topScope)scopeTmp).classes.containsKey(scopeTmp)) throw new Exception("Class not found");
                else {
                    /*((topScope)scopeTmp).classes.*/
                }
            }/*
            if (item instanceof dotFunctionExpression){
                if (item.)
            }
            if (item instanceof subscriptExpression){

            }
            if (item instanceof callFunctionExpression){

            }*/
            if (item instanceof expression){
                type subType = visitExpression((expression) item,scope);
                if (functionTy==null) functionTy = subType;
                else {
                    if (!functionTy.equals(subType)) throw new Exception("Expression type conflict.");
                }
            }
        }
        return tmp;
    }

    public void visitIf(ifStatement node, Scope scope) throws Exception{
        if (visitExpression(node.ifcondition,scope).typeName!="Bool") throw new Exception("If condition is not bool.");
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
