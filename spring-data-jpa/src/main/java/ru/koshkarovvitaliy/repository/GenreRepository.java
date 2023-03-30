package ru.koshkarovvitaliy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.koshkarovvitaliy.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @Transactional(readOnly = true)
    @Query("SELECT g FROM Genre g WHERE g.name = :name")
    Genre findByName(@Param("name") String name);
}