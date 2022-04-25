package ru.koshkarovvitaliy.quiz.model;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

@Getter
public class Questions {

    @Value("${questions.path}")
    private Resource resource;
}
