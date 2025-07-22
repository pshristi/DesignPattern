package com.example.learninglld.commandPattern.withoutCmdPattern;

public class AC {
    private boolean isOn;
    private int currentTemperature;

    public AC() {
        isOn = false;
        currentTemperature = 20;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("AC is on");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("AC is off");
    }

    public void setTemperature(int temperature) {
        currentTemperature = temperature;
        System.out.println("AC temperature is set to " + currentTemperature);
    }
}
