package ru.koshkarovvitaliy.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Answers {

    @Value("${answers.path}")
    private String path;

    private List<Integer> results = new ArrayList<>();
}
