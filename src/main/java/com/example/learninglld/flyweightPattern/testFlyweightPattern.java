package com.example.learninglld.flyweightPattern;

import com.example.learninglld.flyweightPattern.withFlyweight.HumanoidRobot;
import com.example.learninglld.flyweightPattern.withFlyweight.IRobot;
import com.example.learninglld.flyweightPattern.withFlyweight.RoboticFactory;
import com.example.learninglld.flyweightPattern.withoutFlyweight.Robot;
import com.example.learninglld.flyweightPattern.withoutFlyweight.Sprites;

public class testFlyweightPattern {
    public static void testFlyweight1() {
        Integer size = 0;
        for (int i = 0; i < 500000; i++) {
            Robot robot = new Robot();
            robot.setType("HUMANOID");
            robot.setSprite(new Sprites());
            robot.setX(i % 100);
            robot.setY(i / 100);
            size += robot.getSize();
        }
        //100*500000 bytes
    }

    public static void testFlyweight2() {
        RoboticFactory roboticFactory = new RoboticFactory();
        IRobot humanoidRobot = roboticFactory.getRobot("HUMANOID");
        for (int i = 0; i < 500000; i++) {
            humanoidRobot.display(i % 100, i / 100);
        }
    }
}
