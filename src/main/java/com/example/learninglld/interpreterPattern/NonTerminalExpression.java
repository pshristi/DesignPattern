package com.example.learninglld.interpreterPattern;

public class NonTerminalExpression implements IExpression {
    private IExpression left;
    private IExpression right;

    public NonTerminalExpression(IExpression left, IExpression right) {
        this.left = left;
        this.right = right;
    }

    public Integer interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}
