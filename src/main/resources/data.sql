-- TB_CHARACTER
INSERT INTO tb_character (name, type, description) VALUES ('Sheldon Lee Cooper','Protagonist', 'Dr. Sheldon Lee Cooper, B.Sc., M.Sc., M.A., Ph.D., Sc.D., is a Caltech theoretical physicist. Next to his best friend Leonard Hofstadter, he is the main protagonist of The Big Bang Theory.');
INSERT INTO tb_character (name, type, description) VALUES ('Leonard Leakey Hofstadter','Protagonist', 'Dr. Leonard Leakey Hofstadter, Ph.D., is an experimental physicist at the California Institute of Technology. Originally from New Jersey, Leonard attended Princeton University and was twenty-four years old when he received his doctorate.');
INSERT INTO tb_character (name, type, description) VALUES ('Penny Hofstadter','Protagonist', 'Penny Hofstadter is the primary female character in the series. She lives in Apartment 4A with her husband Leonard Hofstadter across the hall from Sheldon Cooper and Amy Farrah Fowler who live in apartment 4B where Penny used to live.');
INSERT INTO tb_character (name, type, description) VALUES ('Amy Farrah Fowler','Protagonist', 'Dr. Amy Farrah Fowler, Ph.D., is a neurobiologist. She initially was discovered by Raj and Howard as a possible match for Sheldon through an online dating service.');
INSERT INTO tb_character (name, type, description) VALUES ('Howard Joel Wolowitz','Protagonist', 'Howard Joel Wolowitz, M.Eng., is a Jewish aerospace engineer and ex-astronaut. As the best friend of Rajesh Koothrappali, Howard often hangs out at Leonard and Sheldon''s apartment with him.');
INSERT INTO tb_character (name, type, description) VALUES ('Rajesh Ramayan Koothrappali','Protagonist', 'Dr. Rajesh Ramayan "Raj" Koothrappali, Ph.D., is an astrophysicist and Howard Wolowitz''s best friend. He often hangs out at Leonard and Sheldon''s apartment, though he has his own apartment (the Raj Mahal) in Pasadena.');
INSERT INTO tb_character (name, type, description) VALUES ('Bernadette Maryann Rostenkowski-Wolowitz','Protagonist', 'Bernadette is a supporting character of The Big Bang Theory and a former waitress at the Cheesecake Factory and has earned her Ph.D. in microbiology who has a lucrative job at the pharmaceutical company ZanGen.');

-- TB_MOVIE
INSERT INTO tb_movie (path_to_image,title, subtitle, release_date, direction, budget) values ('http://localhost:8080/img/tbbt-s1.jpg','The Big Bang Theory S 1', '', '24/09/2007', 'Mark Cendrowski', 9000000.00);
INSERT INTO tb_movie (path_to_image,title, subtitle, release_date, direction, budget) values ('http://localhost:8080/img/tbbt-s2.jpg','The Big Bang Theory S 2', '', '22/09/2008', 'Mark Cendrowski', 10000000.00);
INSERT INTO tb_movie (path_to_image,title, subtitle, release_date, direction, budget) values ('http://localhost:8080/img/tbbt-s3.jpg','The Big Bang Theory S 3', '', '21/09/2009', 'Mark Cendrowski', 15000000.00);
INSERT INTO tb_movie (path_to_image,title, subtitle, release_date, direction, budget) values ('http://localhost:8080/img/tbbt-s4.jpg','The Big Bang Theory S 4', '', '23/09/2010', 'Mark Cendrowski', 12000000.00);
INSERT INTO tb_movie (path_to_image,title, subtitle, release_date, direction, budget) values ('http://localhost:8080/img/tbbt-s5.jpg','The Big Bang Theory S 5', '', '22/09/2011', 'Mark Cendrowski', 9500000.00);
INSERT INTO tb_movie (path_to_image,title, subtitle, release_date, direction, budget) values ('http://localhost:8080/img/tbbt-s6.jpg','The Big Bang Theory S 6', '', '27/09/2012', 'Mark Cendrowski', 11000000.00);
INSERT INTO tb_movie (path_to_image,title, subtitle, release_date, direction, budget) values ('http://localhost:8080/img/tbbt-s7.jpg','The Big Bang Theory S 7', '', '26/09/2013', 'Mark Cendrowski', 20000000.00);
INSERT INTO tb_movie (path_to_image,title, subtitle, release_date, direction, budget) values ('http://localhost:8080/img/tbbt-s8.jpg','The Big Bang Theory S 8', '', '22/09/2014', 'Mark Cendrowski', 12500000.00);
INSERT INTO tb_movie (path_to_image,title, subtitle, release_date, direction, budget) values ('http://localhost:8080/img/tbbt-s9.jpg','The Big Bang Theory S 9', '', '21/09/2015', 'Mark Cendrowski', 18000000.00);
INSERT INTO tb_movie (path_to_image,title, subtitle, release_date, direction, budget) values ('http://localhost:8080/img/tbbt-s10.jpg','The Big Bang Theory S 10', '', '19/09/2016', 'Mark Cendrowski', 16500000.00);
INSERT INTO tb_movie (path_to_image,title, subtitle, release_date, direction, budget) values ('http://localhost:8080/img/tbbt-s11.jpg','The Big Bang Theory S 11', '', '25/09/2017', 'Mark Cendrowski', 15300000.00);
INSERT INTO tb_movie (path_to_image,title, subtitle, release_date, direction, budget) values ('http://localhost:8080/img/tbbt-s12.jpg','The Big Bang Theory S 12', '', '24/09/2018', 'Mark Cendrowski', 14400000.00);

-- TB_MOVIES_CHARACTERS
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,7);

INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (2,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (2,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (2,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (2,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (2,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (2,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (2,7);

INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (3,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (3,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (3,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (3,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (3,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (3,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (3,7);

INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (4,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (4,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (4,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (4,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (4,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (4,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (4,7);

INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (5,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (5,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (5,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (5,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (5,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (5,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (5,7);

INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (6,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (6,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (6,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (6,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (6,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (6,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (6,7);

INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (7,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (7,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (7,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (7,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (7,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (7,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (7,7);

INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (8,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (8,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (8,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (8,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (8,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (8,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (8,7);

INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (9,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (9,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (9,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (9,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (9,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (9,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (9,7);

INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (10,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (10,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (10,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (10,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (10,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (10,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (10,7);

INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (11,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (11,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (11,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (11,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (11,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (11,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (11,7);

INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (12,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (12,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (12,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (12,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (12,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (12,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (12,7);