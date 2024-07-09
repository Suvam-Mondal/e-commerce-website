package com.example.ecommerce.service;

import com.example.ecommerce.repo.OrdersRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderService {

    private final OrdersRepo ordersRepo;

    public OrderService(final OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    public List<com.example.ecommerce.entity.OrderPayment> getOrdersForUser(String userId) {

        return ordersRepo.findAll();

    }

    public void saveOrder(com.example.ecommerce.entity.OrderPayment orderPayment)  {
        ordersRepo.save(orderPayment);

    }

}
