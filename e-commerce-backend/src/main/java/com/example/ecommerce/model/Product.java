package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class Product {

    String document_id;

    String name;
    String brand;
    String category;
    Long price;
    String img;

}
