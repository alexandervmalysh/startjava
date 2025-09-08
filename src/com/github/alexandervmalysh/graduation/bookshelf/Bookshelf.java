package com.github.alexandervmalysh.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int size = 0;

    public int getCapacity() {
        return CAPACITY;
    }

    public int getCount() {
        return size;
    }

    public int getFreeSlots() {
        return CAPACITY - size;
    }

    public Book[] getAll() {
        return Arrays.copyOf(books, size);
    }

    public boolean add(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Ошибка: книга не может быть пустой");
        }
        if (size >= CAPACITY) {
            return false;
        }

        books[size++] = book;
        return true;
    }

    public Book find(String title) {
        if (title == null || title.isBlank()) {
            return null;
        }

        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }

        return null;
    }

    public boolean remove(String title) {
        if (title == null || title.isBlank()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                int elementsToMove = size - i - 1;
                if (elementsToMove > 0) {
                    System.arraycopy(books, i + 1, books, i, elementsToMove);
                }

                books[--size] = null;
                return true;
            }
        }

        return false;
    }

    public void clear() {
        Arrays.fill(books, 0, size, null);
        size = 0;
    }
}
