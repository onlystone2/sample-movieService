--CREATE DATABASE IF NOT EXISTS 'cine_vision';

DELETE FROM comment WHERE 1=1;
DELETE FROM city WHERE 1=1;
DELETE FROM movie WHERE 1=1;
DELETE FROM category WHERE 1=1;
DELETE FROM director WHERE 1=1;



INSERT INTO category (category_id, category_name) VALUES (1, 'ACTION');
INSERT INTO director (director_id, director_name) VALUES (1, 'STEVEN');
INSERT INTO movie (movie_id, description, duration, is_display, movie_name, movie_trailer_url, release_date, category_id, director_id) VALUES (1, 'TEST MOVIE', 10, true, 'TEST MOVIE TITLE', 'http://MOVIE', '2020-07-26 20:00:25+09', 1, 1);
INSERT INTO city (city_id, city_name, movie_id) VALUES (1, 'SEOUL', 1);