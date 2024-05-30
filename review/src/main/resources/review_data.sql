DROP DATABASE IF EXISTS review_db;
CREATE DATABASE review_db;

create table if not exists t_reviews (id bigint not null, review varchar(300) not null, score integer, book_id integer, primary key (id));
-- create sequence if not exists t_reviews_SEQ start with 1 increment by 1;

