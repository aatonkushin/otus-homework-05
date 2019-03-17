package org.tonkushin.hw05.domain;

/**
 * Книга
 */
public class Book {
    private final int id;           //код в БД
    private final String name;      //Наименование книги
    private final Genre genre;      //жанр книги
    private final Author author;    //автор книги

    /**
     * Конструктор класса
     * @param id код в БД
     * @param name наименование книги
     * @param genre жанр книги
     * @param author автор книги
     */
    public Book(int id, String name, Genre genre, Author author) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
    }

    /**
     * код в БД
     * @return код в БД
     */
    public int getId() {
        return id;
    }

    /**
     * наименование книги
     * @return наименование книги
     */
    public String getName() {
        return name;
    }

    /**
     * жанр книги
     * @return жанр книги
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * автор книги
     * @return автор книги
     */
    public Author getAuthor() {
        return author;
    }
}
