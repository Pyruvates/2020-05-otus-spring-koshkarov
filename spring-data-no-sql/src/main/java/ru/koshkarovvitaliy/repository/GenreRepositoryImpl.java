package ru.koshkarovvitaliy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.stereotype.Repository;
import ru.koshkarovvitaliy.model.Genre;

import java.util.List;

@Repository
public class GenreRepositoryImpl implements GenreRepository {
    @Autowired
    private KeyValueOperations keyValueTemplate;

    @Override
    public List<Genre> findAll() {
        return (List<Genre>) keyValueTemplate.findAll(Genre.class);
    }

    @Override
    public Genre save(Genre genre) {
        return keyValueTemplate.insert(genre);
    }
}