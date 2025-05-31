package com.github.alexandervmalysh.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    public static void main(String[] args) {
        int[] original1 = {};
        int[] reversed1 = reverse(original1);
        printTransaction(original1, reversed1);

        int[] original2 = null;
        int[] reversed2 = reverse(original2);
        printTransaction(original2, reversed2);

        int[] original3 = {5};
        int[] reversed3 = reverse(original3);
        printTransaction(original3, reversed3);

        int[] original4 = {6, 8, 9, 1};
        int[] reversed4 = reverse(original4);
        printTransaction(original4, reversed4);

        int[] original5 = {13, 8, 5, 3, 2, 1, 1};
        int[] reversed5 = reverse(original5);
        printTransaction(original5, reversed5);
    }

    private static void printTransaction(int[] original, int[] reversed) {
        if (original == null) {
            System.out.println("Ошибка: массив равен null\n");
            return;
        }
        if (original.length == 0) {
            System.out.println("Ошибка: пустой массив\n");
            return;
        }
        System.out.println("Исходные транзакции: " + Arrays.toString(original));
        System.out.println(" В обратном порядке: " + Arrays.toString(reversed) + '\n');
    }

    private static int[] reverse(int[] original) {
        if (original == null) {
            return null;
        }

        int[] reversed = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[original.length - 1 - i] = original[i];
        }
        return reversed;
    }
}
