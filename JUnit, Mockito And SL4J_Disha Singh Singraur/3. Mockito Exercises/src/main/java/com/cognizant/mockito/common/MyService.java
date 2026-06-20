package com.cognizant.mockito.common;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public String getDetails(int id) {
        return api.fetchDetails(id);
    }

    public void log(String msg) {
        api.logMessage(msg);
    }

    public void processSession() {
        api.start();
        api.stop();
    }
}
