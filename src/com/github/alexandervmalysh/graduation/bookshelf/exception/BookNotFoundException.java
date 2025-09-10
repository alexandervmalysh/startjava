package com.github.alexandervmalysh.graduation.bookshelf.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
