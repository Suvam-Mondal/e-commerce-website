package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
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

    @PostMapping
    public void storeProducts() {
        productService.storeProducts1();
        productService.storeProducts2();
    }


    @GetMapping("/all")
    public List<Product> getAllProducts(@RequestParam("auth") String authToken) throws JsonProcessingException {
        return productService.getProducts(authToken);
    }

    @GetMapping("/{category}")
    public List<Product> getProductsForCategory(@RequestParam String authToken, @PathVariable("category") String category) throws ExecutionException, InterruptedException, JsonProcessingException {
        return productService.getProductsForCategory(category, authToken);
    }

    @GetMapping("/search/{searchKey}")
    public List<Product> getProductsForSearchKey(@RequestParam String authToken, @PathVariable String searchKey) throws ExecutionException, InterruptedException, JsonProcessingException {
        return productService.getProductsForSearchKey(searchKey, authToken);
    }


}
