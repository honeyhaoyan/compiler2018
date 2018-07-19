/*
"+"：出现1+次
"*"：出现0+次
"?"：出现1-次，或者将贪婪匹配（尽量向后匹配直到不能匹配）改为不贪婪匹配
"."：匹配除换行符 \n 之外的任何单字符
*/


grammar Mx;

//----------------the first floor----------------------------
program
    :programItem*
    //:(classDefinition|functionDefinition|globalVariable)*
    ;

//---------------the second floor----------------------------
programItem
    :(classDefinition|functionDefinition|globalVariable)
    ;

classDefinition
    :Class className OpenCurly classBody CloseCurly
    ;
    className
        :Identifier
        ;
    classBody
        :(definitionStatement|functionDefinition|constructionDefinition)*
        ;
        constructionDefinition
            :className OpenParen (definitionExpression (Comma definitionExpression)*)* CloseParen blockStatement
            ;

functionDefinition
    :variableTypeExpression functionName OpenParen (definitionExpression (Comma definitionExpression)*)* CloseParen blockStatement
    ;
    functionName
        :Identifier
        ;

globalVariable
    //:(definitionStatement|assignStatement|newStatement)
    :(newStatement|assignStatement|definitionStatement)
    ;

//-----------------the third floor----------------------------

//statement
blockOrStatement
    :blockStatement|statement
    ;

blockStatement
    :OpenCurly (blockOrStatement)* CloseCurly
    ;

statement
    :newStatement
    |definitionStatement
    |assignStatement
    |ifStatement
    |forStatement
    |whileStatement
    |breakStatement
    |returnStatement
    |continueStatement
    //|selfOperationStatement
    //|callFunctionStatement
    //|dotFunctionStatement
    |valuebleSingleStatement
    |emptyStatement
    ;

    valuebleSingleStatement
        :valuebleSingleExpression Semi
        ;
    emptyStatement
        :Semi
        ;



    newStatement
        :(variableTypeExpression)? Identifier Assign New variableTypeExpression Semi
        //|subscriptExpression Assign New variableTypeExpression Semi
        //|dotVariableExpression Assign New variableTypeExpression Semi
        |valuebleSingleExpression  Assign New variableTypeExpression Semi
        ;

    definitionStatement
            :definitionExpression Semi
            ;

    assignStatement
        :assignExpression Semi
        ;

    ifStatement
        :If OpenParen valuebleSingleExpression CloseParen blockOrStatement (Else blockOrStatement)?
        ;

    forStatement
        :For OpenParen (definitionStatement|assignStatement)?
         (valuebleSingleExpression)? Semi
         (assignExpression | valuebleSingleExpression)?
         CloseParen blockOrStatement
         |For OpenParen Semi(valuebleSingleExpression)? Semi (assignExpression | valuebleSingleExpression)? CloseParen (Semi|blockOrStatement)
        ;
    whileStatement
        :While OpenParen valuebleSingleExpression CloseParen blockOrStatement
        ;
    breakStatement
        :Break Semi
        ;
    returnStatement
        :Return (valuebleSingleExpression|valuebleListExpression)? Semi
        ;
    continueStatement
        :Continue Semi
        ;
    /*selfOperationStatement
        :(Inc | Dec) (valuebleSingleExpression) Semi
        |(valuebleSingleExpression) (Inc|Dec) Semi
        ;
    callFunctionStatement
        :callFunctionExpression Semi
        ;
    dotFunctionStatement
        :dotFunctionExpression Semi
        ;*/

//expression 从上到下依次匹配，所以把优先级大的放在上面，优先级小的放在下面

