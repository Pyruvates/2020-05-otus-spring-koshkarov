package ru.koshkarovvitaliy.repository;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import ru.koshkarovvitaliy.model.Book;

public interface BookRepository extends KeyValueRepository<Book, Integer> {
}