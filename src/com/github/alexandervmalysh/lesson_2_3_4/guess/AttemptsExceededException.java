package com.github.alexandervmalysh.lesson_2_3_4.guess;

public class AttemptsExceededException extends RuntimeException {
    public AttemptsExceededException(String message) {
        super(message);
    }
}