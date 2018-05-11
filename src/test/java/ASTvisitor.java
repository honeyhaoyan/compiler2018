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
                //System.out.println(((functionDefinition) item).functionName);
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
                //System.out.println(((functionDefinition) item).functionName);
                visitFunction2((functionDefinition)item,top);
                //System.out.println(((functionDefinition) item).functionName);
            }
            //visit statements in class function
            if (item instanceof classDefinition) {visitClass3((classDefinition)item,top);}
        }
    }

    public void visitClass1(classDefinition node, topScope scope) throws Exception{
        String className = node.selfName;
        //System.out.println("before check");
        //System.out.println(className);
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
        System.out.println(functionName);
        if (scope.name.contains(functionName)) throw new Exception("FunctionName conflicts with names that have already existed.");
        else {
            functionScope tmp = new functionScope();
            tmp.scopeFather = scope;
            //System.out.println(tmp.scopeFather.scopleType);
            tmp.functionName = functionName;
            tmp.name.add(tmp.functionName);
            tmp.returnType = node.returnType;
            if (!tmp.returnType.typeName.equals("Int")&&!tmp.returnType.typeName.equals("String")&&!tmp.returnType.typeName.equals("Void")){
                String returnName = tmp.returnType.typeName;
                Scope scopeTmp = scope;
                while (!scopeTmp.scopleType.equals("top")) scopeTmp = scopeTmp.scopeFather;
                scopeTmp = (topScope)scopeTmp;
                System.out.println(returnName);
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
                //if (scope.classes.get(node.selfName).name.contains(item.functionName)) throw new Exception("In class, functionName conflicts with names that have already existed.");
                visitFunction1(item,scope.classes.get(node.selfName));
            }
        }
    }

    public void visitFunction2(functionDefinition node,Scope scope) throws Exception{
        System.out.println("-----------------------------------------------------------");
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
        //System.out.println("new block   "+returnNum);
        for (statement item : node.statementSons){
            //System.out.println(item.toString());
            if (item instanceof assignmentStatement){
                //System.out.println("*************************");
                //System.out.println("visit assignmentStatement");
                if (((assignmentStatement) item).expLe.sons.get(0) instanceof constant) throw new Exception("constant left.");
                type ty1 = new type();
                type ty2 = new type();
                ty1 = visitExpression(((assignmentStatement) item).expLe,scope);
                ty2 = visitExpression(((assignmentStatement) item).expRi,scope);
                //System.out.println("*************************");
                System.out.println(ty1.typeName);
                //System.out.println(ty2.typeName);
                if (!ty1.typeName.equals(ty2.typeName)||ty1.arrExp.size()!=ty2.arrExp.size()) {
                    if (ty2.typeName.equals("NullConstant")) {
                        if (ty1.arrExp.size()!=0||((!ty1.typeName.equals("Int"))&&(!ty1.typeName.equals("String"))&&(!ty1.typeName.equals("Bool")))){ }
                        else throw new Exception("Illegal assignment.");
                    }
                    else throw new Exception("Illegal assignment.");
                }
            }

            if (item instanceof definitionStatement){
                variable va = new variable();
                va = ((definitionStatement) item).variableSon;
                type Ty = new type();
                Ty = visitExpressionVariable(va,scope);
                checkDefinition(va.name,scope);
                scope.variable.put(va.name,va);
                scope.name.add(va.name);
                //System.out.println(scope.scopleType);
                //System.out.println(scope.name);
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
                    //type tyDefi = new type();
                    type ty = visitExpression(((definitionStatement) item).exp,scope);
                    //System.out.println(ty.typeName);
                    //System.out.println(ty.arr);
                    if (ty.typeName.equals("NullConstant")){
                        if (va.ty.typeName.equals("Int")||va.ty.typeName.equals("Bool")||va.ty.typeName.equals("String")||va.ty.typeName.equals("LogicConstant")){
                            throw new Exception("null to int or bool");
                        }
                    }
                    if (!Ty.typeName.equals(ty.typeName)||Ty.arrExp.size()!=ty.arrExp.size()) {
                        if (ty.typeName.equals("NullConstant")) {
                            if (Ty.arrExp.size()!=0||((!Ty.typeName.equals("Int"))&&(!Ty.typeName.equals("String"))&&(!Ty.typeName.equals("Bool")))){ }
                            else throw new Exception("In definition, assignment error.");
                        }
                        else throw new Exception("In definition, assignment error.");
                    }
                }
                //if (va.name.equals("n")) System.out.println(va.ty.typeName);
            }

            if (item instanceof ifStatement){
                //System.out.println("visit if statement.");
                visitIf((ifStatement)item,scope,returnNum);
            }

            if (item instanceof forStatement){
                //System.out.println("visit for statement.");
                visitFor((forStatement)item,scope,returnNum);
            }

            if (item instanceof whileStatement){
                //System.out.println("visit while statement.");
                visitWhile((whileStatement)item,scope,returnNum);
            }

            if (item instanceof breakStatement){
                Scope scopeTmp = scope;
                while (!scopeTmp.scopleType.equals("top")){
                    System.out.println(scopeTmp.scopleType);
                    if (scopeTmp.scopleType .equals( "Function")) throw new Exception("In function, illegal break");
                    else {
                        if (scopeTmp.scopleType .equals( "While")||blockType.equals("For")) break;
                    }
                    scopeTmp=scopeTmp.scopeFather;
                }
                if (scopeTmp.scopleType.equals("top")) throw new Exception("Illegal break");
            }

            if (item instanceof returnStatement){
                System.out.println("visit return statement.");
                //System.out.println(((functionScope) scope).functionName);
                if (returnNum == true){
                    throw new Exception("In function, more than one return.");
                }
                else {
                    returnNum = true;
                    Scope scopeTmp = scope;
                    while (!scopeTmp.scopleType.equals("Function")) scopeTmp = scopeTmp.scopeFather;
                    scopeTmp = (functionScope)scopeTmp;
                    type returnType2 = ((functionScope) scopeTmp).returnType;
                    System.out.println(((functionScope) scopeTmp).functionName);
                    System.out.println(visitExpression(((returnStatement) item).returnExpression,scope).typeName);
                    System.out.println(visitExpression(((returnStatement) item).returnExpression,scope).arrExp.size());
                    System.out.println(returnType2.typeName);
                    System.out.println(returnType2.arrExp.size());
                    String nameRequire = returnType2.typeName;
                    String nameProvide = visitExpression(((returnStatement) item).returnExpression,scope).typeName;
                    int numRequire = returnType2.arrExp.size();
                    int numProvide = visitExpression(((returnStatement) item).returnExpression,scope).arrExp.size();
                    /*
                    if (!returnType2.typeName.equals(visitExpression(((returnStatement) item).returnExpression,scope).typeName)||returnType2.arrExp.size()!=visitExpression(((returnStatement) item).returnExpression,scope).arrExp.size()){
                        if (!((functionScope) scopeTmp).functionName.equals("main")||) throw new Exception("return type error");
                    }*/
                    if (!nameRequire.equals(nameProvide)||numRequire!=numProvide){
                        if (nameProvide==null){
                            if (nameRequire.equals("Int")||nameRequire.equals("Bool")) throw new Exception("return type error");
                        }
                        else throw new Exception("return type error");
                    }
                }
            }

            if (item instanceof continueStatement){
                Scope scopeTmp = scope;
                while (!scopeTmp.scopleType.equals("top")){
                    if (scopeTmp.scopleType .equals( "Function")) throw new Exception("In function, illegal continue");
                    else {
                        if (scopeTmp.scopleType .equals( "While")||blockType.equals("For")) break;
                    }
                    scopeTmp=scopeTmp.scopeFather;
                }
                if (scopeTmp.scopleType.equals("top")) throw new Exception("Illegal continue");
            }

            if (item instanceof newStatement){
                type ty1 = ((newStatement) item).newType1;
                type ty2 = ((newStatement) item).newType2;

                //System.out.println("------------------------------------new--------------------------------");
                //System.out.println(ty1.typeName);
                //System.out.println(ty2.typeName);
                //System.out.println(ty1.arr);
                //System.out.println(ty2.arr);

                if (ty1.typeName==null){
                    if (((newStatement) item).method!=null){
                        if (((newStatement) item).method.equals("subscript")){
                            //System.out.println(((newStatement) item).method);
                            ty1 = visitSubsciptionExpression( ((newStatement) item).subscri,scope);
                            //ty1.arr.remove(0);
                        }
                        if (((newStatement) item).method.equals("dotVariable")){
                            ty1 = visitDotVariableExpression(((newStatement) item).dotVa,scope);
                        }
                    }
                    //if ((!((newStatement) item).method.equals("subscript"))&&(!((newStatement) item).method.equals("dotVariable"))){
                     else{
                        variable va = new variable();
                        va.name = ((newStatement) item).name;
                        ty1 = visitExpressionVariable(va,scope);
                    }
                }
                if (!ty1.typeName.equals(ty2.typeName)||ty1.arrExp.size()!=ty2.arrExp.size()){
                        //System.out.println(ty1.typeName);
                        //System.out.println(ty2.typeName);
                        //System.out.println(ty1.arr.size());
                        //System.out.println(ty2.arr.size());
                        if (ty1.arrExp.isEmpty()&&!ty2.arrExp.isEmpty()){
                            if (!ty1.typeName.equals("Int")&&!ty1.typeName.equals("Bool")&&!ty1.typeName.equals("String")&&!ty1.typeName.equals("NullConstant")){
                                Scope scopeTmp = scope;
                                while (!scopeTmp.scopleType.equals("top")) scopeTmp=scopeTmp.scopeFather;
                                scopeTmp = (topScope)scopeTmp;
                                if (!((topScope) scopeTmp).classes.containsKey(ty1.typeName)) throw new Exception("No such variable type.");
                            }
                        }
                        else throw new Exception("NewStatement type conflict.");
                    }
                //else throw new Exception("NewStatement type conflict.");
                if (!ty1.typeName.equals("Int")&&!ty1.typeName.equals("Bool")&&!ty1.typeName.equals("String")&&!ty1.typeName.equals("NullConstant")){
                    //System.out.println("On the way to find class");
                    findClass(ty1.typeName,scope);
                }
                if (((newStatement) item).name!=null){
                variable va = new variable();
                va.ty=ty2;
                va.name = ((newStatement) item).name;
                scope.name.add(va.name);
                scope.variable.put(va.name,va);}
            }

            if (item instanceof selfOperationStatement){
                type ty = new type();
                if (((selfOperationStatement) item).va.name!=null) {
                    variable va = ((selfOperationStatement) item).va;
                    ty = visitExpressionVariable(va,scope);
                }
                else{
                    if (((selfOperationStatement) item).exp!=null){
                        //System.out.println("in");
                        ty = visitDotVariableExpression( (dotVariableExpression)(((selfOperationStatement) item).exp),scope);
                    }
                }
                //System.out.println(((selfOperationStatement) item).va.name);
                //System.out.println(ty.typeName);
                //System.out.println(ty.arrExp.size());
                if (!(ty.typeName.equals("Int")&&ty.arrExp.size()==0)) throw new Exception("Illegal selfOperation.");
            }

            if (item instanceof callFunctionStatement){
                //System.out.println("-------------------------visit callFunctionStatement---------------------------");
                visitCallFunctionExpression(((callFunctionStatement) item).callFunc,scope);
            }

            if (item instanceof dotFunctionStatement){
                System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println(((functionScope) scope).functionName);
                visitExpression(((dotFunctionStatement) item).dotFunc,scope);
                System.out.println(((functionScope) scope).functionName);
            }
            /*
            if (item instanceof emptyStatement){
                System.out.println(scope.scopleType);
                throw new Exception("empty statement.");
            }*/
            //System.out.println(scope.name);

        }/*
        if (scope.scopleType.equals("Function")) {
            scope = (functionScope)scope;
            System.out.println(((functionScope) scope).functionName);
            if (returnNum==false&&!returnType.typeName.equals("Void")&&!((functionScope) scope).functionName.equals("main")) throw new Exception("No return");
        }*/
    }

    public void checkDefinition(String name, Scope scope) throws Exception{
        /*
        Scope scopeTmp = scope;
        while (!scopeTmp.scopleType.equals("top")) {
            if (scopeTmp.variable.containsKey(name)){
                throw new Exception("definition error.");
            }
            scopeTmp = scopeTmp.scopeFather;
        }
        if (scopeTmp.variable.containsKey(name)||scope.function.containsKey(name)){
            throw new Exception("definition error.");
        }*/
        if (scope.variable.containsKey(name)) throw new Exception("definition error.");
    }

    public void checkIdentify(String str) throws Exception{
        //System.out.println("check?");
        //System.out.println(str);
        if (str.equals("if")||str.equals("else")||str.equals("for")||str.equals("while")||str.equals("continue")||str.equals("break")||str.equals("return")||str.equals("class")||str.equals("new")||str.equals("this")||str.equals("true")||str.equals("false")||str.equals("bool")||str.equals("int")||str.equals("string")||str.equals("void")||str.equals("null")||str.equals("")){
            throw new Exception("name illegal");
        }
    }

    public classScope findClass(String className, Scope scope) throws Exception{
        Scope scopeTmp = new Scope();
        scopeTmp = scope;
        while (!scopeTmp.scopleType.equals("top")) {
            //System.out.println(scopeTmp.scopleType);
            scopeTmp = scopeTmp.scopeFather;
        }
        scopeTmp = (topScope)scopeTmp;
        //System.out.println(className);
        if (!((topScope) scopeTmp).classes.containsKey(className)) {
            type ty = new type();
            ty = visitExpressionVariable(createVariable(className),scope);
            //System.out.println(ty.typeName);
            //System.out.println(scope.scopleType);
            if (!((topScope) scopeTmp).classes.containsKey(ty.typeName)) throw new Exception("class not find.");
            return ((topScope) scopeTmp).classes.get(ty.typeName);
        }
        else return ((topScope) scopeTmp).classes.get(className);
    }

    public void  buildInlineFunctions(topScope scope){
        //variable va = new variable();

        functionScope print = new functionScope();
        variable va1 = new variable();
        va1.ty.typeName="String";
        print.inputVariable.add(va1.ty);
        print.functionName = "print";
        print.returnType.typeName = "void";
        print.scopeFather = scope;
        //System.out.println(print.inputVariable.get(0).typeName);
        scope.function.put(print.functionName,print);

        functionScope println = new functionScope();
        variable va2 = new variable();
        va2.ty.typeName="String";
        println.inputVariable.add(va2.ty);
        println.functionName = "println";
        println.returnType.typeName = "void";
        println.scopeFather = scope;
        scope.function.put(println.functionName,println);

        functionScope getString = new functionScope();
        getString.functionName = "getString";
        getString.returnType.typeName = "String";
        getString.scopeFather = scope;
        scope.function.put(getString.functionName,getString);

        functionScope getInt = new functionScope();
        getInt.functionName = "getInt";
        getInt.returnType.typeName = "Int";
        getInt.scopeFather = scope;
        scope.function.put(getInt.functionName,getInt);

        functionScope toString = new functionScope();
        variable va3 = new variable();
        va3.ty.typeName="Int";
        toString.inputVariable.add(va3.ty);
        toString.functionName = "toString";
        toString.returnType.typeName = "String";
        toString.scopeFather = scope;
        scope.function.put(toString.functionName,toString);

        //functionScope
    }

    public type visitExpression (expression node, Scope scope) throws Exception{
        //System.out.println("************************************");
        //System.out.println(node.toString());
        type globalType = new type();
        type subType = new type();
        Op op = new Op();
        for (Node item : node.sons) {
            if (item instanceof expression){
                //System.out.println("expression");
                subType = visitExpression((expression) item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof Op){
                subType = visitOp((Op)item,scope);
                if (subType.typeName!=null) if (subType.typeName.equals("Bool")) return subType;
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
                //System.out.println("type");
                subType = visitType((type)item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof dotVariableExpression){

                subType = visitDotVariableExpression((dotVariableExpression)item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof dotFunctionExpression){
                //System.out.println("************************************");
                subType = visitDotFunctionExpression((dotFunctionExpression)item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof subscriptExpression){
                //System.out.println("sub");
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
        //System.out.println("----------------------------------------");
        //System.out.println(va.name);
        type tmp = new type();
        //System.out.println(va.ty.typeName);
        if (va.ty.typeName!=null) {
            tmp = va.ty;
        }
        else{
            //System.out.println("be in else");
            Scope scopeTmp = scope;
            while (!scopeTmp.scopleType.equals("top")) {
                //System.out.println("-----------------??-----------------------");
                System.out.println(scopeTmp.name);
                //System.out.println(scopeTmp.scopleType);
                //System.out.println(scopeTmp.variable.isEmpty());
                if (scopeTmp.variable.containsKey(va.name)){
                    tmp = scopeTmp.variable.get(va.name).ty;
                    return tmp;
                    //System.out.println("----------------------------------------");
                    //System.out.println(tmp.typeName);
                }
                scopeTmp = scopeTmp.scopeFather;
                //System.out.println("in while");
            }
            //System.out.println("out while");
            //System.out.println(tmp.typeName);
            //System.out.println("-----------------??-----------------------");
            //System.out.println(scopeTmp.name);
            System.out.println(scopeTmp.name);
            if (scopeTmp.variable.containsKey(va.name)){
                System.out.println(tmp.arrExp.size());
                tmp = scopeTmp.variable.get(va.name).ty;
                //System.out.println(tmp.typeName);
            }
        }
        //System.out.println("=============================="+tmp.typeName+"===================================");
        //System.out.println("before return.");
        //System.out.println(tmp.typeName);
        //System.out.println("====================================================================");
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
        Scope scopeTmp = new Scope();
        scopeTmp = scope;
        while (!scopeTmp.scopleType.equals("top")) scopeTmp = scopeTmp.scopeFather;
        scopeTmp = (topScope)scopeTmp;
        if (!ty.typeName.equals("Int")&&!ty.typeName.equals("Bool")&&!ty.typeName.equals("String")){
            if (!((topScope) scopeTmp).classes.containsKey(ty.typeName)){
                subscriptExpression sub = new subscriptExpression();
                sub.father.name = ty.typeName;
                for (expression item : ty.arrExp){
                    /*
                    if (!Character.isDigit(item.charAt(0))) {
                        variable va = new variable();
                        va.name = item;
                        sub.son.addSon(va);
                    }
                    else {
                        constant con = new constant();
                        con.type = "Int";
                        con.value = item;
                        sub.son.addSon(con);
                    }
                    */
                    sub.Son.add(item);
                        //sub.son.sons.add(item)
                }
                tmp = visitSubsciptionExpression(sub,scope);
            }
        }
        System.out.println(tmp.typeName);
        return tmp;
    }

    public type visitDotVariableExpression(dotVariableExpression dotVa, Scope scope)throws Exception{
        /*
        type tmp = new type();
        String sonName="sonname";
        if (dotVa.son.sons.get(0) instanceof expression) {
            visitExpression((expression) dotVa.son.sons.get(0),scope);
            sonName = dotVa.son.sons.get(0).sons.get(0).toString();
            System.out.println("ppppppppppppppp"+sonName);
        }
        else {
            if (dotVa.son.sons.get(0)instanceof variable) {
                sonName = ((variable) dotVa.son.sons.get(0)).name;
                System.out.println("pppppppppppppppppp"+sonName);
            }
        }
        String fatherName="fathername";
        if (dotVa.father.name!=null){
            String Name = dotVa.father.name;
            variable va = new variable();
            va.name = Name;
            type t = new type();
            t = visitExpressionVariable(va,scope);
            fatherName = t.typeName;
            System.out.println(va.name);
           // classScope classes = findClass(fatherName,scope);

        }
        if (dotVa.subFather.father.name!=null){
            type ty = new type();
            ty = visitSubsciptionExpression(dotVa.subFather,scope);
            fatherName = ty.typeName;
        }
        classScope classes = findClass(fatherName,scope);
        System.out.println(sonName);
        if (!classes.variable.containsKey(sonName))throw new Exception("In class, variety name not found");
        else tmp = classes.variable.get(sonName).ty;
        return tmp;*/
        type tmp = new type();
        String father = dotVa.father;
        String son = dotVa.son;

        String fatherName;
        String sonName;
        //System.out.println("-------------------------");
        classScope scopeTmp = new classScope();
        if (dotVa.father.equals("this")) {
            Scope scopeJump = new Scope();
            scopeJump = scope;
            while (!scopeJump.scopleType.equals("class")) scopeJump = scopeJump.scopeFather;
            scopeTmp = (classScope) scopeJump;
        }
        else{fatherName = getDotFatherVa(dotVa,scope);
            scopeTmp = findClass(fatherName,scope);}

        if (son.equals("dotVariableExpression")){
            //System.out.println("-------------------------"+scopeTmp.className);
            sonName = getDotFatherVa((dotVariableExpression) dotVa.dotEx,scopeTmp);
            if (!scopeTmp.variable.containsKey(sonName)) throw new Exception("In class, variety name not found");
            tmp = visitDotVariableExpression((dotVariableExpression) dotVa.dotEx,scopeTmp);
        }
        if (son.equals("dotFunctionExpression")){
            sonName = getDotFatherFon((dotFunctionExpression) dotVa.dotEx,scopeTmp);
            if (!scopeTmp.variable.containsKey(sonName)) throw new Exception("In class, variety name not found");
            tmp = visitDotFunctionExpression((dotFunctionExpression) dotVa.dotEx,scopeTmp);
        }
        if (son.equals("className")){
            sonName = dotVa.classNameS;
            //System.out.println(sonName);
            if (!scopeTmp.variable.containsKey(sonName)) throw new Exception("In class, variety name not found");
            else tmp = scopeTmp.variable.get(sonName).ty;
        }
        return tmp;
    }

    public String getDotFatherVa(dotVariableExpression dotVa,Scope scope) throws Exception{
        type tmp = new type();
        String father = dotVa.father;
        String fatherName="fatherName";

        if (father.equals("className")){
            fatherName = dotVa.classNameF;
        }
        if (father.equals("subscriptExpression")){
            fatherName = visitSubsciptionExpression(dotVa.subscript,scope).typeName;
        }
        if (father.equals("callFunctionExpression")){
            fatherName = visitCallFunctionExpression(dotVa.callFun,scope).typeName;
        }
        return fatherName;
    }

    public String getDotFatherFon(dotFunctionExpression dotVa,Scope scope) throws Exception{
        type tmp = new type();
        String father = dotVa.father;
        String fatherName="fatherName";

        if (father.equals("className")){
            fatherName = dotVa.classNameF;
        }
        if (father.equals("subscriptExpression")){
            fatherName = visitSubsciptionExpression(dotVa.subscript,scope).typeName;
        }
        if (father.equals("callFunctionExpression")){
            fatherName = visitCallFunctionExpression(dotVa.callFunF,scope).typeName;
        }
        return fatherName;
    }

    public type visitDotFunctionExpression(dotFunctionExpression dotFun, Scope scope)throws Exception{
        type tmp = new type();
        /*
        type ty = new type();
        if(dotFun.father.name!=null){
            if (dotFun.father.ty.typeName!="String") {
                //System.out.println("in if");
                ty = visitExpressionVariable(dotFun.father,scope);
            }
        }
        if (dotFun.subFather.father.name!=null){
            ty = visitSubsciptionExpression(dotFun.subFather,scope);
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
        }*/
        //System.out.println(scope.scopleType);
        type ty = new type();
        classScope classes = new classScope();
        if (dotFun.father.equals("className")){
            ty = visitExpressionVariable(createVariable(dotFun.classNameF),scope);
            if (isArray(ty)){
                if (!dotFun.callFunS.functionName.equals("size")) throw new Exception("An array has use dotfunction wrongly.");
                tmp.typeName = "Int";
            }
            else {
                if (ty.typeName.equals("String")) dotFun.father = "String";
                else classes = findClass(dotFun.classNameF,scope);
            }
        }
        if (dotFun.father.equals("subscriptExpression")){
            ty = visitSubsciptionExpression(dotFun.subscript,scope);
            classes = findClass(ty.typeName,scope);
        }
        if (dotFun.father.equals("StringConstant")||dotFun.father.equals("String")){
            //System.out.println("In?");
            //System.out.println(dotFun.callFunS.functionName);
            if (dotFun.callFunS.functionName.equals("length")){
                tmp.typeName = "Int";
            }
            if (dotFun.callFunS.functionName.equals("substring")){
                //System.out.println("In?");
                if (dotFun.callFunS.expressionSons.size()==2){
                    if (!visitExpression(dotFun.callFunS.expressionSons.get(0),scope).typeName.equals("Int")||!visitExpression(dotFun.callFunS.expressionSons.get(1),scope).typeName.equals("Int")){
                        throw new Exception("For String function subString, input variable error.");
                    }
                }
                else throw new Exception("For String function subString, input variable error.");
                tmp.typeName = "String";
            }
            if (dotFun.callFunS.functionName.equals("parseInt")){
                tmp.typeName = "Int";
            }
            if (dotFun.callFunS.functionName.equals("ord")){
                if (dotFun.callFunS.expressionSons.size()==1&&visitExpression(dotFun.callFunS.expressionSons.get(0),scope).typeName.equals("Int")&&visitExpression(dotFun.callFunS.expressionSons.get(0),scope).arrExp.size()==0){}
                else throw new Exception("For String inline function ord, input variable error.");
                tmp.typeName = "Int";
            }
        }
        if (dotFun.father.equals("callFunctionExpression")){
            ty = visitCallFunctionExpression(dotFun.callFunF,scope);
            if (ty.typeName.equals("String")){
                if (dotFun.callFunS.functionName.equals("length")){
                    tmp.typeName = "Int";
                }
                if (dotFun.callFunS.functionName.equals("substring")){
                    //System.out.println("In?");
                    if (dotFun.callFunS.expressionSons.size()==2){
                        if (!visitExpression(dotFun.callFunS.expressionSons.get(0),scope).typeName.equals("Int")||!visitExpression(dotFun.callFunS.expressionSons.get(1),scope).typeName.equals("Int")){
                            throw new Exception("For String function subString, input variable error.");
                        }
                    }
                    else throw new Exception("For String function subString, input variable error.");
                    tmp.typeName = "String";
                }
                if (dotFun.callFunS.functionName.equals("parseInt")){
                    tmp.typeName = "Int";
                }
                if (dotFun.callFunS.functionName.equals("ord")){
                    if (dotFun.callFunS.expressionSons.size()==1&&visitExpression(dotFun.callFunS.expressionSons.get(0),scope).typeName.equals("Int")&&visitExpression(dotFun.callFunS.expressionSons.get(0),scope).arrExp.size()==0){}
                    else throw new Exception("For String inline function ord, input variable error.");
                    tmp.typeName = "Int";
                }
            }
            else classes = findClass(ty.typeName,scope);
        }
        if (dotFun.father.equals("this")){
            classes = (classScope)scope;
        }

        if (classes.className!=null){
            if (!classes.function.containsKey(dotFun.callFunS.functionName)) throw new Exception("In class, no such function.");
            else checkInputVariable(dotFun.callFunS.expressionSons,classes.function.get(dotFun.callFunS.functionName),scope);
            tmp = classes.function.get(dotFun.callFunS.functionName).returnType;
        }

        return tmp;
    }

    public boolean isPrimaryType(type ty) throws Exception{
        return (ty.typeName.equals("Bool")||ty.typeName.equals("Int")||ty.typeName.equals("String"));
    }

    public boolean isArray(type ty) throws Exception{
        return (ty.arrExp.size()>0);
    }

    public variable createVariable(String va) throws Exception{
        variable Va = new variable();
        Va.name = va;
        return Va;
    }

    public type visitSubsciptionExpression(subscriptExpression subExp, Scope scope)throws Exception{
        type tmp = new type();
        variable va = new variable();
        va = subExp.father;
        type t = new type();
        System.out.println(va.name);
        if (va.ty.arrExp.isEmpty()) {
            t = visitExpressionVariable(va,scope);
            System.out.println(t.typeName);
            if (t.arrExp.isEmpty()) throw new Exception("subscriptExpression error");
        }
        //if (!visitExpression(subExp.son,scope).typeName.equals("Int")) throw new Exception("subscriptExpression index error.");
        for (expression item : subExp.Son) {
            if (!visitExpression(item,scope).typeName.equals("Int")) throw new Exception("subscriptExpression index error.");
        }
        tmp.typeName = t.typeName;
        int i=0;
        for (expression item : t.arrExp){
            if (i!=0) tmp.arrExp.add(t.arrExp.get(i));
            i++;
        }
        return tmp;
    }

    public type visitCallFunctionExpression(callFunctionExpression exp, Scope scope)throws Exception{
        //System.out.println("visit CallFunctionExpression");
        type tmp = new type();
        functionScope func = new functionScope();
        //System.out.println(exp.functionName);
        //System.out.println(scope.name);
        func = findFunction(exp.functionName,scope);
        checkInputVariable(exp.expressionSons,func,scope);
        tmp = func.returnType;
        return tmp;
    }

    public functionScope findFunction(String functionName, Scope scope)throws Exception{
        functionScope func = new functionScope();
        Scope tmp = new Scope();
        tmp = scope;
        boolean flag = false;
        //System.out.println(tmp.scopleType);
        while (!tmp.scopleType.equals("top")){
            //System.out.println(tmp.scopleType);
            //System.out.println(tmp);
            if (tmp.scopleType.equals("class")) {
                if (tmp.function.containsKey(functionName)) {func = tmp.function.get(functionName);flag=true;}
            }
            tmp = tmp.scopeFather;
        }
        if (flag == false){
            if (tmp.function.containsKey(functionName)){func = tmp.function.get(functionName);flag=true;}
        }
        //System.out.println(functionName);
        if (flag == false) throw new Exception("No such function.");
        //System.out.println(func.functionName);
        return func;
    }

    public void checkInputVariable(List<expression> list, functionScope scope, Scope scopeVa) throws Exception{
        type variableType = new type();
        int num1 = list.size();
        int num2 = scope.inputVariable.size();
        if (num1!=num2) throw new Exception("input variable size error");
        int i=0;
        for (expression item : list){
            variableType = visitExpression(item,scopeVa);
            //System.out.println("-------------------------------------------");
            //System.out.println(scope.functionName);
            //System.out.println(scope.scopeFather.scopleType);
            //System.out.println(variableType.typeName);
            //System.out.println(i);
            //System.out.println(scope.inputVariable.get(i).typeName);
            //System.out.println("-------------------------------------------");
            if (!scope.inputVariable.get(i).typeName.equals(variableType.typeName)||scope.inputVariable.get(i).arrExp.size()!=variableType.arrExp.size()){
                if (variableType.typeName==null||variableType.typeName.equals("NullConstant")){
                    //System.out.println(scope.inputVariable.get(i).typeName);
                    type typeTest = visitExpressionVariable(createVariable(scope.inputVariable.get(i).typeName),scope);
                    if (typeTest.arrExp.size()==0){
                        //System.out.println("+++++++++++++"+typeTest.typeName);
                        findClass(scope.inputVariable.get(i).typeName,scope);
                    }
                }
                else throw new Exception("input variable error.");
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
            if (!ty1.typeName.equals(ty2.typeName)||ty1.arrExp.size()!=ty2.arrExp.size()) throw new Exception("expression type conflict.");
            else ty=ty1;
        }
        return ty;
    }

    public void visitIf(ifStatement node, Scope scope,boolean returnNum) throws Exception{
        //System.out.println("If");
        if (!visitExpression(node.ifcondition,scope).typeName.equals("Bool")) {
            //System.out.println(node.ifcondition.toString());
            /*
            System.out.println(node.ifcondition.sons.toString());
            if (node.ifcondition.toString()!="true"&&node.ifcondition.toString()!="false") throw new Exception("If condition is not bool.");
            */
            //System.out.println(node.ifcondition.sons.get(0));
            //if (node.ifcondition.sons.get(0).toString()!="true"&&node.ifcondition.sons.get(0).toString()!="false"){
            if (!visitExpression(node.ifcondition,scope).typeName.equals("Bool")){
                throw new Exception("If condition is not bool.");
            }
        }
        Scope ifScope = new Scope();
        ifScope.scopleType = "If";
        ifScope.scopeFather = scope;
        //System.out.println(node.ifblock.statementSons.size());
        if (node.ifblock.statementSons.isEmpty()) throw new Exception("No if block;");
        visitBlock(node.ifblock,ifScope,"If",returnNum,null);
        Scope elseScope = new Scope();
        elseScope.scopleType = "If";
        elseScope.scopeFather = scope;
        visitBlock(node.elseblock,elseScope,"If",returnNum,null);
    }

    public void visitFor(forStatement node, Scope scope, boolean returnNum) throws Exception{
        System.out.println("visit forStatement.");
        System.out.println(node.ifEmptyCon);
        //System.out.println(visitExpression(node.variableCondition,scope).typeName);
        if (node.ifEmptyCon==false) if (!visitExpression(node.variableCondition,scope).typeName.equals("Bool")) throw new Exception("For condition is not bool.");
        Scope forScope = new Scope();
        forScope.scopleType = "For";
        forScope.scopeFather = scope;
        if (node.ifEmptyBlock==false) visitBlock(node.forBlock,forScope,"For",returnNum,null);
    }

    public void visitWhile(whileStatement node,Scope scope,boolean returnNum) throws Exception{
        if (!visitExpression(node.whileCondition,scope).typeName.equals("Bool")) throw new Exception("While condition is not bool");
        Scope whileScope = new Scope();
        whileScope.scopleType = "While";
        whileScope.scopeFather = scope;
        visitBlock(node.whileBlock,whileScope,"While",returnNum,null);
    }

}
