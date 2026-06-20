package com.cognizant.mockito.common;

public interface ExternalApi {
    String getData();
    String fetchDetails(int id);
    void logMessage(String msg);
    void start();
    void stop();
}
