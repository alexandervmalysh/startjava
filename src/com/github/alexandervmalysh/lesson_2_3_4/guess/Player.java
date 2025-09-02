package com.github.alexandervmalysh.lesson_2_3_4.guess;

import static com.github.alexandervmalysh.lesson_2_3_4.guess.GuessNumber.MAX_ATTEMPTS;
import static com.github.alexandervmalysh.lesson_2_3_4.guess.GuessNumber.MAX_NUMBER;
import static com.github.alexandervmalysh.lesson_2_3_4.guess.GuessNumber.MIN_NUMBER;

import java.util.Arrays;

public class Player {
    private final int[] numbers = new int[MAX_ATTEMPTS];
    private final String name;
    private int currentAttempt;
    private int winsCount;

    public Player(String name) {
        this.name = name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, currentAttempt);
    }

    public String getName() {
        return name;
    }

    public int getWinsCount() {
        return winsCount;
    }

    public void addNumber(int number) {
        if (currentAttempt >= MAX_ATTEMPTS) {
            throw new AttemptsExceededException("У " + name + " закончились попытки!\n");
        }
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new OutOfRangeException(
                    "Ошибка: число должно входить в отрезок [" + MIN_NUMBER + ", " +
                    MAX_NUMBER + "].\n" + "Попробуйте еще раз: "
            );
        }
        numbers[currentAttempt++] = number;
    }

    public void incrementWinsCount() {
        winsCount++;
    }

    public void resetWinsCount() {
        winsCount = 0;
    }

    public void clear() {
        Arrays.fill(numbers, 0, currentAttempt, 0);
        currentAttempt = 0;
    }
}
