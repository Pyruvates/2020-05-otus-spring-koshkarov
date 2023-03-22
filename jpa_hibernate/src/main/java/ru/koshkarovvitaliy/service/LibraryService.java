package ru.koshkarovvitaliy.service;

import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.model.Genre;

import java.util.List;

public interface LibraryService {
    List<Genre> getAllGenres();
    List<Author> getAllAuthors();
    List<Book> getAllBooks();
}