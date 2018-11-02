package edu.yuferov.calculator.model.operations;

import edu.yuferov.calculator.model.UnaryOperation;

public class Negate extends UnaryOperation {
    public Negate() {
        super("negate");
    }

    @Override
    protected double evaluate(double arg) {
        return -arg;
    }
}