package com.example.learninglld.chainOfResponsibility;

public class ErrorLogProcessor extends LogProcessor {
    ErrorLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void log(Integer logger, String message) {
        if(logger == ERROR) {
            System.out.println("ERROR: " + message);
        }
        else {
            super.log(logger, message);
        }
    }
}
