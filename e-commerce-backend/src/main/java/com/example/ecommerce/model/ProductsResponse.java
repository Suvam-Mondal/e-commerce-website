package com.example.ecommerce.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class ProductsResponse {

    String id;

    Product product;

}
