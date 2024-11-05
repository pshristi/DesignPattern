package com.example.learninglld.compositePattern.designCalculator;

import static com.example.learninglld.compositePattern.designCalculator.MyCalculatorOperation.ADD;
import static com.example.learninglld.compositePattern.designCalculator.MyCalculatorOperation.MULTIPLY;

public class MyCalculatorUsage {
    public static void useCalculator() {
        //3*(4+5) = 3*9 = 27
        ArithmaticExpr number4 = new NumberExpr(4);
        ArithmaticExpr number9 = new NumberExpr(9);
        ArithmaticExpr add = new MyCalculatorExpression(ADD, number4, number9);
        ArithmaticExpr multiply = new MyCalculatorExpression(MULTIPLY, new NumberExpr(3), add);
        System.out.println("Results : " + multiply.evaluate());
    }
}
