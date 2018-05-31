package com.qyfei;
import com.qyfei.Shape;
public class Rectangle extends Shape {
    @Override
    public float perimeter() {
        float a=3.0f;
        float b=2.5f;
        return (a + b) * 2;
    }

    @Override
    public float area() {
        float a=3.0f;
        float b=2.5f;
        return a * b;
    }
}
