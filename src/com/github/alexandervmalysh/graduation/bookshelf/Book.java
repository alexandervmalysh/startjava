package com.github.alexandervmalysh.graduation.bookshelf;

import java.time.Year;

public class Book {
    private final String author;
    private final String title;
    private final Year year;

    public Book(String author, String title, Year year) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("автор не может быть пустым");
        }

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("название не может быть пустым");
        }

        if (year == null) {
            throw new IllegalArgumentException("год не может быть пустым");
        }

        if (year.getValue() < 1800 || year.getValue() > Year.now().getValue()) {
            throw new IllegalArgumentException("год издания должен быть между 1800 и текущим");
        }

        this.author = author;
        this.title = title;
        this.year = year;
    }

    @SuppressWarnings("unused")
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @SuppressWarnings("unused")
    public Year getYear() {
        return year;
    }

    @Override
    public String toString() {
        return (author + ", " + title + ", " + year.getValue());
    }
}
