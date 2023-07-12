package ru.koshkarovvitaliy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.koshkarovvitaliy.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}