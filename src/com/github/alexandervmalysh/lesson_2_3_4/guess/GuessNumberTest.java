package com.github.alexandervmalysh.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        Player player1 = new Player(console.nextLine());

        System.out.print("Введите имя второго игрока: ");
        Player player2 = new Player(console.nextLine());

        GuessNumber game = new GuessNumber(player1, player2);

        String answer;
        do {
            game.start();
            do {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                answer = console.nextLine().toLowerCase();
            } while (!"yes".equals(answer) && !"no".equals(answer));
        } while (!"no".equals(answer));
    }
}
