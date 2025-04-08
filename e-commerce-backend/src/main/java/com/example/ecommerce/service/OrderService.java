package com.example.ecommerce.service;

import com.example.ecommerce.model.OrderPayment;
import com.example.ecommerce.model.OrderResponse;
import com.example.ecommerce.repo.OrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderService {

    private final OrderRepo ordersRepo;

    public OrderService(final OrderRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    public List<OrderResponse> getOrdersForUser(String userId) {

        return ordersRepo.getAll(userId);

    }

    public void saveOrder(OrderPayment orderPayment)  {
        ordersRepo.saveOrder(orderPayment);

    }

}
