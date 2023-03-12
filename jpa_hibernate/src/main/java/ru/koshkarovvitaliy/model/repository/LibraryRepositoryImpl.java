package ru.koshkarovvitaliy.model.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.koshkarovvitaliy.model.Genre;

import java.util.Collections;
import java.util.List;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {
    @Override
    @Transactional(readOnly = true)
    public List<Genre> findAllGenres() {
        return Collections.emptyList();
    }
}