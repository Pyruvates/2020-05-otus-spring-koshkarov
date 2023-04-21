package ru.koshkarovvitaliy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.stereotype.Repository;
import ru.koshkarovvitaliy.model.Genre;

import java.util.List;

@Repository
public class GenreRepository {
    @Autowired
    private KeyValueOperations keyValueTemplate;

    public List<Genre> findAll() {
        return (List<Genre>) keyValueTemplate.findAll(Genre.class);
    }

    public Genre save(Genre genre) {
        return keyValueTemplate.insert(genre);
    }
}