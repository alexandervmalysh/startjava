package com.github.alexandervmalysh.lesson_2_3_4.guess;

import java.util.Arrays;
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
    public int[] scores;

    public GuessNumber(Player... players) {
        this.players = players;
        this.playersCount = players.length;
        this.scores = new int[playersCount];
    }

    public void start() {
        shufflePlayersOrder();

        System.out.println("\nИгра началась! У каждого игрока по " + MAX_ATTEMPTS +
                " попыток в каждом раунде.\nВсего будет " +
                ROUNDS_COUNT + " раунда");

        Arrays.fill(scores, 0);

        for (int round = 1; round <= ROUNDS_COUNT; round++) {
            System.out.println("\n--- Раунд " + round + " ---");
            playRound();
        }

        determineWinner();
    }

    public void playRound() {
        generateSecretNumber();
        startGameplay();
        printPlayersNumbers();
        clearPlayersNumbers();
    }

    private void shufflePlayersOrder() {
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

    private void generateSecretNumber() {
        secretNumber = (int) (Math.random() * MAX_NUMBER + MIN_NUMBER);
    }

    private void startGameplay() {
        Scanner scanner = new Scanner(System.in);
        boolean isGuessed = false;
        int attempt = 1;

        while (attempt <= MAX_ATTEMPTS && !isGuessed) {
            System.out.println("\nПопытка " + attempt);

            for (Player player : players) {
                try {
                    int playerGuess = inputNumber(player, scanner);
                    if (checkGuess(player, playerGuess, attempt)) {
                        isGuessed = true;

                        for (int i = 0; i < playersCount; i++) {
                            if (players[i].equals(player)) {
                                scores[i]++;
                                break;
                            }
                        }
                        break;
                    }
                } catch (GameException e) {
                    System.out.print(e.getMessage());
                }
            }

            attempt++;
        }

        if (!isGuessed) {
            System.out.println("\nНикто не угадал число в этом раунде!");
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
        System.out.println("\nЧисла игроков: ");

        for (Player player : players) {
            int[] numbers = player.getNumbers();

            for (int num : numbers) {
                System.out.print(num + " ");
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

        for (int i = 0; i < playersCount; i++) {
            System.out.println(players[i].getName() + ": " + scores[i] + " победных раундов");
        }

        int maxScore = scores[0];
        int winnersCount = 1;

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                winnersCount = 1;
            } else if (scores[i] == maxScore) {
                winnersCount++;
            }
        }

        if (maxScore == 0) {
            System.out.println("Все игроки проиграли - никто не угадал число ни в одном раунде!");
        } else if (winnersCount > 1) {
            System.out.println("\nНичья между: ");
            for (int i = 0; i < playersCount; i++) {
                if (scores[i] == maxScore) {
                    System.out.print(players[i].getName() + " ");
                }
            }
            System.out.println("с результатом " + maxScore + " победных раундов");
        } else {
            for (int i = 0; i < playersCount; i++) {
                if (scores[i] == maxScore) {
                    System.out.println("Победитель: " + players[i].getName() +
                            " с результатом " + maxScore + " победных раундов");
                    break;
                }
            }
        }
    }
}
