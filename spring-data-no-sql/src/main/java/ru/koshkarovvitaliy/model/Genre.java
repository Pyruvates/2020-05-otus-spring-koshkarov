package ru.koshkarovvitaliy.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@KeySpace("books")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Genre {
    @Id
    private Integer id;
    private String name;
}