CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percentage  IN NUMBER
) IS
    v_current_salary NUMBER;
    employee_not_found EXCEPTION;
BEGIN
    -- Check if employee exists and get current salary
    SELECT Salary INTO v_current_salary
    FROM Employees
    WHERE EmployeeID = p_employee_id;

    -- Perform salary update
    UPDATE Employees
    SET Salary = Salary * (1 + (p_percentage / 100))
    WHERE EmployeeID = p_employee_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Updated salary for Employee ID ' || p_employee_id || 
                         ' from $' || v_current_salary || ' to $' || (v_current_salary * (1 + (p_percentage / 100))));

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_employee_id || ' does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating salary for Employee ID ' || p_employee_id || ': ' || SQLERRM);
END;
/
SHOW ERRORS;
