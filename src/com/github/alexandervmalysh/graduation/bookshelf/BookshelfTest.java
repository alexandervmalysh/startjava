package com.github.alexandervmalysh.graduation.bookshelf;

import java.time.Year;
import java.util.Scanner;

public class BookshelfTest {
    private static final int SHELF_WIDTH = 44;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Bookshelf shelf = new Bookshelf();

        typewriterPrint("Добро пожаловать в систему управления книжным шкафом\n");

        while (true) {
            displayBookshelf(shelf);
            showMenu();
            int choice = readMenuChoice(scanner);
            executeOperation(choice, shelf, scanner);
            pauseEnter(scanner);
        }
    }

    private static void typewriterPrint(String message) throws InterruptedException {
        if (message == null || message.isBlank()) {
            return;
        }

        for (String ch : message.split("")) {
            System.out.print(ch);
            Thread.sleep(80);
        }
        System.out.println();
    }

    private static void displayBookshelf(Bookshelf shelf) {
        System.out.println("В шкафу книг - " + shelf.getCount() + ", свободно полок - " +
                shelf.getFreeSlots());

        if (shelf.getCount() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу\n");
            return;
        }

        Book[] books = shelf.getAll();

        for (int i = 0; i < 10; i++) {
            if (i < books.length) {
                String bookInfo = books[i].toString();
                String paddedInfo = bookInfo + " ".repeat(SHELF_WIDTH - bookInfo.length());
                System.out.println("|" + paddedInfo + "|");
            } else {
                System.out.println("|" + " ".repeat(SHELF_WIDTH) + "|");
            }

            if (i < 9) {
                System.out.println("|" + "-".repeat(SHELF_WIDTH) + "|");
            }
        }
        System.out.println();
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1) Добавить книгу");
        System.out.println("2) Найти книгу по названию");
        System.out.println("3) Удалить книгу по названию");
        System.out.println("4) Очистить шкаф");
        System.out.println("5) Завершить");
        System.out.print("Ваш выбор: ");
    }

    private static int readMenuChoice(Scanner scanner) {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= 5) {
                    return choice;
                } else {
                    System.out.println("Ошибка: неверное значение меню (" + choice + "). " +
                            "Допустимые значения: 1-5");
                    System.out.print("Повторите ввод: ");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: значение должно быть целым числом");
                scanner.nextLine();
                System.out.print("Повторите ввод: ");
            }
        }
    }

    private static void executeOperation(int choice, Bookshelf shelf, Scanner scanner) {
        switch (choice) {
            case 1:
                addBook(shelf, scanner);
                break;
            case 2:
                findBook(shelf, scanner);
                break;
            case 3:
                removeBook(shelf, scanner);
                break;
            case 4:
                clearBookshelf(shelf);
                break;
            case 5:
                System.out.println("Программа завершена");
                System.exit(0);
                break;
        }
    }

    private static void addBook(Bookshelf shelf, Scanner scanner) {
        System.out.println("\n=== Добавление книги ===");

        String author = readAuthor(scanner);
        String title = readTitle(scanner);
        Year year = readYear(scanner);

        Book book = new Book(author, title, year);

        if (shelf.add(book)) {
            System.out.println("Книга успешно добавлена");
        } else {
            System.out.println("Ошибка: не удалось добавить книгу - шкаф заполнен");
        }
    }

    private static String readAuthor(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите автора: ");
                String author = scanner.nextLine().trim();

                new Book(author, "temp", Year.of(2000));
                return author;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readTitle(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите название: ");
                String title = scanner.nextLine().trim();

                new Book("temp", title, Year.of(2000));
                return title;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Year readYear(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите год издания: ");
                String input = scanner.nextLine().trim();

                int yearValue = Integer.parseInt(input);

                new Book("temp", "temp", Year.of(yearValue));
                return Year.of(yearValue);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: год должен быть целым числом");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void findBook(Bookshelf shelf, Scanner scanner) {
        System.out.println("\n=== Поиск книги ===");

        String title = readTitle(scanner);

        Book foundBook = shelf.find(title);
        if (foundBook != null) {
            System.out.println("Книга найдена: " + foundBook);
        } else {
            System.out.println("Книга не найдена");
        }
    }

    private static void removeBook(Bookshelf shelf, Scanner scanner) {
        System.out.println("\n=== Удаление книги ===");

        String title = readTitle(scanner);

        if (shelf.remove(title)) {
            System.out.println("Книга удалена");
        } else {
            System.out.println("Книга не удалена (не найдена)");
        }
    }

    private static void clearBookshelf(Bookshelf shelf) {
        System.out.println("\n=== Очистка шкафа ===");
        shelf.clear();
        System.out.println("Шкаф очищен");
    }

    private static void pauseEnter(Scanner scanner) {
        System.out.println("Для продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
        System.out.println();
    }
}
