CREATE TABLE authors (
	author_id serial PRIMARY KEY,
	author_name text
);


CREATE TABLE books (
	book_id serial PRIMARY KEY,
	book_title TEXT,
	is_stocked boolean,
	author_id_fk int REFERENCES authors(author_id)
);

INSERT INTO authors (author_name) VALUES ('Stephen King'), ('J.R.R. Tolkein'), ('Ernest Hemingway');

INSERT INTO books (book_title, in_stock, author_id_fk) 
VALUES ('It', TRUE, 1), ('The Shining', FALSE, 1), ('The Hobbit', TRUE, 2), ('That Fish Book', TRUE, 3);
