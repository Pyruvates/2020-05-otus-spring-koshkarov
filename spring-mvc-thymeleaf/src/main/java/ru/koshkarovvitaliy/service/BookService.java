package ru.koshkarovvitaliy.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.repository.BookRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}