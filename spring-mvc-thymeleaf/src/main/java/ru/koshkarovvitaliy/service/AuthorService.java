package ru.koshkarovvitaliy.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.repository.AuthorRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}