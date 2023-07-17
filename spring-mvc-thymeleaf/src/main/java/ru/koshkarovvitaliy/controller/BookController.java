package ru.koshkarovvitaliy.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path = "/book/add-new-book")
    public String addNewBook(@ModelAttribute("book") final Book book) {
//        TODO: add implementation
        log.info("Adding new book");
        return "book/new";
    }

    @PostMapping(path = "/book/save-new-book", params = "add")
    public String saveNewBook() {
//        TODO: add implementation
        log.info("Save new book");
        return "redirect:/library/book";
    }

    @PostMapping(path = "/book/save-new-book", params = "cancel")
    public String cancelSaveNewBook() {
//        TODO: add implementation
        log.info("Cancel save new book");
        return "redirect:/library/book";
    }

    @GetMapping(path = "/book/edit")
    public String editBook(final Model editModel, @RequestParam("id") final Integer id) {
        Book book = bookService.getBookById(id);

        log.info("Found {}", book);

        editModel.addAttribute("book", book);

        return "book/edit.html";
    }

    @PostMapping(path = "book/edit", params = "save")
    public String saveEditedBook() {
//        TODO: add implementation
        log.info("Save edited book");
        return "redirect:/library/book";
    }

    @PostMapping(path = "book/edit", params = "cancel")
    public String cancelSaveEditedBook() {
//        TODO: add implementation
        log.info("Cancel save edited book");
        return "redirect:/library/book";
    }

    @PostMapping(path = "/book/delete")
    public String deleteBook(@RequestParam("id") final Integer id) {
        Book book = bookService.getBookById(id);

        bookService.deleteBookById(id);

        log.info("{} has been deleted", book);

        return "redirect:/library/book";
    }
}