package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



    @PostMapping("/store")
    public void initializeProducts() {
        productService.initializeProducts();
    }

    @GetMapping("/all")
    public List<com.example.ecommerce.model.Product> getAllProducts() {
        log.info("getAllProducts() called");
        return productService.getProducts();
    }


  @GetMapping("/{category}")
    public List<com.example.ecommerce.model.Product> getProductsForCategory(@PathVariable("category") String category) {
        log.info("getProductsForCategory() called for category {}", category);
        List<Product> productsForCategory = productService.getProductsForCategory(category.toLowerCase());
        log.info("getProductsForCategory():: {}", productsForCategory);
        return productsForCategory;
    }

      @GetMapping("/search/{searchKey}")
    public List<com.example.ecommerce.model.Product> getProductsForSearchKey(@PathVariable String searchKey)  {
        return productService.getProductsForSearchKey(searchKey.toLowerCase());
    }


}
