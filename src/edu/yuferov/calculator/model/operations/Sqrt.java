package edu.yuferov.calculator.model.operations;

import edu.yuferov.calculator.model.UnaryOperation;

public class Sqrt extends UnaryOperation {
    public Sqrt() {
        super("sqrt");
    }

    @Override
    protected double evaluate(double arg) {
        return Math.sqrt(arg);
    }
}
