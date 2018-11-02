package edu.yuferov.calculator.model.operations;

import edu.yuferov.calculator.model.BinaryOperation;

public class Multiplication extends BinaryOperation {
    public Multiplication() {
        super('*');
    }

    protected double evaluate(double left, double right) {
        return left * right;
    }
}
