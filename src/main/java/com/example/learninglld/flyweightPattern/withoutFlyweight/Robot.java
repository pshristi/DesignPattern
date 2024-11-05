package com.example.learninglld.flyweightPattern.withoutFlyweight;

public class Robot {
    String type;
    Integer x;
    Integer y;
    Sprites sprite;

    public void display() {
        // render the robot on the screen
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSprite(Sprites sprite) {
        this.sprite = sprite;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getSize() {
        // return the size of the robot
        return this.type.length() + 4 + 4 + 100;
    }
}
