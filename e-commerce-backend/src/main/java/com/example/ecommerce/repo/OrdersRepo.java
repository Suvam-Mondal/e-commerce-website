package com.example.ecommerce.repo;

import com.example.ecommerce.entity.OrderPayment;
import com.example.ecommerce.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepo extends MongoRepository<OrderPayment, String > {

}
