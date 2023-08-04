package ru.koshkarovvitaliy.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "genres")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;
}