package com.techgentsia.ecomexample.orderrms.controllers;

import com.techgentsia.ecomexample.orderrms.entity.Order;
import com.techgentsia.ecomexample.orderrms.exceptions.ResourceNotFoundException;
import com.techgentsia.ecomexample.orderrms.models.OrderRequest;
import com.techgentsia.ecomexample.orderrms.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<Order> createOrder(@AuthenticationPrincipal User user, @Valid @RequestBody OrderRequest order) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(orderService.createOrder(user.getUsername(), order));
    }

    @GetMapping("/")
    public Iterable<Order> getAllOrders(@AuthenticationPrincipal User user) {

        return orderService.getAllOrders(user.getUsername());
    }

}
