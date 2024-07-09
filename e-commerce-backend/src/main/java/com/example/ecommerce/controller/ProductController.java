package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }



    @PostMapping("/mongo/store")
    public void storeProducts_mongo() {
        productService.storeProducts1_mongo();
        productService.storeProducts2_mongo();
    }

    @GetMapping("/mongo/all")
    public List<com.example.ecommerce.entity.Product> getAllProductsFromMongo() {
        log.info("getAllProductsFromMongo() called");
        return productService.getProducts();
    }


    @GetMapping("/mongo/{category}")
    public List<com.example.ecommerce.entity.Product> getProductsForCategory(@PathVariable("category") String category) {
        log.info("getProductsForCategory() called for category {}", category);
        List<Product> productsForCategory = productService.getProductsForCategory(category.toLowerCase());
        log.info("getProductsForCategory():: {}", productsForCategory);
        return productsForCategory;
    }

    @GetMapping("/mongo/search/{searchKey}")
    public List<com.example.ecommerce.entity.Product> getProductsForSearchKey(@PathVariable String searchKey)  {
        return productService.getProductsForSearchKey(searchKey.toLowerCase());
    }



}
