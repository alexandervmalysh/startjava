package com.github.alexandervmalysh.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    public static void main(String[] args) {
        int[] original;
        int[] reversed;

        original = new int[]{};
        reversed = reverse(original);
        printTransactions(original, reversed);

        original = null;
        reversed = reverse(original);
        printTransactions(original, reversed);

        original = new int[]{5};
        reversed = reverse(original);
        printTransactions(original, reversed);

        original = new int[]{6, 8, 9, 1};
        reversed = reverse(original);
        printTransactions(original, reversed);

        original = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversed = reverse(original);
        printTransactions(original, reversed);
    }

    private static int[] reverse(int[] original) {
        if (original == null) {
            return null;
        }

        int len = original.length - 1;
        int[] reversed = new int[original.length];

        for (int element : original) {
            reversed[len--] = element;
        }
        return reversed;
    }

    private static void printTransactions(int[] original, int[] reversed) {
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
}
