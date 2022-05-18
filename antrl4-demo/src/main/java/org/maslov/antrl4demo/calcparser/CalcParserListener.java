package org.maslov.antrl4demo.calcparser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalcParserListener extends CalcBaseListener {

    private int value;
    private int action = 1;

    public int getValue() {
        return value;
    }

    @Override
    public void enterList(CalcParser.ListContext ctx) {
      log.info( "enterList" + ctx.DIGIT().getSymbol().getText());
      int digit = Integer.parseInt(ctx.DIGIT().getSymbol().getText());
      value += digit * action;
      if (ctx.getChild(1) != null) {
          if (ctx.getChild(1).getText().equals("+")) {
              action = 1;
          } else if (ctx.getChild(1).getText().equals("-")) {
              action = -1;
          } else {
              throw new IllegalStateException("Illegal token. Token text:" + ctx.getChild(1).getText());
          }
      }

    }

    @Override
    public void exitList(CalcParser.ListContext ctx) {
        log.info( "exitList" + ctx.DIGIT().getSymbol().getText());
    }


}
