public class WebApp implements Observer {
    private String clientName;

    public WebApp(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("[Web Dashboard - " + clientName + "] Feed Update: " + stockName + " trading at $" + price);
    }
}
