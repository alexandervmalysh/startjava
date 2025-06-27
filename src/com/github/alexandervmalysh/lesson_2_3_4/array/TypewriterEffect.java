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

        String textWithoutPunctuation = enteredText.replaceAll("[\\p{Punct}\\s]+", " ").trim();
        String[] words = textWithoutPunctuation.split(" ");
        int shortestWord = 0;
        int longestWord = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < words[shortestWord].length()) {
                shortestWord = i;
            } else if (words[i].length() > words[longestWord].length()) {
                longestWord = i;
            }
        }

        if (shortestWord > longestWord) {
            int temp = longestWord;
            longestWord = ++shortestWord;
            shortestWord = temp;
        }

        for (int i = shortestWord; i < longestWord; i++) {
            words[i] = words[i].toUpperCase();
        }

        StringBuilder outputText = new StringBuilder();
        for (String word : words) {
            outputText.append(word).append(" ");
        }

        return outputText.toString();
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
