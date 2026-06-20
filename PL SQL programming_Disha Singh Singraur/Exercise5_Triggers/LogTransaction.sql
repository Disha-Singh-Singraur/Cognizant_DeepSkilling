CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, LogDate, Action)
    VALUES (
        :new.TransactionID,
        SYSDATE,
        'Transaction of $' || :new.Amount || ' (' || :new.TransactionType || ') on Account ID ' || :new.AccountID
    );
END;
/
SHOW ERRORS;
