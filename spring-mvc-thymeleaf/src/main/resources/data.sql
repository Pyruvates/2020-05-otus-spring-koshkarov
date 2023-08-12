INSERT INTO genres (name) VALUES
('Programming'), ('Programming'), ('Programming'), ('Reference work'), ('Reference work'), ('Reference work');

INSERT INTO authors (first_name, last_name) VALUES
('Joshua', 'Bloch'), ('Robert', 'Martin'), ('Robert', 'Martin'), ('Budi', 'Kurniawan'), ('Bruce', 'Eckel'), ('Moisés', 'Macero');

INSERT INTO books(name, author_id, genre_id) VALUES
('Thinking of Java', 5, 1),
('Effective Java', 1, 4),
('Java Web Development with Servlets, JSP and EJB', 4, 2),
('Clean Code', 2, 5),
('Clean Architecture: A Craftsman Guide to Software Structure and Design', 3, 6),
('Learn Microservices with Spring Boot: A Practical Approach to RESTful Services Using an Event-Driven Architecture, Cloud-Native Patterns and Containerization', 6, 3);
