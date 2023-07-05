package ru.koshkarovvitaliy.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.service.LibraryService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping(path = "/library")
@AllArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping(path = "/genres")
    public ModelAndView genres() {
        List<Genre> genres = libraryService.getAllGenres();

        log.info("{}", genres);

        ModelAndView modelAndView = new ModelAndView("genres.html");
        modelAndView.addObject("genres", genres);

        return modelAndView;
    }
}