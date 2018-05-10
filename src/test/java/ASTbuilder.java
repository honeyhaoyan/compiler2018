import org.antlr.v4.runtime.tree.*;


public class ASTbuilder extends MxBaseVisitor<Node> {
    @Override public Program visitProgram(MxParser.ProgramContext context) {
        Program tmp = new Program();
        System.out.println("new program");
        int i=0;
        for (ParseTree item : context.programItem()){
            if (context.programItem(i).classDefinition()!=null){
                System.out.println("program class");
                classDefinition classNode = (classDefinition) visit(item);
                tmp.classSons.add(classNode);
                tmp.sequenceSons.add(classNode);
            }
            if (context.programItem(i).functionDefinition()!=null){
                System.out.println("program function");
                functionDefinition functionNode = (functionDefinition) visit(item);
                tmp.functionSons.add(functionNode);
                tmp.sequenceSons.add(functionNode);
            }
            if (context.programItem(i).globalVariable()!=null){
                System.out.println("program global variable");
                variable globalVariableNode = new variable();
                if (context.programItem(i).globalVariable().definitionStatement()!=null){
                    definitionStatement defi = visitDefinitionStatement(context.programItem(i).globalVariable().definitionStatement());
                    globalVariableNode = defi.variableSon;
                }
                else if (context.programItem(i).globalVariable().newStatement()!=null){
                    newStatement newSta = visitNewStatement(context.programItem(i).globalVariable().newStatement());
                    globalVariableNode.name = newSta.name;
                    globalVariableNode.ty = newSta.newType2;
                }
                tmp.variableSons.add(globalVariableNode);
                tmp.sequenceSons.add(globalVariableNode);
            }
            i++;
        }
        return tmp;
    }

    @Override public classDefinition visitClassDefinition(MxParser.ClassDefinitionContext context) {
        classDefinition tmp = new classDefinition();
        String classname;
        classname=context.className().getText();
        tmp.selfName=classname;
        for (ParseTree item : context.classBody().definitionStatement()) {
            definitionStatement definitionNode = (definitionStatement) visit(item);
            tmp.variableSons.add(definitionNode);
        }
        for (ParseTree item : context.classBody().functionDefinition()){
            functionDefinition functionNode = (functionDefinition) visit(item);
            tmp.functionSons.add(functionNode);
        }
        return tmp;
    }

    @Override public functionDefinition visitFunctionDefinition(MxParser.FunctionDefinitionContext context){
        //System.out.println("visit functionDefinition");
        functionDefinition tmp = new functionDefinition();
        String functionName;
        functionName = context.functionName().getText();
        tmp.functionName=functionName;
        tmp.returnType=(type) visit(context.variableTypeExpression());
        if (context.definitionExpression()!=null){
            int i=0;
            while(context.definitionExpression(i)!=null){
                //variable inputNode = (variable)visit(item);
                variable inputNode = new variable();
                inputNode = visitDefinitionExpression(context.definitionExpression(i));
                tmp.inputVariableSons.add(inputNode);
                i++;
            }
        }
        tmp.blockSon=(blockDefinition)visit(context.blockStatement());
        return tmp;
    }

    @Override public variable visitDefinitionExpression(MxParser.DefinitionExpressionContext context){
        variable tmp = new variable();
        type t;
        String na;
        if (context.definitionNormalExpression()!=null){
            t = visitVariableNormalTypeExpression(context.definitionNormalExpression().variableNormalTypeExpression());
            na = context.definitionNormalExpression().Identifier().toString();
        }
        else {
            t = visitVariableArrayTypeExpression(context.definitionArrayExpression().variableArrayTypeExpression());
            na = context.definitionArrayExpression().Identifier().toString();
        }
        tmp.ty.typeName=t.typeName;
        for(String p : t.arr){
            tmp.ty.arr.add(p);
        }
        tmp.name=na;
        //System.out.println(na);
        return tmp;
    }


