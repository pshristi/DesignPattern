package com.example.learninglld.commandPattern.withCmdPattern;

import com.example.learninglld.commandPattern.withoutCmdPattern.AC;

public class TurnOnAcCommand implements ICommand {
    AC ac;

    public TurnOnAcCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOn();
    }

    @Override
    public void undo() {
        ac.turnOff();
    }
}
