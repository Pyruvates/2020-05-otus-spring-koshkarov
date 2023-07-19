CREATE TABLE genres (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE authors (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);

CREATE TABLE books(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    author_id int references authors(id),
    genre_id int references genres(id)
);
