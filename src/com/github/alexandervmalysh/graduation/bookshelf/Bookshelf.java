package com.github.alexandervmalysh.graduation.bookshelf;

import java.time.Year;

public class Bookshelf {
    private static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int size = 0;

    public boolean addBook(String author, String title, Year year) {
        if (size == CAPACITY) {
            return false;
        }

        Book book = new Book(author, title, year);
        books[size] = book;
        size++;
        return true;
    }

    public Book findByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            return null;
        }

        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }

        return null;
    }

    public boolean removeByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            return false;
        }

        int indexBook = -1;

        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                indexBook = i;
                break;
            }
        }

        if (indexBook == -1) {
            return false;
        }

        int elementsToMove = size - indexBook - 1;

        if (elementsToMove > 0) {
            System.arraycopy(books, indexBook + 1, books, indexBook, elementsToMove);
        }

        books[size - 1] = null;
        size--;
        return true;
    }

    public Book[] getAll() {
        Book[] copy = new Book[size];
        System.arraycopy(books, 0, copy, 0, size);
        return copy;
    }

    public int getCount() {
        return size;
    }

    public int getFreeSlots() {
        return CAPACITY - size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            books[i] = null;
        }

        size = 0;
    }
}
