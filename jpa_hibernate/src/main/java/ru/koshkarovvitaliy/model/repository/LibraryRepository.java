package ru.koshkarovvitaliy.model.repository;

import ru.koshkarovvitaliy.model.Genre;

import java.util.List;

public interface LibraryRepository {
    List<Genre> findAllGenres();
}