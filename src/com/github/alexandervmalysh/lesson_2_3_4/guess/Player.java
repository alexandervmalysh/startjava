package com.github.alexandervmalysh.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    private final int[] numbers = new int[MAX_ATTEMPTS];
    private final String name;
    private int currentIndex = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNumber(int number) {
        if (currentIndex >= MAX_ATTEMPTS) {
            throw new InvalidNumberException("Закончились попытки!");
        }
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new InvalidNumberException(
                    "Число должно входить в отрезок [" + MIN_NUMBER + ", " + MAX_NUMBER + "].\n" +
                    "Попробуйте еще раз: "
            );
        }
        numbers[currentIndex++] = number;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, currentIndex);
    }

    public void clearNumbers() {
        Arrays.fill(numbers, 0, currentIndex, 0);
        currentIndex = 0;
    }

    public boolean hasAttempts(int currentAttempt) {
        return currentAttempt > MAX_ATTEMPTS;
    }
}
