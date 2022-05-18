package org.maslov.antrl4demo.calcparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcParserFrontTest {


    @Test
    void simpleExpression() {
        String query = "1 + 2 + 3 - 4";
        CalcParserFront parser = new CalcParserFront();
        int rv = parser.parseExpression(query);
        assertEquals(2, rv);
    }

}