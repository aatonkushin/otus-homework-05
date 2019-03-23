package org.tonkushin.hw05.dao.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.tonkushin.hw05.domain.Book;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbc;

    @Autowired
    public BookDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public long count() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.queryForObject("select count(*) from books", params, Long.class);
    }

    @Override
    public long insert(Book item) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("name", item.getName());
        params.addValue("author_id", item.getAuthor().getId());
        params.addValue("genre_id", item.getGenre().getId());
        jdbc.update("insert into books (`name`, author_id, genre_id) values (:name, :author_id, :genre_id)", params, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public Book getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbc.queryForObject(
                "select books.id, books.name, author_id, authors.name, genre_id, genres.name " +
                        "from books " +
                        "inner join authors on books.author_id = authors.id " +
                        "inner join genres on books.genre_id = genres.id " +
                        "where books.id = :id ", params, new BookMapper());
    }

    @Override
    public List<Book> getAll() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query("select books.id, books.name, author_id, authors.name, genre_id, genres.name " +
                "from books " +
                "inner join authors on books.author_id = authors.id " +
                "inner join genres on books.genre_id = genres.id", params, new BookMapper());
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        jdbc.update("delete from books where id = :id", params);
    }
}
