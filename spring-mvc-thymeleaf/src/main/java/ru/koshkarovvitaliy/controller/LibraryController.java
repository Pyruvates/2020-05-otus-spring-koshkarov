package ru.koshkarovvitaliy.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.service.AuthorService;
import ru.koshkarovvitaliy.service.GenreService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping(path = "/library")
@AllArgsConstructor
public class LibraryController {
    private final AuthorService authorService;
    private final GenreService genreService;

    @GetMapping(path = "/genres")
    public ModelAndView genres() {
        List<Genre> genres = genreService.getAllGenres();

        log.info("All genres: {}", genres);

        ModelAndView modelAndView = new ModelAndView("genre/genres.html");
        modelAndView.addObject("genres", genres);

        return modelAndView;
    }

    @GetMapping(path = "/authors")
    public String authors(Model authorModel) {
        List<Author> authors = authorService.getAllAuthors();

        log.info("All authors: {}", authors);

        authorModel.addAttribute("authors", authors);

        return "author/authors";
    }
}