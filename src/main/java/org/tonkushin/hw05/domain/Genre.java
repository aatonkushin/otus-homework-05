package org.tonkushin.hw05.domain;

/**
 * Жанры книг
 */
public class Genre {
    private long id;           //код в БД
    private String name;      //Наименование жанра

    /**
     * Конструктор класса
     * @param name наименование жанра
     */
    public Genre(String name) {
        this.name = name;
    }

    public Genre(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Код в БД
     * @return код в БД
     */
    public long getId() {
        return id;
    }

    /**
     * Код в БД
     * @param id Код в БД
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Наименование жанра
     * @return Наименование жанра
     */
    public String getName() {
        return name;
    }

    /**
     * Наименование жанра
     * @param name Наименование жанра
     */
    public void setName(String name) {
        this.name = name;
    }
}
