package org.tonkushin.hw05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonkushin.hw05.dao.author.AuthorDao;
import org.tonkushin.hw05.domain.Author;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao dao;

    @Autowired
    public AuthorServiceImpl(AuthorDao dao) {
        this.dao = dao;
    }

    @Override
    public long count() {
        return dao.count();
    }

    @Override
    public Author insert(Author item) {
        long id = dao.insert(item);
        item.setId(id);

        return item;
    }

    @Override
    public Author getById(long id) {

        return dao.getById(id);
    }

    @Override
    public List<Author> getAll() {
        return dao.getAll();
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }
}
