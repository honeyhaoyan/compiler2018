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
            if (item instanceof variable) {visitVariable((variable)item,top);}
            //visit statements in global function
            if (item instanceof functionDefinition) {
                visitFunction2((functionDefinition)item,top);
            }
            //visit statements in class function
            if (item instanceof classDefinition) {visitClass3((classDefinition)item,top);}
        }
    }

    public void visitClass1(classDefinition node, topScope scope) throws Exception{
        String className = node.selfName;
        checkIdentify(className);
        //System.out.println(className);
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
        checkIdentify(functionName);
        //System.out.println(functionName);
        if (scope.name.contains(functionName)) throw new Exception("FunctionName conflicts with names that have already existed.");
        else {
            functionScope tmp = new functionScope();
            if (node.isClassFunction==true){
                tmp.isClassFunction = true;
            }
            tmp.scopeFather = scope;
            //System.out.println(tmp.scopeFather.scopleType);
            tmp.functionName = functionName;
            tmp.name.add(tmp.functionName);
            tmp.returnType = node.returnType;
            if (!tmp.returnType.typeName.equals("Int")&&!tmp.returnType.typeName.equals("String")&&!tmp.returnType.typeName.equals("Void")&&!tmp.returnType.typeName.equals("Bool")){
                String returnName = tmp.returnType.typeName;
                Scope scopeTmp = scope;
                while (!scopeTmp.scopleType.equals("top")) scopeTmp = scopeTmp.scopeFather;
                scopeTmp = (topScope)scopeTmp;
                //System.out.println(returnName);
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
        if (scope.function.containsKey(node.functionName)){
            visitBlock(node.blockSon,scope.function.get(node.functionName),"Function",false,node.returnType);
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
            }
        }
    }


    //-------------------------------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------------------------------------



    //scope
    public void visitBlock(blockDefinition node, Scope scope,String blockType,boolean returnNum,type returnType) throws Exception{
        for (Node item : node.statementSons){
            if (item instanceof blockDefinition){
                Scope scopeBlock = new Scope();
                scopeBlock.scopeFather = scope;
                scopeBlock.scopleType = "Block";
                visitBlock((blockDefinition) item,scopeBlock,"Block",returnNum,returnType);
            }
            if (item instanceof assignmentStatement){
                visitAssignmentStatement((assignmentStatement) item,scope);
            }

            if (item instanceof definitionStatement){
                visitDefinitionStatement((definitionStatement)item,scope);
            }

            if (item instanceof ifStatement){
                visitIf((ifStatement)item,scope,returnNum);
            }

            if (item instanceof forStatement){
                visitFor((forStatement)item,scope,returnNum);
            }

            if (item instanceof whileStatement){
                visitWhile((whileStatement)item,scope,returnNum);
            }

            if (item instanceof breakStatement){
                visitBreakStatement((breakStatement)item,scope);
            }

            if (item instanceof returnStatement){
                if (returnNum == true){
                    throw new Exception("In function, more than one return.");
                }
                else {
                    returnNum = true;
                    Scope scopeTmp = scope;
                    while (!scopeTmp.scopleType.equals("Function")) scopeTmp = scopeTmp.scopeFather;
                    scopeTmp = (functionScope)scopeTmp;
                    type returnType2 = ((functionScope) scopeTmp).returnType;
                    String nameRequire = returnType2.typeName;
                    String nameProvide = visitExpression(((returnStatement) item).returnExpression,scope).typeName;
                    int numRequire = returnType2.arrExp.size();
                    int numProvide = visitExpression(((returnStatement) item).returnExpression,scope).arrExp.size();
                    if (!nameRequire.equals(nameProvide)||numRequire!=numProvide){
                        if (nameProvide==null||nameProvide.equals("NullConstant")){
                            if ((nameRequire.equals("Int")&&numRequire==0&&!((functionScope) scopeTmp).functionName.equals("main"))||nameRequire.equals("Bool")) throw new Exception("return type error");
                        }
                        else {
                            //throw new Exception("return type error");
                        }
                    }
                }
            }

            if (item instanceof continueStatement){
                visitContinueStatement((continueStatement)item,scope,blockType);
            }

            if (item instanceof newStatement){
                visitNewStatement((newStatement)item,scope);
            }

            if (item instanceof valuebleSingleStatement){
                visitValuebleSingleStatement((valuebleSingleStatement)item, scope);
            }
            if (item instanceof illegal&&scope.scopleType.equals("Function")) throw new Exception("illegal statement");
        }
    }



    public void visitAssignmentStatement(assignmentStatement item,Scope scope) throws Exception{
        if (((assignmentStatement) item).expLe.sons.get(0) instanceof constant) throw new Exception("constant left.");
        //if (item.expLe.sons.get(0) instanceof callFunctionExpression) throw new Exception("callFunction left");
        type ty1 = new type();
        type ty2 = new type();
        if (((assignmentStatement) item).expLe.sons.get(0) instanceof callFunctionExpression) throw new Exception("function name can not be left value");
        ty1 = visitExpression(((assignmentStatement) item).expLe,scope);
        ty2 = visitExpression(((assignmentStatement) item).expRi,scope);
        /*System.out.println(ty1.typeName);
        System.out.println(ty2.typeName);
        System.out.println(ty1.arrExp.size());
        System.out.println(ty2.arrExp.size());*/
        if (!ty1.typeName.equals(ty2.typeName)||ty1.arrExp.size()!=ty2.arrExp.size()) {
            if (ty2.typeName.equals("NullConstant")) {
                if (ty1.arrExp.size()!=0||((!ty1.typeName.equals("Int"))&&(!ty1.typeName.equals("String"))&&(!ty1.typeName.equals("Bool")))){ }
                else throw new Exception("Illegal assignment.");
            }
            else throw new Exception("Illegal assignment.");
        }
        if (item.expLe.sons.get(0) instanceof This) throw new Exception("this play as left value");
    }

    public void visitDefinitionStatement(definitionStatement item, Scope scope) throws Exception{
        variable va = new variable();
        if (visitExpression(((definitionStatement) item).exp,scope).typeName!=null){
            type ty = visitExpression(((definitionStatement) item).exp,scope);
        }
        va = ((definitionStatement) item).variableSon;
        type Ty = new type();
        Ty = visitExpressionVariable(va,scope);
        checkDefinition(va.name,scope);
        scope.variable.put(va.name,va);
        scope.name.add(va.name);
        if (va.ty.typeName.equals("Void")) throw new Exception("Definition error: void exception.");
        if (visitExpression(((definitionStatement) item).exp,scope).typeName!=null){
            type ty = visitExpression(((definitionStatement) item).exp,scope);
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

    }

    public void visitBreakStatement(breakStatement item, Scope scope) throws Exception{
        Scope scopeTmp = scope;
        while (!scopeTmp.scopleType.equals("top")){
            //System.out.println(scopeTmp.scopleType);
            if (scopeTmp.scopleType .equals( "Function")) throw new Exception("In function, illegal break");
            else {
                if (scopeTmp.scopleType .equals( "While")||scopeTmp.scopleType.equals("For")) break;
            }
            scopeTmp=scopeTmp.scopeFather;
        }
        if (scopeTmp.scopleType.equals("top")) throw new Exception("Illegal break");
    }

    public void visitContinueStatement(continueStatement item, Scope scope, String blockType) throws Exception{
        Scope scopeTmp = scope;
        while (!scopeTmp.scopleType.equals("top")){
            if (scopeTmp.scopleType .equals( "Function")) throw new Exception("In function, illegal continue");
            else {
                if (scopeTmp.scopleType .equals( "While")||scopeTmp.scopleType.equals("For")) {
                    return;
                }
            }
            scopeTmp=scopeTmp.scopeFather;
        }
        if (scopeTmp.scopleType.equals("top")) throw new Exception("Illegal continue");
    }

    public void visitNewStatement(newStatement item, Scope scope) throws Exception{
        type ty1 = ((newStatement) item).newType1;
        type ty2 = ((newStatement) item).newType2;

        /*System.out.println("------------------------------------new--------------------------------");
        System.out.println(ty1.typeName);
        System.out.println(ty2.typeName);
        System.out.println(ty1.arrExp.size());
        System.out.println(ty2.arrExp.size());
        System.out.println("-----------------------------------------------------------------------");*/
        for (expression exp:ty2.arrExp) visitExpression(exp,scope);
        if (ty2.typeName.equals("Void")) throw new Exception("new void");
        if (ty1.typeName==null){
            //System.out.println("find for ty1");
            if (item.name==null){
                ty1 = visitExpression(item.exp,scope);
                if (item.exp.sons.get(0) instanceof callFunctionExpression) throw new Exception("callFunction left");
            }
            //if ((!((newStatement) item).method.equals("subscript"))&&(!((newStatement) item).method.equals("dotVariable"))){
            else{
                variable va = new variable();
                va.name = ((newStatement) item).name;
                ty1 = visitExpressionVariable(va,scope);
            }
        }
        if (!ty1.typeName.equals(ty2.typeName)||ty1.arrExp.size()!=ty2.arrExp.size()){
            /*System.out.println(ty1.typeName);
            System.out.println(ty2.typeName);
            System.out.println(ty1.arrExp.size());
            System.out.println(ty2.arrExp.size());*/
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

    public void visitValuebleSingleStatement(valuebleSingleStatement item, Scope scope) throws Exception{
        visitExpression(item.exp,scope);
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
        //System.out.println(scope.scopleType);
        //System.out.println(node.ifblock.statementSons.size());
        //if (node.ifblock.statementSons.) throw new Exception("No if block;");
        visitBlock(node.ifblock,ifScope,"If",returnNum,null);
        Scope elseScope = new Scope();
        elseScope.scopleType = "If";
        elseScope.scopeFather = scope;
        visitBlock(node.elseblock,elseScope,"If",returnNum,null);
    }

    public void visitFor(forStatement node, Scope scope, boolean returnNum) throws Exception{
        //System.out.println("visit forStatement.");
        //System.out.println(node.ifEmptyCon);
        //System.out.println(visitExpression(node.variableCondition,scope).typeName);
        if (node.circleVariable instanceof assignmentStatement) visitAssignmentStatement((assignmentStatement) node.circleVariable,scope);
        if (node.circleVariable instanceof definitionStatement) visitDefinitionStatement((definitionStatement)node.circleVariable,scope);

        if (node.ifEmptyCon==false) if (!visitExpression(node.variableCondition,scope).typeName.equals("Bool"))
        {
            //throw new Exception("For condition is not bool.");
        }
        //visitExpression(node.variableCondition,scope)
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


    //----------------------------------------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------------------------------



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

        functionScope length = new functionScope();
        length.functionName = "length";
        length.returnType.typeName = "Int";
        length.scopeFather = scope;
        scope.function.put(length.functionName,length);

        functionScope substring = new functionScope();
        variable va4 = new variable();
        variable va5 = new variable();
        va4.ty.typeName="Int";
        va5.ty.typeName="Int";
        substring.inputVariable.add(va4.ty);
        substring.inputVariable.add(va5.ty);
        substring.functionName = "substring";
        substring.returnType.typeName = "String";
        substring.scopeFather = scope;
        scope.function.put(substring.functionName,substring);
        //System.out.println("::::::::::::::::::::::::::::::::"+scope.scopleType);

        functionScope parseInt = new functionScope();
        parseInt.functionName = "parseInt";
        parseInt.returnType.typeName = "Int";
        parseInt.scopeFather = scope;
        scope.function.put(parseInt.functionName,parseInt);

        functionScope ord = new functionScope();
        variable va6 = new variable();
        va6.ty.typeName="Int";
        ord.inputVariable.add(va6.ty);
        ord.functionName = "ord";
        ord.returnType.typeName = "Int";
        ord.scopeFather = scope;
        scope.function.put(ord.functionName,ord);

        functionScope size = new functionScope();
        size.functionName = "size";
        size.returnType.typeName = "Int";
        size.scopeFather = scope;
        scope.function.put(size.functionName,size);

        //functionScope
    }



    //---------------------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------------------------------


    public void checkDefinition(String name, Scope scope) throws Exception{
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
        //System.out.println(className);
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

    public functionScope findFunction(String functionName, Scope scope)throws Exception{
        functionScope func = new functionScope();
        Scope tmp = new Scope();
        tmp = scope;
        boolean flag = false;
        //System.out.println(tmp.scopleType);
        //scope = (classScope) scope;
        //System.out.println(((classScope) scope).className);
        while (!tmp.scopleType.equals("top")){
            //System.out.println(tmp.scopleType);
            //System.out.println(tmp.scopleType);
            //System.out.println(tmp);
            if (tmp.scopleType.equals("class")) {
                if (tmp.function.containsKey(functionName)) {func = tmp.function.get(functionName);flag=true;}
            }
            tmp = tmp.scopeFather;
            //System.out.println(tmp.scopleType);
        }
        //System.out.println(tmp.scopleType);
        if (flag == false){
            if (tmp.function.containsKey(functionName)){
                func = tmp.function.get(functionName);
                flag=true;
            }
        }
        //System.out.println(tmp.function.keySet());
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
        //System.out.println(num1);
        //System.out.println(num2);
        int i=0;
        if (num1!=0){ for (expression item : list){
            //System.out.println("still in????");
            variableType = visitExpression(item,scopeVa);
           /* System.out.println("-------------------------------------------");
            System.out.println(scope.functionName);
            System.out.println(scope.scopeFather.scopleType);
            System.out.println(variableType.typeName);
            System.out.println(i);
            System.out.println(scope.inputVariable.get(i).typeName);
            System.out.println("-------------------------------------------");*/
            if (!scope.inputVariable.get(i).typeName.equals(variableType.typeName)||scope.inputVariable.get(i).arrExp.size()!=variableType.arrExp.size()){
                if (variableType.typeName==null||variableType.typeName.equals("NullConstant")){
                    //System.out.println(scope.inputVariable.get(i).typeName);
                    type typeTest = visitExpressionVariable(createVariable(scope.inputVariable.get(i).typeName),scope);
                    if (typeTest.arrExp.size()==0){
                        //System.out.println("+++++++++++++"+typeTest.typeName);
                        //System.out.println(scope.inputVariable.get(i).typeName);
                        findClass(scope.inputVariable.get(i).typeName,scope);
                    }
                }
                else throw new Exception("input variable error.");
            }
            i++;
        }}
    }

    public type checkException (type ty1,type ty2) throws Exception{
        type ty = new type();
        if (ty1.typeName==null) {ty1=ty2;ty=ty2;}
        else {
            if (ty2.typeName!=null){
            if (!ty1.typeName.equals(ty2.typeName)||ty1.arrExp.size()!=ty2.arrExp.size()) throw new Exception("expression type conflict.");
            else ty=ty1;
            }
            else ty = ty1;
        }
        return ty;
    }

    public void checkType(type ty, String str)throws Exception{
        if (!ty.typeName.equals(str)||ty.arrExp.size()!=0) throw new Exception("type error") ;
    }

    public boolean checkConstantType(type ty) throws Exception{
        if (ty.typeName!=null) {
            if (ty.typeName.equals("Int")||ty.typeName.equals("Bool")||ty.typeName.equals("String")) return true;
            else return false;
        }
        else return false;
    }

    public void checkEqual(type ty1,type ty2) throws Exception{
        if (checkConstantType(ty1)){
            if (!ty2.typeName.equals(ty1.typeName)) {
                if ((ty2.typeName.equals("null")||ty2.typeName.equals("NullConstant"))&&ty1.arrExp.size()!=0){}
                else throw new Exception("== type error");
            }
            else {
                if (ty1.arrExp.size()!=ty2.arrExp.size()) throw new Exception("== type error");
            }
        }
        else{
            if (!ty2.typeName.equals(ty1.typeName)) {
                if (ty2.typeName.equals("null")||ty2.typeName.equals("NullConstant")){}
                else throw new Exception("== type error");
                //sadstory
            }
            else {
                if (ty1.arrExp.size()!=ty2.arrExp.size()) throw new Exception("== type error");
            }
        }
    }

    public classScope findClassScope(Scope scope)throws Exception{
        Scope scopeTmp = scope;
        while(!scopeTmp.scopleType.equals("class")&&!scopeTmp.scopleType.equals("top")) scopeTmp = scopeTmp.scopeFather;
        if (!scopeTmp.scopleType.equals("class")) throw new Exception("can not find class scope");
        return (classScope) scopeTmp;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------



    public type visitExpression (expression node, Scope scope) throws Exception{
        type globalType = new type();
        type subType = new type();
        Op op = new Op();
        for (Node item : node.sons) {
            if (item instanceof Op){
                item = (Op)item;
                if (((Op) item).op.equals("==")||((Op) item).op.equals("!=")||((Op) item).op.equals("<")||((Op) item).op.equals(">")||((Op) item).op.equals("<=")||((Op) item).op.equals(">=")){
                    type type1 = visitExpression((expression) node.sons.get(1),scope);
                    type type2 = visitExpression((expression)node.sons.get(2),scope);
                    checkEqual(type1,type2);
                    globalType.typeName = "Bool";
                    node.ty = globalType;
                    return globalType;
                }
                if (((Op) item).op.equals("!")){
                    globalType.typeName = "Bool";
                }
                if (((Op) item).op.equals("||")||((Op) item).op.equals("&&")){
                    globalType.typeName = "Bool";
                }
                if (((Op) item).op.equals("++")||((Op) item).op.equals("--")||((Op) item).op.equals("~")||((Op) item).op.equals("-")||((Op) item).op.equals("*")||((Op) item).op.equals("/")||((Op) item).op.equals("%")||((Op) item).op.equals("^")||((Op) item).op.equals("&")||((Op) item).op.equals("|")||((Op) item).op.equals("^")||((Op) item).op.equals("<<")||((Op) item).op.equals(">>")){
                    globalType.typeName = "Int";
                }
                if (((Op) item).op.equals(".")){
                    type type1 = visitExpression((expression) node.sons.get(1),scope);
                    type type2 = new type();
                    if (!checkConstantType(type1)) {
                        type2 = visitExpression((expression)node.sons.get(2),findClass(type1.typeName,scope));
                    }
                    else type2 = visitExpression((expression)node.sons.get(2),scope);
                    globalType = type2;
                    node.ty = globalType;
                    return globalType;
                }
                if (((Op) item).op.equals("[")){
                    type type1 = visitExpression((expression) node.sons.get(1),scope);
                    type type2 = visitExpression((expression)node.sons.get(2),scope);
                    if (node.sons.get(2) instanceof callFunctionExpression){
                        int t = 1;
                    }
                    //System.out.println(type1.typeName);
                    if (type1.typeName!=null) if (type1.arrExp.size()==0) throw new Exception("subscript error");
                    if (!type2.typeName.equals("Int")) throw new Exception("index error");
                    globalType.typeName = type1.typeName;
                    int i = 0;
                    for (expression it : type1.arrExp){
                        if (i==0) i=i+1;
                        else {
                            globalType.arrExp.add(it);i=i+1;
                        }
                    }
                    node.ty = globalType;
                    return globalType;
                }
                op.op = ((Op) item).op;
            }
            if (item instanceof variable){
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
            if (item instanceof callFunctionExpression){
                subType = visitCallFunctionExpression((callFunctionExpression)item,scope);
                globalType = checkException(globalType,subType);
            }
            if (item instanceof expression){
                subType = visitExpression((expression)item,scope);
                globalType = checkException(globalType,subType);
            }

        }
        if (op.op!=null){
            if (op.op.equals("+")){
                //System.out.println("============================================================");
                //System.out.println(globalType.typeName);
                if (globalType.typeName!=null) if (!globalType.typeName.equals("String")&&!globalType.typeName.equals("Int")) throw new Exception("Expression type conflicts.");
            }
        }
        node.ty = globalType;
        return globalType;
    }

   /* public type visitOp(Op op, Scope scope)throws Exception{
        type tmp = new type();
        if (op.op.equals("==")||op.op.equals("!=")||op.op.equals("<")||op.op.equals(">")||op.op.equals("!")||op.op.equals("<=")||op.op.equals(">=")){
            tmp.typeName="Bool";
            return tmp;
        }
        if (op.op.equals("-")||op.op.equals("/")||op.op.equals("*")||op.op.equals("++")||op.op.equals("--")||op.op.equals("&")||op.op.equals("|")||op.op.equals("^")||op.op.equals("~")||op.op.equals("<<")||op.op.equals(">>")){
            tmp.typeName="Int";
            return tmp;
        }
       // if (op.op.equals('.'))
        return tmp;
    }*/

    public type visitExpressionVariable(variable va, Scope scope)throws Exception{
        type tmp = new type();
        boolean flag = false;
        if (va.ty.typeName!=null) {
            tmp = va.ty;
        }
        else{
            Scope scopeTmp = scope;
            while (!scopeTmp.scopleType.equals("top")) {
                //System.out.println(scopeTmp.name);
                if (scopeTmp.variable.containsKey(va.name)){
                    tmp = scopeTmp.variable.get(va.name).ty;
                    flag = true;
                    if (tmp!=null && va.ty.typeName == null) va.ty = tmp;
                    return tmp;

                }
                scopeTmp = scopeTmp.scopeFather;
            }
            //System.out.println(scopeTmp.name);
            scopeTmp = (topScope)scopeTmp;
            if (scopeTmp.variable.containsKey(va.name)){
                //System.out.println(tmp.arrExp.size());
                tmp = scopeTmp.variable.get(va.name).ty;
                flag = true;
            }
            else if (((topScope) scopeTmp).classes.containsKey(va.name)){
                tmp.typeName = va.name;
            }
        }
        //if (flag==false) throw new Exception("variable no definition");
        if (tmp!=null && va.ty.typeName == null) va.ty = tmp;
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
        //scope = (classScope)scope;
        tmp.typeName = findClassScope(scope).className;
        /*remain to be finished.*/
        return tmp;
    }

    public type visitType(type ty, Scope scope)throws Exception{
        if (ty.typeName!=null) if (ty.typeName.equals("Void")) throw new Exception("new void");
        type tmp = new type();
        //if (ty.typeName.equals("newVoid")) throw new Exception("new void");
        tmp = ty;
        Scope scopeTmp = new Scope();
        scopeTmp = scope;
        while (!scopeTmp.scopleType.equals("top")) scopeTmp = scopeTmp.scopeFather;
        scopeTmp = (topScope)scopeTmp;
        /*
        if (ty.typeName!=null) if (!ty.typeName.equals("Int")&&!ty.typeName.equals("Bool")&&!ty.typeName.equals("String")){
            if (!((topScope) scopeTmp).classes.containsKey(ty.typeName)){
                subscriptExpression sub = new subscriptExpression();
                sub.father.name = ty.typeName;
                for (expression item : ty.arrExp){

                    sub.Son.add(item);
                        //sub.son.sons.add(item)
                }
                tmp = visitSubsciptionExpression(sub,scope);
            }
        }*/
        //System.out.println(tmp.typeName);
        return tmp;
    }
/*
    public type visitDotVariableExpression(dotVariableExpression dotVa, Scope scope)throws Exception{
        type tmp = new type();
        String father = dotVa.father;
        String son = dotVa.son;

        String fatherName="fathername";
        String sonName;

        classScope scopeTmp = new classScope();
        if (dotVa.father.equals("this")) {
            Scope scopeJump = new Scope();
            scopeJump = scope;
            while (!scopeJump.scopleType.equals("class")) scopeJump = scopeJump.scopeFather;
            scopeTmp = (classScope) scopeJump;
        }
        else{fatherName = getDotFatherVa(dotVa,scope);
            //System.out.println(fatherName);
            if (visitExpressionVariable(createVariable(fatherName),scope).typeName!=null){
                if (visitExpressionVariable(createVariable(fatherName),scope).typeName.equals("String")) scopeTmp = (classScope) scope;
                else scopeTmp = findClass(fatherName,scope);
            }
            else scopeTmp = findClass(fatherName,scope);

        }

        if (son.equals("dotVariableExpression")){
            System.out.println("-------------------------"+scopeTmp.className);
            sonName = getDotFatherVa((dotVariableExpression) dotVa.dotEx,scopeTmp);
            System.out.println(fatherName);
            System.out.println(sonName);
            System.out.println(scopeTmp.name);
            if (!scopeTmp.name.contains(sonName)&&!scopeTmp.className.equals(sonName)) throw new Exception("In class, variety name not found");
            tmp = visitDotVariableExpression((dotVariableExpression) dotVa.dotEx,scopeTmp);
        }
        if (son.equals("dotFunctionExpression")){
            System.out.println(fatherName);
            if (!visitExpressionVariable(createVariable(fatherName),scope).typeName.equals("String")){
                //System.out.println(sonName);
                sonName = getDotFatherFon((dotFunctionExpression) dotVa.dotEx,scopeTmp);
                System.out.println(sonName);
                if (!scopeTmp.variable.containsKey(sonName)) throw new Exception("In class, variety name not found");
            }
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
        System.out.println(father);
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

    public type visitDotFunctionExpression(dotFunctionExpression dotFun, Scope scope)throws Exception {
        //System.out.println("visitDotFunctionExpression");
            type tmp = new type();
            type ty = new type();
            classScope classes = new classScope();
            Scope scopeTmp = new Scope();
            if (dotFun.father.equals("className")) {
                ty = visitExpressionVariable(createVariable(dotFun.classNameF), scope);
                if (isArray(ty)) {
                    if (!dotFun.callFunS.functionName.equals("size"))
                        throw new Exception("An array has use dotfunction wrongly.");
                    tmp.typeName = "Int";
                } else {
                    if (ty.typeName.equals("String")) dotFun.father = "String";
                    else classes = findClass(dotFun.classNameF, scope);
                }
            }
            if (dotFun.father.equals("subscriptExpression")) {
                ty = visitSubsciptionExpression(dotFun.subscript, scope);
                if (!ty.typeName.equals("String")&&!ty.typeName.equals("Int")) classes = findClass(ty.typeName, scope);
                else {
                    scopeTmp = scope;
                    while (!scopeTmp.scopleType.equals("top")) scopeTmp = scopeTmp.scopeFather;
                    }
            }
            if (dotFun.father.equals("StringConstant") || dotFun.father.equals("String")) {
                //System.out.println("In?");
                //System.out.println(dotFun.callFunS.functionName);
                if (dotFun.callFunS.functionName.equals("length")) {
                    tmp.typeName = "Int";
                }
                if (dotFun.callFunS.functionName.equals("substring")) {
                    //System.out.println("In?");
                    if (dotFun.callFunS.expressionSons.size() == 2) {
                        if (!visitExpression(dotFun.callFunS.expressionSons.get(0), scope).typeName.equals("Int") || !visitExpression(dotFun.callFunS.expressionSons.get(1), scope).typeName.equals("Int")) {
                            throw new Exception("For String function subString, input variable error.");
                        }
                    } else throw new Exception("For String function subString, input variable error.");
                    tmp.typeName = "String";
                }
                if (dotFun.callFunS.functionName.equals("parseInt")) {
                    tmp.typeName = "Int";
                }
                if (dotFun.callFunS.functionName.equals("ord")) {
                    if (dotFun.callFunS.expressionSons.size() == 1 && visitExpression(dotFun.callFunS.expressionSons.get(0), scope).typeName.equals("Int") && visitExpression(dotFun.callFunS.expressionSons.get(0), scope).arrExp.size() == 0) {
                    } else throw new Exception("For String inline function ord, input variable error.");
                    tmp.typeName = "Int";
                }
                scopeTmp = scope;
                while (!scopeTmp.scopleType.equals("top")) scopeTmp = scopeTmp.scopeFather;

            }
            if (dotFun.father.equals("callFunctionExpression")) {
                ty = visitCallFunctionExpression(dotFun.callFunF, scope);
                if (ty.typeName.equals("String")) {
                    if (dotFun.callFunS.functionName.equals("length")) {
                        tmp.typeName = "Int";
                    }
                    if (dotFun.callFunS.functionName.equals("substring")) {
                        //System.out.println("In?");
                        if (dotFun.callFunS.expressionSons.size() == 2) {
                            if (!visitExpression(dotFun.callFunS.expressionSons.get(0), scope).typeName.equals("Int") || !visitExpression(dotFun.callFunS.expressionSons.get(1), scope).typeName.equals("Int")) {
                                throw new Exception("For String function subString, input variable error.");
                            }
                        } else throw new Exception("For String function subString, input variable error.");
                        tmp.typeName = "String";
                    }
                    if (dotFun.callFunS.functionName.equals("parseInt")) {
                        tmp.typeName = "Int";
                    }
                    if (dotFun.callFunS.functionName.equals("ord")) {
                        if (dotFun.callFunS.expressionSons.size() == 1 && visitExpression(dotFun.callFunS.expressionSons.get(0), scope).typeName.equals("Int") && visitExpression(dotFun.callFunS.expressionSons.get(0), scope).arrExp.size() == 0) {
                        } else throw new Exception("For String inline function ord, input variable error.");
                        tmp.typeName = "Int";
                    }
                }
                if (!ty.typeName.equals("String")) classes = findClass(ty.typeName, scope);
            }
            if (dotFun.father.equals("this")) {
                classes = (classScope) scope;
            }
            if (dotFun.son.equals("DotFunctionExpression")) {
                if (classes.className != null) tmp = visitDotFunctionExpression((dotFunctionExpression) dotFun.dotEx,classes);
                else if (scopeTmp.scopleType!=null) tmp = visitDotFunctionExpression((dotFunctionExpression) dotFun.dotEx,scopeTmp);
            }
            //System.out.println(classes.className);
            if (classes.className != null&&dotFun.son.equals("callFunctionExpression")) {
                if (!classes.function.containsKey(dotFun.callFunS.functionName))
                    throw new Exception("In class, no such function.");
                else
                    checkInputVariable(dotFun.callFunS.expressionSons, classes.function.get(dotFun.callFunS.functionName), scope);
                    tmp = classes.function.get(dotFun.callFunS.functionName).returnType;
            }
            else if (scopeTmp.scopleType != null&&dotFun.son.equals("callFunctionExpression")) {
               // System.out.println(dotFun.callFunS.functionName);
                if (!scopeTmp.function.containsKey(dotFun.callFunS.functionName))
                    throw new Exception("In top, no such function.");
                else
                    checkInputVariable(dotFun.callFunS.expressionSons, scopeTmp.function.get(dotFun.callFunS.functionName), scope);
                tmp = scopeTmp.function.get(dotFun.callFunS.functionName).returnType;
            }
            return tmp;
    }



    public type visitSubsciptionExpression(subscriptExpression subExp, Scope scope)throws Exception{
        System.out.println("visitSubsciptionExpression");
        type tmp = new type();
        type t = new type();
        if (subExp.father.name!=null) {
            System.out.println(subExp.father.name);
            variable va = new variable();
            va = subExp.father;
            //type t = new type();
            if (va.ty.arrExp.isEmpty()) {
                t = visitExpressionVariable(va, scope);
                if (t.arrExp.isEmpty()) throw new Exception("subscriptExpression error");
            }
        }
        else{
            //t = visitExpression(subExp.fatherExp,scope);
            t = subExp.typeFather;
            //System.out.println(t.typeName);
            //System.out.println(t.arrExp.size());
            if (t.arrExp.isEmpty()) throw new Exception("subscriptExpression error");
        }
        //if (!visitExpression(subExp.son,scope).typeName.equals("Int")) throw new Exception("subscriptExpression index error.");
        for (expression item : subExp.Son) {
            if (!visitExpression(item,scope).typeName.equals("Int")) throw new Exception("subscriptExpression index error.");
        }
        tmp.typeName = t.typeName;
        int num=subExp.Son.size();
        int i=0;
        for (expression item : t.arrExp){
            if (i>num-1) tmp.arrExp.add(t.arrExp.get(i));
            i++;
        }
        return tmp;
    }*/

    public type visitCallFunctionExpression(callFunctionExpression exp, Scope scope)throws Exception{
        type tmp = new type();
        functionScope func = new functionScope();
        func = findFunction(exp.functionName,scope);
        if (func.isClassFunction == true){
            exp.isClassFunction = true;
        }
        if (func.scopeFather.scopleType.equals("top")) checkInputVariable(exp.expressionSons,func,scope);
        tmp = func.returnType;
        exp.va.ty = tmp;
        return tmp;
    }





}
