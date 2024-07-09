package com.example.ecommerce.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {

    String keyText;
    String imgPath;

}
