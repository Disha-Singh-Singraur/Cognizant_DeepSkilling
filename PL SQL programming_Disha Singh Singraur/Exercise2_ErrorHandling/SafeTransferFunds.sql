CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_source_account_id IN NUMBER,
    p_dest_account_id   IN NUMBER,
    p_amount            IN NUMBER
) IS
    v_source_balance NUMBER;
    v_dest_balance   NUMBER;
    insufficient_funds EXCEPTION;
    invalid_amount EXCEPTION;
BEGIN
    -- Validate transfer amount
    IF p_amount <= 0 THEN
        RAISE invalid_amount;
    END IF;

    -- Check source account existence and lock it for update to prevent race conditions
    BEGIN
        SELECT Balance INTO v_source_balance
        FROM Accounts
        WHERE AccountID = p_source_account_id
        FOR UPDATE;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Source account ' || p_source_account_id || ' does not exist.');
            RAISE;
    END;

    -- Check dest account existence
    BEGIN
        SELECT Balance INTO v_dest_balance
        FROM Accounts
        WHERE AccountID = p_dest_account_id
        FOR UPDATE;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Destination account ' || p_dest_account_id || ' does not exist.');
            RAISE;
    END;

    -- Check sufficient funds
    IF v_source_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Perform transfer
    UPDATE Accounts
    SET Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE AccountID = p_source_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE AccountID = p_dest_account_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from account ' || 
                         p_source_account_id || ' to account ' || p_dest_account_id);

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient funds in source account ' || p_source_account_id);
    WHEN invalid_amount THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Transfer amount must be positive.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: An unexpected error occurred. ' || SQLERRM);
END;
/
SHOW ERRORS;
