package com.github.alexandervmalysh.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final int[] numbers = new int[GuessNumber.MAX_ATTEMPTS];
    private final String name;
    private int currentAttempt;
    private int winsCount;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWinsCount() {
        return winsCount;
    }

    public void incrementWinsCount() {
        winsCount++;
    }

    public void addNumber(int number) {
        if (currentAttempt >= GuessNumber.MAX_ATTEMPTS) {
            throw new AttemptsExceededException("У " + name + " закончились попытки!\n");
        }
        if (number < GuessNumber.MIN_NUMBER || number > GuessNumber.MAX_NUMBER) {
            throw new OutOfRangeException(
                    "Ошибка: число должно входить в отрезок [" + GuessNumber.MIN_NUMBER + ", " +
                    GuessNumber.MAX_NUMBER + "].\n" + "Попробуйте еще раз: "
            );
        }
        numbers[currentAttempt++] = number;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, currentAttempt);
    }

    public void clear() {
        Arrays.fill(numbers, 0, currentAttempt, 0);
        currentAttempt = 0;
    }
}
