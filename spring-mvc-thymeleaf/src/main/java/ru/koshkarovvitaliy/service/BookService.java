package ru.koshkarovvitaliy.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.model.BookDTO;
import ru.koshkarovvitaliy.repository.BookRepository;
import ru.koshkarovvitaliy.repository.EntityNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(final Integer id) {
        return bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteBookById(final Integer id) {
        bookRepository.deleteById(id);
    }

    public void saveBook(final BookDTO bookDTO) {
        try {
            Book book = bookRepository.findById(bookDTO.bookId()).orElseThrow(EntityNotFoundException::new);
            book.setName(bookDTO.bookName());
            book.getAuthor().setFirstName(bookDTO.authorFirstname());
            book.getAuthor().setLastName(bookDTO.authorLastname());
            book.getGenre().setName(bookDTO.genreName());

            Book savedBook = bookRepository.save(book);
            log.info("Book has been saved {}", savedBook);
        } catch (Exception ex) {
            log.info("Book hasn't been saved because of an error");
            log.error("{}: {}", ex.getClass(), ex.getMessage());
        }
    }
}