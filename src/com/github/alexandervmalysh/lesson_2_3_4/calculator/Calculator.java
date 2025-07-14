package com.github.alexandervmalysh.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPECTED_PARTS_LENGTH = 3;

    public static double calculate(String expression) {
        try {
            String trimmedExpression = expression.trim();
            String[] parts = trimmedExpression.split("\\s+");

            validateExpressionParts(parts);

            int firstNumber = parseNumber(parts[0]);
            char operation = parseOperation(parts[1]);
            int secondNumber = parseNumber(parts[2]);

            validateDivisionByZero(operation, secondNumber);

            return switch (operation) {
                case '+' -> firstNumber + secondNumber;
                case '-' -> firstNumber - secondNumber;
                case '*' -> firstNumber * secondNumber;
                case '/' -> (double) firstNumber / secondNumber;
                case '^' -> Math.pow(firstNumber, secondNumber);
                case '%' -> Math.floorMod(firstNumber, secondNumber);
                default -> throw new UnsupportedOperationException("Операция " + operation +
                        " не поддерживается");
            };
        } catch (IllegalArgumentException | UnsupportedOperationException | ArithmeticException exception) {
            System.out.println(exception.getMessage());
            throw exception;
        }
    }

    private static void validateExpressionParts(String[] parts) {
        if (parts.length != EXPECTED_PARTS_LENGTH) {
            throw new IllegalArgumentException("Ошибка: неверный формат выражения. " +
                    "Ожидается: число | операция | число");
        }
    }

    private static int parseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ошибка: '" + numberStr + "' не является целым числом");
        }
    }

    private static char parseOperation(String operationStr) {
        if (operationStr.length() != 1) {
            throw new IllegalArgumentException("Ошибка: операция должна состоять из одного символа");
        }
        return operationStr.charAt(0);
    }

    private static void validateDivisionByZero(char operation, int secondNumber) {
        if ((operation == '/' || operation == '%') && secondNumber == 0) {
            throw new ArithmeticException("Ошибка: деление на ноль запрещено");
        }
    }
}
