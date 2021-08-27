INSERT INTO role (name)
values ('ADMIN'),
       ('USER');

INSERT INTO profession (name)
values ('ACTOR'),
       ('PRODUCER'),
       ('SCREENWRITER');

INSERT INTO employee (last_name, name)
values ('ActorLastName1', 'ActorName1'),
       ('ActorLastName2', 'ActorName2'),
       ('ActorLastName3', 'ActorName3');

INSERT INTO movie (description, country, duration, name, rating, release_date)
VALUES ('some description 1', 'USA', 113, 'Wrath of Man', 8.4, '2021-04-22'),
       ('some description 2', 'USA', 109, 'Mortal Kombat', 8.5, '2021-01-01');

INSERT INTO genre (name, parent_genre_id)
values ('thriller', null),
       ('phantasy', null);

INSERT INTO userr (date_of_birthday, email, last_name, name, sex, telephone)
VALUES ('2000-03-03', 'user@gmail.com', 'Petrov', 'Petr', 'MALE', '0996738495');


INSERT INTO movie_list (comment, movie_list_type, name, user_id)
values (null, 'WILL', 'Will watch', (SELECT id from userr where true limit 1));

INSERT INTO user_to_role (user_id, role_id) values ((SELECT id from userr limit 1), (SELECT id from role where name like 'USER'))