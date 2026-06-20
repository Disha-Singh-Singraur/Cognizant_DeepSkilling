CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_annual_rate IN NUMBER,
    p_years       IN NUMBER
) RETURN NUMBER IS
    v_monthly_installment NUMBER;
    v_monthly_rate        NUMBER;
    v_total_months        NUMBER;
BEGIN
    -- Calculate monthly interest rate (percentage as fractional, e.g. 5% = 0.05 / 12)
    v_monthly_rate := (p_annual_rate / 100) / 12;
    v_total_months := p_years * 12;

    IF v_monthly_rate = 0 THEN
        v_monthly_installment := p_loan_amount / v_total_months;
    ELSE
        -- Standard EMI formula: P * r * (1 + r)^n / ((1 + r)^n - 1)
        v_monthly_installment := p_loan_amount * v_monthly_rate * 
                                 (POWER(1 + v_monthly_rate, v_total_months) / 
                                 (POWER(1 + v_monthly_rate, v_total_months) - 1));
    END IF;

    RETURN ROUND(v_monthly_installment, 2);
END;
/
SHOW ERRORS;
