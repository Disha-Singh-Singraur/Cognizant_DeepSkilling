CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    -- 1. Check positive deposit rule
    IF :new.TransactionType = 'Deposit' AND :new.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
    END IF;

    -- 2. Check sufficient balance for withdrawals
    IF :new.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance
        FROM Accounts
        WHERE AccountID = :new.AccountID;

        IF :new.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20003, 'Withdrawal amount must be positive.');
        ELSIF :new.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20004, 'Withdrawal exceeds account balance. Current balance is: ' || v_balance);
        END IF;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20005, 'Account ID ' || :new.AccountID || ' does not exist.');
    WHEN OTHERS THEN
        RAISE;
END;
/
SHOW ERRORS;
