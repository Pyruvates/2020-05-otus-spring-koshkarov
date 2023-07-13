package ru.koshkarovvitaliy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.koshkarovvitaliy.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}