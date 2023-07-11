package ru.koshkarovvitaliy.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping(path = "/genres")
    public ModelAndView genres() {
        List<Genre> genres = genreService.getAllGenres();

        log.info("All genres {}", genres);

        ModelAndView genresModelAndView = new ModelAndView("genre/genres.html");
        genresModelAndView.addObject("genres", genres);

        return genresModelAndView;
    }

    @GetMapping(path = "/genre/addNewGenre")
    public ModelAndView addNewGenre(@ModelAttribute("genre") final Genre genre) {
        return new ModelAndView("genre/new.html");
    }

    @PostMapping(path = "/genre/saveNewGenre", params = "add")
    public ModelAndView saveNewGenre(@ModelAttribute("genre") final Genre genre) {
        Genre newGenre = genreService.saveNewGenre(genre);

        log.info("Saved genre {}", newGenre);

        return new ModelAndView("redirect:/library/genres");
    }

    @PostMapping(path = "/genre/saveNewGenre", params = "cancel")
    public ModelAndView cancelSaveNewGenre() {
        return new ModelAndView("redirect:/library/genres");
    }

    @GetMapping(path = "genre/edit")
    public ModelAndView editGenre(@RequestParam("id") final Integer id, Model editModel) {
        Genre genre = genreService.findById(id);

        log.info("Found genre by id {}", genre);

        editModel.addAttribute("genre", genre);

        return new ModelAndView("genre/edit.html");
    }

    @PostMapping(path = "genre/edit", params = "save")
    public ModelAndView saveEditedGenre(@ModelAttribute("genre") final Genre genre) {
        Genre editedGenre = genreService.saveNewGenre(genre);
        log.info("Saved genre after edit {}", editedGenre);
        return new ModelAndView("redirect:/library/genres");
    }

    @PostMapping(path = "genre/edit", params = "cancel")
    public ModelAndView cancelSaveEditedGenre(@ModelAttribute("genre") final Genre genre) {
        log.info("Cancel edit {}", genre);
        return new ModelAndView("redirect:/library/genres");
    }
}