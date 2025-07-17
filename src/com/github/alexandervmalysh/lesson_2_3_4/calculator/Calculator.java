package com.github.alexandervmalysh.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPECTED_PARTS_LENGTH = 3;

    public static double calculate(String expression) {
        try {
            String[] parts = validateExpressionParts(expression);

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
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private static String[] validateExpressionParts(String expression) {
        String[] parts = expression.trim().replaceAll("\\s+", " ").split(" ");

        if (parts.length != EXPECTED_PARTS_LENGTH) {
            throw new InvalidExpressionFormatException("Ошибка: неверный формат выражения. " +
                    "Ожидается: число | операция | число");
        }
        return parts;
    }

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка: '" + number + "' не является целым числом");
        }
    }

    private static char parseOperation(String operation) {
        if (operation.length() != 1) {
            throw new IllegalArgumentException("Ошибка: операция должна состоять из одного символа");
        }
        return operation.charAt(0);
    }

    private static void validateDivisionByZero(char operation, int secondNumber) {
        if ((operation == '/' || operation == '%') && secondNumber == 0) {
            throw new ArithmeticException("Ошибка: деление на ноль запрещено");
        }
    }
}
