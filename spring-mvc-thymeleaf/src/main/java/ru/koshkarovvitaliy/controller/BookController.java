package ru.koshkarovvitaliy.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.model.BookDTO;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.service.AuthorService;
import ru.koshkarovvitaliy.service.BookService;
import ru.koshkarovvitaliy.service.GenreService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/library")
@AllArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;

    @GetMapping(path = "/book")
    public String getAllBooks(final Model bookModel) {
        List<Book> books = bookService.getAllBooks();
        log.info("All books {}", books);

        bookModel.addAttribute("books", books);

        return "book/book.html";
    }

    @GetMapping(path = "/book/add-new-book")
    public String addNewBook(@ModelAttribute("book") final Book book) {
        return "book/new";
    }

    @PostMapping(path = "/book/save-new-book", params = "add")
    public String saveNewBook(final Book book) {
        log.info("Passed params {}", book);

        Book savedBook = bookService.saveBook(book);
        log.info("Book has been saved {}", savedBook);

        return "redirect:/library/book";
    }

    @PostMapping(path = "/book/save-new-book", params = "cancel")
    public String cancelSaveNewBook() {
        return "redirect:/library/book";
    }

    @GetMapping(path = "/book/edit")
    public String editBook(final Model editModel, @RequestParam("id") final Integer id) {
        Book book = bookService.getBookById(id);
        log.info("Found {}", book);
        editModel.addAttribute("book", book);

        List<Genre> genres = genreService.getAllGenres();
        editModel.addAttribute("genres",
                genres.stream()
                        .map(Genre::getName)
                        .collect(Collectors.toSet()));

        List<Author> authors = authorService.getAllAuthors();
        editModel.addAttribute("authors",
                authors.stream()
                        .map(author -> String.join(" ", author.getFirstName(), author.getLastName()))
                        .collect(Collectors.toSet()));

        return "book/edit.html";
    }

    @PostMapping(path = "book/edit", params = "save")
    public String saveEditedBook(@RequestParam("id") final Integer bookId,
                                 @RequestParam("bookName") final String bookName,
                                 @RequestParam("authorFirstName") final String authorFName,
                                 @RequestParam("authorLastName") final String authorLName,
                                 @RequestParam("genreName") final String genreName) {
        BookDTO bookDTO = new BookDTO(bookId, bookName, authorFName, authorLName, genreName);
        log.info("Passed parameters: {}", bookDTO);

        bookService.saveBook(bookDTO);

        return "redirect:/library/book";
    }

    @PostMapping(path = "book/edit", params = "cancel")
    public String cancelSaveEditedBook() {
        return "redirect:/library/book";
    }

    @PostMapping(path = "/book/delete")
    public String deleteBook(@RequestParam("id") final Integer id) {
        Book book = bookService.getBookById(id);

        log.info("{} has been deleted", book);

        bookService.deleteBookById(id);

        return "redirect:/library/book";
    }
}