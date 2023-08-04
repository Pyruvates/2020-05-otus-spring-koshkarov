package ru.koshkarovvitaliy.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.service.GenreService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping(path = "/library")
@AllArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping(path = "/genre")
    public ModelAndView getAllGenres(@Value("genre/genre.html") final ModelAndView genresModelAndView) {
        List<Genre> genres = genreService.getAllGenres();

        log.info("All genres {}", genres);

        genresModelAndView.addObject("genres", genres);

        return genresModelAndView;
    }

    @GetMapping(path = "/genre/add-new-genre")
    public ModelAndView addNewGenre(@Value("genre/new.html") final ModelAndView addGenreModelAndView,
                                    @ModelAttribute("genre") final Genre genre) {
        return addGenreModelAndView;
    }

    @PostMapping(path = "/genre/save-new-genre", params = "add")
    public ModelAndView saveNewGenre(@ModelAttribute("genre") final Genre genre) {
        Genre newGenre = genreService.saveGenre(genre);

        log.info("Saved genre {}", newGenre);

        return new ModelAndView("redirect:/library/genre");
    }

    @PostMapping(path = "/genre/save-new-genre", params = "cancel")
    public ModelAndView cancelSaveNewGenre() {
        return new ModelAndView("redirect:/library/genre");
    }

    @PostMapping(path = "/genre/delete")
    public ModelAndView deleteGenre(@RequestParam("id") final Integer id) {
        Genre genre = genreService.getGenreById(id);

        genreService.deleteGenreById(id);

        log.info("{} has been deleted", genre);

        return new ModelAndView("redirect:/library/genre");
    }
}