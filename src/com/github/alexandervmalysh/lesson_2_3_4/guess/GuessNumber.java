package com.github.alexandervmalysh.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS = 10;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;

    private final Player player1;
    private final Player player2;
    private int secretNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        System.out.println("\nИгра началась! У каждого игрока по " + MAX_ATTEMPTS + " попыток");

        generateSecretNumber();
        startGameplay();
        printPlayersNumbers();
        clearPlayersNumbers();
    }

    private void generateSecretNumber() {
        secretNumber = (int) (Math.random() * MAX_NUMBER + MIN_NUMBER);
    }

    private void startGameplay() {
        Scanner scanner = new Scanner(System.in);
        boolean isGuessed = false;
        int attempt = 1;

        while (attempt <= MAX_ATTEMPTS && !isGuessed) {
            System.out.println("\nПопытка " + attempt);

            try {
                int player1Guess = inputNumber(player1, scanner);
                if (checkGuess(player1, player1Guess, attempt)) {
                    isGuessed = true;
                    continue;
                }
            } catch (GameException e) {
                System.out.print(e.getMessage());
            }

            try {
                int player2Guess = inputNumber(player2, scanner);
                if (checkGuess(player1, player2Guess, attempt)) {
                    isGuessed = true;
                }
            } catch (GameException e) {
                System.out.print(e.getMessage());
            }

            attempt++;
        }

        if (!isGuessed) {
            System.out.println("\nНикто не угадал число!");
        }
    }

    private int inputNumber(Player player, Scanner scanner) {
        System.out.print("Число вводит " + player.getName() + ": ");

        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите целое число!");
                scanner.next();
                continue;
            }

            int number = scanner.nextInt();
            try {
                player.addNumber(number);
                return number;
            } catch (GameException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    private boolean checkGuess(Player player, int guess, int attempt) {
        if (guess == secretNumber) {
            System.out.println("\n" + player.getName() + " угадал число " + secretNumber + " с " +
                    attempt + "-й попытки");
            return true;
        }

        System.out.println(guess + (guess < secretNumber ? " меньше" : " больше") +
                " того, что загадал компьютер");
        return false;
    }

    private void printPlayersNumbers() {
        System.out.println(player1.getName() + ": " + Arrays.toString(player1.getNumbers()));
        System.out.println(player2.getName() + ": " + Arrays.toString(player2.getNumbers()));
    }

    private void clearPlayersNumbers() {
        player1.clear();
        player2.clear();
    }
}
