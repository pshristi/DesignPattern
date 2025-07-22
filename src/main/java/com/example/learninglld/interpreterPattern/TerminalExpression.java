package com.example.learninglld.interpreterPattern;

public class TerminalExpression implements IExpression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }
    public Integer interpret(Context context) {
        return context.getValue(data);
    }
}
