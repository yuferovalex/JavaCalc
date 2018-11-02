package edu.yuferov.calculator.model.operations;

import edu.yuferov.calculator.model.BinaryOperation;

public class Addition extends BinaryOperation {
    public Addition() {
        super('+');
    }

    protected double evaluate(double left, double right) {
        return left + right;
    }
}
