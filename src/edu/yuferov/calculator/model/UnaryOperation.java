package edu.yuferov.calculator.model;

public abstract class UnaryOperation implements Expression {
    Expression expression;
    String name;

    public UnaryOperation(String name) {
        this.name = name;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public double evaluate() {
        return evaluate(expression.evaluate());
    }

    protected abstract double evaluate(double arg);

    @Override
    public String toString() {
        return String.format("%s(%s)", name, expression.toString());
    }
}
