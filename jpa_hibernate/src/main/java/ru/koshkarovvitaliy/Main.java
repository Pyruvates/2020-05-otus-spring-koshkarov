package ru.koshkarovvitaliy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.koshkarovvitaliy.model.Author;
import ru.koshkarovvitaliy.model.Book;
import ru.koshkarovvitaliy.model.Genre;
import ru.koshkarovvitaliy.repository.LibraryRepository;
import ru.koshkarovvitaliy.repository.LibraryRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(Main.class, args);
//        Console.main(args);

        LibraryRepository libraryRepository = context.getBean(LibraryRepositoryImpl.class);

        List<Genre> allGenres = libraryRepository.getAllGenres();
        allGenres.forEach(System.out::println);
        System.out.println();

        List<Author> allAuthors = libraryRepository.getAllAuthors();
        allAuthors.forEach(System.out::println);
        System.out.println();

        List<Book> allBooks = libraryRepository.getAllBooks();
        allBooks.forEach(System.out::println);
        System.out.println();

        Genre fantasyGenre = libraryRepository.getGenreById(2);
        System.out.println(fantasyGenre);
        Genre programmingGenre = libraryRepository.getGenreById(4);
        System.out.println(programmingGenre);
        System.out.println();

        List<Book> programmingBooks = libraryRepository.getBooksByGenre(programmingGenre);
        programmingBooks.forEach(System.out::println);
        System.out.println();
        List<Book> fantasyBooks = libraryRepository.getBooksByGenre(fantasyGenre);
        fantasyBooks.forEach(System.out::println);
        System.out.println();

        Author joanneRowling = allAuthors.get(0);
        joanneRowling.setLastName("Rowling");
        libraryRepository.updateAuthor(joanneRowling);
        allAuthors = libraryRepository.getAllAuthors();
        allAuthors.forEach(System.out::println);
        System.out.println();

        Genre biographyGenre = new Genre(5, "Biography");
        libraryRepository.addGenre(biographyGenre);
        System.out.println();

        allGenres = libraryRepository.getAllGenres();
        allGenres.forEach(System.out::println);
        System.out.println();

        libraryRepository.removeBookById(5);

        allBooks = libraryRepository.getAllBooks();
        allBooks.forEach(System.out::println);

        System.exit(1);
    }
}