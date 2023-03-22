package ru.koshkarovvitaliy.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.model.Genre;

import java.util.List;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {
    @PersistenceContext
    private EntityManager em;
    @Transactional(readOnly = true)
    @Override
    public List<Genre> getAllGenres() {
        return em.createQuery("SELECT g FROM Genre g", Genre.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAllAuthors() {
        return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllBooks() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }
}