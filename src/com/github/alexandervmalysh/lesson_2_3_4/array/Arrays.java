package com.github.alexandervmalysh.lesson_2_3_4.array;

public class Arrays {
    private Arrays() {
    }

    public static StringBuilder buildCharTriangle(char leftBorder, char rightBorder, boolean direction) {
        if (leftBorder > rightBorder) {
            System.out.printf("Ошибка: левая граница %d > правой %d%n%n",
                    (int) leftBorder, (int) rightBorder);
            return null;
        }

        char[] chars = new char[rightBorder - leftBorder + 1];
        int len = chars.length;

        for (int i = 0; i < len; i++) {
            chars[i] = direction ? leftBorder++ : rightBorder--;
        }

        StringBuilder charTriangle = new StringBuilder();

        for (int i = 0; i < len; i++) {
            charTriangle.repeat(" ", len - 1 - i);
            charTriangle.append(chars[i]).repeat(chars[i], i * 2).append("\n");
        }

        return charTriangle;
    }

    public static long[] calcFactorials(int... numbers) {
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

    public static float[] filterAboveIndexValue(float[] original, int index) {
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

    public static float[] generateRandomArray() {
        float[] original = new float[15];

        for (int i = 0; i < original.length; i++) {
            original[i] = (float) Math.random();
        }

        return original;
    }

    public static int[] fillUniqueSorted(int leftRange, int rightRange, int numbersPerLine) {
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

        java.util.Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    public static int[] reverse(int[] original) {
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

    public static boolean simulateHacking() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        int len = spins.length;

        System.out.print("Hacking:  ");
        for (int i = 0; i < 3 * len; i++) {
            System.out.print("\b" + spins[i % len]);
            Thread.sleep(250);
        }
        return (int) (Math.random() * 100) > 70;
    }

    public static String toUpperCaseRange(String enteredText) {
        if (enteredText == null || enteredText.isBlank()) {
            System.out.println("Ошибка: строка " + (enteredText == null ? "равна null" : "пустая") + "\n");
            return null;
        }

        String[] words = enteredText.split(" ");
        int shortestWordIndex = 0;
        int longestWordIndex = 0;
        int shortestLength = Integer.MAX_VALUE;
        int longestLength = 0;

        for (int i = 0; i < words.length; i++) {
            String cleanWord = words[i].replaceAll("\\p{P}", "");
            if (cleanWord.isBlank()) continue;

            int currentLength = cleanWord.length();

            if (currentLength < shortestLength) {
                shortestWordIndex = i;
                shortestLength = currentLength;
            }
            if (currentLength > longestLength) {
                longestWordIndex = i;
                longestLength = currentLength;
            }
        }

        int start = Math.min(shortestWordIndex, longestWordIndex);
        int end = Math.max(shortestWordIndex, longestWordIndex);

        for (int i = start; i <= end; i++) {
            words[i] = words[i].toUpperCase();
        }

        StringBuilder outputText = new StringBuilder();
        for (String word : words) {
            outputText.append(word).append(" ");
        }

        return outputText.toString().trim();
    }
}