    @Override public definitionStatement visitDefinitionStatement(MxParser.DefinitionStatementContext context){
        //System.out.println("visit DefinitionStatement");
        //System.out.println(context.getText());
        definitionStatement tmp = new definitionStatement();
        type t;
        String na;
        if (context.definitionExpression().definitionNormalExpression()!=null){
            t = visitVariableNormalTypeExpression(context.definitionExpression().definitionNormalExpression().variableNormalTypeExpression());
            na = context.definitionExpression().definitionNormalExpression().Identifier().toString();
            if (context.definitionExpression().definitionNormalExpression().valuebleSingleExpression()!=null){
                //System.out.println("+++++++++++++++++++++++++++++++++  exp != null +++++++++++++++++++++++++++++++++");
                //System.out.println(na);
                tmp.exp = visitValuebleSingleExpression(context.definitionExpression().definitionNormalExpression().valuebleSingleExpression());
                //System.out.println(tmp.exp.toString());
            }
        }
        else {
            t = visitVariableArrayTypeExpression(context.definitionExpression().definitionArrayExpression().variableArrayTypeExpression());
            na = context.definitionExpression().definitionArrayExpression().Identifier().toString();
            //System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+na+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            //System.out.println(t.typeName);
        }
        tmp.variableSon.ty.typeName=t.typeName;
        //System.out.println(tmp.variableSon.ty.typeName);
        for(String p : t.arr){
            tmp.variableSon.ty.arr.add(p);
        }
        tmp.variableSon.name=na;
        //System.out.println(na);
        return tmp;
    }

    @Override public blockDefinition visitBlockStatement(MxParser.BlockStatementContext context) {
        //System.out.println("visit BlockStatement");
        blockDefinition tmp = new blockDefinition();
        int num = context.getChildCount();
        if (context.CloseCurly()!=null) num = num-2;
        for (int i=0;i<num;++i){
            if (context.statement(i).assignStatement()!=null){
                tmp.statementSons.add(visitAssignStatement(context.statement(i).assignStatement()));
            }
            if (context.statement(i).breakStatement()!=null){
                tmp.statementSons.add(visitBreakStatement(context.statement(i).breakStatement()));
            }
            if (context.statement(i).continueStatement()!=null){
                tmp.statementSons.add(visitContinueStatement(context.statement(i).continueStatement()));
            }
            if (context.statement(i).definitionStatement()!=null){
                tmp.statementSons.add(visitDefinitionStatement(context.statement(i).definitionStatement()));
            }
            if (context.statement(i).forStatement()!=null){
                tmp.statementSons.add(visitForStatement(context.statement(i).forStatement()));
            }
            if (context.statement(i).ifStatement()!=null){
                tmp.statementSons.add(visitIfStatement(context.statement(i).ifStatement()));
            }
            if (context.statement(i).newStatement()!=null){
                tmp.statementSons.add(visitNewStatement(context.statement(i).newStatement()));
            }
            if (context.statement(i).returnStatement()!=null){
                tmp.statementSons.add(visitReturnStatement(context.statement(i).returnStatement()));
            }
            if (context.statement(i).whileStatement()!=null){
                tmp.statementSons.add(visitWhileStatement(context.statement(i).whileStatement()));
            }
            if (context.statement(i).selfOperationStatement()!=null){
                tmp.statementSons.add(visitSelfOperationStatement(context.statement(i).selfOperationStatement()));
            }
            if (context.statement(i).callFunctionStatement()!=null){
                tmp.statementSons.add(visitCallFunctionStatement(context.statement(i).callFunctionStatement()));
            }

            if (context.statement(i).emptyStatement()!=null){
                tmp.statementSons.add(visitEmptyStatement(context.statement(i).emptyStatement()));
            }
        }
        return tmp;
    }

