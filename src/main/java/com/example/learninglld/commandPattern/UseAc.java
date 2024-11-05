package com.example.learninglld.commandPattern;

import com.example.learninglld.commandPattern.withCmdPattern.ICommand;
import com.example.learninglld.commandPattern.withCmdPattern.MyRemoteControl;
import com.example.learninglld.commandPattern.withCmdPattern.TurnOnAcCommand;
import com.example.learninglld.commandPattern.withoutCmdPattern.AC;

public class UseAc {
    public void useAC() {
        AC ac = new AC();
        ac.turnOn();
        ac.setTemperature(22);
        ac.turnOff();
    }

    public static void useAc1() {
       AC ac = new AC();
       MyRemoteControl remoteControl = new MyRemoteControl();

       remoteControl.setCommand(new TurnOnAcCommand(ac));
       remoteControl.pressButton();
       remoteControl.pressUndo();
    }
}
