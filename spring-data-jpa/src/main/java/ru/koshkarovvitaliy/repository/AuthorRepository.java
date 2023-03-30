package ru.koshkarovvitaliy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.koshkarovvitaliy.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Transactional(readOnly = true)
    @Query("SELECT a FROM Author a WHERE a.firstName = :firstName AND a.lastName = :lastName")
    Author findByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}