    @Override public newStatement visitNewStatement(MxParser.NewStatementContext context){
        newStatement tmp = new newStatement();
        if (context.Identifier()!=null) tmp.name=context.Identifier().getText();
        /*
        if (context.variableTypeExpression(0).variableArrayTypeExpression()!=null){
            System.out.println("===================================");
            //System.out.println(tmp.newType1.typeName);
            //System.out.println(tmp.newType2.typeName);
            tmp.newType1=(type)visit(context.variableTypeExpression(0).variableArrayTypeExpression());
            if (context.variableTypeExpression(1)!=null) tmp.newType2=(type)visit(context.variableTypeExpression(1).variableArrayTypeExpression());
            System.out.println(tmp.newType1.typeName);
            System.out.println(tmp.newType2.typeName);
        }
        else if (context.variableTypeExpression(0).variableNormalTypeExpression()!=null){
            //System.out.println("****************************************");
            //System.out.println(context.variableTypeExpression(0).variableNormalTypeExpression().Identifier().toString());
            tmp.newType1.typeName = context.variableTypeExpression(0).variableNormalTypeExpression().Identifier().toString();
            //tmp.newType2=(type)visit(context.variableTypeExpression(1).variableArrayTypeExpression());
            tmp.newType2.typeName = context.variableTypeExpression(1).variableNormalTypeExpression().Identifier().toString();
        }*/
        if (context.variableTypeExpression(1)!=null&&context.variableTypeExpression(0)!=null) {
            //System.out.println("--------------------------------- if --------------------------------");
            if (context.variableTypeExpression(1).variableNormalTypeExpression()!=null){
                tmp.newType2 = visitVariableNormalTypeExpression(context.variableTypeExpression(1).variableNormalTypeExpression());
            }
            if (context.variableTypeExpression(1).variableArrayTypeExpression()!=null){
                tmp.newType2 = visitVariableArrayTypeExpression(context.variableTypeExpression(1).variableArrayTypeExpression());
            }
            if (context.variableTypeExpression(0).variableNormalTypeExpression() != null) {
                tmp.newType1 = visitVariableNormalTypeExpression(context.variableTypeExpression(0).variableNormalTypeExpression());
            }
            if (context.variableTypeExpression(0).variableArrayTypeExpression() != null) {
                tmp.newType1 = visitVariableArrayTypeExpression(context.variableTypeExpression(0).variableArrayTypeExpression());
            }
            //System.out.println(tmp.newType1.typeName);
            //System.out.println(tmp.newType2.typeName);
        }
        else {
            //System.out.println("--------------------------------- else --------------------------------");
            if (context.subscriptExpression()!=null){
                tmp.subscri = visitSubscriptExpression(context.subscriptExpression());
                tmp.method = "subscript";
            }
            if (context.dotVariableExpression()!=null){
                tmp.dotVa = visitDotVariableExpression(context.dotVariableExpression());
                tmp.method = "dotVariable";
            }
            if (context.variableTypeExpression(0).variableNormalTypeExpression() != null) {
                tmp.newType2 = visitVariableNormalTypeExpression(context.variableTypeExpression(0).variableNormalTypeExpression());
            }
            if (context.variableTypeExpression(0).variableArrayTypeExpression() != null) {
                tmp.newType2 = visitVariableArrayTypeExpression(context.variableTypeExpression(0).variableArrayTypeExpression());
            }
        }
        return tmp;
    }

    @Override public assignmentStatement visitAssignStatement(MxParser.AssignStatementContext context) {
        //System.out.println("visit AssignStatement");
        assignmentStatement tmp = new assignmentStatement();
        /*
        tmp.exp = visitValuebleSingleExpression(context.assignExpression().valuebleSingleExpression(1));
        if (){
        tmp.variableLe.father = context.assignExpression().valuebleSingleExpression(0).dotExpression().dotVariableExpression().className(0).toString();
        tmp.variableLe.name = context.assignExpression().valuebleSingleExpression(0).dotExpression().dotVariableExpression().className(1).toString();}
        else {

        }*/
        tmp.expLe = visitValuebleSingleExpression(context.assignExpression().valuebleSingleExpression(0));
        tmp.expRi = visitValuebleSingleExpression(context.assignExpression().valuebleSingleExpression(1));
        return tmp;
    }

    /* Notice : it is rewritten for forStatement for(int i; i<=5; i=i+1)*/
    @Override public assignmentStatement visitAssignExpression(MxParser.AssignExpressionContext context) {
        assignmentStatement tmp = new assignmentStatement();
        tmp.expLe = visitValuebleSingleExpression(context.valuebleSingleExpression(0));
        tmp.expRi = visitValuebleSingleExpression(context.valuebleSingleExpression(1));
        return tmp;
    }

    @Override public ifStatement visitIfStatement(MxParser.IfStatementContext context) {
        //System.out.println("visit ifStatement");
        ifStatement tmp = new ifStatement();
        tmp.ifcondition=visitValuebleSingleExpression(context.valuebleSingleExpression());
        tmp.ifblock = visitBlockStatement(context.blockStatement(0));
        //System.out.println(context.blockStatement(0).getChildCount());
        if (context.blockStatement(1)!=null) tmp.elseblock = visitBlockStatement(context.blockStatement(1));
        return tmp;
    }

