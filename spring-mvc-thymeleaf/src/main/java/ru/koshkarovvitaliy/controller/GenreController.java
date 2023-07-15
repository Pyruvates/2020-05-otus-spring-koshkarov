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
    public ModelAndView genres(@Value("genre/genre.html") final ModelAndView genresModelAndView) {
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

    @GetMapping(path = "/genre/edit")
    public ModelAndView editGenre(@Value("genre/edit.html") final ModelAndView editModelAndView,
                                  @RequestParam("id") final Integer id) {
        Genre genre = genreService.getGenreById(id);

        log.info("Genre found by id {}", genre);

        editModelAndView.addObject("genre", genre);

        return editModelAndView;
    }

    @PostMapping(path = "/genre/edit", params = "save")
    public ModelAndView saveEditedGenre(@ModelAttribute("genre") final Genre genre) {
        Genre editedGenre = genreService.saveGenre(genre);

        log.info("Saved genre after edit {}", editedGenre);

        return new ModelAndView("redirect:/library/genre");
    }

    @PostMapping(path = "/genre/edit", params = "cancel")
    public ModelAndView cancelSaveEditedGenre(@ModelAttribute("genre") final Genre genre) {
        log.info("Cancel edit {}", genre);

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