package com.example.ecommerce.model;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class Product {

    @Id
    Integer document_id;

    String name;
    String brand;
    String category;
    Long price;
    String img;
    Double rating;
    List<ProductDetail> details;

}
