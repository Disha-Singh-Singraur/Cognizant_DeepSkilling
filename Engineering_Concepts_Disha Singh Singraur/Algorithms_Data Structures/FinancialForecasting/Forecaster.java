public class Forecaster {

    /**
     * Calculates the future value using a purely recursive approach.
     * Formula: FV = PV * (1 + growthRate)^periods
     * Recursively: FV(periods) = FV(periods - 1) * (1 + growthRate)
     * Base case: FV(0) = PV
     */
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        // Base Case: 0 periods remaining means value remains unchanged
        if (periods == 0) {
            return currentValue;
        }
        
        // Recursive step
        return calculateFutureValue(currentValue, growthRate, periods - 1) * (1 + growthRate);
    }
}
