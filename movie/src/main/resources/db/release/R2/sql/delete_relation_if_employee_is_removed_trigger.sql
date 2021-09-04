CREATE TRIGGER remove_employee_from_relation_trigger
    BEFORE DELETE
    ON employee
    FOR EACH ROW
    DELETE
    FROM profession_to_employee
    where employee_id like OLD.id;