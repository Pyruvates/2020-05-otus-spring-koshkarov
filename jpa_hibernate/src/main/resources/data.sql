INSERT INTO genres(name) VALUES
('Sci-Fi'), ('Fantasy'), ('Novel'), ('Historical fiction'), ('Biography'), ('Reference work'), ('Programming');

INSERT INTO authors(first_name, last_name) VALUES
('Joanne', 'Rowling'), ('Robert', 'Martin'), ('Joshua', 'Bloch');

INSERT INTO books(name, author_id, genre_id) VALUES
('Harry Potter and the Deathly Hallows - Part 1', 1, 2),
('Clean Code', 2, 7),
('Effective Java', 3, 6),
('Harry Potter and the Deathly Hallows - Part 2', 1, 2),
('Harry Potter and the Half-Blood Prince', 1, 2),
('Clean Architecture: A Craftsman Guide to Software Structure and Design', 2, 7);