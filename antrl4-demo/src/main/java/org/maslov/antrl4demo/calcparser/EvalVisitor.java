package org.maslov.antrl4demo.calcparser;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends CalcBaseVisitor<Integer> {

    Map<String, Integer> memory = new HashMap<>();


    @Override
    public Integer visitProg(CalcParser.ProgContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitPrintExpr(CalcParser.PrintExprContext ctx) {
        int value = visit(ctx.expr());
        return value;
    }

    @Override
    public Integer visitAssign(CalcParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Integer visitBlank(CalcParser.BlankContext ctx) {
        return 0;
    }

    @Override
    public Integer visitMulDiv(CalcParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == CalcParser.MUL) {
            return left * right;
        } else {
            return left / right;
        }

    }

    @Override
    public Integer visitAddSub(CalcParser.AddSubContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == CalcParser.ADD) {
            return left + right;
        } else {
            return left - right;
        }

    }

    @Override
    public Integer visitId(CalcParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if ( memory.containsKey(id) ) return memory.get(id);
        return 0;
    }

    @Override
    public Integer visitInt(CalcParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    @Override
    public Integer visitParents(CalcParser.ParentsContext ctx) {
        return visit(ctx.expr());
    }

}
