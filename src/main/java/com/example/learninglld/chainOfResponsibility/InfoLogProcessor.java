package com.example.learninglld.chainOfResponsibility;

public class InfoLogProcessor extends LogProcessor {
    InfoLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void log(Integer logger, String message) {
        if(logger == INFO) {
            System.out.println("INFO: " + message);
        }
        else {
           super.log(logger, message);
        }
    }
}
