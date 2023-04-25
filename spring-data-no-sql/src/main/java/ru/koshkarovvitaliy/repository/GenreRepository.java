package ru.koshkarovvitaliy.repository;

import ru.koshkarovvitaliy.model.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> findAll();
    Genre save(Genre genre);
}