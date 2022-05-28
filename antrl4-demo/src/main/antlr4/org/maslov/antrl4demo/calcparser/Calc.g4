grammar Calc;

MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';


/* The start rule; begin parsing here */
prog: stat+ ;

stat: expr NEWLINE                  #printExpr
    | ID '=' expr NEWLINE           #assign
    | NEWLINE                       #blank
    ;

expr: expr op=('*'|'/') expr         #MulDiv
    | expr op=('+'|'-') expr         #AddSub
    | INT                           #int
    | ID                            #id
    | '(' expr ')'                  #parents
    ;

INT
    : '0' | [1-9][0-9]*;

ID
   : [a-zA-Z] [a-zA-Z_0-9]*
   ;

NEWLINE: '\r'? '\n';
WS: [ \t] -> skip;
COMMENT_INPUT:  '/*' .*? '*/' -> channel(HIDDEN);


