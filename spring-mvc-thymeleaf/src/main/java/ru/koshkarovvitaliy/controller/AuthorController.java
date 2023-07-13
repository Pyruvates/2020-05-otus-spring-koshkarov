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
@RequestMapping(path = "/library")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping(path = "/authors")
    public String authors(final Model authorModel) {
        List<Author> authors = authorService.getAllAuthors();

        log.info("All authors {}", authors);

        authorModel.addAttribute("authors", authors);

        return "author/authors";
    }
}