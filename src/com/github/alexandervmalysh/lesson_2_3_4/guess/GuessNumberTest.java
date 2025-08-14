package com.github.alexandervmalysh.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final int PLAYERS_COUNT = 3;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Player[] players = createPlayers(console);

        String answer = YES;

        while (true) {
            if (YES.equals(answer)) {
                GuessNumber game = new GuessNumber(players);
                game.start();
            }

            System.out.print("\nХотите продолжить игру? [yes/no]: ");
            answer = console.nextLine().toLowerCase();

            if (NO.equals(answer)) {
                break;
            } else if (!YES.equals(answer)) {
                System.out.println("Ошибка: введите 'yes' или 'no'");
            }
        }
    }

    private static Player[] createPlayers(Scanner console) {
        Player[] players = new Player[PLAYERS_COUNT];

        for (int i = 0; i < players.length; i++) {
            System.out.printf("Введите имя %d-го игрока: ", i + 1);
            players[i] = new Player(console.nextLine());
        }
        return players;
    }
}
