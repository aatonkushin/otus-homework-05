package org.tonkushin.hw05.dao.genre;

import org.springframework.jdbc.core.RowMapper;
import org.tonkushin.hw05.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new Genre(id, name);
    }
}
