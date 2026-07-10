package com.cognizant.user.model;

public class OrderDto {
    private Long id;
    private Long userId;
    private String product;
    private double price;

    public OrderDto() {}

    public OrderDto(Long id, Long userId, String product, double price) {
        this.id = id;
        this.userId = userId;
        this.product = product;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
