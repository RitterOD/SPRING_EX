package org.maslov.antrl4demo.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class SQLQueryParser {
    /*
    public SQLQuery parseQuery(String raw) {
        CharStream charStream = CharStreams.fromString(raw);
        sqlLexer lexer = new sqlLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        sqlParser parser = new sqlParser(tokens);
        sqlParser.SqlQueryContext sqlQueryContext = parser.sqlQuery();

        ParseTreeWalker walker = new ParseTreeWalker();
        SQLParserListener listener = new SQLParserListener();

        walker.walk(listener, sqlQueryContext);

        return listener.getQuery();
    }

     */
}
