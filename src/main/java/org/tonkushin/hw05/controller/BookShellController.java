package org.tonkushin.hw05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.tonkushin.hw05.domain.Book;
import org.tonkushin.hw05.service.BookService;

import java.util.List;

@ShellComponent
public class BookShellController {
    private final BookService service;

    @Autowired
    public BookShellController(BookService service) {
        this.service = service;
    }

    @ShellMethod(value = "Выводит список всех книг", key = {"get-books", "gb"})
    public String getBooks() {
        List<Book> items = service.getAll();

        StringBuilder sb = new StringBuilder();
        sb.append("Код\tНазвание книги\tАвтор\tЖанр\n");
        for (Book item : items) {
            sb.append(item.getId()).append("\t")
                    .append(item.getName()).append("\t")
                    .append(item.getAuthor().getName()).append("\t")
                    .append(item.getGenre().getName()).append("\n");
        }

        return sb.toString();
    }

    @ShellMethod(value = "Добавляет книгу с названием name, автором с кодом authorId и жанром с кодом genreId", key = {"add-book", "ab"})
    public String addBook(String name, long authorId, long genreId) {
        service.insert(name, authorId, genreId);
        return "Книга с названием '" + name + "' добавлена";
    }

    @ShellMethod(value = "Удаляет книгу с указанным кодом.", key={"delete-book", "db"})
    public String deleteBook(long id) {
        service.deleteById(id);
        return "Книга удалена";
    }
}
