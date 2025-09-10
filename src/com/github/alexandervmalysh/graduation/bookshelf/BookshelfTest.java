package com.github.alexandervmalysh.graduation.bookshelf;

import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    private static final int SHELF_WIDTH = 44;
    private static final int MIN_MENU_VALUE = 1;
    private static final int MAX_MENU_VALUE = 5;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();

        typeWelcome();

        while (true) {
            displayBookshelf(bookshelf);
            showMenu();
            int choice = selectMenu(scanner);

            if (choice == 5) {
                System.out.println("Программа завершена");
                break;
            }

            executeOperation(choice, bookshelf, scanner);

            pauseEnter(scanner);
        }
        scanner.close();
    }

    private static void typeWelcome() throws InterruptedException {
        String message = "Добро пожаловать в систему управления книжным шкафом\n";

        for (String ch : message.split("")) {
            System.out.print(ch);
            Thread.sleep(80);
        }
        System.out.println();
    }

    private static void displayBookshelf(Bookshelf bookshelf) {
        System.out.println("В шкафу книг - " + bookshelf.getCount() + ", свободно полок - " +
                bookshelf.getFreeSlots());

        if (bookshelf.getCount() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу\n");
            return;
        }

        Book[] books = bookshelf.getAll();

        for (int i = 0; i < Bookshelf.CAPACITY; i++) {
            if (i < books.length) {
                String bookInfo = books[i].toString();
                String paddedInfo = bookInfo + " ".repeat(SHELF_WIDTH - bookInfo.length());
                System.out.println("|" + paddedInfo + "|");
            } else {
                System.out.println("|" + " ".repeat(SHELF_WIDTH) + "|");
            }

            if (i < Bookshelf.CAPACITY - 1) {
                System.out.println("|" + "-".repeat(SHELF_WIDTH) + "|");
            }
        }
        System.out.println();
    }

    private static void showMenu() {
        System.out.print("""
                Выберите действие:
                1) Добавить книгу
                2) Найти книгу по названию
                3) Удалить книгу по названию
                4) Очистить шкаф
                5) Завершить
                Ваш выбор: \
                """);
    }

    private static int selectMenu(Scanner scanner) {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= MIN_MENU_VALUE && choice <= MAX_MENU_VALUE) return choice;

                System.out.println("Ошибка: неверное значение меню (" + choice + "). " +
                        "Допустимые значения: " + MIN_MENU_VALUE + "-" + MAX_MENU_VALUE);
                System.out.print("Повторите ввод: ");
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: значение должно быть целым числом");
                scanner.nextLine();
                System.out.print("Повторите ввод: ");
            }
        }
    }

    private static void executeOperation(int choice, Bookshelf bookshelf, Scanner scanner) {
        switch (choice) {
            case 1 -> addBook(bookshelf, scanner);
            case 2 -> findBook(bookshelf, scanner);
            case 3 -> removeBook(bookshelf, scanner);
            case 4 -> clearBookshelf(bookshelf);
            default -> System.out.println("Неизвестная операция");
        }
    }

    private static void addBook(Bookshelf bookshelf, Scanner scanner) {
        System.out.println("\n=== Добавление книги ===");

        String author = inputAuthor(scanner);
        String title = inputTitle(scanner);
        Year year = inputYear(scanner);

        Book book = new Book(author, title, year);

        if (bookshelf.add(book)) {
            System.out.println("Книга успешно добавлена");
        } else {
            System.out.println("Ошибка: не удалось добавить книгу - шкаф заполнен");
        }
    }

    private static void findBook(Bookshelf bookshelf, Scanner scanner) {
        System.out.println("\n=== Поиск книги ===");

        String title = inputTitle(scanner);

        Book foundBook = bookshelf.find(title);
        if (foundBook != null) {
            System.out.println("Книга найдена: " + foundBook);
        } else {
            System.out.println("Книга не найдена");
        }
    }

    private static void removeBook(Bookshelf bookshelf, Scanner scanner) {
        System.out.println("\n=== Удаление книги ===");

        String title = inputTitle(scanner);

        if (bookshelf.remove(title)) {
            System.out.println("Книга удалена");
        } else {
            System.out.println("Книга не удалена (не найдена)");
        }
    }

    private static void clearBookshelf(Bookshelf bookshelf) {
        System.out.println("\n=== Очистка шкафа ===");
        bookshelf.clear();
        System.out.println("Шкаф очищен");
    }

    private static String inputTitle(Scanner scanner) {
        while (true) {
            System.out.print("Введите название: ");
            String title = scanner.nextLine().trim();

            if (!title.isBlank()) {
                return title;
            }
            System.out.println("Ошибка: название не может быть пустым");
        }
    }

    private static String inputAuthor(Scanner scanner) {
        while (true) {
            System.out.print("Введите автора: ");
            String author = scanner.nextLine().trim();

            if (!author.isBlank()) {
                return author;
            }
            System.out.println("Ошибка: автор не может быть пустым");
        }
    }

    private static Year inputYear(Scanner scanner) {
        while (true) {
            System.out.print("Введите год издания: ");
            String input = scanner.nextLine().trim();

            if (input.isBlank()) {
                System.out.println("Ошибка: год не может быть пустым");
                continue;
            }
            try {
                Year year = Year.of(Integer.parseInt(input));
                if (year.isBefore(Book.MIN_YEAR) || year.isAfter(Year.now())) {
                    System.out.println("Ошибка: год издания должен быть между 1800 и текущим");
                    continue;
                }
                return year;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: год должен быть целым числом");
            }
        }
    }

    private static void pauseEnter(Scanner scanner) {
        System.out.println("Для продолжения работы нажмите клавишу <Enter>");
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            System.out.println("Ошибка: ввод должен быть пустым. Нажмите клавишу <Enter>");
        }
        System.out.println();
    }
}
