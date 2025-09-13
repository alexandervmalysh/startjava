package com.github.alexandervmalysh.graduation.bookshelf;

import com.github.alexandervmalysh.graduation.bookshelf.exception.InvalidMenuChoiceException;

public enum MenuOption {
    ADD(1, "Добавить книгу"),
    FIND(2, "Найти книгу по названию"),
    REMOVE(3, "Удалить книгу по названию"),
    CLEAR(4, "Очистить шкаф"),
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

        final int firstAllowedIndex = 1;
        final int lastAllowedIndex = options.length;
        final int choice;

        try {
            choice = Integer.parseInt(userInput.trim());
        } catch (NumberFormatException e) {
            throw new InvalidMenuChoiceException("Ошибка: значение должно быть целым числом");
        }

        if (choice < firstAllowedIndex || choice > lastAllowedIndex) {
            throw new InvalidMenuChoiceException("Ошибка: Неверное значение меню (" + choice + "). " +
                    "Допустимые значения: " + firstAllowedIndex + "-" + lastAllowedIndex
            );
        }

        return options[choice - 1];
    }
}
