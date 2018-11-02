package edu.yuferov.calculator;

import edu.yuferov.calculator.view.*;
import edu.yuferov.calculator.model.Model;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setContentPane(new MainWindow(new Model()).contentPane);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }
}
