INSERT INTO genres (name) VALUES
('Programming'), ('Reference work');

INSERT INTO authors (first_name, last_name) VALUES
('Joshua', 'Bloch'), ('Robert', 'Martin'), ('Budi', 'Kurniawan'), ('Bruce', 'Eckel'), ('Moisés', 'Macero');

INSERT INTO books(name, author_id, genre_id) VALUES
('Thinking of Java', 4, 1),
('Effective Java', 1, 2),
('Java Web Development with Servlets, JSP and EJB', 3, 1),
('Clean Code', 2, 2),
('Clean Architecture: A Craftsman Guide to Software Structure and Design', 2, 2),
('Learn Microservices with Spring Boot: A Practical Approach to RESTful Services Using an Event-Driven Architecture, Cloud-Native Patterns and Containerization', 5, 1);
