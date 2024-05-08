package com.example.ecommerce.entity;

import com.example.ecommerce.model.OrderItemList;
import com.example.ecommerce.model.PaymentInfo;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "orders")
public class OrderPayment {

    @Id
    String orderId;
    
    List<OrderItemList> orderList;
    PaymentInfo paymentInfo;

}
