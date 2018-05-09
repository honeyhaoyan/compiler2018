import java.util.List;

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
        boolean flag = false;
        for (Node item : node.sequenceSons){
            //get function name and function head
            if (item instanceof functionDefinition) {
                visitFunction1((functionDefinition)item,top);
                if (((functionDefinition) item).functionName.equals("main")) flag = true;
                System.out.println(((functionDefinition) item).functionName);
            }
            //get class variable definition (to be used in class functions) and class function definition
            if (item instanceof classDefinition) visitClass2((classDefinition)item,top);
        }
        if (flag==false) throw new Exception("no main.");
        for (Node item : node.sequenceSons){
            //visit global variable
           // System.out.println("??????????????????????????????????");
            if (item instanceof variable) {visitVariable((variable)item,top);}
            //visit statements in global function
            if (item instanceof functionDefinition) {
               // System.out.println("==============================visit function===================================");
                visitFunction2((functionDefinition)item,top);
                //System.out.println(((functionDefinition) item).functionName);
            }
            //visit statements in class function
            if (item instanceof classDefinition) {visitClass3((classDefinition)item,top);}
        }
    }

    public void visitClass1(classDefinition node, topScope scope) throws Exception{
        String className = node.selfName;
        System.out.println("before check");
        System.out.println(className);
        checkIdentify(className);
        //System.out.println(className);
        if (scope.name.contains(className)) throw new Exception("In program, classname conflicts with names that have already existed.");
        else{
            classScope tmp = new classScope();
            tmp.scopeFather = scope;
            tmp.className = className;
            scope.classes.put(className,tmp);
            scope.name.add(className);
            //scope.scopleType="class";
        }
    }

    public void visitFunction1(functionDefinition node, Scope scope) throws Exception{
        String functionName = node.functionName;
        checkIdentify(functionName);
        //System.out.println(functionName);
        if (scope.name.contains(functionName)) throw new Exception("FunctionName conflicts with names that have already existed.");
        else {
            functionScope tmp = new functionScope();
            tmp.scopeFather = scope;
            tmp.functionName = functionName;
            tmp.name.add(tmp.functionName);
            tmp.returnType = node.returnType;
            if (tmp.returnType.typeName!="Int"&&tmp.returnType.typeName!="String"&&tmp.returnType.typeName!="Void"){
                String returnName = tmp.returnType.typeName;
                Scope scopeTmp = scope;
                while (scopeTmp.scopleType!="top") scopeTmp = scopeTmp.scopeFather;
                scopeTmp = (topScope)scopeTmp;
                if (!((topScope) scopeTmp).classes.containsKey(returnName)) throw new Exception("return type error.");
            }
            //System.out.println(functionName);
            //System.out.println(tmp.returnType.typeName);
            if (functionName.equals("main")){
                //System.out.println("be in if");
                if (!tmp.returnType.typeName.equals("Int")) throw new Exception("main return error");
            }
            if (node.inputVariableSons!=null){
                int i=0;
                for (variable item : node.inputVariableSons){
                    //System.out.println(item.name);
                    if (tmp.name.contains(item.name)) throw new Exception("In function, inputVariableName conflicts with names that have already existed.");
                    else {
                        tmp.name.add(item.name);
                        //tmp.inputVariable.put(i,item.ty.typeName);
                        tmp.inputVariable.add(item.ty);
                        tmp.variable.put(item.name,item);
                        //System.out.println("--------------------------------------");
                        //System.out.println(item.ty.typeName);
                        //System.out.println(tmp.functionName);
                        i++;
                    }
                }
            //System.out.println(tmp.inputVariable.size());
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
        //System.out.println("-----------------------------------------------------------");
        if (scope.function.containsKey(node.functionName)){
            visitBlock(node.blockSon,scope.function.get(node.functionName),"Function",false,node.returnType);
        //System.out.println("WHAT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    public void visitVariable(variable node,Scope scope) throws Exception{
        checkIdentify(node.name);
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
                //System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            }
            //System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        }
    }

    //scope
    public void visitBlock(blockDefinition node, Scope scope,String blockType,boolean returnNum,type returnType) throws Exception{
        for (statement item : node.statementSons){
            //System.out.println(item.toString());
            if (item instanceof assignmentStatement){
                System.out.println("*************************");
                System.out.println("visit assignmentStatement");
                if (((assignmentStatement) item).expLe.sons.get(0) instanceof constant) throw new Exception("constant left.");
                type ty1 = new type();
                type ty2 = new type();
                ty1 = visitExpression(((assignmentStatement) item).expLe,scope);
                ty2 = visitExpression(((assignmentStatement) item).expRi,scope);
                //System.out.println("*************************");
                System.out.println(ty1.typeName);
                System.out.println(ty2.typeName);
                if (!ty1.typeName.equals(ty2.typeName)||ty1.arr.size()!=ty2.arr.size()) throw new Exception("Illegal assignment.");
            }

            if (item instanceof definitionStatement){
                variable va = new variable();
                va = ((definitionStatement) item).variableSon;
                type Ty = new type();
                System.out.println("before visit.");
                Ty = visitExpressionVariable(va,scope);
                System.out.println("after visit.");
                System.out.println("*************************");
                System.out.println(Ty.typeName);
                System.out.println(va.ty.typeName);
                //if (Ty.typeName!=null) throw new Exception("re definition.");
                checkDefinition(va.name,scope);
                scope.variable.put(va.name,va);
                scope.name.add(va.name);
                //System.out.println("*************************");
                //System.out.println("visit definitionStatement");
                //System.out.println(va.name);
                //System.out.println(va.ty.typeName);
                if (va.ty.typeName.equals("Void")) throw new Exception("Definition error: void exception.");
                //System.out.println(va.ty.typeName);
                //System.out.println("*************************");
                //System.out.println("visit definitionStatement");
                if (visitExpression(((definitionStatement) item).exp,scope).typeName!=null){
                    //System.out.println(((definitionStatement) item).exp.toString());
                    type ty = visitExpression(((definitionStatement) item).exp,scope);
                    //System.out.println(ty.typeName);
                    //System.out.println(ty.arr);
                    if (ty.typeName.equals("NullConstant")){
                        if (va.ty.typeName.equals("Int")||va.ty.typeName.equals("Bool")||va.ty.typeName.equals("String")||va.ty.typeName.equals("LogicConstant")){
                            throw new Exception("null to int or bool");
                        }
                    }
                }
                //if (va.name.equals("n")) System.out.println(va.ty.typeName);
            }

            if (item instanceof ifStatement){
                System.out.println("visit if statement.");
                visitIf((ifStatement)item,scope);
            }

            if (item instanceof forStatement){
                System.out.println("visit for statement.");
                visitFor((forStatement)item,scope);
            }

            if (item instanceof whileStatement){
                System.out.println("visit while statement.");
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
                System.out.println("visit return statement.");
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
                System.out.println("------------------------------------new--------------------------------");
                System.out.println(ty1.typeName);
                System.out.println(ty2.typeName);
                System.out.println(ty1.arr);
                System.out.println(ty2.arr);
                if (ty1.typeName==null){
                    variable va = new variable();
                    va.name = ((newStatement) item).name;
                    ty1 = visitExpressionVariable(va,scope);
                }
                if (!ty1.typeName.equals(ty2.typeName)||ty1.arr.size()!=ty2.arr.size()){
                        if (ty1.arr.isEmpty()&&!ty2.arr.isEmpty()){
                            if (ty1.typeName!="Int"&&ty1.typeName!="LogicConstant"&&ty1.typeName!="String"&&ty1.typeName!="NullConstant"){
                                Scope scopeTmp = scope;
                                while (scopeTmp.scopleType!="top") scopeTmp=scopeTmp.scopeFather;
                                scopeTmp = (topScope)scopeTmp;
                                if (!((topScope) scopeTmp).classes.containsKey(ty1.typeName)) throw new Exception("No such variable type.");
                            }
                        }
                        else throw new Exception("NewStatement type conflict.");
                    }
                //else throw new Exception("NewStatement type conflict.");
                if (ty1.typeName!="Int"&&ty1.typeName!="LogicConstant"&&ty1.typeName!="String"&&ty1.typeName!="NullConstant"){
                    //System.out.println("On the way to find class");
                    findClass(ty1.typeName,scope);
                }
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
                //System.out.println("-------------------------visit callFunctionStatement---------------------------");
                visitExpression(((callFunctionStatement) item).callFunc,scope);
            }

            if (item instanceof dotFunctionStatement){
                visitExpression(((dotFunctionStatement) item).dotFunc,scope);
            }

            if (item instanceof emptyStatement){
                throw new Exception("empty statement.");
            }
        }
    }

    public void checkDefinition(String name, Scope scope) throws Exception{
        Scope scopeTmp = scope;
        while (scopeTmp.scopleType!="top") {
            if (scopeTmp.name.contains(name)){
                throw new Exception("definition error.");
            }
            scopeTmp = scopeTmp.scopeFather;
        }
        if (scopeTmp.name.contains(name)){
            throw new Exception("definition error.");
        }
    }

    public void checkIdentify(String str) throws Exception{
        System.out.println("check?");
        System.out.println(str);
        if (str.equals("if")||str.equals("else")||str.equals("for")||str.equals("while")||str.equals("continue")||str.equals("break")||str.equals("return")||str.equals("class")||str.equals("new")||str.equals("this")||str.equals("true")||str.equals("false")||str.equals("bool")||str.equals("int")||str.equals("string")||str.equals("void")||str.equals("null")){
            throw new Exception("name illegal");
        }
    }

    public void findClass(String className, Scope scope) throws Exception{
        Scope scopeTmp = new Scope();
        scopeTmp = scope;
        while (!scopeTmp.scopleType.equals("top")) {
            //System.out.println(scopeTmp.scopleType);
            scopeTmp = scopeTmp.scopeFather;
        }
        scopeTmp = (topScope)scopeTmp;
        if (!((topScope) scopeTmp).classes.containsKey(className)) throw new Exception("class not find.");
    }

    public void  buildInlineFunctions(topScope scope){
        variable va = new variable();

        functionScope print = new functionScope();
        va.ty.typeName="String";
        print.inputVariable.add(va.ty);
        print.functionName = "print";
        print.returnType.typeName = "void";
        scope.function.put(print.functionName,print);

        functionScope println = new functionScope();
        va.ty.typeName="String";
        println.inputVariable.add(va.ty);
        println.functionName = "println";
        println.returnType.typeName = "void";
        scope.function.put(println.functionName,println);

        functionScope getString = new functionScope();
        getString.functionName = "getString";
        getString.returnType.typeName = "String";
        scope.function.put(getString.functionName,getString);

        functionScope getInt = new functionScope();
        getInt.functionName = "getInt";
        getInt.returnType.typeName = "Int";
        scope.function.put(getInt.functionName,getInt);

        functionScope toString = new functionScope();
        va.ty.typeName="Int";
        toString.inputVariable.add(va.ty);
        toString.functionName = "toString";
        toString.returnType.typeName = "String";
        scope.function.put(toString.functionName,toString);
    }

    public type visitExpression (expression node, Scope scope) throws Exception{
        //System.out.println("************************************");
        //System.out.println(node.toString());
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
                //System.out.println(op.op);
            }
            if (item instanceof variable){
                //System.out.println("--------------------------variable-----------------------------");
                //System.out.println(((variable) item).name);
                //System.out.println(((variable) item).ty.typeName);
                subType = visitExpressionVariable((variable)item,scope);
                //System.out.println(subType.typeName);
                globalType = checkException(globalType,subType);
                //System.out.println("After check.");
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
                //System.out.println("============================================================");
                //System.out.println(globalType.typeName);
                if (!globalType.typeName.equals("String")&&!globalType.typeName.equals("Int")) throw new Exception("Expression type conflicts.");
            }
        }
        return globalType;
    }

    public type visitOp(Op op, Scope scope)throws Exception{
        type tmp = new type();
        if (op.op.equals("==")||op.op.equals("!=")||op.op.equals("<")||op.op.equals(">")||op.op.equals("&&")||op.op.equals("||")||op.op.equals("!")||op.op.equals("<=")||op.op.equals(">=")){
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
        System.out.println("----------------------------------------");
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
                System.out.println("----------------------------------------");
                System.out.println(scopeTmp.name);
                System.out.println(scopeTmp.variable.isEmpty());
                if (scopeTmp.variable.containsKey(va.name)){
                    tmp = scopeTmp.variable.get(va.name).ty;
                    System.out.println("----------------------------------------");
                    System.out.println(tmp.typeName);
                }
                scopeTmp = scopeTmp.scopeFather;
                //System.out.println("in while");
            }
            //System.out.println("out while");
            System.out.println(tmp.typeName);
            if (scopeTmp.variable.containsKey(va.name)){
                tmp = scopeTmp.variable.get(va.name).ty;
                System.out.println(tmp.typeName);
            }
        }
        //System.out.println("before return.");
        System.out.println(tmp.typeName);
        return tmp;
    }

    public type visitConstant(constant con, Scope scope)throws Exception{
        type tmp = new type();
        tmp.typeName = con.type;
        //System.out.println(tmp.typeName);
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
        String sonName = "wrong";
        if (dotVa.son.sons.get(0) instanceof expression) {
            visitExpression((expression) dotVa.son.sons.get(0),scope);
            sonName = dotVa.son.sons.get(0).sons.get(0).toString();
        }
        else {
            if (dotVa.son.sons.get(0)instanceof variable) sonName = ((variable) dotVa.son.sons.get(0)).name;
        }
        //String sonName = dotVa.son.name;
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
                    //System.out.println(tmp.typeName);
                }
            }
        }
        else throw new Exception("variable not define");
        return tmp;
    }

    public type visitDotFunctionExpression(dotFunctionExpression dotFun, Scope scope)throws Exception{
        type tmp = new type();
        type ty = new type();
        //System.out.println(dotFun.father.ty.typeName);
        //System.out.println(dotFun.father.name);
        //System.out.println(ty.arr);
/*
        if (dotFun.son.sons.get(0) instanceof expression) visitExpression((expression)dotFun.son.sons.get(0),scope);
        else {callFunctionExpression call = new callFunctionExpression();
                call = (callFunctionExpression)dotFun.son.sons.get(0);}*/
        if (dotFun.father.ty.typeName!="String") {
            //System.out.println("in if");
            ty = visitExpressionVariable(dotFun.father,scope);
        }
        if (ty.arr.isEmpty()) {
            if (dotFun.son.functionName=="size") throw new Exception("variable that is not a string uses size().");
            else {
                if (ty.typeName!="String"&&dotFun.father.ty.typeName!="String"){
                    functionScope func = findFunction(dotFun.son.functionName,scope);
                    checkInputVariable(dotFun.son.expressionSons,func);
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
            //System.out.println(dotFun.son.functionName);
            //System.out.println(ty.arr);
            throw new Exception("an array uses function wrongly.");
        }
        return tmp;
    }

    public type visitSubsciptionExpression(subscriptExpression subExp, Scope scope)throws Exception{
        //System.out.println("visit subsciption.");
        type tmp = new type();
        variable va = new variable();
        va = subExp.father;
        //System.out.println(subExp.father.name);
        //System.out.println(va.name);
        //System.out.println(va.ty.typeName);
        if (va.ty.arr.isEmpty()) throw new Exception("subscriptExpression error");
        else {
            //tmp.typeName = va.ty.typeName;
            tmp = visitExpressionVariable(va,scope);
            if (tmp.arr.isEmpty()) throw new Exception("subscriptExpression error");
        }
        //System.out.println("----------------------------------");
        return tmp;
    }

    public type visitCallFunctionExpression(callFunctionExpression exp, Scope scope)throws Exception{
        /*
        type tmp = new type();
        type variableType = new type();
        Scope scopeTmp = scope;
        while (scopeTmp.scopleType!="top") scopeTmp = scopeTmp.scopeFather;
        System.out.println(exp.functionName);
        System.out.println(scopeTmp.function);
        System.out.println(exp.functionName);

        if (scopeTmp.function.containsKey(exp.functionName)){
            tmp = scopeTmp.function.get(exp.functionName).returnType;
            int num1 = exp.expressionSons.size();
            int num2 = scopeTmp.function.get(exp.functionName).inputVariable.size();
            System.out.println(num1);
            System.out.println(num2);
            if (num1!=num2) throw new Exception("function input size error");
            if (num1!=0){
                int i=0;
                for (expression item : exp.expressionSons ){
                    variableType = visitExpression((expression) item,scope);
                    System.out.println(item.toString());
                    //System.out.println(variableType.typeName);
                    if (!scopeTmp.function.get(exp.functionName).inputVariable.get(i).equals(variableType.typeName)){
                    //if (!scopeTmp.function.get(exp.functionName).inputVariable.containsKey(variableType.typeName)){
                        //System.out.println(variableType.typeName);
                        System.out.println(scopeTmp.function.get(exp.functionName).inputVariable.get(i));
                        System.out.println(variableType.typeName);
                        throw new Exception("function input variable type error.");
                    }
                    i++;
                }

            }
        }
        else throw new Exception("call function does not exist.");*/
        System.out.println("call Function");
        type tmp = new type();
        functionScope func = new functionScope();
        func = findFunction(exp.functionName,scope);
        System.out.println(exp.functionName);
        tmp = func.returnType;
        return tmp;
    }

    public functionScope findFunction(String functionName, Scope scope)throws Exception{
        functionScope func = new functionScope();
        Scope tmp = new Scope();
        tmp = scope;
        boolean flag = false;
        while (!tmp.scopleType.equals("top")){
            if (tmp.scopleType.equals("class")) {
                if (tmp.function.containsKey(functionName)) {func = tmp.function.get(functionName);flag=true;}
            }
            tmp = tmp.scopeFather;
        }
        if (flag == false){
            if (tmp.function.containsKey(functionName)){func = tmp.function.get(functionName);flag=true;}
        }
        if (flag == false) throw new Exception("No such function.");
        return func;
    }

    public void checkInputVariable(List<expression> list, functionScope scope) throws Exception{
        type variableType = new type();
        int num1 = list.size();
        int num2 = scope.inputVariable.size();
        if (num1!=num2) throw new Exception("input variable size error");
        int i=0;
        for (expression item : list){
            variableType = visitExpression(item,scope);
            if (!scope.inputVariable.get(i).typeName.equals(variableType.typeName)||scope.inputVariable.get(i).arr.size()!=variableType.arr.size()){
                throw new Exception("input variable error.");
            }
            i++;
        }
    }

    public type checkException (type ty1,type ty2) throws Exception{
        type ty = new type();
        if (ty1.typeName==null) {ty1=ty2;ty=ty2;}
        else if (ty2.typeName!=null){
            //System.out.println(ty1.typeName);
            //System.out.println(ty2.typeName);
            //System.out.println(ty1.arr.size());
            // System.out.println(ty2.arr.size());
            if (!ty1.typeName.equals(ty2.typeName)||!ty1.arr.equals(ty2.arr)) throw new Exception("expression type conflict.");
            else ty=ty1;
        }
        return ty;
    }

    public void visitIf(ifStatement node, Scope scope) throws Exception{
        if (visitExpression(node.ifcondition,scope).typeName!="Bool") {
            //System.out.println(node.ifcondition.toString());
            /*
            System.out.println(node.ifcondition.sons.toString());
            if (node.ifcondition.toString()!="true"&&node.ifcondition.toString()!="false") throw new Exception("If condition is not bool.");
            */
            //System.out.println(node.ifcondition.sons.get(0));
            //if (node.ifcondition.sons.get(0).toString()!="true"&&node.ifcondition.sons.get(0).toString()!="false"){
            if (visitExpression(node.ifcondition,scope).typeName!="LogicConstant"){
                throw new Exception("If condition is not bool.");
            }
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
        //System.out.println("visit forStatement.");
        //System.out.println(visitExpression(node.variableCondition,scope).typeName);
        if (!visitExpression(node.variableCondition,scope).typeName.equals("Bool")) throw new Exception("For condition is not bool.");
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
