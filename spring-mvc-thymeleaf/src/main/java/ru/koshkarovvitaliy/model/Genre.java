package ru.koshkarovvitaliy.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@Table(name = "genres")
@NoArgsConstructor
@Getter
@Setter
@ToString
@NamedNativeQuery(name = "unique_by_name_genres", query = "SELECT DISTINCT ON(name) id, name FROM genres", resultClass = Genre.class)
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;
}