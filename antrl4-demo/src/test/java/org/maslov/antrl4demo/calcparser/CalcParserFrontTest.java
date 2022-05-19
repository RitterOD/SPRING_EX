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

    @Test
    void simpleExpressionTwoArg() {
        String query = "1 + 2";
        CalcParserFront parser = new CalcParserFront();
        int rv = parser.parseExpression(query);
        assertEquals(3, rv);
    }

    @Test
    void simpleExpressionTwoLongArg() {
        String query = "1000 + 2000";
        CalcParserFront parser = new CalcParserFront();
        int rv = parser.parseExpression(query);
        assertEquals(3000, rv);
    }

    @Test
    void complexExpression() {
        String query = "1000 + (2000 * 2) + (5 - 4)";
        CalcParserFront parser = new CalcParserFront();
        int rv = parser.parseExpression(query);
        assertEquals(5001, rv);
    }
}