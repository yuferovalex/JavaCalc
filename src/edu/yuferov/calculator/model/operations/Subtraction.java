package edu.yuferov.calculator.model.operations;

import edu.yuferov.calculator.model.BinaryOperation;

public class Subtraction extends BinaryOperation {
    public Subtraction() {
        super('-');
    }

    protected double evaluate(double left, double right) {
        return left - right;
    }
}
