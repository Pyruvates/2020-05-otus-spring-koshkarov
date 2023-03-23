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
    public Genre getGenreById(int id) {
        return em.createQuery("SELECT g FROM Genre g WHERE id = ?1", Genre.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void addGenre(Genre genre) {
        if (genre.getId() <= 0) {
            em.persist(genre);
        } else {
            em.merge(genre);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAllAuthors() {
        return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    @Transactional
    @Override
    public void updateAuthor(Author author) {
        em.createQuery("UPDATE Author a SET a.firstName = :firstName, a.lastName = :lastName WHERE a.id = :id")
                .setParameter("id", author.getId())
                .setParameter("firstName", author.getFirstName())
                .setParameter("lastName", author.getLastName())
                .executeUpdate();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllBooks() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return em.createQuery("SELECT b FROM Book b WHERE genre = :genre")
                .setParameter("genre", genre)
                .getResultList();
    }

    @Transactional
    @Override
    public void removeBookById(int id) {
        em.createQuery("DELETE FROM Book b WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}