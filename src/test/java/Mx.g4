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
        :(definitionStatement)* (functionDefinition)*
        ;

functionDefinition
    :variableTypeExpression functionName OpenParen (definitionExpression (Comma definitionExpression)*)* CloseParen blockStatement
    ;

globalVariable
    :(definitionStatement|assignStatement|newStatement)
    ;

//-----------------the third floor----------------------------

//statement
blockStatement
    :OpenCurly (statement)* CloseCurly
    |statement
    ;

statement
    :emptyStatement
    |definitionStatement
    |newStatement
    |assignStatement
    |ifStatement
    |forStatement
    |whileStatement
    |breakStatement
    |returnStatement
    |continueStatement
    |selfOperationStatement
    |callFunctionStatement
    |dotFunctionStatement
    ;

    emptyStatement
        :Semi
        ;

    definitionStatement
        :definitionExpression Semi
        ;

    newStatement
        :(variableTypeExpression)? Identifier Assign New variableTypeExpression Semi
        |subscriptExpression Assign New variableTypeExpression Semi
        |dotVariableExpression Assign New variableTypeExpression Semi
        ;

    assignStatement
        :assignExpression Semi
        ;

    ifStatement
        :If OpenParen valuebleSingleExpression CloseParen blockStatement (Else blockStatement)?
        ;

    forStatement
        :For OpenParen (definitionStatement|assignStatement)
         (valuebleSingleExpression)? Semi
         (assignExpression | valuebleSingleExpression)
         CloseParen blockStatement
        ;
    whileStatement
        :While OpenParen valuebleSingleExpression CloseParen blockStatement
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
    selfOperationStatement
        :(Inc | Dec) (Identifier|dotVariableExpression) Semi
        |(Identifier|dotVariableExpression) (Inc|Dec) Semi
        |(Not | Lnot) (Identifier|dotVariableExpression) Semi
        ;
    callFunctionStatement
        :callFunctionExpression Semi
        ;
    dotFunctionStatement
        :dotFunctionExpression Semi
        ;

//expression 从上到下依次匹配，所以把优先级大的放在上面，优先级小的放在下面

valuebleSingleExpression
    :Identifier
    |variableTypeExpression
    |constant
    |This
    |dotExpression
    |subscriptExpression
    |(Inc | Dec) valuebleSingleExpression
    |valuebleSingleExpression (Inc|Dec)
    |(Not | Lnot) valuebleSingleExpression
    |valuebleSingleExpression (Mul|Div) valuebleSingleExpression
    |valuebleSingleExpression (Add|Sub|Mod) valuebleSingleExpression
    //|valuebleSingleExpression (Mul|Div) valuebleSingleExpression
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
    ;

    variableTypeExpression
        :variableNormalTypeExpression
        |variableArrayTypeExpression
        ;
        variableNormalTypeExpression
            :(primaryType|Identifier)
            ;
        variableArrayTypeExpression
            //:(className | primaryType) ((OpenBlacket (IntegerConstant)? CloseBlacket )*)?
            :(primaryType|Identifier) ((OpenBlacket (IntegerConstant|Identifier)? CloseBlacket )*)?
            //:(primaryType) ((OpenBlacket (IntegerConstant)? CloseBlacket )*)?
            ;

    dotExpression
        :dotVariableExpression
        |dotFunctionExpression
        ;
        dotVariableExpression
            //:className Dot valuebleSingleExpression
            :(className|subscriptExpression|callFunctionExpression) Dot (dotExpression|className)
           // |className Dot className
            //|subscriptExpression Dot valuebleSingleExpression
            //:className Dot className
            ;
        dotFunctionExpression
            :(className|subscriptExpression|StringConstant|callFunctionExpression) Dot callFunctionExpression
            //|StringConstant Dot callFunctionExpression
            //|subscriptExpression Dot callFunctionExpression
            ;
            functionName
                :Identifier
                ;

    subscriptExpression
        :className OpenBlacket (valuebleSingleExpression) CloseBlacket
        ;

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
        //:variableArrayTypeExpression Identifier (Assign OpenCurly valuebleListExpression CloseCurly)?
        :variableArrayTypeExpression Identifier
        ;

assignExpression
    //:variableTypeExpression Assign valuebleSingleExpression

    : valuebleSingleExpression Assign valuebleSingleExpression
    //| Identifier Assign OpenCurly valuebleListExpression CloseCurly
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







