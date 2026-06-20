public class MobileApp implements Observer {
    private String clientName;

    public MobileApp(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("[Mobile App - " + clientName + "] Notification: Stock " + stockName + " is now $" + price);
    }
}
