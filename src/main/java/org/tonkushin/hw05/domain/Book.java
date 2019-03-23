package org.tonkushin.hw05.domain;

/**
 * Книга
 */
public class Book {
    private int id;           //код в БД
    private String name;      //Наименование книги
    private Genre genre;      //жанр книги
    private Author author;    //автор книги

    public Book() {
    }

    /**
     * Конструктор класса
     *
     * @param id     код в БД
     * @param name   наименование книги
     * @param genre  жанр книги
     * @param author автор книги
     */
    public Book(int id, String name, Genre genre, Author author) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
