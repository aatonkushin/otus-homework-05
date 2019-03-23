package org.tonkushin.hw05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonkushin.hw05.dao.genre.GenreDao;
import org.tonkushin.hw05.domain.Genre;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreDao dao;

    @Autowired
    public GenreServiceImpl(GenreDao dao) {
        this.dao = dao;
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public Genre insert(Genre item) {
        int id = dao.insert(item);
        item.setId(id);

        return item;
    }

    @Override
    public Genre getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Genre> getAll() {
        return dao.getAll();
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
