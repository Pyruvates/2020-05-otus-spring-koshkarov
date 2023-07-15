package ru.koshkarovvitaliy.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.repository.AuthorRepository;
import ru.koshkarovvitaliy.repository.EntityNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author saveAuthor(final Author author) {
        return authorRepository.save(author);
    }

    public Author getAuthorById(final Integer id) {
        return authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}