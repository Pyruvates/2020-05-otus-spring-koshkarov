package ru.koshkarovvitaliy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.repository.AuthorRepository;
import ru.koshkarovvitaliy.repository.BookRepository;
import ru.koshkarovvitaliy.repository.GenreRepository;

import java.util.Arrays;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        Genre fantasy = new Genre("Fantasy");
        Genre fanFiction = new Genre("Fan fiction");
        Genre programming = new Genre("Programming");

        Author joanneRowling = new Author("Joanne", "Rowling");
        Author robertMartin = new Author("Robert", "Martin");

        Book harryPotterAndMethodsOfRationality = new Book("Harry Potter and the Methods of Rationality");
        Book cleanCode = new Book("Clean Code", robertMartin, programming);

        GenreRepository genreRepository = context.getBean(GenreRepository.class);
        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);

        bookRepository.save(harryPotterAndMethodsOfRationality);
        bookRepository.save(cleanCode);

        System.out.println("-------");
        bookRepository.findAll().forEach(System.out::println);
        System.out.println("-------");

        genreRepository.saveAll(Arrays.asList(fantasy, fanFiction, programming));
        genreRepository.findAll().forEach(System.out::println);
        System.out.println("-------");

        authorRepository.findAll().forEach(System.out::println);
        System.out.println("-------");
        authorRepository.save(joanneRowling);
        authorRepository.findAll().forEach(System.out::println);
        System.out.println("-------");
    }
}