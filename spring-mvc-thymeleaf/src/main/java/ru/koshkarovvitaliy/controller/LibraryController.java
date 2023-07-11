package ru.koshkarovvitaliy.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

        ModelAndView genresModelAndView = new ModelAndView("genre/genres.html");
        genresModelAndView.addObject("genres", genres);

        return genresModelAndView;
    }

    @GetMapping(path = "/genres/addNewGenre")
    public ModelAndView addNewGenre(@ModelAttribute("genre") final Genre genre) {
        return new ModelAndView("genre/newGenre.html");
    }

    @PostMapping(path = "/genres/saveNewGenre", params = "add")
    public ModelAndView saveNewGenre(@ModelAttribute("genre") final Genre genre) {
        Genre newGenre = genreService.saveNewGenre(genre);

        log.info("Saved genre: {}", newGenre);

        return new ModelAndView("redirect:/library/genres");
    }

    @PostMapping(path = "/genres/saveNewGenre", params = "cancel")
    public ModelAndView cancelSaveNewGenre() {
        return new ModelAndView("redirect:/library/genres");
    }

//    TODO: make redirect genres page and redirect after edit to genres page
    @GetMapping(path = "genres/edit")
    public ModelAndView editGenre(@ModelAttribute("genre") final Genre genre) {
        return new ModelAndView("genre/editGenre.html")
                .addObject("genre", genre);
    }

    @GetMapping(path = "/authors")
    public String authors(final Model authorModel) {
        List<Author> authors = authorService.getAllAuthors();

        log.info("All authors: {}", authors);

        authorModel.addAttribute("authors", authors);

        return "author/authors";
    }
}