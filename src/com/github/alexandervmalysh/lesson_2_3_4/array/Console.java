package com.github.alexandervmalysh.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";
    private static final String RESET = "\033[0m";

    private Console() {
    }

    public static void printArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f", array[i]);

            if ((i + 1) % 8 == 0 || i == array.length - 1) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }

    public static void printArrayComparison(float[] original, float[] modified, int index) {
        if (modified == null) {
            return;
        }

        System.out.println("Исходный массив: ");
        printArray(original);

        System.out.printf("Значение из ячейки по индексу %d: %.3f%n", index, modified[index]);
        System.out.println("Измененный массив:");
        printArray(modified);

        int zeroedCount = 0;
        for (float numbers : original) {
            if (numbers > modified[index]) {
                zeroedCount++;
            }
        }

        System.out.printf("Количество обнуленных ячеек: %d%n%n", zeroedCount);
    }

    public static void printCharTriangle(StringBuilder charTriangle) {
        if (charTriangle == null) {
            return;
        }

        System.out.println(charTriangle);
    }

    public static void printFactorialExpr(int[] numbers, long[] factorials) {
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

    public static void printHackingResult(boolean isAccessGranted) {
        System.out.printf("%s%s", isAccessGranted
                ? GREEN + "Access Granted!\n\n"
                : RED + "Access Denied!\n\n", RESET);
    }

    public static void printNumbers(int[] uniqueNumbers, int numbersPerLine) {
        if (uniqueNumbers == null) {
            return;
        }

        for (int i = 0; i < uniqueNumbers.length; i++) {
            System.out.printf("%d%s", uniqueNumbers[i], (i + 1) % numbersPerLine == 0 ? "\n" : " ");
        }

        if (uniqueNumbers.length % numbersPerLine != 0) {
            System.out.println();
        }

        System.out.println();
    }

    public static void printTransactions(int[] original, int[] reversed) {
        if (original == null) {
            System.out.println("Ошибка: массив равен null\n");
            return;
        }

        int len = original.length;
        if (len == 0) {
            System.out.println("Ошибка: пустой массив\n");
            return;
        }
        System.out.println("Исходные транзакции: " + Arrays.toString(original));
        System.out.println(" В обратном порядке: " + Arrays.toString(reversed) + '\n');
    }

    public static void type(String enteredText) throws InterruptedException {
        if (enteredText == null || enteredText.isBlank()) {
            return;
        }

        for (String ch : enteredText.split("")) {
            System.out.print(ch);
            Thread.sleep(80);
        }
        System.out.println("\n");
    }
}
