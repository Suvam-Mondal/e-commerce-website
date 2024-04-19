package com.example.ecommerce.model;

import lombok.Data;

@Data
public class PaymentInfo {

    String  paymentType;
    String  paymentStatus;
    String  paymentCardNumber;
    String  registeredEmail;

}
