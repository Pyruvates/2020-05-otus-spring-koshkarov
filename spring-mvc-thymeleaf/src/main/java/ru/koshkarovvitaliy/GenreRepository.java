package ru.koshkarovvitaliy;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.koshkarovvitaliy.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}