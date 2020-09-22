package com.techgentsia.ecomexample.orderrms.repositories;

import com.techgentsia.ecomexample.orderrms.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> findAllByCustomerId(UUID customer);

}
