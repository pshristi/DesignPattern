package com.example.learninglld.chainOfResponsibility;

public class LoggerUsage {
    public static void useLogger() {
        LogProcessor infoProcessor = new InfoLogProcessor(new ErrorLogProcessor(null));
        infoProcessor.log(LogProcessor.INFO, "This is an info message");
        infoProcessor.log(LogProcessor.DEBUG, "This is a warning message");
        infoProcessor.log(LogProcessor.ERROR, "This is an error message");
    }
}
