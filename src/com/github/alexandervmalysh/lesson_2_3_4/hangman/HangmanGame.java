package com.github.alexandervmalysh.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private final String[] gallows = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private final String[] secretWords = {
            "алгоритм",
            "объект",
            "класс",
            "массив",
            "данные",
            "инкапсуляция",
            "абстракция",
            "наследование",
            "полиморфизм"
    };
    private final String wordToGuess;
    private char[] maskedWord;
    private final StringBuilder wrongLetters;
    private int totalAttempts;
    private int gallowsStep;

    public HangmanGame() {
        wordToGuess = chooseSecretWord();
        makeMaskedWord();
        wrongLetters = new StringBuilder();
        totalAttempts = gallows.length;
    }

    private String chooseSecretWord() {
        Random rnd = new Random();
        return secretWords[rnd.nextInt(secretWords.length)].toUpperCase();
    }

    private void makeMaskedWord() {
        maskedWord = new char[wordToGuess.length()];
        Arrays.fill(maskedWord, '_');
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            printGameState();

            System.out.print("\nВведите букву: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.length() != 1) {
                System.out.println("\nОшибка: введите одну букву");
                continue;
            }

            char letter = input.charAt(0);

            if (!isCyrillic(letter)) {
                System.out.println("\nОшибка: введите кириллическую букву");
                continue;
            }

            if (isAlreadyGuessed(letter)) {
                System.out.println("\nОшибка: вы уже вводили эту букву");
                continue;
            }

            if (wordToGuess.indexOf(letter) != -1) {
                updateMaskedWord(letter);

                if (gallowsStep > 0) {
                    gallowsStep--;
                    totalAttempts++;
                }

                if (isWordGuessed()) {
                    gameOver = true;
                    System.out.println("Поздравляем! Вы угадали слово: " + wordToGuess);
                }
            } else {
                wrongLetters.append(letter);
                gallowsStep++;
                totalAttempts--;
                if (gallowsStep >= gallows.length) {
                    gameOver = true;
                    printGallows();
                    System.out.println("Вы проиграли! Загаданное слово: " + wordToGuess);
                }
            }
        }
    }

    private void printGameState() {
        System.out.print("\nЗагаданное слово: ");
        for (char maskedLetter : maskedWord) {
            System.out.print(maskedLetter + " ");
        }

        System.out.println("\nВведенные буквы: " + getWrongLetters());
        System.out.println("Осталось попыток: " + totalAttempts);

        if (gallowsStep > 0) {
            printGallows();
        }
    }

    private String getWrongLetters() {
        return wrongLetters.toString().replace("", " ").trim();
    }

    private boolean isCyrillic(char letter) {
        return (letter >= 'А' && letter <= 'Я') || letter == 'Ё';
    }

    private boolean isAlreadyGuessed(char letter) {
        for (char maskedLetter : maskedWord) {
            if (maskedLetter == letter) return true;
        }

        return wrongLetters.indexOf(String.valueOf(letter)) != -1;
    }

    private void updateMaskedWord(char letter) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                maskedWord[i] = letter;
            }
        }
    }

    private boolean isWordGuessed() {
        for (char maskedLetter : maskedWord) {
            if (maskedLetter == '_') return false;
        }
        return true;
    }

    private void printGallows() {
        for (int i = 0; i < gallowsStep; i++) {
            System.out.println(gallows[i]);
        }
    }
}
