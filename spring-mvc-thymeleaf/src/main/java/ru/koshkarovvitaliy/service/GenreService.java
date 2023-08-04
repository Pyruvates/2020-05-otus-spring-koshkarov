package ru.koshkarovvitaliy.service;

import jakarta.persistence.EntityManager;
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
    private final EntityManager em;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @SuppressWarnings("unchecked")
    public List<Genre> getUniqueByNameGenres() {
        return em.createNamedQuery("unique_by_name_genres").getResultList();
    }

    public Genre saveGenre(final Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre getGenreById(final Integer id) {
        return genreRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteGenreById(final Integer id) {
        genreRepository.deleteById(id);
    }
}