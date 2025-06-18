package com.github.alexandervmalysh.lesson_2_3_4.array;

import java.util.Arrays;

public class UniqueArrayFiller {
    public static void main(String[] args) {
        int[] numbers = generateRandomArray(-30, -10, 23);
        printSortNumbers(numbers, 23);

        numbers = generateRandomArray(10, 50, 10);
        printSortNumbers(numbers, 10);

        numbers = generateRandomArray(-34, -34, 0);
        printSortNumbers(numbers, 0);

        numbers = generateRandomArray(-1, 2, -3);
        printSortNumbers(numbers, -3);

        numbers = generateRandomArray(5, -8, 2);
        printSortNumbers(numbers, 2);
    }

    private static int[] generateRandomArray(int leftRange, int rightRange, int numbersPerLine) {
        if (numbersPerLine < 1) {
            System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)%n%n",
                    numbersPerLine);
            return null;
        }

        if (leftRange > rightRange) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", leftRange, rightRange);
            return null;
        }

        int arrayLength = (int) ((rightRange - leftRange + 1) * 0.75);

        if (arrayLength <= 0) {
            System.out.printf("Ошибка: длина массива должна быть больше 0 (%d)%n%n", arrayLength);
            return null;
        }

        int[] numbers = new int[arrayLength];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * (rightRange - leftRange + 1)) + leftRange;
        }

        Arrays.sort(numbers);
        return numbers;
    }

    private static void printSortNumbers(int[] numbers, int numbersPerLine) {
        if (numbers == null) {
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d%s", numbers[i], (i + 1) % numbersPerLine == 0 ? "\n" : " ");
        }

        if (numbers.length % numbersPerLine != 0) {
            System.out.println();
        }

        System.out.println();
    }
}
