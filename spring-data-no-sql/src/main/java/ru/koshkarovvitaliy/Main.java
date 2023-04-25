package ru.koshkarovvitaliy;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.repository.AuthorRepository;
import ru.koshkarovvitaliy.repository.BookRepository;
import ru.koshkarovvitaliy.repository.GenreRepository;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableMapRepositories
@Log4j2
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);

        GenreRepository genreRepository = ctx.getBean(GenreRepository.class);
        AuthorRepository authorRepository = ctx.getBean(AuthorRepository.class);
        BookRepository bookRepository = ctx.getBean(BookRepository.class);

        List<Genre> genres = genreRepository.findAll();
        log.info("Genres: {}", genres);

        genreRepository.save(new Genre(1, "Biography"));
        Genre programming = new Genre(2, "Programming");
        genreRepository.save(programming);
        Genre fantasy = new Genre(3, "Fantasy");
        genreRepository.save(fantasy);

        genres = genreRepository.findAll();
        log.info("Genres: {}", genres);

        List<Author> authors = authorRepository.findAll();
        log.info("Authors: {}", authors);

        Author robertMartin = new Author(1, "Robert", "Martin");
        authorRepository.save(robertMartin);
        Author joanneRowling = new Author(2, "Joanne", "Rowling");
        authorRepository.save(joanneRowling);
        authors = authorRepository.findAll();
        log.info("Authors: {}", authors);

        List<Book> books = bookRepository.findAll();
        log.info("Books: {}", books);

        Book cleanCode = new Book(1, "Clean Code", List.of(robertMartin), programming);
        Book harryPotter = new Book(2, "Harry Potter and the Goblet of Fire", List.of(joanneRowling), fantasy);
        Book algorithms = new Book(3, "Introduction to Algorithms,", List.of(new Author("Thomas", "Cormen"), new Author("Charles", "Leiserson"), new Author("Ronald", "Rivest"), new Author("Clifford", "Stein")), programming);
        Book fairyTales = new Book(4, "Fairy Tales", Collections.emptyList(), fantasy);

        bookRepository.save(cleanCode);
        bookRepository.save(harryPotter);
        bookRepository.save(algorithms);
        bookRepository.save(fairyTales);

        books = bookRepository.findAll();
        log.info("Books: {}", books);
    }
}