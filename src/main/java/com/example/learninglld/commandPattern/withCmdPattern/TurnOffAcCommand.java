package com.example.learninglld.commandPattern.withCmdPattern;

import com.example.learninglld.commandPattern.withoutCmdPattern.AC;

public class TurnOffAcCommand implements ICommand {
    AC ac;

    public TurnOffAcCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOff();
    }

    @Override
    public void undo() {
        ac.turnOn();
    }
}
