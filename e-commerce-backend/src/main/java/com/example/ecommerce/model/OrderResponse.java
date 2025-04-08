package com.example.ecommerce.model;

import lombok.Data;

@Data
public class OrderResponse {
    private String orderId;
    private int paymentInfoId;
    private String paymentType;
    private String paymentStatus;
    private String paymentCardNumber;
    private String registeredEmail;
    private int orderItemListId;
    private int productId;
    private int quantity;
    private String name;
    private String brand;
    private String category;
    private long price;
    private String img;
    private double rating;
}
