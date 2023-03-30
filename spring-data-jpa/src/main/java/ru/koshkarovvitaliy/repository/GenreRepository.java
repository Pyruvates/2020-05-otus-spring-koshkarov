package ru.koshkarovvitaliy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.koshkarovvitaliy.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @Query("SELECT g FROM Genre g WHERE g.name = :name")
    Genre findByName(@Param("name") String name);
}