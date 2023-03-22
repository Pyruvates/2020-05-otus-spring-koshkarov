package ru.koshkarovvitaliy;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.service.LibraryServiceImpl;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        Console.main(args);

        LibraryServiceImpl libraryService = context.getBean(LibraryServiceImpl.class);

        List<Genre> allGenres = libraryService.getAllGenres();
        allGenres.forEach(System.out::println);

        System.out.println();

        List<Author> allAuthors = libraryService.getAllAuthors();
        allAuthors.forEach(System.out::println);

        System.out.println();

        List<Book> allBooks = libraryService.getAllBooks();
        allBooks.forEach(System.out::println);
    }
}