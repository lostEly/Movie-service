CREATE TRIGGER set_actor_when_employee_crated_trigger
    AFTER INSERT
    ON employee
    FOR EACH ROW
    INSERT INTO profession_to_employee (employee_id, profession_id)
    VALUES (new.id, (select id from profession where profession.name like 'ACTOR'));