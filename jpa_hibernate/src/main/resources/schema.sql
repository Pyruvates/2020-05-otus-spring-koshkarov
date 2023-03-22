CREATE TABLE genres(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE authors(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);

CREATE TABLE books(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    author_id int references authors(id) ON DELETE CASCADE,
    genre_id int references genres(id) ON DELETE CASCADE
);