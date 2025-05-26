package com.github.alexandervmalysh.lesson_2_3.calculator;

public class Calculator {
    private int firstNumber;
    private int secondNumber;
    private char operation;

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public void calculate() {
        if ((operation == '/' || operation == '%') && secondNumber == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return;
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
                result = firstNumber / secondNumber;
                break;
            case '^':
                result = power(firstNumber, secondNumber);
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
            default:
                System.out.println("Ошибка: операция " + operation + " не поддерживается");
                return;
        }
        System.out.println("Результат вычисления: " + result);
    }

    private double power(int firstNumber, int secondNumber) {
        double result = 1.0;
        int absSecondNumber = Math.abs(secondNumber);
        for (int i = 0; i < absSecondNumber; i++) {
            result *= firstNumber;
        }
        return secondNumber < 0 ? 1 / result : result;
    }
}