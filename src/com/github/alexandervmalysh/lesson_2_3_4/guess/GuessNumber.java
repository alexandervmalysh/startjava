package com.github.alexandervmalysh.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS = 10;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;
    public static final int ROUNDS_COUNT = 3;

    private final Player[] players;
    private final int playersCount;
    private int secretNumber;

    public GuessNumber(Player... players) {
        this.players = players;
        this.playersCount = players.length;
    }

    public void start() {
        shufflePlayers();

        System.out.println("\nИгра началась! У каждого игрока по " + MAX_ATTEMPTS +
                " попыток в каждом раунде.\nВсего будет " +
                ROUNDS_COUNT + " раунда");

        for (Player player : players) {
            player.clear();
        }

        for (int round = 1; round <= ROUNDS_COUNT; round++) {
            System.out.println("\n--- Раунд " + round + " ---");
            playRound();
        }

        determineWinner();

        for (Player player : players) {
            player.resetWinsCount();
        }
    }

    private void shufflePlayers() {
        Random random = new Random();

        for (int i = playersCount - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Player temp = players[i];
            players[i] = players[j];
            players[j] = temp;
        }

        System.out.print("\nПорядок игроков для угадывания: ");
        for (int i = 0; i < playersCount; i++) {
            System.out.print(players[i].getName());
            if (i < playersCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private void playRound() {
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

        for (int attempt = 1; attempt <= MAX_ATTEMPTS && !isGuessed; attempt++) {
            System.out.println("\nПопытка " + attempt);

            for (Player currentPlayer : players) {
                try {
                    int playerGuess = inputNumber(currentPlayer, scanner);
                    if (checkGuess(currentPlayer, playerGuess, attempt)) {
                        isGuessed = true;
                        break;
                    }
                } catch (OutOfRangeException e) {
                    System.out.print(e.getMessage());
                }
            }
        }

        if (!isGuessed) {
            System.out.println("\nНикто не угадал число в этом раунде!");
        }
    }

    private int inputNumber(Player player, Scanner scanner) {
        System.out.print("Число вводит " + player.getName() + ": ");

        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.print("Ошибка: введите целое число!\n" +
                        "Попробуйте еще раз: ");
                scanner.next();
                continue;
            }

            int number = scanner.nextInt();
            try {
                player.addNumber(number);
                return number;
            } catch (OutOfRangeException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    private boolean checkGuess(Player player, int guess, int attempt) {
        if (guess == secretNumber) {
            System.out.println("\n" + player.getName() + " угадал число " + secretNumber + " с " +
                    attempt + "-й попытки");
            player.incrementWinsCount();
            return true;
        }

        System.out.println(guess + (guess < secretNumber ? " меньше" : " больше") +
                " того, что загадал компьютер");
        return false;
    }

    private void printPlayersNumbers() {
        System.out.println("\nЧисла игроков:");
        for (Player player : players) {
            int[] numbers = player.getNumbers();
            if (numbers.length == 0) {
                System.out.println("(нет чисел)");
                continue;
            }
            System.out.print(numbers[0]);
            for (int i = 1; i < numbers.length; i++) {
                System.out.print(" " + numbers[i]);
            }
            System.out.println();
        }
    }

    private void clearPlayersNumbers() {
        for (Player player : players) {
            player.clear();
        }
    }

    private void determineWinner() {
        System.out.println("\n--- Результаты игры ---");

        Arrays.sort(players, Comparator.comparing(Player::getWinsCount).reversed());

        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getWinsCount() + " победных раундов");
        }

        int maxScore = players[0].getWinsCount();

        if (maxScore == 0) {
            System.out.println("Все игроки проиграли - никто не угадал число ни в одном раунде!");
            return;
        }

        int winnersCount = 1;
        for (int i = 1; i < players.length; i++) {
            if (players[i].getWinsCount() == maxScore) {
                winnersCount++;
            } else {
                break;
            }
        }

        if (winnersCount > 1) {
            System.out.println("\nНичья между: ");
            for (int i = 0; i < winnersCount; i++) {
                System.out.print(players[i].getName() + " ");
            }
            System.out.println("с результатом " + maxScore + " победных раундов");
        } else {
            System.out.println("Победитель: " + players[0].getName() +
                    " с результатом " + maxScore + " победных раундов");
        }
    }
}
