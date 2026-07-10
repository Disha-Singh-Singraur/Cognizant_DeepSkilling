package com.cognizant.user.model;

import java.util.List;

public class UserDetailsResponse {
    private User user;
    private List<OrderDto> orders;

    public UserDetailsResponse() {}

    public UserDetailsResponse(User user, List<OrderDto> orders) {
        this.user = user;
        this.orders = orders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
}
