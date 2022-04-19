package ru.koshkarovvitaliy.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class Answers {

    @Value("${answers.path}")
    private String classPath;
}
