package org.tonkushin.hw05.domain;

/**
 * Жанры книг
 */
public class Genre {
    private final int id;           //код в БД
    private final String name;      //Наименование жанра

    /**
     * Конструктор класса
     * @param id код в БД
     * @param name наименование жанра
     */
    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * код в БД
     * @return код в БД
     */
    public int getId() {
        return id;
    }

    /**
     * Наименование жанра
     * @return Наименование жанра
     */
    public String getName() {
        return name;
    }
}
