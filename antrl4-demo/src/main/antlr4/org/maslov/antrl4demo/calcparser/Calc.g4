grammar Calc;




/* */
list
    : DIGIT '+' list | DIGIT '-' list | DIGIT;


DIGIT
    : '0' | [1-9][0-9]*;



ASTERISK: '*';
SELECT: 'SELECT';
FROM: 'FROM';
EOQ: ';';

VALID_NAME
   : [a-zA-Z] [a-zA-Z_0-9]*
   ;

SPACE:          [ \t\r\n]+    -> channel(HIDDEN);
COMMENT_INPUT:  '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT:   ('-- ' | '#')
                ~[\r\n]*
                ('\r'? '\n' | EOF)
                              -> channel(HIDDEN);

