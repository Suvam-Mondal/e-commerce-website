package com.example.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {

    String  paymentType;
    String  paymentStatus;
    String  paymentCardNumber;
    String  registeredEmail;

}
