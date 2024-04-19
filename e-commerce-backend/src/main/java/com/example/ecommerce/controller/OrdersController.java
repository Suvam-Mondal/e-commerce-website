package com.example.ecommerce.controller;

import com.example.ecommerce.model.OrderPayment;
import com.example.ecommerce.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    @Autowired
    public OrdersController(final OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping()
    public void addNewTodo(@RequestParam String authToken, @RequestBody OrderPayment orderPayment) throws ExecutionException, InterruptedException {
        orderService.saveOrder(orderPayment, authToken);
    }

    @GetMapping()
    public List<OrderPayment> getOrdersForUser(@RequestParam String userEmail, @RequestParam String authToken) throws JsonProcessingException {
        return orderService.getOrdersForUser(userEmail, authToken);
    }



}
