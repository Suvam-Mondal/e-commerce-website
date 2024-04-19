package com.example.ecommerce.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderPayment {

    String orderId;
    List<OrderItemList> orderList;
    PaymentInfo paymentInfo;

}
