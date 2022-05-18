package org.maslov.antrl4demo.calcparser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalcParserListener extends CalcBaseListener {

    private int value;

    public int getValue() {
        return value;
    }

    @Override
    public void enterList(CalcParser.ListContext ctx) {
      log.info( ctx.DIGIT().getSymbol().getText());

    }

    @Override
    public void exitList(CalcParser.ListContext ctx) {
        log.info( ctx.DIGIT().getSymbol().getText());
    }


}
