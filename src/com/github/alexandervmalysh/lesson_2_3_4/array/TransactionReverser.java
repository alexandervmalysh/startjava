package com.github.alexandervmalysh.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    public static void main(String[] args) {
        displayResult(new int[]{});
        displayResult(null);
        displayResult(new int[]{5});
        displayResult(new int[]{6, 8, 9, 1});
        displayResult(new int[]{13, 8, 5, 3, 2, 1, 1});
    }

    private static void displayResult(int[] original) {
        if (original == null) {
            System.out.println("Ошибка: массив равен null\n");
            return;
        }
        if (original.length == 0) {
            System.out.println("Ошибка: пустой массив\n");
            return;
        }
        System.out.println("Исходные транзакции: " + Arrays.toString(original));
        System.out.println(" В обратном порядке: " + Arrays.toString(reverse(original)) + '\n');
    }

    private static int[] reverse(int[] original) {
        int[] reversed = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[original.length - 1 - i] = original[i];
        }
        return reversed;
    }
}
