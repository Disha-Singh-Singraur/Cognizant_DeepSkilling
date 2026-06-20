DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, DOB FROM Customers;
    v_age NUMBER;
BEGIN
    FOR r_cust IN c_customers LOOP
        -- Calculate age in years
        v_age := MONTHS_BETWEEN(SYSDATE, r_cust.DOB) / 12;
        
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = r_cust.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Applied 1% interest rate discount to Customer ID: ' || r_cust.CustomerID);
        END IF;
    END LOOP;
    COMMIT;
END;
/