    @Override public forStatement visitForStatement(MxParser.ForStatementContext context) {
        //System.out.println("visit ForStatement");
        forStatement tmp = new forStatement();
        if (context.assignStatement()!=null){
            tmp.circleVariable = visitAssignStatement(context.assignStatement());
        }
        else {
            tmp.circleVariable = visitDefinitionStatement(context.definitionStatement());
        }
        tmp.variableCondition=visitValuebleSingleExpression(context.valuebleSingleExpression(0));
        if (context.valuebleSingleExpression(1)!=null){
            tmp.operateVariable=visitValuebleSingleExpression(context.valuebleSingleExpression(1));
        }
        else tmp.operateVariable=visitAssignExpression(context.assignExpression());
        tmp.forBlock=visitBlockStatement(context.blockStatement());
        return tmp;
    }

    @Override public whileStatement visitWhileStatement(MxParser.WhileStatementContext context) {
        //System.out.println("visit WhileStatement");
        whileStatement tmp = new whileStatement();
        tmp.whileCondition=visitValuebleSingleExpression(context.valuebleSingleExpression());
        tmp.whileBlock=visitBlockStatement(context.blockStatement());
        return tmp;
    }

    @Override public breakStatement visitBreakStatement(MxParser.BreakStatementContext context)  {
        //System.out.println("visit BreakStatement");
        breakStatement tmp = new breakStatement();
        return tmp;
    }

    @Override public returnStatement visitReturnStatement(MxParser.ReturnStatementContext context){
        //System.out.println("visit ReturnStatement");
        returnStatement tmp = new returnStatement();
        if (context.valuebleSingleExpression()!=null) tmp.returnExpression = visitValuebleSingleExpression(context.valuebleSingleExpression());
        //if (context.Identifier()!=null) tmp.returnExpression =
        return tmp;
    }

    @Override public continueStatement visitContinueStatement(MxParser.ContinueStatementContext context) {
        //System.out.println("visit ContinueStatement");
        continueStatement tmp = new continueStatement();
        return tmp;
    }

    @Override public selfOperationStatement visitSelfOperationStatement(MxParser.SelfOperationStatementContext context){
        selfOperationStatement tmp = new selfOperationStatement();
        Op op = new Op();
        if (context.Inc()!=null) op.op=context.Inc().toString();
        if (context.Dec()!=null) op.op=context.Dec().toString();
        if (context.Not()!=null) op.op=context.Not().toString();
        if (context.Lnot()!=null) op.op=context.Lnot().toString();
        tmp.op=op;
        //tmp.va.name=context.Identifier().toString();
        if (context.dotVariableExpression()!=null) tmp.exp = visitDotVariableExpression(context.dotVariableExpression());
        else if (context.Identifier()!=null){
            tmp.va.name=context.Identifier().toString();
        }
        return tmp;
    }

    @Override public callFunctionStatement visitCallFunctionStatement(MxParser.CallFunctionStatementContext context) {
        callFunctionStatement tmp = new callFunctionStatement();
        tmp.callFunc = visitCallFunctionExpression(context.callFunctionExpression());
        return tmp;
    }

    @Override public dotFunctionStatement visitDotFunctionStatement(MxParser.DotFunctionStatementContext context) {
        dotFunctionStatement tmp = new dotFunctionStatement();
        tmp.dotFunc = visitDotFunctionExpression(context.dotFunctionExpression());
        return tmp;
    }

    @Override public emptyStatement visitEmptyStatement(MxParser.EmptyStatementContext context){
        emptyStatement tmp = new emptyStatement();
        return tmp;
    }


