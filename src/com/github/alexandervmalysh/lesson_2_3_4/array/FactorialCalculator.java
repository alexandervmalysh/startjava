package com.github.alexandervmalysh.lesson_2_3_4.array;

public class FactorialCalculator {
    public static void main(String[] args) {
        int[] numbers = {};
        long[] factorials = calcFactorials(numbers);
        printFactorialExpr(numbers, factorials);

        numbers = null;
        factorials = calcFactorials(numbers);
        printFactorialExpr(numbers, factorials);

        numbers = new int[]{8, 0, 9};
        factorials = calcFactorials(numbers);
        printFactorialExpr(numbers, factorials);

        numbers = new int[]{-3, 1, 7, 13};
        factorials = calcFactorials(numbers);
        printFactorialExpr(numbers, factorials);

        numbers = new int[]{-22, -0};
        factorials = calcFactorials(numbers);
        printFactorialExpr(numbers, factorials);
    }

    private static long[] calcFactorials(int... numbers) {
        if (numbers == null) {
            return null;
        }

        long[] factorials = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) continue;

            long factorialValue = 1;
            for (int j = 1; j <= numbers[i]; j++) {
                factorialValue *= j;
            }
            factorials[i] = factorialValue;
        }
        return factorials;
    }

    private static void printFactorialExpr(int[] numbers, long[] factorials) {
        if (numbers == null) {
            System.out.println("Ошибка: массив равен null\n");
            return;
        }

        if (numbers.length == 0) {
            System.out.println("Ошибка: пустой массив\n");
            return;
        }

        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                System.out.println("Ошибка: факториал " + numbers[i] + "! не определен");
                continue;
            }
            if (numbers[i] == 0 || numbers[i] == 1) {
                System.out.println(numbers[i] + "! = " + factorials[i]);
            } else {
                expression.append(numbers[i]).append("! = ");
                for (int j = 1; j <= numbers[i]; j++) {
                    expression.append(j);
                    if (j != numbers[i]) {
                        expression.append(" * ");
                    }
                }
                System.out.println(expression.append(" = ").append(factorials[i]));
                expression.setLength(0);
            }
        }
        System.out.println();
    }
}
