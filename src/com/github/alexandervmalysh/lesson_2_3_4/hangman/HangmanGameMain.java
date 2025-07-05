package com.github.alexandervmalysh.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру \"Виселица!\"");

        Scanner scanner = new Scanner(System.in);
        String answer;

        do {
            new HangmanGame().play();

            do {
                System.out.print("\nХотите сыграть еще раз? [yes/no]: ");
                answer = scanner.nextLine().toLowerCase();

                if (!answer.equals("yes") && !answer.equals("no")) {
                    System.out.println("\nВведите корректный ответ [yes / no]: ");
                }
            } while (!"yes".equals(answer) && !"no".equals(answer));
        } while (!"no".equals(answer));
    }
}