    @Override public expression visitValuebleSingleExpression(MxParser.ValuebleSingleExpressionContext context){
        //System.out.println("visit ValuebleSingleExpression");
        //System.out.println(context.getText());
        expression tmp = new expression();
        if (context.constant()!=null) {
            //System.out.println("visit constant");
            //System.out.println(context.constant().getText());
            constant con = new constant();
            con=visitConstant(context.constant());
            tmp.addSon(con);
        }
        if (context.Inc()!=null||context.Dec()!=null||context.Not()!=null||context.Lnot()!=null){
            //System.out.println("visit op");
            Op op = new Op();
            if (context.Inc()!=null) op.op=context.Inc().toString();
            if (context.Dec()!=null) op.op=context.Dec().toString();
            if (context.Not()!=null) op.op=context.Not().toString();
            if (context.Lnot()!=null) op.op=context.Lnot().toString();
            tmp.addSon(op);
            //System.out.println("-----------------------------------------");
            //System.out.println(op.op);
            //System.out.println("-----------------------------------------");
        }
        if (context.Add()!=null||context.And()!=null||context.Div()!=null||context.Equal()!=null||context.Ge()!=null||context.Gt()!=null||context.Land()!=null||context.Le()!=null||context.Lor()!=null||context.Lshift()!=null||context.Lt()!=null||context.Mod()!=null||context.Mul()!=null||context.Or()!=null||context.Rshift()!=null||context.Notequal()!=null||context.Sub()!=null||context.Xor()!=null){
            //System.out.println("visit op");
            Op op = new Op();
            if (context.And()!=null) op.op=context.And().toString();
            if (context.Add()!=null) op.op=context.Add().toString();
            if (context.Div()!=null) op.op=context.Div().toString();
            if (context.Equal()!=null) op.op=context.Equal().toString();
            if (context.Ge()!=null) op.op=context.Ge().toString();
            if (context.Gt()!=null) op.op=context.Gt().toString();
            if (context.Land()!=null) op.op=context.Land().toString();
            if (context.Le()!=null) op.op=context.Le().toString();
            if (context.Lor()!=null) op.op=context.Lor().toString();
            if (context.Lshift()!=null) op.op=context.Lshift().toString();
            if (context.Lt()!=null) op.op=context.Lt().toString();
            if (context.Mod()!=null) op.op=context.Mod().toString();
            if (context.Mul()!=null) op.op=context.Mul().toString();
            if (context.Or()!=null) op.op=context.Or().toString();
            if (context.Rshift()!=null) op.op=context.Rshift().toString();
            if (context.Notequal()!=null) op.op=context.Notequal().toString();
            if (context.Sub()!=null) op.op=context.Sub().toString();
            if (context.Xor()!=null) op.op=context.Xor().toString();
            tmp.addSon(op);
            //System.out.println("-----------------------------------------");
            //System.out.println(op.op);
            //System.out.println("-----------------------------------------");
        }
        if (context.This()!=null){
            //System.out.println("visit this");
            This th = new This();
            tmp.addSon(th);
        }
        if (context.variableTypeExpression()!=null){
            type t = new type();
            t = visitVariableTypeExpression(context.variableTypeExpression());
            tmp.addSon(t);
        }
        if (context.dotExpression()!=null){
            if (context.dotExpression().dotVariableExpression()!=null){
                //System.out.println("*******************************************************");
                //System.out.println("visit dot expression");
                //System.out.println(context.dotExpression().dotVariableExpression().className(0).Identifier().toString());
                dotVariableExpression dotVa = new dotVariableExpression();
                dotVa = visitDotVariableExpression(context.dotExpression().dotVariableExpression());
                //System.out.println(dotVa.father.name);
                //System.out.println(dotVa.son.name);
                tmp.addSon(dotVa);
            }
            else {
                dotFunctionExpression dotFun = new dotFunctionExpression();
                dotFun = visitDotFunctionExpression(context.dotExpression().dotFunctionExpression());
                tmp.addSon(dotFun);
            }
        }
        if (context.subscriptExpression()!=null){
            subscriptExpression exp = new subscriptExpression();
            exp=visitSubscriptExpression(context.subscriptExpression());
            tmp.addSon(exp);
        }
        if (context.valuebleSingleExpression(0)!=null){
            expression exp = new expression();
            exp = visitValuebleSingleExpression(context.valuebleSingleExpression(0));
            tmp.addSon(exp);
        }
        if (context.valuebleSingleExpression(1)!=null){
            expression exp = new expression();
            exp = visitValuebleSingleExpression(context.valuebleSingleExpression(1));
            tmp.addSon(exp);
        }
        if (context.Identifier()!=null){
            variable va = new variable();
            va.name=context.Identifier().toString();
            tmp.addSon(va);
        }
        if (context.callFunctionExpression()!=null){
            //System.out.println("--------------------------build callFunctionExpression----------------------------");
            callFunctionExpression callFunc = new callFunctionExpression();
            callFunc = visitCallFunctionExpression(context.callFunctionExpression());
            tmp.addSon(callFunc);
        }
        return tmp;
    }

