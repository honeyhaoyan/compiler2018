import org.antlr.v4.runtime.tree.*;


public class ASTbuilder extends MxBaseVisitor<Node> {
    @Override public Program visitProgram(MxParser.ProgramContext context) {
        Program tmp = new Program();
        System.out.println("new program");
        int i=0;
        //System.out.println(context.programItem().size());
        for (ParseTree item : context.programItem()){
            if (context.programItem(i).classDefinition()!=null){
                System.out.println("program class");
                classDefinition classNode = (classDefinition) visit(item);
                tmp.classSons.add(classNode);
                tmp.sequenceSons.add(classNode);
            }
            if (context.programItem(i).functionDefinition()!=null){
                System.out.println("program function");
                functionDefinition functionNode = visitFunctionDefinition(context.programItem(i).functionDefinition());
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
        for (ParseTree item : context.classBody().constructionDefinition()){
            functionDefinition functionNode = (functionDefinition)visit(item);
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
                variable inputNode = new variable();
                inputNode = visitDefinitionExpression(context.definitionExpression(i));
                tmp.inputVariableSons.add(inputNode);
                i++;
            }
        }
        //tmp.blockSon=(blockDefinition)visit(context.blockStatement());
        tmp.blockSon = visitBlockStatement(context.blockStatement());
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
        for(expression p : t.arrExp){
            tmp.ty.arrExp.add(p);
        }
        tmp.name=na;
        return tmp;
    }


    @Override public definitionStatement visitDefinitionStatement(MxParser.DefinitionStatementContext context){
        definitionStatement tmp = new definitionStatement();
        type t;
        String na;
        if (context.definitionExpression().definitionNormalExpression()!=null){
            t = visitVariableNormalTypeExpression(context.definitionExpression().definitionNormalExpression().variableNormalTypeExpression());
            na = context.definitionExpression().definitionNormalExpression().Identifier().toString();
            if (context.definitionExpression().definitionNormalExpression().valuebleSingleExpression()!=null){
                tmp.exp = visitValuebleSingleExpression(context.definitionExpression().definitionNormalExpression().valuebleSingleExpression());
            }
        }
        else {
            t = visitVariableArrayTypeExpression(context.definitionExpression().definitionArrayExpression().variableArrayTypeExpression());
            na = context.definitionExpression().definitionArrayExpression().Identifier().toString();
        }
        tmp.variableSon.ty.typeName=t.typeName;
        for(expression p : t.arrExp){
            tmp.variableSon.ty.arrExp.add(p);
        }
        tmp.variableSon.name=na;
        return tmp;
    }

    @Override public blockDefinition visitBlockOrStatement(MxParser.BlockOrStatementContext context) {
        if (context.blockStatement()!=null) return visitBlockStatement(context.blockStatement());
        else {
            blockDefinition tmp = new blockDefinition();
            /*
            if (context.statement().assignStatement()!=null){
                tmp.statementSons.add(visitAssignStatement(context.statement().assignStatement()));
            }
            if (context.statement().breakStatement()!=null){
                tmp.statementSons.add(visitBreakStatement(context.statement().breakStatement()));
            }
            if (context.statement().continueStatement()!=null){
                //System.out.println("continueStatement(");
                tmp.statementSons.add(visitContinueStatement(context.statement().continueStatement()));
            }
            if (context.statement().definitionStatement()!=null){
                tmp.statementSons.add(visitDefinitionStatement(context.statement().definitionStatement()));
            }
            if (context.statement().forStatement()!=null){
                tmp.statementSons.add(visitForStatement(context.statement().forStatement()));
            }
            if (context.statement().ifStatement()!=null){
                tmp.statementSons.add(visitIfStatement(context.statement().ifStatement()));
            }
            if (context.statement().newStatement()!=null){
                tmp.statementSons.add(visitNewStatement(context.statement().newStatement()));
            }
            if (context.statement().returnStatement()!=null){
                tmp.statementSons.add(visitReturnStatement(context.statement().returnStatement()));
            }
            if (context.statement().whileStatement()!=null){
                tmp.statementSons.add(visitWhileStatement(context.statement().whileStatement()));
            }

            if (context.statement().emptyStatement()!=null){
                tmp.statementSons.add(visitEmptyStatement(context.statement().emptyStatement()));
            }

            if (context.statement().valuebleSingleStatement()!=null){
                tmp.statementSons.add(visitValuebleSingleStatement(context.statement().valuebleSingleStatement()));
            }*/
            tmp.statementSons.add(visitStatement(context.statement()));
            return tmp;
        }
    }


    @Override public blockDefinition visitBlockStatement(MxParser.BlockStatementContext context) {
        //System.out.println("visit BlockStatement");
        blockDefinition tmp = new blockDefinition();
        //int num1 = context.statement().size();
        //int num2 = context.blockStatement().size();
        //System.out.println(num);
        //if (context.CloseCurly()!=null) num = num-2;
        //int i=0;int j=0;
        //System.out.println(num1);
        //System.out.println(num2);

        int num = context.blockOrStatement().size();
        //System.out.println(num);
        for (int i=0;i<num;++i){
            int initialNum = tmp.statementSons.size();
            //System.out.println(context.getChild(k+1).toStringTree());
            if (context.blockOrStatement(i).statement()!=null){
                //int initialNum = tmp.statementSons.size();
                /*
                if (context.blockOrStatement(i).statement().assignStatement()!=null){
                    System.out.println("assignStatement");
                    tmp.statementSons.add(visitAssignStatement(context.blockOrStatement(i).statement().assignStatement()));
                }
                if (context.blockOrStatement(i).statement().breakStatement()!=null){
                    System.out.println("breakStatement");
                    tmp.statementSons.add(visitBreakStatement(context.blockOrStatement(i).statement().breakStatement()));
                }
                if (context.blockOrStatement(i).statement().continueStatement()!=null){
                    System.out.println("continueStatement(");
                    tmp.statementSons.add(visitContinueStatement(context.blockOrStatement(i).statement().continueStatement()));
                }
                if (context.blockOrStatement(i).statement().definitionStatement()!=null){
                    System.out.println("definitionStatement");
                    tmp.statementSons.add(visitDefinitionStatement(context.blockOrStatement(i).statement().definitionStatement()));
                }
                if (context.blockOrStatement(i).statement().forStatement()!=null){
                    System.out.println("forStatement");
                    tmp.statementSons.add(visitForStatement(context.blockOrStatement(i).statement().forStatement()));
                }
                if (context.blockOrStatement(i).statement().ifStatement()!=null){
                    System.out.println("ifStatement");
                    tmp.statementSons.add(visitIfStatement(context.blockOrStatement(i).statement().ifStatement()));
                }
                if (context.blockOrStatement(i).statement().newStatement()!=null){
                    System.out.println("newStatement");
                    tmp.statementSons.add(visitNewStatement(context.blockOrStatement(i).statement().newStatement()));
                }
                if (context.blockOrStatement(i).statement().returnStatement()!=null){
                    System.out.println("returnStatement");
                    tmp.statementSons.add(visitReturnStatement(context.blockOrStatement(i).statement().returnStatement()));
                }
                if (context.blockOrStatement(i).statement().whileStatement()!=null){
                    System.out.println("whileStatement");
                    tmp.statementSons.add(visitWhileStatement(context.blockOrStatement(i).statement().whileStatement()));
                }

                if (context.blockOrStatement(i).statement().selfOperationStatement()!=null){
                    System.out.println("selfOperationStatement");
                    tmp.statementSons.add(visitSelfOperationStatement(context.blockOrStatement(i).statement().selfOperationStatement()));
                }
                if (context.blockOrStatement(i).statement().callFunctionStatement()!=null){
                    System.out.println("callFunctionStatement");
                    tmp.statementSons.add(visitCallFunctionStatement(context.blockOrStatement(i).statement().callFunctionStatement()));
                }

                if (context.blockOrStatement(i).statement().emptyStatement()!=null){
                    System.out.println("emptyStatement");
                    tmp.statementSons.add(visitEmptyStatement(context.blockOrStatement(i).statement().emptyStatement()));
                }

                if (context.blockOrStatement(i).statement().valuebleSingleStatement()!=null){
                    System.out.println("valuebleSingleStatement");
                    tmp.statementSons.add(visitValuebleSingleStatement(context.blockOrStatement(i).statement().valuebleSingleStatement()));
                }
                if (context.blockOrStatement(i).statement().dotFunctionStatement()!=null){
                    System.out.println("dotFunctionStatement");
                    tmp.statementSons.add(visitDotFunctionStatement(context.blockOrStatement(i).statement().dotFunctionStatement()));
                }
                if (initialNum == tmp.statementSons.size()){
                    //System.out.println("blockOrStatement");
                    tmp.statementSons.add(new illegal());
                }*/
                tmp.statementSons.add(visitStatement(context.blockOrStatement(i).statement()));
            }
            if (context.blockOrStatement(i).blockStatement()!=null){
                tmp.statementSons.add(visitBlockStatement(context.blockOrStatement(i).blockStatement()));
            }
            if (initialNum == tmp.statementSons.size()){
               // System.out.println(initialNum);
                tmp.statementSons.add(new illegal());
            }
        }
        //blockDefinition tmp = new blockDefinition();
        //tmp = visitBlockOrStatement(context.blockOrStatement(0));
        return tmp;
    }

    @Override public statement visitStatement(MxParser.StatementContext context){
        statement tmp = new statement();
        if (context.assignStatement()!=null){
            return (visitAssignStatement(context.assignStatement()));
        }
        if (context.breakStatement()!=null){
            return (visitBreakStatement(context.breakStatement()));
        }
        if (context.continueStatement()!=null){
            //System.out.println("continueStatement(");
            return (visitContinueStatement(context.continueStatement()));
        }
        if (context.definitionStatement()!=null){
            return (visitDefinitionStatement(context.definitionStatement()));
        }
        if (context.forStatement()!=null){
            return (visitForStatement(context.forStatement()));
        }
        if (context.ifStatement()!=null){
            return (visitIfStatement(context.ifStatement()));
        }
        if (context.newStatement()!=null){
            return (visitNewStatement(context.newStatement()));
        }
        if (context.returnStatement()!=null){
            return (visitReturnStatement(context.returnStatement()));
        }
        if (context.whileStatement()!=null){
            return (visitWhileStatement(context.whileStatement()));
        }
            /*
            if (context.statement().selfOperationStatement()!=null){
                tmp.statementSons.add(visitSelfOperationStatement(context.statement().selfOperationStatement()));
            }
            if (context.statement().callFunctionStatement()!=null){
                tmp.statementSons.add(visitCallFunctionStatement(context.statement().callFunctionStatement()));
            }
            */
        if (context.emptyStatement()!=null){
            return (visitEmptyStatement(context.emptyStatement()));
        }

        if (context.valuebleSingleStatement()!=null){
            return (visitValuebleSingleStatement(context.valuebleSingleStatement()));
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
            tmp.name = context.Identifier().toString();
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
            /*
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
            }*/
            tmp.exp = visitValuebleSingleExpression(context.valuebleSingleExpression());
            if (context.variableTypeExpression(0).variableNormalTypeExpression()!=null){
                tmp.newType2 = visitVariableNormalTypeExpression(context.variableTypeExpression(1).variableNormalTypeExpression());
            }
            if (context.variableTypeExpression(0).variableArrayTypeExpression()!=null){
                tmp.newType2 = visitVariableArrayTypeExpression(context.variableTypeExpression(1).variableArrayTypeExpression());
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
        //System.out.println("assignmentStatement");
        assignmentStatement tmp = new assignmentStatement();
        tmp.expLe = visitValuebleSingleExpression(context.valuebleSingleExpression(0));
        tmp.expRi = visitValuebleSingleExpression(context.valuebleSingleExpression(1));
        return tmp;
    }

    @Override public ifStatement visitIfStatement(MxParser.IfStatementContext context) {
        //System.out.println("---------------------------visit ifStatement-------------------------------");
        ifStatement tmp = new ifStatement();
        tmp.ifcondition=visitValuebleSingleExpression(context.valuebleSingleExpression());
        tmp.ifblock = visitBlockOrStatement(context.blockOrStatement(0));
        System.out.println(tmp.ifblock.statementSons.size());
        //System.out.println(context.blockStatement(0).getChildCount());
        if (context.blockOrStatement(1)!=null) tmp.elseblock = visitBlockOrStatement(context.blockOrStatement(1));
        return tmp;
    }

    @Override public forStatement visitForStatement(MxParser.ForStatementContext context) {
        //System.out.println("visit ForStatement");
        forStatement tmp = new forStatement();
        if (context.assignStatement()!=null){
            //System.out.println("in it");
            tmp.circleVariable = visitAssignStatement(context.assignStatement());
        }
        else {
            if (context.definitionStatement()!=null) tmp.circleVariable = visitDefinitionStatement(context.definitionStatement());
        }
        if (context.valuebleSingleExpression(0)!=null) tmp.variableCondition=visitValuebleSingleExpression(context.valuebleSingleExpression(0));
        else tmp.ifEmptyCon = true;
        if (context.valuebleSingleExpression(1)!=null){
            tmp.operateVariable=visitValuebleSingleExpression(context.valuebleSingleExpression(1));
        }
        else {
            if (context.assignExpression()!=null) tmp.operateVariable=visitAssignExpression(context.assignExpression());
        }
        if (context.blockOrStatement()!=null) tmp.forBlock=visitBlockOrStatement(context.blockOrStatement());
        else tmp.ifEmptyBlock = true;
        return tmp;
    }

    @Override public whileStatement visitWhileStatement(MxParser.WhileStatementContext context) {
        //System.out.println("visit WhileStatement");
        whileStatement tmp = new whileStatement();
        tmp.whileCondition=visitValuebleSingleExpression(context.valuebleSingleExpression());
        tmp.whileBlock=visitBlockOrStatement(context.blockOrStatement());
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
    /*
    @Override public selfOperationStatement visitSelfOperationStatement(MxParser.SelfOperationStatementContext context){
        selfOperationStatement tmp = new selfOperationStatement();
        Op op = new Op();
        if (context.Inc()!=null) op.op=context.Inc().toString();
        if (context.Dec()!=null) op.op=context.Dec().toString();
        //if (context.Not()!=null) op.op=context.Not().toString();
        //if (context.Lnot()!=null) op.op=context.Lnot().toString();
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
    }*/

    @Override public emptyStatement visitEmptyStatement(MxParser.EmptyStatementContext context){
        emptyStatement tmp = new emptyStatement();
        return tmp;
    }

    @Override public valuebleSingleStatement visitValuebleSingleStatement(MxParser.ValuebleSingleStatementContext context){
        /*emptyStatement tmp = new emptyStatement();
        //System.out.println("123");
        if (context.valuebleSingleExpression().newExpression()!=null){
            if (context.valuebleSingleExpression().newExpression().variableTypeExpression()!=null){
                if (context.valuebleSingleExpression().newExpression().variableTypeExpression().variableNormalTypeExpression()!=null){
                    if (context.valuebleSingleExpression().newExpression().variableTypeExpression().variableNormalTypeExpression().primaryType()!=null){
                        if (context.valuebleSingleExpression().newExpression().variableTypeExpression().variableNormalTypeExpression().primaryType().Void()!=null){
                            tmp.islegal = false;
                        }
                    }
                }
            }
        }*/
        valuebleSingleStatement tmp = new valuebleSingleStatement();
        tmp.exp = visitValuebleSingleExpression(context.valuebleSingleExpression());
        return tmp;
    }


    @Override public expression visitValuebleSingleExpression(MxParser.ValuebleSingleExpressionContext context){
        //System.out.println("visit ValuebleSingleExpression");
        //System.out.println(context.getText());
        expression tmp = new expression();
        /*if (context.constant()!=null) {
            //System.out.println("visit constant");
            //System.out.println(context.constant().getText());
            constant con = new constant();
            con=visitConstant(context.constant());
            tmp.addSon(con);
        }*/
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
        if (context.Dot()!=null || context.OpenBlacket()!=null){
            Op op = new Op();
            if (context.Dot()!=null) op.op = context.Dot().toString();
            if (context.OpenBlacket()!=null) op.op = context.OpenBlacket().toString();
        }
        if (context.constant()!=null) {
            //System.out.println("visit constant");
            //System.out.println(context.constant().getText());
            constant con = new constant();
            con=visitConstant(context.constant());
            tmp.addSon(con);
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
        /*
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
        }*/
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
            //System.out.println("identifier");
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
        if (context.newExpression()!=null){
            type ty = new type();
            System.out.println("newExpression()");
            ty = visitNewExpression(context.newExpression());
            tmp.addSon(ty);
        }
        return tmp;
    }
/*
    @Override public subscriptExpression visitSubscriptExpression(MxParser.SubscriptExpressionContext context) {
        //int i=0;
        //subscriptExpression tmp = new subscriptExpression();
        subscriptExpression tmp = new subscriptExpression();
        expression expression1 = new expression();
        if (context.className()!=null) {
            tmp.father.name = context.className().Identifier().toString();
            int i = 0;
            for (ParseTree item : context.OpenBlacket()) {
                if (context.valuebleSingleExpression(i) != null) {
                    tmp.Son.add(visitValuebleSingleExpression(context.valuebleSingleExpression(i)));
                } else tmp.Son.add(expression1);
                i++;
            }
        }
        else {
           // tmp.fatherExp = visitValuebleSingleExpression(context.valuebleSingleExpression(0));
            tmp.typeFather = visitNewExpression(context.newExpression());
            //System.out.println(typeFather.typeName);
            //System.out.println(typeFather.arrExp.size());
            int i = 0;
            for (ParseTree item : context.OpenBlacket()) {
                if (context.valuebleSingleExpression(i) != null) {
                    tmp.Son.add(visitValuebleSingleExpression(context.valuebleSingleExpression(i)));
                } else tmp.Son.add(expression1);
                i++;
            }

        }

        return tmp;
    }

    @Override public dotVariableExpression visitDotVariableExpression(MxParser.DotVariableExpressionContext context) {
        dotVariableExpression tmp = new dotVariableExpression();

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
            if (context.This()!=null){
                tmp.father = "this";
                tmp.classNameF = "this";
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
            if (context.This()!=null){
                tmp.father = "this";
                tmp.classNameF = "this";
                tmp.classNameS = context.className(0).Identifier().toString();
            }
            if (context.callFunctionExpression()==null&&context.subscriptExpression()==null&&context.This()==null){
                tmp.father = "className";
                tmp.classNameF = context.className(0).Identifier().toString();
                tmp.classNameS = context.className(1).Identifier().toString();
            }
            //System.out.println(tmp.classNameS);
        }
        return tmp;
    }

    @Override public dotFunctionExpression visitDotFunctionExpression(MxParser.DotFunctionExpressionContext context) {
       // System.out.println("visit DotFunctionExpression");
        dotFunctionExpression tmp = new dotFunctionExpression();

        if (context.className()!=null){
            System.out.println("className");
            System.out.println(context.className().Identifier().toString());
            tmp.father = "className";
            tmp.classNameF = context.className().Identifier().toString();

            if (context.dotFunctionExpression()!=null) {tmp.dotEx = visitDotFunctionExpression(context.dotFunctionExpression());tmp.son = "DotFunctionExpression";}
            if (context.callFunctionExpression(0)!=null) {tmp.callFunS = visitCallFunctionExpression(context.callFunctionExpression(0));tmp.son = "callFunctionExpression";}
            //if (context.dotFunctionExpression()!=null) {tmp.dotEx = visitDotFunctionExpression(context.dotFunctionExpression());tmp.son = "DotFunctionExpression";}
        }
        if (context.subscriptExpression()!=null){
            //System.out.println("subscriptExpression");
            tmp.father = "subscriptExpression";
            tmp.subscript = visitSubscriptExpression(context.subscriptExpression());

            //tmp.callFunS = visitCallFunctionExpression(context.callFunctionExpression(0));
            if (context.callFunctionExpression()!=null) {tmp.callFunS = visitCallFunctionExpression(context.callFunctionExpression(0));tmp.son = "callFunctionExpression";}
            if (context.dotFunctionExpression()!=null) {tmp.dotEx = visitDotFunctionExpression(context.dotFunctionExpression());tmp.son = "DotFunctionExpression";}
        }
        if (context.StringConstant()!=null){
            //System.out.println("StringConstant");
            tmp.father  = "StringConstant";
            tmp.constantStr = context.StringConstant().toString();

            //tmp.callFunS = visitCallFunctionExpression(context.callFunctionExpression(0));
            if (context.callFunctionExpression()!=null) {tmp.callFunS = visitCallFunctionExpression(context.callFunctionExpression(0));tmp.son = "callFunctionExpression";}
            if (context.dotFunctionExpression()!=null) {tmp.dotEx = visitDotFunctionExpression(context.dotFunctionExpression());tmp.son = "DotFunctionExpression";}
        }
        if (context.callFunctionExpression(1)!=null&&context.callFunctionExpression(0)!=null){
            System.out.println("two callFunctionExpression");
            tmp.father = "callFunctionExpression";
            tmp.callFunF = visitCallFunctionExpression(context.callFunctionExpression(0));

            if (context.callFunctionExpression(1)!=null) {tmp.callFunS = visitCallFunctionExpression(context.callFunctionExpression(1));tmp.son = "callFunctionExpression";}
            if (context.dotFunctionExpression()!=null) {tmp.dotEx = visitDotFunctionExpression(context.dotFunctionExpression());tmp.son = "DotFunctionExpression";}
        }
        if (context.This()!=null){
            System.out.println("This");
            tmp.father = "this";

            //tmp.callFunS = visitCallFunctionExpression(context.callFunctionExpression(0));
            if (context.callFunctionExpression()!=null) {tmp.callFunS = visitCallFunctionExpression(context.callFunctionExpression(0));tmp.son = "callFunctionExpression";}
            if (context.dotFunctionExpression()!=null) {tmp.dotEx = visitDotFunctionExpression(context.dotFunctionExpression());tmp.son = "DotFunctionExpression";}
        }

        return tmp;
    }*/

    @Override public callFunctionExpression visitCallFunctionExpression(MxParser.CallFunctionExpressionContext context) {
        //System.out.println("visitCallFunctionExpression");
        callFunctionExpression tmp = new callFunctionExpression();
        //System.out.println(context.toStringTree());
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
            //con.type="LogicConstant";
            con.type="Bool";
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
                //System.out.println(t.typeName);
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
            t.typeName = context.Identifier().toString();
            //System.out.println(t.typeName);
        }
        expression expression1 = new expression();
        //expression expression2 = new expression();
        int i = 0;
        for (ParseTree item : context.OpenBlacket()){
            if (context.valuebleSingleExpression(i)!=null){
                t.arrExp.add(visitValuebleSingleExpression(context.valuebleSingleExpression(i)));
            }
            else t.arrExp.add(expression1);
            i++;
        }/*
        if (context.CloseBlacket(0) != null) {
            if (context.valuebleSingleExpression(0)!=null){
                t.arrExp.add(visitValuebleSingleExpression(context.valuebleSingleExpression(0)));
            }
            else t.arrExp.add(expression1);
        }
        if (context.CloseBlacket(1) != null) {
            if (context.valuebleSingleExpression(1)!=null){
                t.arrExp.add(visitValuebleSingleExpression(context.valuebleSingleExpression(1)));
            }
            else t.arrExp.add(expression2);
        }*/
        return t;
    }

    @Override public type visitNewExpression(MxParser.NewExpressionContext context){
        type tmp = new type();
        if (context.Identifier()!=null) tmp.typeName = context.Identifier().toString();

        /*if (context.variableTypeExpression()!=null){
            if (context.variableTypeExpression().variableNormalTypeExpression()!=null){
                if (context.variableTypeExpression().variableNormalTypeExpression().primaryType()!=null){
                    if (context.variableTypeExpression().variableNormalTypeExpression().primaryType().Void()!=null) tmp.typeName="newVoid";
                }
            }
        }
        System.out.println(tmp.typeName);*/
        if (context.variableTypeExpression()!=null){
            if (context.variableTypeExpression().variableArrayTypeExpression().Identifier()!=null) tmp.typeName = context.variableTypeExpression().variableArrayTypeExpression().Identifier().toString();
            if (context.variableTypeExpression().variableArrayTypeExpression().primaryType()!=null){
                if (context.variableTypeExpression().variableArrayTypeExpression().primaryType().Bool()!=null){
                    tmp.typeName = "Bool";
                }
                if (context.variableTypeExpression().variableArrayTypeExpression().primaryType().Int()!=null){
                    tmp.typeName = "Int";
                }
                if (context.variableTypeExpression().variableArrayTypeExpression().primaryType().String()!=null){
                    tmp.typeName = "String";
                }
            }

            if (context.variableTypeExpression().variableArrayTypeExpression()!=null){
               /* for (ParseTree item : context.variableTypeExpression().variableArrayTypeExpression().valuebleSingleExpression()){
                    tmp.arrExp.add((expression) visit(item));
                }*/
                expression exp = new expression();
                int i=0;
                while (context.variableTypeExpression().variableArrayTypeExpression().OpenBlacket(i)!=null){
                    if (context.variableTypeExpression().variableArrayTypeExpression().valuebleSingleExpression(i)!=null){
                        tmp.arrExp.add((expression) visit(context.variableTypeExpression().variableArrayTypeExpression().valuebleSingleExpression(i)));
                    }
                    else tmp.arrExp.add(exp);
                    i++;
                }
            }
        }
        return tmp;
    }

    @Override public functionDefinition visitConstructionDefinition(MxParser.ConstructionDefinitionContext context){
        functionDefinition tmp = new functionDefinition();
        String functionName;
        functionName = context.className().Identifier().toString();
        tmp.functionName=functionName;
        tmp.returnType.typeName = context.className().Identifier().toString();
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


}








