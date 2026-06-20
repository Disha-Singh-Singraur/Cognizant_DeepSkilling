package com.cognizant.mockitoadvanced.exercise2;
public class ApiService {
    private final RestClient restClient;
    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }
    public String fetchData() {
        return "Fetched " + restClient.getResponse();
    }
}
