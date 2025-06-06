package com.github.alexandervmalysh.lesson_2_3_4.array;

public class ArrayThresholdFilter {
    public static void main(String[] args) {
        float[] original = generateRandomArray();

        float[] modified = filterAboveIndexValue(original, -1);
        printArrayComparison(original, modified, -1);

        modified = filterAboveIndexValue(original, 15);
        printArrayComparison(original, modified, 15);

        modified = filterAboveIndexValue(original, 0);
        printArrayComparison(original, modified, 0);

        modified = filterAboveIndexValue(original, 14);
        printArrayComparison(original, modified, 14);
    }

    private static float[] generateRandomArray() {
        float[] original = new float[15];

        for (int i = 0; i < original.length; i++) {
            original[i] = (float) Math.random();
        }

        return original;
    }

    private static float[] filterAboveIndexValue(float[] original, int index) {
        int length = original.length;

        if (index < 0 || index >= length) {
            System.out.printf("Ошибка: индекс %d недопустим. Допустимые индексы: от 0 до %d%n%n",
                    index, length - 1);
            return null;
        }

        float[] modified = new float[length];

        for (int i = 0; i < length; i++) {
            if (original[i] > original[index]) {
                modified[i] = 0;
                continue;
            }

            modified[i] = original[i];
        }

        return modified;
    }

    private static void printArrayComparison(float[] original, float[] modified, int index) {
        if (modified == null) {
            return;
        }

        System.out.println("Исходный массив: ");
        printArray(original, 8);

        System.out.printf("Значение из ячейки по индексу %d: %.3f%n", index, modified[index]);
        System.out.println("Измененный массив:");
        printArray(modified, 7);

        int zeroedCount = 0;
        for (float numbers : original) {
            if (numbers > modified[index]) {
                zeroedCount++;
            }
        }

        System.out.printf("Количество обнуленных ячеек: %d%n%n", zeroedCount);
    }

    private static void printArray(float[] array, int numbersPerLine) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f", array[i]);

            if ((i + 1) % numbersPerLine == 0 || i == array.length - 1) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }
}
