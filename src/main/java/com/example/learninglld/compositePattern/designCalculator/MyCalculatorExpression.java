package com.example.learninglld.compositePattern.designCalculator;

public class MyCalculatorExpression implements ArithmaticExpr {
    ArithmaticExpr left;
    ArithmaticExpr right;
    MyCalculatorOperation operation;

    MyCalculatorExpression(MyCalculatorOperation operation, ArithmaticExpr left, ArithmaticExpr right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        switch (operation) {
            case ADD:
                return left.evaluate() + right.evaluate();
            case SUBTRACT:
                return left.evaluate() - right.evaluate();
            case MULTIPLY:
                return left.evaluate() * right.evaluate();
            case DIVIDE:
                return left.evaluate() / right.evaluate();
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }
}
