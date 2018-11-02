package edu.yuferov.calculator.model;

public abstract class BinaryOperation implements Expression {
    Expression left;
    Expression right;
    char symbol;

    public BinaryOperation(char symbol) {
        this.symbol = symbol;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public double evaluate() {
        return evaluate(left.evaluate(), right.evaluate());
    }

    protected abstract double evaluate(double left, double right);

    @Override
    public String toString() {
        String rightString = right == null ? "" : right.toString();
        return String.format("%s %c %s", left.toString(), symbol, rightString);
    }
}
