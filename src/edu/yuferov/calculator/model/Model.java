package edu.yuferov.calculator.model;

public class Model implements Performer {
    BinaryOperation head = new RootOperation();

    @Override
    public void setValue(Constant constant) {
        head.setRight(constant);
    }

    @Override
    public void applyOperation(UnaryOperation operation) {
        operation.setExpression(head.getRight());
        head.setRight(operation);
    }

    @Override
    public void applyOperation(BinaryOperation operation) {
        operation.setLeft(head);
        head = operation;
    }

    @Override
    public String getExpressionString() {
        return head.toString();
    }

    @Override
    public double getCurrentResult() { return head.right.evaluate(); }

    @Override
    public double getFullResult() {
        return head.evaluate();
    }

    @Override
    public void clear() {
        head = new RootOperation();
    }
}

class RootOperation extends BinaryOperation {
    public RootOperation() {
        super('\0');
        setRight(new Constant(0));
    }

    @Override
    public double evaluate() {
        return getRight().evaluate();
    }

    @Override
    protected double evaluate(double l, double r) { return 0.0; }

    @Override
    public String toString() {
        return getRight().toString();
    }
}