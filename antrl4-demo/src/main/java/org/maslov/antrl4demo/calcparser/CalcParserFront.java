package org.maslov.antrl4demo.calcparser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.maslov.antrl4demo.parser.SQLParserListener;
import org.maslov.antrl4demo.parser.sqlLexer;
import org.maslov.antrl4demo.parser.sqlParser;

public class CalcParserFront {

    public int parseExpression(String rawExpression) {

        CharStream charStream = CharStreams.fromString(rawExpression);
        CalcLexer lexer = new CalcLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        var calcListContext = parser.list();

        ParseTreeWalker walker = new ParseTreeWalker();
        CalcParserListener listener = new CalcParserListener();

        walker.walk(listener, calcListContext);

        return listener.getValue();
    }
}
