package com.github.alexandervmalysh.lesson_2_3_4.array;

public class FactorialCalculator {
    public static void main(String[] args) {
        int[] numbers = {};
        int[] factorials = calculateFactorials(numbers);
        printFactorials(numbers, factorials);

        numbers = null;
        factorials = calculateFactorials(numbers);
        printFactorials(numbers, factorials);

        numbers = new int[]{8, 0, 9};
        factorials = calculateFactorials(numbers);
        printFactorials(numbers, factorials);

        numbers = new int[]{-3, 1, 7, 13};
        factorials = calculateFactorials(numbers);
        printFactorials(numbers, factorials);

        numbers = new int[]{-22, -0};
        factorials = calculateFactorials(numbers);
        printFactorials(numbers, factorials);
    }

    private static int[] calculateFactorials(int... numbers) {
        if (numbers == null) {
            return null;
        }

        int len = numbers.length;
        int[] factorials = new int[len];

        for (int i = 0; i < len; i++) {
            if (numbers[i] < 0) {
                continue;
            }
            int factorialValue = 1;
            for (int j = 1; j < numbers[i]; j++) {
                factorialValue *= j;
            }
            factorials[i] = factorialValue;
        }
        return factorials;
    }

    private static void printFactorials(int[] numbers, int[] factorials) {
        if (numbers == null) {
            System.out.println("Ошибка: массив равен null\n");
            return;
        }

        int len = numbers.length;

        if (len == 0) {
            System.out.println("Ошибка: пустой массив\n");
            return;
        }

        for (int i = 0; i < len; i++) {
            if (numbers[i] < 0) {
                System.out.println("Ошибка: факториал " + numbers[i] + "! не определен");
                continue;
            }
            if (numbers[i] == 0 || numbers[i] == 1) {
                System.out.println(numbers[i] + "! = " + factorials[i]);
            } else {
                StringBuilder stringBuilder = new StringBuilder(numbers[i] + "! = ");
                for (int j = 1; j <= numbers[i]; j++) {
                    stringBuilder.append(String.format("%d%s", j, j != numbers[i] ? " * " : ""));
                }
                stringBuilder.append(" = ").append(factorials[i]);
                System.out.print(stringBuilder + "\n");
            }
        }
        System.out.println();
    }
}
