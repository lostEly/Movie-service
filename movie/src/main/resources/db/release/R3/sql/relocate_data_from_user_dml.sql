# INSERT INTO genre (name, parent_genre_id)
# values ('crime', null),
#        ('action', null);

INSERT INTO contact_info (email, telephone)
values ((SELECT email from userr), (SELECT  telephone from userr));


INSERT INTO employee_to_movie (movie_id, employee_id)
VALUES ((SELECT id from movie where name like 'Wrath of Man'), (SELECT id from employee order by rand() limit 1)),
       ((SELECT id from movie where name like 'Wrath of Man'), (SELECT id from employee order by rand() limit 1)),
       ((SELECT id from movie where name like 'Wrath of Man'), (SELECT id from employee order by rand() limit 1)),
       ((SELECT id from movie where name like 'Wrath of Man'), (SELECT id from employee order by rand() limit 1)),
       ((SELECT id from movie where name like 'Wrath of Man'), (SELECT id from employee order by rand() limit 1)),
       ((SELECT id from movie where name like 'Wrath of Man'), (SELECT id from employee order by rand() limit 1)),
       ((SELECT id from movie where name like 'Mortal Kombat'), (SELECT id from employee order by rand() limit 1)),
       ((SELECT id from movie where name like 'Mortal Kombat'), (SELECT id from employee order by rand() limit 1)),
       ((SELECT id from movie where name like 'Mortal Kombat'), (SELECT id from employee order by rand() limit 1));

INSERT INTO country_to_movie (movie_id, country_id)
VALUES ((SELECT id from movie where name like 'Mortal Kombat'), ((SELECT id from country where alpha2 like 'US'))),
       ((SELECT id from movie where name like 'Wrath of Man'), ((SELECT id from country where alpha2 like 'US')));
