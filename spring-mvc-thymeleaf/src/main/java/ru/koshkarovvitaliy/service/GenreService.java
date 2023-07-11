package ru.koshkarovvitaliy.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.repository.EntityNotFoundException;
import ru.koshkarovvitaliy.repository.GenreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre saveNewGenre(final Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre findById(final Integer id) {
        return genreRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteGenre(final Integer id) {
        genreRepository.deleteById(id);
    }
}