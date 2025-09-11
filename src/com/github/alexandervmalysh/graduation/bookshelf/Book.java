package com.github.alexandervmalysh.graduation.bookshelf;

import java.time.Year;

public class Book {
    public static final Year MIN_YEAR = Year.of(1800);

    private final String author;
    private final String title;
    private final Year publicationYear;

    public Book(String author, String title, Year publicationYear) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Ошибка: автор книги не может быть пустым");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Ошибка: название книги не может быть пустым");
        }

        if (publicationYear == null) {
            throw new IllegalArgumentException("Ошибка: год издания не может быть пустым");
        }

        Year now = Year.now();

        if (publicationYear.isBefore(MIN_YEAR) || publicationYear.isAfter(now)) {
            throw new IllegalArgumentException("Ошибка: год издания должен быть между " +
                    MIN_YEAR + " и текущим");
        }

        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return (author + ", " + title + ", " + publicationYear);
    }
}
