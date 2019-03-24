package org.tonkushin.hw05.dao.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.tonkushin.hw05.domain.Genre;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GenreDaoJdbc implements GenreDao {
    private final NamedParameterJdbcOperations jdbc;

    @Autowired
    public GenreDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public long count() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.queryForObject("select count(*) from genres", params, Long.class);
    }

    @Override
    public long insert(Genre item) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", item.getName());
        jdbc.update("insert into genres (`name`) values (:name)", params, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public Genre getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbc.queryForObject("select * from genres where id = :id", params, new GenreMapper());
    }

    @Override
    public List<Genre> getAll() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query("select * from genres order by name", params, new GenreMapper());
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        jdbc.update("delete from genres where id = :id", params);
    }
}
