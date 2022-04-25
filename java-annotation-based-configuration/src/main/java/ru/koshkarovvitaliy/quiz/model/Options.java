package ru.koshkarovvitaliy.quiz.model;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

@Getter
public class Options {

    @Value("${options.path}")
    private Resource resource;
}
