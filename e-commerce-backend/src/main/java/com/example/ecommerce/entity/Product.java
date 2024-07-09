package com.example.ecommerce.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

@Data
@Document(collection = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    String document_id;

    String name;
    String brand;
    String category;
    Long price;
    String img;
    Double rating;
    List<ProductDetail> details;

}
