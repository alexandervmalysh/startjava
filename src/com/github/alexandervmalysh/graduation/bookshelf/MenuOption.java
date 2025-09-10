package com.github.alexandervmalysh.graduation.bookshelf;

public enum MenuOption {
    ADD_BOOK("Добавить книгу"),
    FIND_BOOK("Найти книгу по названию"),
    REMOVE_BOOK("Удалить книгу по названию"),
    CLEAR_BOOKSHELF("Очистить шкаф"),
    EXIT("Завершить");

    private final String description;

    MenuOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
