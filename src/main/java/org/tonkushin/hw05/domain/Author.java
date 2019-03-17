package org.tonkushin.hw05.domain;

/**
 * Авторы книг
 */
public class Author {
    private final int id;           //код в БД
    private final String name;      //Имя автора

    /**
     * Конструктор класса
     *
     * @param id   код в БД
     * @param name имя автора
     */
    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * код в БД
     *
     * @return код в БД
     */
    public int getId() {
        return id;
    }

    /**
     * код в БД
     *
     * @return код в БД
     */
    public String getName() {
        return name;
    }
}
