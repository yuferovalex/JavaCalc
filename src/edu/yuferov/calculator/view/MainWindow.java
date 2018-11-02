package edu.yuferov.calculator.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import edu.yuferov.calculator.model.*;
import edu.yuferov.calculator.model.operations.*;

public class MainWindow {
    public JPanel contentPane;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton divisionOperationButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a0Button;
    private JButton decimalSeparatorButton;
    private JButton clearFieldButton;
    private JButton fullClearButton;
    private JButton resultButton;
    private JTextField resultTextField;
    private JButton multiplicationOperationButton;
    private JButton negateOperationButton;
    private JButton substractionOperationButton;
    private JButton additionOperationButton;
    private JButton backspaceButton;
    private JButton sqrtOperationButton;
    private JLabel expressionLabel;

    boolean mustClearValue = false;
    boolean mustFullClear = false;
    boolean decimalPoint = false;
    Performer performer;

    public MainWindow(Performer performer) {
        this.performer = performer;

        initNumberButtonsListeners();
        decimalSeparatorButton.addActionListener(e -> this.addDecimalPoint());
        clearFieldButton.addActionListener(e -> this.clearCurrentValue());
        backspaceButton.addActionListener(e -> this.removeLastSymbol());
        negateOperationButton.addActionListener(e -> this.performOperation(new Negate()));
        additionOperationButton.addActionListener(e -> this.performOperation(new Addition()));
        substractionOperationButton.addActionListener(e -> this.performOperation(new Subtraction()));
        multiplicationOperationButton.addActionListener(e -> this.performOperation(new Multiplication()));
        divisionOperationButton.addActionListener(e -> this.performOperation(new Division()));
        sqrtOperationButton.addActionListener(e -> this.performOperation(new Sqrt()));
        resultButton.addActionListener(e -> this.evaluateFullResult());
        fullClearButton.addActionListener(e -> this.fullClear());
    }

    public void updateExpressionString() {
        expressionLabel.setText(performer.getExpressionString());
    }

    public void clearExpressionString() {
        expressionLabel.setText("");
    }

    public void evaluateFullResult() {
        double result = performer.getFullResult();
        fullClear();
        resultTextField.setText(String.valueOf(result));
        performer.setValue(new Constant(result));
        mustClearValue = true;
    }

    public void addDecimalPoint() {
        fullClearIfNeeded();
        clearCurrentValueIfNeeded();
        if (decimalPoint) {
            return;
        }
        decimalPoint = true;
        resultTextField.setText(resultTextField.getText() + getDecimalSeparator());
    }

    public void addNumber(String number) {
        fullClearIfNeeded();
        clearCurrentValueIfNeeded();
        if (resultTextField.getText().equals("0")) {
            resultTextField.setText(number);
        } else {
            resultTextField.setText(resultTextField.getText() + number);
        }
        passNumber();
    }

    public void passNumber() {
        String text = resultTextField.getText();
        double value = Double.parseDouble(text);
        performer.setValue(new Constant(value));
    }

    public void performOperation(UnaryOperation operation) {
        performer.applyOperation(operation);
        mustFullClear = true;
        updateExpressionString();
        updateCurrentResult();
    }

    public void performOperation(BinaryOperation operation) {
        performer.applyOperation(operation);
        mustClearValue = true;
        mustFullClear = false;
        updateExpressionString();
        passNumber();
    }

    public void clearCurrentValueIfNeeded() {
        if (mustClearValue) {
            clearCurrentValue();
        }
    }

    public void fullClearIfNeeded() {
        if (mustFullClear) {
            fullClear();
        }
    }

    public void fullClear() {
        performer.clear();
        clearCurrentValue();
        clearExpressionString();
        mustFullClear = false;
    }

    public void updateCurrentResult() {
        double currentResult = performer.getCurrentResult();
        String text = String.valueOf(currentResult);
        resultTextField.setText(text);
    }

    public void clearCurrentValue() {
        resultTextField.setText("0");
        performer.setValue(new Constant(0));
        decimalPoint = false;
        mustClearValue = false;
    }

    public void removeLastSymbol() {
        String currentValue = resultTextField.getText();
        String newValue = currentValue.substring(0, currentValue.length() - 1);
        if (newValue.length() == 0) {
            resultTextField.setText("0");
        }
        else {
            resultTextField.setText(newValue);
        }
        passNumber();
    }

    private void initNumberButtonsListeners() {
        ActionListener listener = (e) -> {
            JButton sourceButton = (JButton) e.getSource();
            String number = sourceButton.getText();
            this.addNumber(number);
        };

        a0Button.addActionListener(listener);
        a1Button.addActionListener(listener);
        a2Button.addActionListener(listener);
        a3Button.addActionListener(listener);
        a4Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a6Button.addActionListener(listener);
        a7Button.addActionListener(listener);
        a8Button.addActionListener(listener);
        a9Button.addActionListener(listener);
    }

    static private char getDecimalSeparator() {
        // DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
        // DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
        // return symbols.getDecimalSeparator();
        return '.';
    }
}