    @Override public subscriptExpression visitSubscriptExpression(MxParser.SubscriptExpressionContext context) {
        subscriptExpression tmp = new subscriptExpression();
        //tmp.father=(variable)visit(context.className());
        //System.out.println(context.className().Identifier().toString());
        tmp.father.name = context.className().Identifier().toString();
        //System.out.println("visit build subscript.");
        //System.out.println(tmp.father.name);
        tmp.son=(expression) visit(context.valuebleSingleExpression());
        return tmp;
    }

    @Override public dotVariableExpression visitDotVariableExpression(MxParser.DotVariableExpressionContext context) {
        dotVariableExpression tmp = new dotVariableExpression();
        /*
        if (context.className(0)!=null) tmp.father.name = context.className(0).Identifier().toString();
        if (context.subscriptExpression()!=null) tmp.subFather = visitSubscriptExpression(context.subscriptExpression());
        //System.out.println(context.className(0).Identifier().toString());
        //tmp.son.name = context.className(1).Identifier().toString();
        //System.out.println(context.className(1).Identifier().toString());
        tmp.son = visitValuebleSingleExpression(context.valuebleSingleExpression());
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(tmp.son.sons.toString());*/
        if (context.dotExpression()!=null){
            //tmp.son = "dotExpression";
            if (context.dotExpression().dotVariableExpression()!=null){
                tmp.son = "dotVariableExpression";
                tmp.dotEx = visitDotVariableExpression(context.dotExpression().dotVariableExpression());
            }
            if (context.dotExpression().dotFunctionExpression()!=null){
                tmp.son = "dotFunctionExpression";
                tmp.dotEx = visitDotFunctionExpression(context.dotExpression().dotFunctionExpression());
            }
            if (context.className(0)!=null){
                tmp.father = "className";
                tmp.classNameF = context.className(0).Identifier().toString();
            }
            if (context.subscriptExpression()!=null){
                tmp.father = "subscriptExpression";
                tmp.subscript = visitSubscriptExpression(context.subscriptExpression());
            }
            if (context.callFunctionExpression()!=null){
                tmp.father = "callFunctionExpression";
                tmp.callFun = visitCallFunctionExpression(context.callFunctionExpression());
            }
        }
        else{
            tmp.son = "className";
            if (context.subscriptExpression()!=null){
                tmp.father = "subscriptExpression";
                tmp.subscript = visitSubscriptExpression(context.subscriptExpression());
                tmp.classNameS = context.className(0).Identifier().toString();
            }
            if (context.callFunctionExpression()!=null){
                tmp.father = "callFunctionExpression";
                tmp.callFun=visitCallFunctionExpression(context.callFunctionExpression());
                tmp.classNameS = context.className(0).Identifier().toString();
            }
            if (context.callFunctionExpression()==null&&context.subscriptExpression()==null){
                tmp.father = "className";
                tmp.classNameF = context.className(0).Identifier().toString();
                tmp.classNameS = context.className(1).Identifier().toString();
            }
            //System.out.println(tmp.classNameS);
        }
        return tmp;
    }

    @Override public dotFunctionExpression visitDotFunctionExpression(MxParser.DotFunctionExpressionContext context) {
        //System.out.println("visit DotFunctionExpression");
        dotFunctionExpression tmp = new dotFunctionExpression();
        /*
        if (context.className()!=null) tmp.father.name = context.className().toString();
        if (context.StringConstant()!=null) tmp.father.ty.typeName="String";
        if (context.subscriptExpression()!=null) tmp.subFather = visitSubscriptExpression(context.subscriptExpression());
        tmp.son = visitCallFunctionExpression(context.callFunctionExpression());
        //tmp.son = visitValuebleSingleExpression(context.valuebleSingleExpression());*/
        if (context.className()!=null){
            tmp.father = "className";
            tmp.classNameF = context.className().Identifier().toString();
            tmp.callFunS = visitCallFunctionExpression(context.callFunctionExpression(0));
        }
        if (context.subscriptExpression()!=null){
            tmp.father = "subscriptExpression";
            tmp.subscript = visitSubscriptExpression(context.subscriptExpression());
            tmp.callFunS = visitCallFunctionExpression(context.callFunctionExpression(0));
        }
        if (context.StringConstant()!=null){
            tmp.father  = "StringConstant";
            tmp.constantStr = context.StringConstant().toString();
            tmp.callFunS = visitCallFunctionExpression(context.callFunctionExpression(0));
        }
        if (context.callFunctionExpression(1)!=null){
            tmp.father = "callFunctionExpression";
            tmp.callFunF = visitCallFunctionExpression(context.callFunctionExpression(0));
            tmp.callFunS = visitCallFunctionExpression(context.callFunctionExpression(1));
        }

        return tmp;
    }

