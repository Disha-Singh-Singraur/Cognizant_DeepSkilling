DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance FROM Customers;
BEGIN
    FOR r_cust IN c_customers LOOP
        IF r_cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = r_cust.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Promoted Customer ID ' || r_cust.CustomerID || ' to VIP status.');
        END IF;
    END LOOP;
    COMMIT;
END;
/
