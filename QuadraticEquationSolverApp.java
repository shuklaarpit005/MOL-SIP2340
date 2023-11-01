package project;

import javax.swing.*;
import java.awt.*;

class QuadraticEquationSolverApp extends JFrame {
    private final JTextField    coefATextField;
    private final JTextField coefBTextField;
    private final JTextField coefCTextField;
    private final JTextArea resultTextArea;

    public QuadraticEquationSolverApp() {
        setTitle("Quadratic Equation Solver");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("Enter coefficient a: "));
        coefATextField = new JTextField();
        panel.add(coefATextField);

        panel.add(new JLabel("Enter coefficient b: "));
        coefBTextField = new JTextField();
        panel.add(coefBTextField);

        panel.add(new JLabel("Enter coefficient c: "));
        coefCTextField = new JTextField();
        panel.add(coefCTextField);

        JButton solveButton = new JButton("Solve");
        panel.add(solveButton);

        solveButton.addActionListener(e -> solveQuadraticEquation());

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        panel.add(resultTextArea);

        add(panel);
    }

    private void solveQuadraticEquation() {
        try {
            double a = Double.parseDouble(coefATextField.getText());
            double b = Double.parseDouble(coefBTextField.getText());
            double c = Double.parseDouble(coefCTextField.getText());

            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                resultTextArea.setText("Two distinct real roots:\nRoot 1 = " + root1 + "\nRoot 2 = " + root2);
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                resultTextArea.setText("One real root:\nRoot = " + root);
            } else {
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
                resultTextArea.setText("Complex roots:\nRoot 1 = " + realPart + " + " + imaginaryPart + "i\nRoot 2 = " + realPart + " - " + imaginaryPart + "i");
            }
        } catch (NumberFormatException ex) {
            resultTextArea.setText("Invalid input. Please enter valid coefficients.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuadraticEquationSolverApp().setVisible(true));
    }
}

