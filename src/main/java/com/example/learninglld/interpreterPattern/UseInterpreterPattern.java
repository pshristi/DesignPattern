package com.example.learninglld.interpreterPattern;

public class UseInterpreterPattern {
    public static void useInterpreterPattern() {
        Context context = new Context();
        context.assignValue("a", 10);
        context.assignValue("b", 20);

        IExpression expression = new NonTerminalExpression(
                new TerminalExpression("a"),
                new NonTerminalExpression(
                        new TerminalExpression("a"),
                        new TerminalExpression("b")
                )
        );

        System.out.println("Result: " + expression.interpret(context));
    }
}
