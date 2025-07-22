package com.example.learninglld.interpreterPattern;

import java.util.HashMap;
import java.util.Map;

public class Context {

    Map<String, Integer> contextMap = new HashMap<>();

    public void assignValue(String variable, int value) {
        contextMap.put(variable, value);
    }

    public int getValue(String variable) {
        return contextMap.get(variable);
    }
}
