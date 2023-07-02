package ru.koshkarovvitaliy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.service.LibraryService;

import java.util.List;

@Controller
@Slf4j
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping(path = "/library")
    public String method() {
        List<Genre> genres = libraryService.getAllGenres();

        log.info("{}", genres);

        return "library";
    }
}