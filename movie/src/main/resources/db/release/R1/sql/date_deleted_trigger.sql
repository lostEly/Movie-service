CREATE TRIGGER date_deleted_userr_trigger
    BEFORE DELETE
    ON userr
    FOR EACH ROW
        INSERT INTO userr_archives(id, date_created, date_updated, date_of_birthday, email, last_name, name, sex, telephone)
        VALUES (old.id, old.date_created, old.date_updated, old.date_of_birthday, old.email, old.last_name, old.name, old.sex, old.telephone);

CREATE TRIGGER date_deleted_employee_trigger
    BEFORE DELETE
    ON employee
    FOR EACH ROW
        INSERT INTO employee_archives(id, date_created, date_updated, last_name, name)
        VALUES (old.id, old.date_created, old.date_updated, old.last_name, old.name);

CREATE TRIGGER date_deleted_genre_trigger
    BEFORE DELETE
    ON genre
    FOR EACH ROW
        INSERT INTO genre_archives(id, date_created, date_updated, name)
        VALUES (old.id, old.date_created, old.date_updated, old.name);

CREATE TRIGGER date_deleted_movie_trigger
    BEFORE DELETE
    ON movie
    FOR EACH ROW
        INSERT INTO movie_archives(id, date_created, date_updated, description, duration, name, rating, release_date)
        VALUES (old.id, old.date_created, old.date_updated, old.description, old.duration, old.name, old.rating, old.release_date);

CREATE TRIGGER date_deleted_movie_list_trigger
    BEFORE DELETE
    ON movie_list
    FOR EACH ROW
        INSERT INTO movie_list_archives(id, date_created, date_updated, comment, movie_list_type, name)
        VALUES (old.id, old.date_created, old.date_updated, old.comment, old.movie_list_type, old.name);

CREATE TRIGGER date_deleted_profession_trigger
    BEFORE DELETE
    ON profession
    FOR EACH ROW
        INSERT INTO profession_archives(id, date_created, date_updated, name)
        VALUES (old.id, old.date_created, old.date_updated, old.name);

CREATE TRIGGER date_deleted_role_trigger
    BEFORE DELETE
    ON role
    FOR EACH ROW
        INSERT INTO role_archives(id, date_created, date_updated, name)
        VALUES (old.id, old.date_created, old.date_updated, old.name);
