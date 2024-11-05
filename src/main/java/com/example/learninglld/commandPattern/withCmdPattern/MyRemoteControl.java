package com.example.learninglld.commandPattern.withCmdPattern;

import java.util.Stack;

public class MyRemoteControl {
    Stack<ICommand> commmandHistory = new Stack<>();
    ICommand currentCommand;

    public void setCommand(ICommand command) {
        currentCommand = command;
    }

    public void pressButton() {
        currentCommand.execute();
        commmandHistory.add(currentCommand);
    }

    public void pressUndo() {
        if (!commmandHistory.isEmpty()) {
            ICommand undoCommand = commmandHistory.pop();
            undoCommand.undo();
        }
    }
}
