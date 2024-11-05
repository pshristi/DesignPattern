package com.example.learninglld.flyweightPattern.withFlyweight;

import com.example.learninglld.flyweightPattern.withoutFlyweight.Sprites;

public class RoboticDog implements IRobot {
    private Sprites sprite;
    private String type;

    public RoboticDog(String type, Sprites sprite) {
        this.type = type;
        this.sprite = sprite;
    }

    public Sprites getSprite() {
        return sprite;
    }

    public String getType() {
        return type;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Robotic dog at (" + x + ", " + y + ")");
    }
}
