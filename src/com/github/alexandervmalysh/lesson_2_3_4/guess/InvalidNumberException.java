package com.github.alexandervmalysh.lesson_2_3_4.guess;

public class InvalidNumberException extends RuntimeException {
    public InvalidNumberException(String message) {
        super(message);
    }
}
