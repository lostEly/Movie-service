CREATE TRIGGER date_updated_userr_trigger
    BEFORE UPDATE
    ON userr
    FOR EACH ROW
    SET new.date_updated = now();

--
-- CREATE TRIGGER date_updated_employee_trigger
--     AFTER UPDATE
--     ON employee
--     FOR EACH ROW SET date_updated = CURRENT_TIMESTAMP;
--

CREATE TRIGGER date_updated_employee_trigger
    BEFORE UPDATE
    ON employee
    FOR EACH ROW
    SET new.date_updated = now();


-- CREATE TRIGGER date_updated_genre_trigger
--     AFTER UPDATE
--     ON genre
--     FOR EACH ROW SET date_updated = CURRENT_TIMESTAMP;
--


CREATE TRIGGER date_updated_genre_trigger
    BEFORE UPDATE
    ON genre
    FOR EACH ROW
    SET new.date_updated = now();


-- CREATE TRIGGER date_updated_movie_trigger
--     AFTER UPDATE
--     ON movie
--     FOR EACH ROW SET date_updated = CURRENT_TIMESTAMP;
--

CREATE TRIGGER date_updated_movie_trigger
    BEFORE UPDATE
    ON movie
    FOR EACH ROW
    SET new.date_updated = now();


-- CREATE TRIGGER date_updated_movie_list_trigger
--     AFTER UPDATE
--     ON movie_list
--     FOR EACH ROW SET date_updated = CURRENT_TIMESTAMP;
--

CREATE TRIGGER date_updated_movie_list_trigger
    BEFORE UPDATE
    ON movie_list
    FOR EACH ROW
    SET new.date_updated = now();


-- CREATE TRIGGER date_updated_profession_trigger
--     AFTER UPDATE
--     ON profession
--     FOR EACH ROW SET date_updated = CURRENT_TIMESTAMP;
--

CREATE TRIGGER date_updated_profession_trigger
    BEFORE UPDATE
    ON profession
    FOR EACH ROW
    SET new.date_updated = now();


-- CREATE TRIGGER date_updated_role_trigger
--     AFTER UPDATE
--     ON role
--     FOR EACH ROW SET date_updated = CURRENT_TIMESTAMP;


CREATE TRIGGER date_updated_role_trigger
    BEFORE UPDATE
    ON role
    FOR EACH ROW
    SET new.date_updated = now();