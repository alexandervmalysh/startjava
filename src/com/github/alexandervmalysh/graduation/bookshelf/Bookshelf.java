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

    public int getFreeShelves() {
        return CAPACITY - size;
    }

    public int getMaxBookLength() {
        return maxBookLength;
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
        maxBookLength = Math.max(maxBookLength, newBookLength);
    }

    public Book[] find(String title) {
        if (title == null || title.isBlank()) {
            return new Book[0];
        }

        int foundBufferCapacity = 5;
        Book[] foundBooks = new Book[foundBufferCapacity];
        int foundBooksCount = 0;

        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                if (foundBooksCount == foundBufferCapacity) {
                    foundBufferCapacity = Math.max(foundBufferCapacity + 1,
                            (int) Math.ceil(foundBufferCapacity * 1.5));
                    foundBooks = Arrays.copyOf(foundBooks, foundBufferCapacity);
                }
                foundBooks[foundBooksCount++] = books[i];
            }
        }

        return (foundBooksCount == foundBooks.length) ? foundBooks :
                Arrays.copyOf(foundBooks, foundBooksCount);
    }

    public void remove(String title) {
        if (title == null || title.isBlank()) {
            throw new BookNotFoundException("Ошибка: название книги не может быть пустым");
        }

        int writeIndex = 0;
        int readIndex = 0;
        int removedCount = 0;
        boolean needsRecalculateMax = false;

        while (readIndex < size) {
            int blockStart = readIndex;

            while (readIndex < size && !books[readIndex].getTitle().equalsIgnoreCase(title)) {
                readIndex++;
            }

            int blockLen = readIndex - blockStart;

            if (blockLen > 0) {
                System.arraycopy(books, blockStart, books, writeIndex, blockLen);
                writeIndex += blockLen;
            }

            int removedStart = readIndex;

            while (readIndex < size && books[readIndex].getTitle().equalsIgnoreCase(title)) {
                if (books[readIndex].toString().length() == maxBookLength) {
                    needsRecalculateMax = true;
                }
                readIndex++;
            }

            removedCount += (readIndex - removedStart);
        }

        if (removedCount == 0) {
            throw new BookNotFoundException("Ошибка: книга с названием \"" + title + "\" не найдена");
        }

        Arrays.fill(books, writeIndex, size, null);
        size = writeIndex;

        if (needsRecalculateMax) {
            recalculateMaxLength();
        }
    }

    public Book[] getAll() {
        return Arrays.copyOf(books, size);
    }

    public void clear() {
        Arrays.fill(books, 0, size, null);
        size = 0;
        maxBookLength = 0;
    }

    private void recalculateMaxLength() {
        maxBookLength = 0;
        for (int i = 0; i < size; i++) {
            maxBookLength = Math.max(maxBookLength, books[i].toString().length());
        }
    }
}
