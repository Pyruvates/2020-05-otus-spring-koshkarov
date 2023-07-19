package ru.koshkarovvitaliy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "library")
public class LibraryController {

    @GetMapping
    public String library() {
        return "library/library.html";
    }
}