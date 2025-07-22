package com.example.learninglld.chainOfResponsibility;

public class LogProcessor {
    public static final Integer INFO = 1;
    public static final Integer DEBUG = 2;
    public static final Integer ERROR = 3;

    LogProcessor nextProcessor;
    LogProcessor(LogProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void log(Integer logger, String message) {
        if(nextProcessor != null) {
            nextProcessor.log(logger, message);
        }
        else {
            System.out.println("No more processors available");
        }
    }
}