    @Override public callFunctionExpression visitCallFunctionExpression(MxParser.CallFunctionExpressionContext context) {
        callFunctionExpression tmp = new callFunctionExpression();
        tmp.functionName = context.Identifier().toString();
        int i=0;
        if (context.valuebleListExpression()!=null){
        for (ParseTree item : context.valuebleListExpression().valuebleSingleExpression()){
            expression exp = new expression();
            exp = visitValuebleSingleExpression(context.valuebleListExpression().valuebleSingleExpression(i));
            tmp.expressionSons.add(exp);
            i++;
        }}
        else if (context.valuebleSingleExpression()!=null) {
            expression exp = new expression();
            exp = visitValuebleSingleExpression(context.valuebleSingleExpression());
            tmp.expressionSons.add(exp);
        }
        return tmp;
    }

    @Override public Node visitValuebleListExpression(MxParser.ValuebleListExpressionContext context) {
        Node tmp = new Node();
        for (ParseTree item : context.children){
            tmp.addSon((Node)item);
        }
        return tmp;
    }

    @Override public constant visitConstant(MxParser.ConstantContext context) {
        //System.out.println("visit Constant");
        constant con = new constant();
        if(context.IntegerConstant()!=null){
            con.type="Int";
            con.value=context.IntegerConstant().toString();
        }
        if(context.LogicConstant()!=null){
            con.type="LogicConstant";
            con.value=context.LogicConstant().toString();
        }
        if(context.StringConstant()!=null){
           // System.out.println("be in string");
            con.type="String";
            con.value=context.StringConstant().toString();
        }
        if(context.NullConstant()!=null){
            //System.out.println("visit NullConstant");
            con.type="NullConstant";
        }
        return con;
    }

    @Override public type visitVariableTypeExpression(MxParser.VariableTypeExpressionContext context){
        //System.out.println("visit VariableTypeExpression");
        type t = new type();
        if (context.variableNormalTypeExpression()!=null){
            t = visitVariableNormalTypeExpression(context.variableNormalTypeExpression());
        }
        if (context.variableArrayTypeExpression()!=null){
            t = visitVariableArrayTypeExpression(context.variableArrayTypeExpression());
        }
        return t;
    }

    @Override public type visitVariableNormalTypeExpression(MxParser.VariableNormalTypeExpressionContext context) {
        //System.out.println("visit VariableNormalTypeExpression");
        type t = new type();
        if (context.Identifier()!=null){
            t.typeName=context.Identifier().toString();
        }
        if (context.primaryType()!=null){
            if (context.primaryType().Bool() != null) {
                t.typeName = "Bool";
            }
            if (context.primaryType().Int() != null) {
                t.typeName = "Int";
            }
            if (context.primaryType().String() != null) {
                t.typeName = "String";
            }
            if (context.primaryType().Void() != null) {
                t.typeName = "Void";
            }
        }
        return t;
    }

    @Override public type visitVariableArrayTypeExpression(MxParser.VariableArrayTypeExpressionContext context) {
        //System.out.println("visit VariableArrayTypeExpression");

        type t = new type();
        if (context.primaryType() != null) {
            if (context.primaryType().Bool() != null) {
                t.typeName = "Bool";
            }
            if (context.primaryType().Int() != null) {
                t.typeName = "Int";
                System.out.println(t.typeName);
            }
            if (context.primaryType().String() != null) {
                t.typeName = "String";
            }
            if (context.primaryType().Void() != null) {
                t.typeName = "Void";
            }
        }

        if (context.Identifier()!=null){
           // t.typeName = context.Identifier().toString();
            //System.out.println(context.Identifier().toString());
            if (context.Identifier(0)!=null) t.typeName = context.Identifier(0).toString();
            //System.out.println(t.typeName);
        }

        if (context.CloseBlacket(0) != null) {
            if (context.IntegerConstant(0) != null) {
                t.arr.add(context.IntegerConstant(0).toString());
            }
            else t.arr.add("0");
        }
        if (context.CloseBlacket(1) != null) {
            if (context.IntegerConstant(1) != null) {
                t.arr.add(context.IntegerConstant(1).toString());
            }
            else t.arr.add("0");
        }
        return t;
    }

}








