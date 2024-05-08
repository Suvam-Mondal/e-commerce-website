package com.example.ecommerce.entity;

import com.example.ecommerce.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.N;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemList {

    Product product;
    Integer quantity;

}
