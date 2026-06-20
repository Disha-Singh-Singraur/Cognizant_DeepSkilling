CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id IN NUMBER,
    p_dest_account_id   IN NUMBER,
    p_amount            IN NUMBER
) IS
    v_source_balance NUMBER;
BEGIN
    -- Get source balance
    SELECT Balance INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_source_account_id;

    -- Check balance
    IF v_source_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account ' || p_source_account_id);
    END IF;

    -- Update balances
    UPDATE Accounts
    SET Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE AccountID = p_source_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE AccountID = p_dest_account_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transferred $' || p_amount || ' from account ' || 
                         p_source_account_id || ' to account ' || p_dest_account_id);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Account ID not found during transfer.');
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/
SHOW ERRORS;
