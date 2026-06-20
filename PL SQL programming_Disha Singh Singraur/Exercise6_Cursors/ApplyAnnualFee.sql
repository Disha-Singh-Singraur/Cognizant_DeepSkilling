DECLARE
    -- Explicit cursor with FOR UPDATE to lock rows
    CURSOR c_accounts IS
        SELECT AccountID, Balance 
        FROM Accounts
        FOR UPDATE OF Balance;
        
    v_fee CONSTANT NUMBER := 25.00; -- $25 annual maintenance fee
BEGIN
    FOR r_acc IN c_accounts LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee, LastModified = SYSDATE
        WHERE CURRENT OF c_accounts;
        
        DBMS_OUTPUT.PUT_LINE('Deducted $' || v_fee || ' fee from Account ID: ' || r_acc.AccountID || 
                             '. Old Balance: $' || r_acc.Balance || 
                             '. New Balance: $' || (r_acc.Balance - v_fee));
    END LOOP;
    COMMIT;
END;
/
