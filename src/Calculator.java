import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private static String currentInput = "";
    private static String operator = "";
    private static double firstNumber = 0;

    public static void main(String[] args) {
        // Window
        JFrame frame = new JFrame("计算器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        // TextField
        JTextField displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font("Arial", Font.PLAIN, 24));
        displayField.setPreferredSize(new Dimension(300, 60));
        frame.setLayout(new BorderLayout());
        frame.add(displayField, BorderLayout.NORTH);

        // Button
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleButtonClick(label, displayField);
                }
            });
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // 核心按钮点击处理方法
    private static void handleButtonClick(String label, JTextField displayField) {
        if (label.matches("[0-9.]")) {
            // 处理数字和小数点输入
            currentInput += label;
            displayField.setText(currentInput);
        } else if (label.matches("[+\\-*/]")) {
            // 处理运算符输入
            if (!currentInput.isEmpty()) {
                firstNumber = Double.parseDouble(currentInput);
                operator = label;
                currentInput = "";
            }
        } else if (label.equals("=")) {
            // 处理等号，执行计算
            if (!currentInput.isEmpty() && !operator.isEmpty()) {
                double secondNumber = Double.parseDouble(currentInput);
                double result = 0;
                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        if (secondNumber != 0) {
                            result = firstNumber / secondNumber;
                        } else {
                            displayField.setText("错误");
                            currentInput = "";
                            operator = "";
                            return;
                        }
                        break;
                }
                displayField.setText(String.valueOf(result));
                currentInput = String.valueOf(result);
                operator = "";
            }
        }
    }
}