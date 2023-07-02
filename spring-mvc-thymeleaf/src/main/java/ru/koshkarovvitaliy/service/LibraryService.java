package ru.koshkarovvitaliy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.koshkarovvitaliy.GenreRepository;
import ru.koshkarovvitaliy.model.Genre;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}