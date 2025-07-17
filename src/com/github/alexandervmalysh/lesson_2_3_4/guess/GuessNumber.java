package com.github.alexandervmalysh.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    private final Player player1;
    private final Player player2;
    private int secretNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        generateSecretNumber();
        System.out.println("\nИгра началась! У каждого игрока по " + MAX_ATTEMPTS + " попыток");
        startGameplay();
        printPlayersNumbers();
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

            if (player1.hasAttempts(attempt)) {
                System.out.println("У " + player1.getName() + " закончились попытки!");
            } else {
                System.out.print("Число вводит " + player1.getName() + ": ");
                int player1Guess = getValidNumber(player1, scanner);
                if (checkGuess(player1, player1Guess, attempt)) {
                    isGuessed = true;
                    continue;
                }
            }

            if (player2.hasAttempts(attempt)) {
                System.out.println("У " + player2.getName() + " закончились попытки!");
            } else {
                System.out.print("Число вводит " + player2.getName() + ": ");
                int player2Guess = getValidNumber(player2, scanner);
                if (checkGuess(player1, player2Guess, attempt)) {
                    isGuessed = true;
                }
            }
            attempt++;
        }

        if (!isGuessed) {
            System.out.println("\nНикто не угадал число!");
        }
    }

    private int getValidNumber(Player player, Scanner scanner) {
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
            } catch (InvalidNumberException e) {
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

        player1.clearNumbers();
        player2.clearNumbers();
    }
}
