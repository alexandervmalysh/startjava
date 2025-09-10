package com.github.alexandervmalysh.graduation.bookshelf;

import java.time.Year;

public class Book {
    public static final Year MIN_YEAR = Year.of(1800);

    private final String author;
    private final String title;
    private final Year year;

    public Book(String author, String title, Year year) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Ошибка: автор не может быть пустым");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Ошибка: название не может быть пустым");
        }

        if (year == null) {
            throw new IllegalArgumentException("Ошибка: год не может быть пустым");
        }

        Year now = Year.now();

        if (year.isBefore(MIN_YEAR) || year.isAfter(now)) {
            throw new IllegalArgumentException("Ошибка: год издания должен быть между " +
                    MIN_YEAR + " и текущим");
        }

        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return (author + ", " + title + ", " + year);
    }
}
