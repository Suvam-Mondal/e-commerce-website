package com.example.ecommerce.model;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class OrderItemList {

    @Id
    Integer orderItemListId;

    Product product;
    Integer quantity;

}
