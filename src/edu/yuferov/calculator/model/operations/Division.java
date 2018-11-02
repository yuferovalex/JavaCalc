package edu.yuferov.calculator.model.operations;

import edu.yuferov.calculator.model.BinaryOperation;

public class Division extends BinaryOperation {
    public Division() {
        super('/');
    }

    protected double evaluate(double left, double right) {
        return left / right;
    }
}
