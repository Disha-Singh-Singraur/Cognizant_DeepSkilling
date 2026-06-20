DECLARE
    -- Explicit cursor with FOR UPDATE
    CURSOR c_loans IS
        SELECT LoanID, CustomerID, InterestRate, LoanAmount
        FROM Loans
        FOR UPDATE OF InterestRate;
        
    v_new_rate NUMBER;
BEGIN
    FOR r_loan IN c_loans LOOP
        -- Policy: Reduce interest rate by 0.5% for loans greater than $8,000, 
        -- and increase by 0.25% for smaller loans as per hypothetical risk adjustments
        IF r_loan.LoanAmount > 8000 THEN
            v_new_rate := r_loan.InterestRate - 0.5;
        ELSE
            v_new_rate := r_loan.InterestRate + 0.25;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE CURRENT OF c_loans;
        
        DBMS_OUTPUT.PUT_LINE('Updated Loan ID ' || r_loan.LoanID || 
                             ' (Customer ' || r_loan.CustomerID || 
                             '). Old Rate: ' || r_loan.InterestRate || 
                             '%, New Rate: ' || v_new_rate || '%');
    END LOOP;
    COMMIT;
END;
/
