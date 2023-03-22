package ru.koshkarovvitaliy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.repository.LibraryRepository;

import java.util.List;
@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public List<Genre> getAllGenres() {
        return libraryRepository.getAllGenres();
    }

    @Override
    public List<Author> getAllAuthors() {
        return libraryRepository.getAllAuthors();
    }

    @Override
    public List<Book> getAllBooks() {
        return libraryRepository.getAllBooks();
    }
}