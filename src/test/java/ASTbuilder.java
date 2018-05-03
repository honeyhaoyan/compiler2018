import org.antlr.v4.runtime.tree.*;


public class ASTbuilder extends MxBaseVisitor<Node> {
    @Override public Program visitProgram(MxParser.ProgramContext context) {
        Program tmp = new Program();
        //System.out.println("new program");
        int i=0;
        for (ParseTree item : context.programItem()){
            if (context.programItem(i).classDefinition()!=null){
                //System.out.println("program class");
                classDefinition classNode = (classDefinition) visit(item);
                tmp.classSons.add(classNode);
                tmp.sequenceSons.add(classNode);
            }
            if (context.programItem(i).functionDefinition()!=null){
                //System.out.println("program function");
                functionDefinition functionNode = (functionDefinition) visit(item);
                tmp.functionSons.add(functionNode);
                tmp.sequenceSons.add(functionNode);
            }
            if (context.programItem(i).globalVariable()!=null){
                //System.out.println("program global variable");
                variable globalVariableNode = new variable();
                definitionStatement defi = visitDefinitionStatement(context.programItem(i).globalVariable().definitionStatement(0));
                globalVariableNode = defi.variableSon;
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
        for (ParseTree item : context.definitionExpression()){
            variable inputNode = (variable)visit(item);
            tmp.inputVariableSons.add(inputNode);
        }
        tmp.blockSon=(blockDefinition)visit(context.blockStatement());
        return tmp;
    }

    @Override public definitionStatement visitDefinitionStatement(MxParser.DefinitionStatementContext context){
        //System.out.println("visit DefinitionStatement");
        definitionStatement tmp = new definitionStatement();
        type t;
        String na;
        if (context.definitionExpression().definitionNormalExpression()!=null){
            t = visitVariableNormalTypeExpression(context.definitionExpression().definitionNormalExpression().variableNormalTypeExpression());
            na = context.definitionExpression().definitionNormalExpression().Identifier().toString();
        }
        else {
            t = visitVariableArrayTypeExpression(context.definitionExpression().definitionArrayExpression().variableArrayTypeExpression());
            na = context.definitionExpression().definitionNormalExpression().Identifier().toString();
        }
        tmp.variableSon.ty.typeName=t.typeName;
        for(String p : t.arr){
            tmp.variableSon.ty.arr.add(p);
        }
        tmp.variableSon.name=na;
        return tmp;
    }

    @Override public blockDefinition visitBlockStatement(MxParser.BlockStatementContext context) {
        //System.out.println("visit BlockStatement");
        blockDefinition tmp = new blockDefinition();
        int num = context.getChildCount();
        for (int i=0;i<num-2;++i){
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
        }
        return tmp;
    }

    @Override public newStatement visitNewStatement(MxParser.NewStatementContext context){
        newStatement tmp = new newStatement();
        tmp.name=context.Identifier().getText();
        tmp.newType1=(type)visit(context.variableArrayTypeExpression(0));
        tmp.newType2=(type)visit(context.variableArrayTypeExpression(1));
        return tmp;
    }

    @Override public assignmentStatement visitAssignStatement(MxParser.AssignStatementContext context) {
        //System.out.println("visit AssignStatement");
        assignmentStatement tmp = new assignmentStatement();
        tmp.exp = visitValuebleSingleExpression(context.assignExpression().valuebleSingleExpression());
        tmp.variableLe.name = context.assignExpression().Identifier().toString();
        return tmp;
    }

    /* Notice : it is rewritten for forStatement for(int i; i<=5; i=i+1)*/
    @Override public assignmentStatement visitAssignExpression(MxParser.AssignExpressionContext context) {
        assignmentStatement tmp = new assignmentStatement();
        tmp.exp = visitValuebleSingleExpression(context.valuebleSingleExpression());
        tmp.variableLe.name = context.Identifier().toString();
        return tmp;
    }

    @Override public ifStatement visitIfStatement(MxParser.IfStatementContext context) {
        //System.out.println("visit ifStatement");
        ifStatement tmp = new ifStatement();
        tmp.ifcondition.addSon(visitValuebleSingleExpression(context.valuebleSingleExpression()));
        tmp.ifblock = visitBlockStatement(context.blockStatement(0));
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
        tmp.returnExpression = visitValuebleSingleExpression(context.valuebleSingleExpression());
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
        tmp.va.name=context.Identifier().toString();
        return tmp;
    }

    @Override public expression visitValuebleSingleExpression(MxParser.ValuebleSingleExpressionContext context){
        //System.out.println("visit ValuebleSingleExpression");
        expression tmp = new expression();
        if (context.constant()!=null) {
            constant con = new constant();
            con=visitConstant(context.constant());
            tmp.addSon(con);
        }
        if (context.Inc()!=null||context.Dec()!=null||context.Not()!=null||context.Lnot()!=null){
            Op op = new Op();
            if (context.Inc()!=null) op.op=context.Inc().toString();
            if (context.Dec()!=null) op.op=context.Dec().toString();
            if (context.Not()!=null) op.op=context.Not().toString();
            if (context.Lnot()!=null) op.op=context.Lnot().toString();
            tmp.addSon(op);
            //System.out.println(op.op);
        }
        if (context.Add()!=null||context.Div()!=null||context.Equal()!=null||context.Ge()!=null||context.Gt()!=null||context.Land()!=null||context.Le()!=null||context.Lor()!=null||context.Lshift()!=null||context.Lt()!=null||context.Mod()!=null||context.Mul()!=null||context.Or()!=null||context.Rshift()!=null||context.Notequal()!=null||context.Sub()!=null||context.Xor()!=null){
            Op op = new Op();
            if (context.And()!=null) op.op=context.Add().toString();
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
            //System.out.println(op.op);
        }
        if (context.This()!=null){
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
                dotVariableExpression dotVa = new dotVariableExpression();
                dotVa = visitDotVariableExpression(context.dotExpression().dotVariableExpression());
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
            callFunctionExpression callFunc = new callFunctionExpression();
            callFunc = visitCallFunctionExpression(context.callFunctionExpression());
            tmp.addSon(callFunc);
        }
        return tmp;
    }

    @Override public subscriptExpression visitSubscriptExpression(MxParser.SubscriptExpressionContext context) {
        subscriptExpression tmp = new subscriptExpression();
        tmp.father=(variable)visit(context.className());
        tmp.son=(expression) visit(context.valuebleSingleExpression());
        return tmp;
    }

    @Override public dotVariableExpression visitDotVariableExpression(MxParser.DotVariableExpressionContext context) {
        dotVariableExpression tmp = new dotVariableExpression();
        tmp.father.name = context.className(0).toString();
        tmp.son.name = context.className(1).toString();
        return tmp;
    }

    @Override public dotFunctionExpression visitDotFunctionExpression(MxParser.DotFunctionExpressionContext context) {
        //System.out.println("visit DotFunctionExpression");
        dotFunctionExpression tmp = new dotFunctionExpression();
        tmp.father.name = context.className().toString();
        tmp.son = visitCallFunctionExpression(context.callFunctionExpression());
        return tmp;
    }

    @Override public callFunctionExpression visitCallFunctionExpression(MxParser.CallFunctionExpressionContext context) {
        callFunctionExpression tmp = new callFunctionExpression();
        tmp.functionName = context.Identifier().toString();
        int i=0;
        for (ParseTree item : context.valuebleListExpression().valuebleSingleExpression()){
            expression exp = new expression();
            exp = visitValuebleSingleExpression(context.valuebleListExpression().valuebleSingleExpression(i));
            tmp.expressionSons.add(exp);
            i++;
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
            con.type="IntegerConstant";
            con.value=context.IntegerConstant().toString();
        }
        if(context.LogicConstant()!=null){
            con.type="LogicConstant";
            con.value=context.LogicConstant().toString();
        }
        if(context.StringConstant()!=null){
            con.type="StringConstant";
            con.value=context.StringConstant().toString();
        }
        if(context.NullConstant()!=null){
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
            }
            if (context.primaryType().String() != null) {
                t.typeName = "String";
            }
            if (context.primaryType().Void() != null) {
                t.typeName = "Void";
            }
        }
        if (context.CloseBlacket(0) != null) {
            if (context.IntegerConstant(0) != null) {
                t.arr.add(context.IntegerConstant(0).toString());
            }
        }
        if (context.CloseBlacket(1) != null) {
            if (context.IntegerConstant(1) != null) {
                t.arr.add(context.IntegerConstant(1).toString());
            }
        }
        return t;
    }

}








