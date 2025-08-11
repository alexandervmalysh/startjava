package com.github.alexandervmalysh.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Player[] players = createPlayers(console);

        String answer;
        do {
            GuessNumber game = new GuessNumber(players);
            game.start();
            answer = getContinueAnswer(console);
        } while (!NO.equals(answer));
    }

    private static Player[] createPlayers(Scanner console) {
        Player[] players = new Player[3];

        for (int i = 0; i < players.length; i++) {
            System.out.printf("Введите имя %d-го игрока: ", i + 1);
            players[i] = new Player(console.nextLine());
        }
        return players;
    }

    private static String getContinueAnswer(Scanner console) {
        while (true) {
            System.out.print("\nХотите продолжить игру? [yes/no]: ");
            String answer = console.nextLine().toLowerCase();
            if (YES.equals(answer) || NO.equals(answer)) {
                return answer;
            } else {
                System.out.print("Ошибка: введите корректный ответ [yes/no]\n");
            }
        }
    }
}
