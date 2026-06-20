CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + (p_bonus_percentage / 100))
    WHERE Department = p_department;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully applied bonus of ' || p_bonus_percentage || 
                         '% to employees in department: ' || p_department);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonus for department ' || p_department || ': ' || SQLERRM);
END;
/
SHOW ERRORS;
