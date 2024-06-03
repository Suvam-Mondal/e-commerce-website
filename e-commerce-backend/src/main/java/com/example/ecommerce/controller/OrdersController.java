package com.example.ecommerce.controller;

import com.example.ecommerce.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orders")
@Slf4j
public class OrdersController {

    private final OrderService orderService;

    @Autowired
    public OrdersController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public void addNewTodo(@RequestBody com.example.ecommerce.entity.OrderPayment orderPayment) {
        orderService.saveOrder(orderPayment);
    }

    @GetMapping()
    public List<com.example.ecommerce.entity.OrderPayment> getOrdersForUser(@RequestParam String userEmail)  {
        return orderService.getOrdersForUser(userEmail);
    }



}
