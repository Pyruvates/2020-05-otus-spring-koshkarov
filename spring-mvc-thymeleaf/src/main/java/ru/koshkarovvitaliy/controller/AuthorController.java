package ru.koshkarovvitaliy.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.service.AuthorService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping(path = "library")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping(path = "author")
    public String getAllAuthors(final Model authorModel) {
        List<Author> authors = authorService.getAllAuthors();

        log.info("All authors {}", authors);

        authorModel.addAttribute("authors", authors);

        return "author/author";
    }

    @GetMapping(path = "author/add-new-author")
    public String addNewAuthor(@ModelAttribute("author") final Author author) {
        return "author/new";
    }

    @PostMapping(path = "author/save-new-author", params = "add")
    public String saveNewAuthor(final Author author) {
        Author newAuthor = authorService.saveAuthor(author);

        log.info("New author has been saved {}", newAuthor);

        return "redirect:/library/author";
    }

    @PostMapping(path = "author/save-new-author", params = "cancel")
    public String cancelSaveNewAuthor() {
        return "redirect:/library/author";
    }
}