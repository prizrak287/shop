CREATE SEQUENCE authors_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 2147483648
    START 1
    CACHE 1;


CREATE SEQUENCE books_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 2147483648
    START 1
    CACHE 1;


CREATE SEQUENCE users_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 2147483648
    START 1
    CACHE 1;


CREATE TABLE authors
(
    id      INTEGER NOT NULL DEFAULT nextval('authors_seq'),
    fio     VARCHAR(64),
    age     INTEGER,
    address VARCHAR(128),
    CONSTRAINT pk_authors PRIMARY KEY (id)
);

CREATE TABLE books
(
    id               INTEGER NOT NULL DEFAULT nextval('books_seq'),
    name             VARCHAR(32),
    publishing_house VARCHAR(128),
    date_of_publish  date,
    CONSTRAINT pk_books PRIMARY KEY (id)
);

CREATE TABLE users
(
    id            INTEGER NOT NULL DEFAULT nextval('users_seq'),
    first_name    VARCHAR(32),
    last_name     VARCHAR(32),
    login         VARCHAR(32),
    hash_password varchar(256),
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT unq_users UNIQUE (login)
);

CREATE TABLE authors_books
(
    author_id INTEGER,
    book_id   INTEGER,
    CONSTRAINT pk_authors_books PRIMARY KEY (author_id, book_id),
    CONSTRAINT fk_authors FOREIGN KEY (author_id) REFERENCES authors (id),
    CONSTRAINT fk_books FOREIGN KEY (book_id) REFERENCES books (id)
);

