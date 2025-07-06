package com.github.alexandervmalysh.lesson_2_3_4.calculator;

public class Calculator {
    public double calculate(String expression) {
        String[] parts = expression.split(" ");

        if (parts.length != 3) {
            System.out.println("Ошибка: неверный формат выражения");
            return Double.NaN;
        }

        if (!isInteger(parts[0]) || !isInteger(parts[2])) {
            System.out.println("Ошибка: неверный формат чисел");
            return Double.NaN;
        }

        int firstNumber = Integer.parseInt(parts[0]);
        char operation = parts[1].charAt(0);
        int secondNumber = Integer.parseInt(parts[2]);

        if ((operation == '/' || operation == '%') && secondNumber == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return Double.NaN;
        }

        double result = 0.0;

        switch (operation) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = (double) firstNumber / secondNumber;
                break;
            case '^':
                result = Math.pow(firstNumber, secondNumber);
                break;
            case '%':
                result = Math.floorMod(firstNumber, secondNumber);
                break;
            default:
                System.out.println("Ошибка: операция " + operation + " не поддерживается");
                return Double.NaN;
        }

        return result;
    }

    private boolean isInteger(String s) {
        if (s.isEmpty()) return false;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                continue;
            }

            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}