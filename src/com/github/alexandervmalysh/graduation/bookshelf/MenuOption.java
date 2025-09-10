package com.github.alexandervmalysh.graduation.bookshelf;

import com.github.alexandervmalysh.graduation.bookshelf.exception.InvalidMenuChoiceException;

public enum MenuOption {
    ADD_BOOK(1, "Добавить книгу"),
    FIND_BOOK(2, "Найти книгу по названию"),
    REMOVE_BOOK(3, "Удалить книгу по названию"),
    CLEAR_BOOKSHELF(4, "Очистить шкаф"),
    EXIT(5, "Завершить");

    private final int number;
    private final String description;

    MenuOption(int number, String description) {
        this.number = number;
        this.description = description;
    }

    @SuppressWarnings("unused")
    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOption fromUserInput(MenuOption[] options, String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            throw new InvalidMenuChoiceException("Ошибка: значение должно быть целым числом");
        }

        final int min = 1;
        final int max = options.length;
        final int choice;

        try {
            choice = Integer.parseInt(userInput.trim());
        } catch (NumberFormatException e) {
            throw new InvalidMenuChoiceException("Ошибка: значение должно быть целым числом");
        }

        if (choice < min || choice > max) {
            throw new InvalidMenuChoiceException("Ошибка: Неверное значение меню (" + choice + "). " +
                    "Допустимые значения: " + min + "-" + max
            );
        }

        return options[choice - 1];
    }
}
