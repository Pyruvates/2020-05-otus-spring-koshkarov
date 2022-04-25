package ru.koshkarovvitaliy.quiz.model;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Answers {

    @Value("${answers.path}")
    private Resource resource;

    @Value("${max.failed.count}")
    private int maxFailedCount;

    private final List<Integer> results = new ArrayList<>();
}
