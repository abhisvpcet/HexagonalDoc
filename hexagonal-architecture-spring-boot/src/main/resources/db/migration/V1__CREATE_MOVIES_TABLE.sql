--CREATE SEQUENCE movies_table_id_seq;
--
--CREATE TABLE movies(
--    id BIGINT primary key DEFAULT next val('movies_table_id_seq'),
--    title varchar(255),
--    description varchar(255),
--    release_date timestamp,
--    director_name varchar(255),
--    version INTEGER
--);


CREATE TABLE movies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(255),
    release_date TIMESTAMP,
    director_name VARCHAR(255),
    version INTEGER
);