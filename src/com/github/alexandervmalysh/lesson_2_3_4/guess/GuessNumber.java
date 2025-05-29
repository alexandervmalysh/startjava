package com.github.alexandervmalysh.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;
    private int secretNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        generateSecretNumber();
        startGameplay();
    }

    private void generateSecretNumber() {
        secretNumber = (int) (Math.random() * 100 + 1);
    }

    private void startGameplay() {
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = player1;

        while (true) {
            System.out.print(currentPlayer.getName() + ", введите число для угадывания: ");
            int playerGuess = scanner.nextInt();

            if (checkGuess(currentPlayer, playerGuess)) {
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
        scanner.nextLine();
    }

    private boolean checkGuess(Player player, int guess) {
        if (guess == secretNumber) {
            System.out.println("Поздравляем, " + player.getName() +
                    "! Вы угадали число и победили!");
            return true;
        }

        if (guess < secretNumber) {
            System.out.println(guess + " меньше того, что загадал компьютер");
        } else {
            System.out.println(guess + " больше того, что загадал компьютер");
        }
        return false;
    }
}