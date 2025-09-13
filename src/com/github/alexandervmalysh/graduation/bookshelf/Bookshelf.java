package com.github.alexandervmalysh.graduation.bookshelf;

import com.github.alexandervmalysh.graduation.bookshelf.exception.BookNotFoundException;
import com.github.alexandervmalysh.graduation.bookshelf.exception.BookshelfFullException;
import java.util.Arrays;

public class Bookshelf {
    private static final int DEFAULT_SEARCH_CAPACITY = 5;
    public static final int CAPACITY = 10;

    private final Book[] books = new Book[CAPACITY];
    private int size = 0;
    private int bookshelfLength = 0;

    public int getCount() {
        return size;
    }

    public int getFreeShelves() {
        return CAPACITY - size;
    }

    public int getBookshelfLength() {
        return bookshelfLength;
    }

    public void add(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Ошибка: книга не может быть пустой");
        }
        if (size >= CAPACITY) {
            throw new BookshelfFullException("Ошибка: шкаф заполнен");
        }

        books[size++] = book;
        int newBookLength = book.toString().length();
        bookshelfLength = Math.max(bookshelfLength, newBookLength);
    }

    public Book[] find(String title) {
        if (title == null || title.isBlank()) {
            return new Book[0];
        }

        int searchCapacity = DEFAULT_SEARCH_CAPACITY;
        Book[] foundBooks = new Book[searchCapacity];
        int foundBooksCount = 0;

        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                if (foundBooksCount == searchCapacity) {
                    searchCapacity = (int) Math.ceil(searchCapacity * 1.5);
                    foundBooks = Arrays.copyOf(foundBooks, searchCapacity);
                }
                foundBooks[foundBooksCount++] = books[i];
            }
        }

        return Arrays.copyOf(foundBooks, foundBooksCount);
    }

    public void remove(String title) {
        if (title == null || title.isBlank()) {
            throw new BookNotFoundException("Ошибка: название книги не может быть пустым");
        }

        int writeIndex = 0;
        boolean removed = false;

        for (int readIndex = 0; readIndex < size; readIndex++) {
            if (books[readIndex].getTitle().equalsIgnoreCase(title)) {
                removed = true;
                if (books[readIndex].toString().length() == bookshelfLength) {
                    removed = true;
                }
            } else {
                if (writeIndex != readIndex) {
                    System.arraycopy(books, readIndex, books, writeIndex, 1);
                }
                writeIndex++;
            }
        }

        if (!removed) {
            throw new BookNotFoundException("Ошибка: книга с названием \"" + title + "\" не найдена");
        }

        size = writeIndex;

        recalculateMaxLength();
    }

    public Book[] getAll() {
        return Arrays.copyOf(books, size);
    }

    public void clear() {
        Arrays.fill(books, 0, size, null);
        size = 0;
        bookshelfLength = 0;
    }

    private void recalculateMaxLength() {
        if (size == 0) {
            bookshelfLength = 0;
            return;
        }

        bookshelfLength = 0;
        for (int i = 0; i < size; i++) {
            bookshelfLength = Math.max(bookshelfLength, books[i].toString().length());
        }
    }
}
