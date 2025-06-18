package com.github.alexandervmalysh.lesson_2_3_4.array;

import java.util.Arrays;

public class UniqueArrayFiller {
    public static void main(String[] args) {
        printNumbers(generateRandomArray(-30, -10, 23), 23);
        printNumbers(generateRandomArray(10, 50, 10), 10);
        printNumbers(generateRandomArray(-34, -34, 0), 0);
        printNumbers(generateRandomArray(-1, 2, -3), -3);
        printNumbers(generateRandomArray(5, -8, 2), 2);
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

        int[] uniqueNumbers = new int[arrayLength];
        int currentIndex = 0;

        while (currentIndex < arrayLength) {
            int randomNum = (int) (Math.random() * (rightRange - leftRange + 1)) + leftRange;
            boolean isUniqueNumber = true;

            for (int i = 0; i < currentIndex; i++) {
                if (uniqueNumbers[i] == randomNum) {
                    isUniqueNumber = false;
                    break;
                }
            }

            if (isUniqueNumber) {
                uniqueNumbers[currentIndex] = randomNum;
                currentIndex++;
            }
        }

        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    private static void printNumbers(int[] uniqueNumbers, int numbersPerLine) {
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
}
