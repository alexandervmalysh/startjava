package com.github.alexandervmalysh.lesson_2_3_4.calculator;

public class Calculator {
    public double calculate(String expression) {
        String[] parts = expression.split(" ");

        if (parts.length != 3) {
            System.out.println("Ошибка: неверный формат выражения");
            return Double.NaN;
        }

        int firstNumber = Integer.parseInt(parts[0]);
        char operation = parts[1].charAt(0);
        int secondNumber = Integer.parseInt(parts[2]);

        if ((operation == '/' || operation == '%') && secondNumber == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return Double.NaN;
        }

        switch (operation) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                return (double) firstNumber / secondNumber;
            case '^':
                return Math.pow(firstNumber, secondNumber);
            case '%':
                return Math.floorMod(firstNumber, secondNumber);
            default:
                System.out.println("Ошибка: операция " + operation + " не поддерживается");
                return Double.NaN;
        }
    }
}