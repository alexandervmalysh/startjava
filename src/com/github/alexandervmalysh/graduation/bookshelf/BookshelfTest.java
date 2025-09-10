package com.github.alexandervmalysh.graduation.bookshelf;

import com.github.alexandervmalysh.graduation.bookshelf.exception.BookNotFoundException;
import com.github.alexandervmalysh.graduation.bookshelf.exception.BookshelfFullException;
import com.github.alexandervmalysh.graduation.bookshelf.exception.InvalidMenuChoiceException;
import java.time.Year;
import java.util.Scanner;

public class BookshelfTest {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();

        typeWelcome();

        while (true) {
            displayBookshelf(bookshelf);
            showMenu(bookshelf);

            MenuOption selected = selectMenu(scanner, bookshelf);

            if (selected == MenuOption.EXIT) {
                System.out.println("Программа завершена");
                break;
            }

            executeOperation(selected, bookshelf, scanner);
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
        if (bookshelf.getCount() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу\n");
            return;
        }

        System.out.println("В шкафу книг - " + bookshelf.getCount() +
                ", свободно полок - " + bookshelf.getFreeSlots());

        int shelfContentWidth = bookshelf.getMaxBookLength();
        Book[] books = bookshelf.getAll();
        String[] contents = new String[Bookshelf.CAPACITY];

        for (int i = 0; i < contents.length; i++) {
            String bookInfo = (i < books.length) ? books[i].toString() : "";
            contents[i] = bookInfo + " ".repeat(shelfContentWidth - bookInfo.length());
        }

        StringBuilder sb = new StringBuilder();
        String divider = "|" + "-".repeat(shelfContentWidth) + "|";

        for (String row : contents) {
            sb.append("|").append(row).append("|").append(System.lineSeparator());
            sb.append(divider).append(System.lineSeparator());
        }

        System.out.print(sb);
        System.out.println();
    }

    private static MenuOption[] getVisibleOptions(Bookshelf bookshelf) {
        int count = bookshelf.getCount();
        if (count == 0) {
            return new MenuOption[] {
                    MenuOption.ADD_BOOK,
                    MenuOption.EXIT
            };
        } else if (count >= Bookshelf.CAPACITY) {
            return new MenuOption[] {
                    MenuOption.FIND_BOOK,
                    MenuOption.REMOVE_BOOK,
                    MenuOption.CLEAR_BOOKSHELF,
                    MenuOption.EXIT
            };
        } else {
            return new MenuOption[] {
                    MenuOption.ADD_BOOK,
                    MenuOption.FIND_BOOK,
                    MenuOption.REMOVE_BOOK,
                    MenuOption.CLEAR_BOOKSHELF,
                    MenuOption.EXIT
            };
        }
    }

    private static void showMenu(Bookshelf bookshelf) {
        System.out.println("Выберите действие: ");

        MenuOption[] options = getVisibleOptions(bookshelf);

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ") " + options[i].getDescription());
        }

        System.out.print("Ваш выбор: ");
    }

    private static MenuOption selectMenu(Scanner scanner, Bookshelf bookshelf) {
        MenuOption[] options = getVisibleOptions(bookshelf);

        while (true) {
            String token = scanner.nextLine();
            try {
                return MenuOption.fromUserInput(options, token);
            } catch (InvalidMenuChoiceException e) {
                System.out.println(e.getMessage());
                System.out.print("Повторите ввод: ");
            }
        }
    }

    private static void executeOperation(MenuOption selectedOption, Bookshelf bookshelf, Scanner scanner) {
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
            System.out.println("Ошибка: книга не найдена");
            return;
        }

        System.out.println("Найдено: " + found.length);

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
