package ru.koshkarovvitaliy.model;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Answers {

    @Value("${application.answers.path}")
    private Resource resource;

    @Value("${application.answers.max.failed.count}")
    private int maxFailedCount;

    private final List<Integer> results = new ArrayList<>();
}