package ru.koshkarovvitaliy.quiz.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class Options {

    @Value("${options.path}")
    private String path;
}
