package ru.koshkarovvitaliy.repository;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import ru.koshkarovvitaliy.model.Author;

public interface AuthorRepository extends KeyValueRepository<Author, Integer> {
}