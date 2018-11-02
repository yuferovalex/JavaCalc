package edu.yuferov.calculator.model;

public interface Performer {
    void setValue(Constant constant);
    void applyOperation(UnaryOperation operation);
    void applyOperation(BinaryOperation operation);
    String getExpressionString();
    double getCurrentResult();
    double getFullResult();
    void clear();
}
