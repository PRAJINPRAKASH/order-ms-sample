package com.techgentsia.ecomexample.orderrms.services;

import com.techgentsia.ecomexample.orderrms.entity.Order;
import com.techgentsia.ecomexample.orderrms.models.OrderRequest;
import com.techgentsia.ecomexample.orderrms.models.Product;
import com.techgentsia.ecomexample.orderrms.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService  {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private InternalProductService internalProductService;
    @Autowired
    private InternalCustomerService internalCustomerService;
    public List<Order> getAllOrders(String user) {
        List<Order> result = new ArrayList<>();
        System.out.println("findAllByCustomerId");
        orderRepository.findAllByCustomerId(UUID.fromString(user)).forEach(result::add);
        return result;
    }

    public Order createOrder(String user,OrderRequest order) {
        internalCustomerService.customerNotExists();
        Product product = internalProductService.getProductById(order.getProductId());
        Order newOrder = new Order();
        newOrder.setCustomerId(UUID.fromString(user));
        newOrder.setProductId(UUID.fromString(order.getProductId()));
        newOrder.setQuantity(order.getQuantity());
        newOrder.setUnitPrice(product.getPrice());
        newOrder.calculateTotal();
        return orderRepository.save(newOrder);
    }



}
