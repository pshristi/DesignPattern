package com.example.learninglld.flyweightPattern.withFlyweight;

import com.example.learninglld.flyweightPattern.withoutFlyweight.Sprites;

import java.util.HashMap;
import java.util.Map;

public class RoboticFactory {
    Map<String, IRobot> instanceMap;

    public RoboticFactory() {
        instanceMap = new HashMap<>();
    }

    public IRobot getRobot(String type) {
        if(instanceMap.containsKey(type)) {
            return instanceMap.get(type);
        }
        else {
            if(type == "HUMANOID"){
                Sprites humanoidSprite = new Sprites();
                IRobot humanoidObject = new HumanoidRobot(type, humanoidSprite);
                instanceMap.put(type, humanoidObject);
                return humanoidObject;
            }
            else if(type == "ROBOTICDOG"){
                Sprites roboticDogSprite = new Sprites();
                IRobot roboticDogObject = new RoboticDog(type, roboticDogSprite);
                instanceMap.put(type, roboticDogObject);
                return roboticDogObject;
            }
        }
        return null;
    }
}
