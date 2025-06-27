package com.github.alexandervmalysh.lesson_2_3_4.array;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        String enteredText = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        type(toUpperCaseWordRange(enteredText));

        enteredText = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        type(toUpperCaseWordRange(enteredText));

        enteredText = null;
        type(toUpperCaseWordRange(enteredText));

        enteredText = "";
        type(toUpperCaseWordRange(enteredText));
    }

    private static String toUpperCaseWordRange(String enteredText) {
        if (enteredText == null) {
            System.out.println("Ошибка: строка равна null\n");
            return null;
        }

        if (enteredText.isBlank()) {
            System.out.println("Ошибка: строка пустая\n");
            return null;
        }

        String[] words = enteredText.split(" ");
        int shortestWordIndex = 0;
        int longestWordIndex = 0;

        for (int i = 0; i < words.length; i++) {
            String cleanWord = words[i].replaceAll("\\p{P}", "");
            if (cleanWord.isEmpty()) continue;

            if (cleanWord.length() < words[shortestWordIndex].replaceAll("\\p{P}", "").length()) {
                shortestWordIndex = i;
            }
            if (cleanWord.length() > words[longestWordIndex].replaceAll("\\p{P}", "").length()) {
                longestWordIndex = i;
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

        for (String character : enteredText.split("")) {
            System.out.print(character);
            Thread.sleep(80);
        }
        System.out.println("\n");
    }
}
