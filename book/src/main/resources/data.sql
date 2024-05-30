create table if not exists t_books (id bigint not null, author varchar(100) not null, nb_of_pages integer, year_pub integer, title varchar(100) not null, primary key (id));
-- create sequence if not exists t_books_SEQ start with 1 increment by 1;

INSERT INTO t_books (id, title, author, nb_of_pages, year_pub) VALUES
(1, 'Understanding Quarkus', 'Antonio', 200, 2015),
(2, 'Practising Quarkus', 'Antonio', 200, 2020),
(3, 'Effective Java', 'Josh Bloch', 400, 2012),
(4, 'Thinking in Java', 'Bruce Eckel', 324, 1998);
