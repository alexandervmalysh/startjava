package com.github.alexandervmalysh.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Player[] players = new Player[3];

        for (int i = 0; i < players.length; i++) {
            System.out.printf("Введите имя %d-го игрока: ", i + 1);
            players[i] = new Player(console.nextLine());
        }

        String answer;
        do {
            GuessNumber game = new GuessNumber(players[0], players[1], players[2]);
            game.start();
            do {
                System.out.print("\nХотите продолжить игру? [yes/no]: ");
                answer = console.nextLine().toLowerCase();
                if (!"yes".equals(answer) && !"no".equals(answer)) {
                    System.out.print("Ошибка: введите корректный ответ [yes/no]\n");
                }
            } while (!"yes".equals(answer) && !"no".equals(answer));
        } while (!"no".equals(answer));
    }
}
