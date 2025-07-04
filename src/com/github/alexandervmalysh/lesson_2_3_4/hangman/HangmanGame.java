package com.github.alexandervmalysh.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private final String[] hangedMan = {
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
    private final char[] guessedLetters;
    private final char[] wrongLetters;
    private int guessedCount;
    private int wrongCount;
    private int totalAttempts;
    private int hangedManStep;

    public HangmanGame() {
        wordToGuess = chooseSecretWord();
        makeMaskedWord();
        guessedLetters = new char[wordToGuess.length()];
        wrongLetters = new char[hangedMan.length + 1];
        totalAttempts = hangedMan.length;
        hangedManStep = 0;
        guessedCount = 0;
        wrongCount = 0;
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
                guessedLetters[guessedCount++] = letter;
                updateMaskedWord(letter);
                if (hangedManStep > 0) {
                    hangedManStep--;
                    totalAttempts++;
                }
                if (isWordGuessed()) {
                    gameOver = true;
                    System.out.println("Поздравляем! Вы угадали слово: " + wordToGuess);
                }
            } else {
                wrongLetters[wrongCount++] = letter;
                hangedManStep++;
                totalAttempts--;
                if (hangedManStep >= hangedMan.length) {
                    gameOver = true;
                    printHangedMan();
                    System.out.println("Вы проиграли! Загаданное слово: " + wordToGuess);
                }
            }
        }
        askToPlayAgain(scanner);
    }

    private void printGameState() {
        System.out.print("\nЗагаданное слово: ");
        for (char maskedLetter : maskedWord) {
            System.out.print(maskedLetter + " ");
        }
        System.out.println("\nВведенные буквы: " + getWrongLetters());
        System.out.println("Осталось попыток: " + totalAttempts);

        if (hangedManStep > 0) {
            printHangedMan();
        }
    }

    private String getWrongLetters() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < wrongCount; i++) {
            stringBuilder.append(wrongLetters[i]).append(" ");
        }
        return stringBuilder.toString();
    }

    private boolean isCyrillic(char letter) {
        return (letter >= 'А' && letter <= 'Я') || letter == 'Ё';
    }

    private boolean isAlreadyGuessed(char letter) {
        for (int i = 0; i < guessedCount; i++) {
            if (guessedLetters[i] == letter) return true;
        }
        for (int i = 0; i < wrongCount; i++) {
            if (wrongLetters[i] == letter) return true;
        }
        return false;
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

    private void printHangedMan() {
        for (int i = 0; i < hangedManStep; i++) {
            System.out.println(hangedMan[i]);
        }
    }

    private void askToPlayAgain(Scanner scanner) {
        System.out.print("\nХотите сыграть еще раз? [yes/no]: ");

        while (true) {
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                new HangmanGame().play();
                return;
            } else if (answer.equals("no")) {
                System.out.println("\nСпасибо за игру!");
                return;
            }

            System.out.print("\nВведите корректный ответ [yes / no]: ");
        }
    }
}
