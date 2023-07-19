package ru.koshkarovvitaliy.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
}