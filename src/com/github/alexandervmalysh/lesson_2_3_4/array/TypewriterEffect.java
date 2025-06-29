package com.github.alexandervmalysh.lesson_2_3_4.array;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        String enteredText = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        type(toUpperCaseRange(enteredText));

        enteredText = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        type(toUpperCaseRange(enteredText));

        enteredText = null;
        type(toUpperCaseRange(enteredText));

        enteredText = "";
        type(toUpperCaseRange(enteredText));
    }

    private static String toUpperCaseRange(String enteredText) {
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

    private static void type(String enteredText) throws InterruptedException {
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
