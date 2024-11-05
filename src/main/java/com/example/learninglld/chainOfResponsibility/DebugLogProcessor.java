package com.example.learninglld.chainOfResponsibility;

public class DebugLogProcessor extends LogProcessor {
    DebugLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void log(Integer logger, String message) {
        if(logger == DEBUG) {
            System.out.println("DEBUG: " + message);
        }
        else {
            super.log(logger, message);
        }
    }
}
