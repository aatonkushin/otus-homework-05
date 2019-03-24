package org.tonkushin.hw05.dao.author;

import org.springframework.jdbc.core.RowMapper;
import org.tonkushin.hw05.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new Author(id, name);
    }
}
