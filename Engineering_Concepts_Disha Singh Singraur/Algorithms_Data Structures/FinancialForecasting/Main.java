public class Main {
    public static void main(String[] args) {
        double initialValue = 1000.00; // Present Value (PV)
        double growthRate = 0.05;      // 5% growth rate
        int periods = 10;              // 10 years / periods

        System.out.println("--- Financial Forecasting ---");
        System.out.println("Initial Value: $" + initialValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Forecast Periods: " + periods);

        double futureValue = Forecaster.calculateFutureValue(initialValue, growthRate, periods);
        System.out.printf("Future Value after %d periods: $%.2f\n", periods, futureValue);
    }
}
