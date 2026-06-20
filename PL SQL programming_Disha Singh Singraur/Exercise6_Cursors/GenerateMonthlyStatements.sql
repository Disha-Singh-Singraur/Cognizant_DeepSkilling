DECLARE
    CURSOR c_monthly_statements IS
        SELECT c.CustomerID, c.Name, a.AccountID, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE TO_CHAR(t.TransactionDate, 'YYYY-MM') = TO_CHAR(SYSDATE, 'YYYY-MM');

    v_prev_customer_id NUMBER := -1;
BEGIN
    DBMS_OUTPUT.PUT_LINE('=== MONTHLY TRANSACTION STATEMENTS ===');
    FOR r_trans IN c_monthly_statements LOOP
        IF r_trans.CustomerID != v_prev_customer_id THEN
            DBMS_OUTPUT.PUT_LINE('--------------------------------------');
            DBMS_OUTPUT.PUT_LINE('Customer: ' || r_trans.Name || ' (ID: ' || r_trans.CustomerID || ')');
            v_prev_customer_id := r_trans.CustomerID;
        END IF;
        
        DBMS_OUTPUT.PUT_LINE('  Account ID: ' || r_trans.AccountID || 
                             ' | Trans ID: ' || r_trans.TransactionID || 
                             ' | Date: ' || TO_CHAR(r_trans.TransactionDate, 'YYYY-MM-DD') ||
                             ' | Type: ' || r_trans.TransactionType || 
                             ' | Amount: $' || r_trans.Amount);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('--------------------------------------');
END;
/
