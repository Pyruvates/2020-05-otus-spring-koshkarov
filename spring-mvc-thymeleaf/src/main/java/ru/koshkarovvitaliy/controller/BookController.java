package ru.koshkarovvitaliy.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.service.BookService;

import java.util.List;

@Controller
@RequestMapping(path = "/library")
@AllArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;

    @GetMapping(path = "/book")
    public String getAllBooks(final Model bookModel) {
        List<Book> books = bookService.getAllBooks();

        log.info("All books {}", books);

        bookModel.addAttribute("books", books);

        return "book/book.html";
    }
}