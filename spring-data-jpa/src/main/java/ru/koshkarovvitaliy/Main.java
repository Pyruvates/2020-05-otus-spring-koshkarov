package ru.koshkarovvitaliy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.repository.AuthorRepository;
import ru.koshkarovvitaliy.repository.GenreRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        List<Genre> genres = Arrays.asList(
                new Genre("Fantasy"),
                new Genre("Fan fiction"),
                new Genre("Programming")
        );

        Author joanneRowling = new Author("Joanne", "Rowling");
        Author robertMartin = new Author("Robert", "Martin");

        GenreRepository genreRepository = context.getBean(GenreRepository.class);
        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);

        genreRepository.saveAll(genres);
        authorRepository.save(joanneRowling);
        authorRepository.save(robertMartin);

        genreRepository.findAll().forEach(System.out::println);
        System.out.println("-------");
        authorRepository.findAll().forEach(System.out::println);
    }
}