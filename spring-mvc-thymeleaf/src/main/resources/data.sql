INSERT INTO genres (name) VALUES
('Programming'), ('Reference work');

INSERT INTO authors (first_name, last_name) VALUES
('Joshua', 'Bloch'), ('Robert', 'Martin');

INSERT INTO books(name, author_id, genre_id) VALUES
('Clean Code', 2, 2),
('Effective Java', 1, 2),
('Clean Architecture: A Craftsman Guide to Software Structure and Design', 2, 2);