valuebleSingleExpression
    :Identifier
    |newExpression
    |variableTypeExpression
    |constant
    |This
    //|dotExpression
    //|subscriptExpression
    |valuebleSingleExpression Dot valuebleSingleExpression
    |valuebleSingleExpression OpenBlacket (valuebleSingleExpression)? CloseBlacket
    |(Inc | Dec) valuebleSingleExpression
    |valuebleSingleExpression (Inc|Dec)
    |(Not | Lnot) valuebleSingleExpression
    |valuebleSingleExpression (Mul|Div|Mod) valuebleSingleExpression
    |Sub valuebleSingleExpression
    |valuebleSingleExpression (Add|Sub) valuebleSingleExpression
    |valuebleSingleExpression (Lshift | Rshift) valuebleSingleExpression
    |valuebleSingleExpression (Le | Ge | Lt | Gt) valuebleSingleExpression
    |valuebleSingleExpression (Equal | Notequal) valuebleSingleExpression
    |valuebleSingleExpression And valuebleSingleExpression
    |valuebleSingleExpression Xor valuebleSingleExpression
    |valuebleSingleExpression Or valuebleSingleExpression
    |valuebleSingleExpression Land valuebleSingleExpression
    |valuebleSingleExpression Lor valuebleSingleExpression
    |callFunctionExpression
    |OpenParen valuebleSingleExpression CloseParen
    //|newExpression
    ;

    newExpression
        :New (Identifier|variableTypeExpression) (OpenParen CloseParen)?
        ;
    variableTypeExpression
        :variableArrayTypeExpression
        |variableNormalTypeExpression
        ;
        variableNormalTypeExpression
            :(primaryType|Identifier)
            ;
        variableArrayTypeExpression
            :(primaryType|Identifier) (OpenBlacket (valuebleSingleExpression)? CloseBlacket )*
            ;
    /*
    dotExpression
        :dotVariableExpression
        |dotFunctionExpression
        ;
        dotVariableExpression
            :(className|subscriptExpression|callFunctionExpression|This) Dot (dotExpression|className)

            ;
        dotFunctionExpression
            :(OpenParen)?(className|subscriptExpression|StringConstant|callFunctionExpression|This|(OpenParen callFunctionExpression Add callFunctionExpression CloseParen)) Dot (dotFunctionExpression|callFunctionExpression)(CloseParen)?
            //|StringConstant Dot callFunctionExpression
            //|subscriptExpression Dot callFunctionExpression
            ;
            functionName
                :Identifier
                ;

    subscriptExpression

        :(className|dotVariableExpression)(OpenBlacket (valuebleSingleExpression) CloseBlacket)*

        |(OpenParen)*(OpenParen newExpression CloseParen)((OpenBlacket valuebleSingleExpression CloseBlacket)* CloseParen)* (OpenBlacket (valuebleSingleExpression) CloseBlacket)*
        ;
    */

    callFunctionExpression
        :Identifier OpenParen (valuebleListExpression|valuebleSingleExpression)? CloseParen
        ;

valuebleListExpression
    :valuebleSingleExpression (Comma valuebleSingleExpression)+
    ;

definitionExpression  // int a(b) / int a=b
    :definitionNormalExpression
    |definitionArrayExpression
    ;
    definitionNormalExpression
        :variableNormalTypeExpression Identifier (Assign valuebleSingleExpression)?
        |variableNormalTypeExpression Identifier (OpenParen valuebleSingleExpression CloseParen)?
        ;
    definitionArrayExpression
        :variableArrayTypeExpression Identifier (Assign valuebleSingleExpression)?
        ;

assignExpression
    : valuebleSingleExpression Assign valuebleSingleExpression
    ;








//-------------------- lexer--------------------------------------------
OpenParen : '(';
CloseParen : ')';
OpenCurly : '{';
CloseCurly : '}';
OpenBlacket : '[';
CloseBlacket : ']';
Semi : ';';
Comma : ',';
Dot : '.';
Assign : '=';
Inc : '++';
Dec : '--';
Add : '+';
Sub : '-';
Mul : '*';
Div : '/';
Mod : '%';
Land : '&&';
Lor : '||';
Lnot : '!';
Lshift : '<<';
Rshift : '>>';
Not : '~';
Or : '|';
And : '&';
Xor : '^';
Lt : '<';
Gt : '>';
Equal : '==';
Le : '<=';
Ge : '>=';
Notequal : '!=';


If : 'if';
Else : 'else';
For : 'for';
While : 'while';
Break : 'break';
Continue : 'continue';
Return : 'return';
Class : 'class';
New : 'new';
This : 'this';

primaryType
    : Bool | Int | String | Void
    ;

        Bool : 'bool';
        Int : 'int';
        String : 'string';
        Void : 'void';

constant
    : LogicConstant
    | IntegerConstant
    | StringConstant
    | NullConstant
    ;

    LogicConstant
        : 'true' | 'false'
        ;

    IntegerConstant
        : DecimalConstant
        //DecimalConstant
        ;

        fragment
        DecimalConstant
            : [1-9] [0-9]*
            | '0'
            ;

    StringConstant
        : '"' (~["\\\r\n] | EscapeSequence)* '"'
        ;
            fragment
            EscapeSequence
                : '\\' [btnfr"'\\]
                ;

    NullConstant
        : 'null'
        ;

Identifier
    : [a-zA-Z] [0-9a-zA-Z_]*
    ;

WhiteSpace
    : [ \t]+ -> skip
    ;

NewLine
    : [\n\r]+ -> skip
    ;

LineComment
    : '//' ~[\r\n]* -> skip
    ;

BlockComment
    : '/*' .*? '*/' -> skip
    ;


    //https://stackoverflow.com/questions/29971097/how-to-create-ast-with-antlr4







