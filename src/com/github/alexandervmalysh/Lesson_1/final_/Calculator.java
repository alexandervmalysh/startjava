package com.github.alexandervmalysh.lesson_1.final_;

public class Calculator {
    public static void main(String[] args) {
        int firstOperand = 5;
        int secondOperand = 2;
        char operator = '^';
        int result;

        if (operator == '+') {
            result = firstOperand + secondOperand;
        } else if (operator == '-') {
            result = firstOperand - secondOperand;
        } else if (operator == '*') {
            result = firstOperand * secondOperand;
        } else if (operator == '/') {
            if (secondOperand == 0) {
                System.out.println("Ошибка: деление на ноль!");
                return;
            }
            result = firstOperand / secondOperand;
        } else if (operator == '^') {
            result = 1;
            for (int i = 0; i < secondOperand; i++) {
                result *= firstOperand;
            }
        } else if (operator == '%') {
            result = firstOperand % secondOperand;
        } else {
            System.out.println("Ошибка: неизвестный оператор: '" + operator + "'");
            return;
        }
        System.out.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
    }
}