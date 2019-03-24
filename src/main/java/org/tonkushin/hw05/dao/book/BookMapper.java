package org.tonkushin.hw05.dao.book;

import org.springframework.jdbc.core.RowMapper;
import org.tonkushin.hw05.domain.Author;
import org.tonkushin.hw05.domain.Book;
import org.tonkushin.hw05.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("books.id");
        String name = resultSet.getString("books.name");

        long authorId = resultSet.getLong("author_id");
        String authorName = resultSet.getString("authors.name");
        Author author = new Author(id, authorName);

        long genreId = resultSet.getLong("genre_id");
        String genreName = resultSet.getString("genres.name");
        Genre genre = new Genre(id, genreName);

        Book item = new Book();
        item.setId(id);
        item.setName(name);
        item.setAuthor(author);
        item.setGenre(genre);

        return item;
    }
}
