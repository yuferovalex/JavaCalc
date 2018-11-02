package edu.yuferov.calculator.model;

public class Constant implements Expression {
    final double value;

    public Constant(double value) {
        this.value = value;
    }

    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}