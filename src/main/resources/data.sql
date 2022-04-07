-- TB_ACTOR
INSERT INTO tb_actor (name, hometown, birthdate, deathdate, age, marital_status) VALUES ('James Joseph Parsons','Houston, Texas, EUA', '24/03/1973', '', 49, 'Married');
INSERT INTO tb_actor (name, hometown, birthdate, deathdate, age, marital_status) VALUES ('John Mark Galecki','Bree, Belgica', '30/04/1975', '', 46, 'Single');
INSERT INTO tb_actor (name, hometown, birthdate, deathdate, age, marital_status) VALUES ('Kaley Christine Cuoco','Camarillo, Califórnia, EUA', '30/11/1985', '', 36, 'Married');
INSERT INTO tb_actor (name, hometown, birthdate, deathdate, age, marital_status) VALUES ('Mayim Hoya Bialik','San Diego, Califórnia, EUA', '12/12/1975', '', 46, 'Divorced');
INSERT INTO tb_actor (name, hometown, birthdate, deathdate, age, marital_status) VALUES ('Simon Maxwell Helberg','Los Angeles, Califórnia, EUA', '09/12/1980', '', 41, 'Married');
INSERT INTO tb_actor (name, hometown, birthdate, deathdate, age, marital_status) VALUES ('Kunal Nayyar','Hammersmith, Londres, Reino Unido', '30/04/1981', '', 40, 'Married');
INSERT INTO tb_actor (name, hometown, birthdate, deathdate, age, marital_status) VALUES ('Melissa Ivy Rauch','Marlboro, Nova Jersey, EUA', '23/06/1980', '', 41, 'Married');

-- TB_CHARACTER
INSERT INTO tb_character (name, type, description) VALUES ('Sheldon Lee Cooper','Protagonist', 'Dr. Sheldon Lee Cooper, B.Sc., M.Sc., M.A., Ph.D., Sc.D., is a Caltech theoretical physicist. Next to his best friend Leonard Hofstadter, he is the main protagonist of The Big Bang Theory.');
INSERT INTO tb_character (name, type, description) VALUES ('Leonard Leakey Hofstadter','Protagonist', 'Dr. Leonard Leakey Hofstadter, Ph.D., is an experimental physicist at the California Institute of Technology. Originally from New Jersey, Leonard attended Princeton University and was twenty-four years old when he received his doctorate.');
INSERT INTO tb_character (name, type, description) VALUES ('Penny Hofstadter','Protagonist', 'Penny Hofstadter s the primary female character in the series. She lives in Apartment 4A with her husband Leonard Hofstadter across the hall from Sheldon Cooper and Amy Farrah Fowler who live in apartment 4B where Penny used to live.');
INSERT INTO tb_character (name, type, description) VALUES ('Amy Farrah Fowler','Protagonist', 'Dr. Amy Farrah Fowler, Ph.D., is a neurobiologist. She initially was discovered by Raj and Howard as a possible match for Sheldon through an online dating service.');
INSERT INTO tb_character (name, type, description) VALUES ('Howard Joel Wolowitz','Protagonist', 'Howard Joel Wolowitz, M.Eng., is a Jewish aerospace engineer and ex-astronaut. As the best friend of Rajesh Koothrappali, Howard often hangs out at Leonard and Sheldon''s apartment with him.');
INSERT INTO tb_character (name, type, description) VALUES ('Rajesh Ramayan Koothrappali','Protagonist', 'Dr. Rajesh Ramayan "Raj" Koothrappali, Ph.D., is an astrophysicist and Howard Wolowitz''s best friend. He often hangs out at Leonard and Sheldon''s apartment, though he has his own apartment (the Raj Mahal) in Pasadena.');
INSERT INTO tb_character (name, type, description) VALUES ('Bernadette Maryann Rostenkowski-Wolowitz','Protagonist', 'Bernadette is a supporting character of The Big Bang Theory and a former waitress at the Cheesecake Factory and has earned her Ph.D. in microbiology who has a lucrative job at the pharmaceutical company ZanGen.');

-- TB_MOVIE
INSERT INTO tb_movie (title, subtitle, release_date, direction, budget) values ('The Big Bang Theory', '', '24/09/2007', 'Mark Cendrowski', 9000000.00);

-- TB_MOVIES_CHARACTERS
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,1);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,2);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,3);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,4);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,5);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,6);
INSERT INTO tb_movies_characters (movie_id, character_id) VALUES (1,7);

-- TB_ACTORS_CHARACTERS
INSERT INTO tb_actors_characters (actor_id, character_id) VALUES (1,1);
INSERT INTO tb_actors_characters (actor_id, character_id) VALUES (2,2);
INSERT INTO tb_actors_characters (actor_id, character_id) VALUES (3,3);
INSERT INTO tb_actors_characters (actor_id, character_id) VALUES (4,4);
INSERT INTO tb_actors_characters (actor_id, character_id) VALUES (5,5);
INSERT INTO tb_actors_characters (actor_id, character_id) VALUES (6,6);
INSERT INTO tb_actors_characters (actor_id, character_id) VALUES (7,7);

-- TB_MOVIES_ACTORS
INSERT INTO tb_movies_actors (movie_id, actor_id) VALUES (1,1);
INSERT INTO tb_movies_actors (movie_id, actor_id) VALUES (1,2);
INSERT INTO tb_movies_actors (movie_id, actor_id) VALUES (1,3);
INSERT INTO tb_movies_actors (movie_id, actor_id) VALUES (1,4);
INSERT INTO tb_movies_actors (movie_id, actor_id) VALUES (1,5);
INSERT INTO tb_movies_actors (movie_id, actor_id) VALUES (1,6);
INSERT INTO tb_movies_actors (movie_id, actor_id) VALUES (1,7);