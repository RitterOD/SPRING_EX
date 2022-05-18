package org.maslov.antrl4demo.calcparser;

import org.junit.jupiter.api.Test;
import org.maslov.antrl4demo.parser.SQLQuery;
import org.maslov.antrl4demo.parser.SQLQueryParser;

import static org.junit.jupiter.api.Assertions.*;

class CalcParserFrontTest {


    @Test
    void simpleExpression() {
        String query = "1 + 1 + 2 - 3";
        CalcParserFront parser = new CalcParserFront();
        int rv = parser.parseExpession(query);
        assertEquals(1, rv);
    }

}