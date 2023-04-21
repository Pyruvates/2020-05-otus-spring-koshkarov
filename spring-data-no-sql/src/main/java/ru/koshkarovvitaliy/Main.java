package ru.koshkarovvitaliy;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.repository.GenreRepository;

import java.util.List;

@SpringBootApplication
@EnableMapRepositories
@Log4j2
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Spring Data NoSQL!");

        ApplicationContext ctx = SpringApplication.run(Main.class, args);

        GenreRepository genreRepository = ctx.getBean(GenreRepository.class);

        List<Genre> all = genreRepository.findAll();
        log.info("Before save: {}", all);

        genreRepository.save(new Genre(1, "Biography"));

        all = genreRepository.findAll();
        log.info("Before save: {}", all);
    }
}