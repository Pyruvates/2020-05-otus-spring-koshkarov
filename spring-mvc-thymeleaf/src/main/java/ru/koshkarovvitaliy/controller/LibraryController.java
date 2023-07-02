package ru.koshkarovvitaliy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {

    @GetMapping(path = "/library")
    public String method() {
        return "library";
    }
}