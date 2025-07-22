package com.example.learninglld.factoryPattern;

public class UsePattern {
    public void drawShape() {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("rectangle");
        shape2.draw();
    }
}
