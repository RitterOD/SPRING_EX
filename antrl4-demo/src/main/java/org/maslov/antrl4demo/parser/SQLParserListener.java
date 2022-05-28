package org.maslov.antrl4demo.parser;

import java.util.ArrayList;
import java.util.List;

public class SQLParserListener /*extends sqlBaseListener*/{
    /*
    private final List<String> columns = new ArrayList<>();

    private String fromTable;
    private boolean allColumns;

    public SQLQuery getQuery() {
        return new SQLQuery(fromTable, new ArrayList<>(columns), allColumns);
    }

    @Override
    public void enterSqlQuery(sqlParser.SqlQueryContext ctx) {
        fromTable = null;
        columns.clear();
        allColumns = false;
    }

    @Override
    public void exitColumn(sqlParser.ColumnContext ctx) {
        columns.add(ctx.VALID_NAME().getText());
    }

    @Override
    public void exitAllColumns(sqlParser.AllColumnsContext ctx) {
        allColumns = true;
    }

    @Override
    public void exitTable(sqlParser.TableContext ctx) {
        fromTable = ctx.VALID_NAME().getText();
    }*/
}
