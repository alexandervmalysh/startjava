package com.github.alexandervmalysh.graduation.bookshelf;

import com.github.alexandervmalysh.graduation.bookshelf.exception.BookNotFoundException;
import com.github.alexandervmalysh.graduation.bookshelf.exception.BookshelfFullException;
import com.github.alexandervmalysh.graduation.bookshelf.exception.InvalidMenuChoiceException;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    private static final int MIN_SHELF_WIDTH = 44;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();

        typeWelcome();

        while (true) {
            displayBookshelf(bookshelf);
            showMenu(bookshelf);

            int choice = selectMenu(scanner, bookshelf);

            int exitNumber = (bookshelf.getCount() == 0) ? 2 :
                    (bookshelf.getCount() >= Bookshelf.CAPACITY ? 4 : 5);

            if (choice == exitNumber) {
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
        int shelfContentWidth = Math.max(bookshelf.getMaxBookLength(), MIN_SHELF_WIDTH);

        for (int i = 0; i < Bookshelf.CAPACITY; i++) {
            if (i < books.length) {
                String bookInfo = books[i].toString();
                String paddedInfo = bookInfo + " ".repeat(shelfContentWidth - bookInfo.length());
                System.out.println("|" + paddedInfo + "|");
            } else {
                System.out.println("|" + " ".repeat(shelfContentWidth) + "|");
            }

            if (i < Bookshelf.CAPACITY - 1) {
                System.out.println("|" + "-".repeat(shelfContentWidth) + "|");
            }
        }
        System.out.println();
    }

    private static void showMenu(Bookshelf bookshelf) {
        System.out.println("Выберите действие: ");

        int menuNumber = 1;

        if (bookshelf.getCount() == 0) {
            System.out.println(menuNumber++ + ") " + MenuOption.ADD_BOOK.getDescription());
            System.out.println(menuNumber + ") " + MenuOption.EXIT.getDescription());
        } else if (bookshelf.getCount() >= Bookshelf.CAPACITY) {
            System.out.println(menuNumber++ + ") " + MenuOption.FIND_BOOK.getDescription());
            System.out.println(menuNumber++ + ") " + MenuOption.REMOVE_BOOK.getDescription());
            System.out.println(menuNumber++ + ") " + MenuOption.CLEAR_BOOKSHELF.getDescription());
            System.out.println(menuNumber + ") " + MenuOption.EXIT.getDescription());
        } else {
            System.out.println(menuNumber++ + ") " + MenuOption.ADD_BOOK.getDescription());
            System.out.println(menuNumber++ + ") " + MenuOption.FIND_BOOK.getDescription());
            System.out.println(menuNumber++ + ") " + MenuOption.REMOVE_BOOK.getDescription());
            System.out.println(menuNumber++ + ") " + MenuOption.CLEAR_BOOKSHELF.getDescription());
            System.out.println(menuNumber + ") " + MenuOption.EXIT.getDescription());
        }

        System.out.print("Ваш выбор: ");
    }

    private static int selectMenu(Scanner scanner, Bookshelf bookshelf) {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                int minChoice = 1;
                int maxChoice;

                if (bookshelf.getCount() == 0) {
                    maxChoice = 2;
                } else if (bookshelf.getCount() >= Bookshelf.CAPACITY) {
                    maxChoice = 4;
                } else {
                    maxChoice = 5;
                }

                if (choice >= minChoice && choice <= maxChoice) return choice;

                System.out.println("Ошибка: неверное значение меню (" + choice + "). " +
                        "Допустимые значения: " + minChoice + "-" + maxChoice);
                System.out.print("Повторите ввод: ");
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: значение должно быть целым числом");
                scanner.nextLine();
                System.out.print("Повторите ввод: ");
            }
        }
    }

    private static void executeOperation(int choice, Bookshelf bookshelf, Scanner scanner) {
        MenuOption selectedOption;

        if (bookshelf.getCount() == 0) {
            switch (choice) {
                case 1 -> selectedOption = MenuOption.ADD_BOOK;
                case 2 -> selectedOption = MenuOption.EXIT;
                default -> throw new InvalidMenuChoiceException("Ошибка: неверный выбор пункта меню: " +
                    choice);
            }
        } else if (bookshelf.getCount() >= Bookshelf.CAPACITY) {
            switch (choice) {
                case 1 -> selectedOption = MenuOption.FIND_BOOK;
                case 2 -> selectedOption = MenuOption.REMOVE_BOOK;
                case 3 -> selectedOption = MenuOption.CLEAR_BOOKSHELF;
                case 4 -> selectedOption = MenuOption.EXIT;
                default -> throw new InvalidMenuChoiceException("Ошибка: неверный выбор пункта меню: " +
                        choice);
            }
        } else {
            switch (choice) {
                case 1 -> selectedOption = MenuOption.ADD_BOOK;
                case 2 -> selectedOption = MenuOption.FIND_BOOK;
                case 3 -> selectedOption = MenuOption.REMOVE_BOOK;
                case 4 -> selectedOption = MenuOption.CLEAR_BOOKSHELF;
                case 5 -> selectedOption = MenuOption.EXIT;
                default -> throw new InvalidMenuChoiceException("Ошибка: неверный выбор пункта меню: " +
                        choice);
            }
        }

        switch (selectedOption) {
            case ADD_BOOK -> addBook(bookshelf, scanner);
            case FIND_BOOK -> findBook(bookshelf, scanner);
            case REMOVE_BOOK -> removeBook(bookshelf, scanner);
            case CLEAR_BOOKSHELF -> clearBookshelf(bookshelf);
            case EXIT -> System.out.println("Программа завершена");
            default -> throw new InvalidMenuChoiceException("Ошибка: неизвестная операция");
        }
    }

    private static void addBook(Bookshelf bookshelf, Scanner scanner) {
        System.out.println("\n=== Добавление книги ===");

        String author = inputAuthor(scanner);
        String title = inputTitle(scanner);
        Year year = inputYear(scanner);

        try {
            bookshelf.add(new Book(author, title, year));
            System.out.println("Книга успешно добавлена");
        } catch (BookshelfFullException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void findBook(Bookshelf bookshelf, Scanner scanner) {
        System.out.println("\n=== Поиск книги ===");

        String title = inputTitle(scanner);
        Book[][] found = bookshelf.find(title);

        if (found.length == 0) {
            System.out.println("Ошибка: книга с названием \"" + title + "\" не найдена");
            return;
        }

        System.out.println("Найдено: " + found.length + " шт.");

        for (int i = 0; i < found.length; i++) {
            System.out.println((i + 1) + ") " + found[i][0]);
        }
    }

    private static void removeBook(Bookshelf bookshelf, Scanner scanner) {
        System.out.println("\n=== Удаление книги ===");

        String title = inputTitle(scanner);

        try {
            bookshelf.remove(title);
            System.out.println("Книга удалена");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
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
            System.out.println("Ошибка: название книги не может быть пустым");
        }
    }

    private static String inputAuthor(Scanner scanner) {
        while (true) {
            System.out.print("Введите автора: ");
            String author = scanner.nextLine().trim();

            if (!author.isBlank()) {
                return author;
            }
            System.out.println("Ошибка: автор книги не может быть пустым");
        }
    }

    private static Year inputYear(Scanner scanner) {
        while (true) {
            System.out.print("Введите год издания: ");
            String input = scanner.nextLine().trim();

            if (input.isBlank()) {
                System.out.println("Ошибка: год издания не может быть пустым");
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
                System.out.println("Ошибка: год издания должен быть целым числом");
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
