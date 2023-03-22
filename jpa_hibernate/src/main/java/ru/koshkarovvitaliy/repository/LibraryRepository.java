package ru.koshkarovvitaliy.repository;

import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.model.Genre;

import java.util.List;

public interface LibraryRepository {
    List<Genre> getAllGenres();
    List<Author> getAllAuthors();
    List<Book> getAllBooks();
}