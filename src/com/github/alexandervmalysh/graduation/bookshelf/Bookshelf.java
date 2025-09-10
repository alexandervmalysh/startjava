package com.github.alexandervmalysh.graduation.bookshelf;

import com.github.alexandervmalysh.graduation.bookshelf.exception.BookNotFoundException;
import com.github.alexandervmalysh.graduation.bookshelf.exception.BookshelfFullException;
import java.util.Arrays;

public class Bookshelf {
    public static final int CAPACITY = 10;

    private final Book[] books = new Book[CAPACITY];
    private int size = 0;
    private int maxBookLength = 0;

    public int getCount() {
        return size;
    }

    public int getFreeSlots() {
        return CAPACITY - size;
    }

    public int getMaxBookLength() {
        return maxBookLength;
    }

    public Book[] getAll() {
        return Arrays.copyOf(books, size);
    }

    private void recalculateMaxLength() {
        maxBookLength = 0;
        for (int i = 0; i < size; i++) {
            int bookLength = books[i].toString().length();
            if (bookLength > maxBookLength) {
                maxBookLength = bookLength;
            }
        }
    }

    public void add(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Ошибка: книга не может быть пустой");
        }
        if (size >= CAPACITY) {
            throw new BookshelfFullException("Ошибка: шкаф заполнен");
        }

        books[size++] = book;
        recalculateMaxLength();
    }

    public Book[][] find(String title) {
        if (title == null || title.isBlank()) {
            return new Book[0][0];
        }

        int foundCount = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                foundCount++;
            }
        }

        if (foundCount == 0) {
            return new Book[0][0];
        }

        Book[][] result = new Book[foundCount][1];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                result[index++][0] = books[i];
            }
        }

        return result;
    }

    public void remove(String title) {
        if (title == null || title.isBlank()) {
            throw new BookNotFoundException("Ошибка: название книги не может быть пустым");
        }

        int write = 0;
        int removedCount = 0;
        boolean needsRecalculateMax = false;

        for (int read = 0; read < size; read++) {
            Book current = books[read];
            if (current.getTitle().equalsIgnoreCase(title)) {
                removedCount++;
                if (current.toString().length() == maxBookLength) {
                    needsRecalculateMax = true;
                }
            } else {
                books[write++] = current;
            }
        }

        if (removedCount == 0) {
            throw new BookNotFoundException("Ошибка: книга с названием \"" + title + "\" не найдена");
        }

        Arrays.fill(books, write, size, null);
        size = write;

        if (needsRecalculateMax) {
            recalculateMaxLength();
        }
    }

    public void clear() {
        Arrays.fill(books, 0, size, null);
        size = 0;
        maxBookLength = 0;
    }
}
