package com.example.learninglld;

import com.example.learninglld.chainOfResponsibility.LoggerUsage;
import com.example.learninglld.compositePattern.designCalculator.MyCalculatorUsage;
import com.example.learninglld.compositePattern.designFilesystem.fileSystemCorrectUsage;
import com.example.learninglld.compositePattern.problemStatement.fileSystemUsage;
import com.example.learninglld.interpreterPattern.UseInterpreterPattern;
import com.example.learninglld.shoppingCartCoupon.UseShoppingCartWithCoupons;
import com.example.learninglld.visitorPattern.UseVisitorPattern;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningLldApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningLldApplication.class, args);
        UseInterpreterPattern.useInterpreterPattern();

    }

}
