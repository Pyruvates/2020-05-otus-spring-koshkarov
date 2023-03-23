package ru.koshkarovvitaliy.repository;

import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.model.Genre;

import java.util.List;

public interface LibraryRepository {
    List<Genre> getAllGenres();
    Genre getGenreById(int id);
    void addGenre(Genre genre);
    List<Author> getAllAuthors();
    void updateAuthor(Author author);
    List<Book> getAllBooks();
    List<Book> getBooksByGenre(Genre genre);
    void removeBookById(int id);
}