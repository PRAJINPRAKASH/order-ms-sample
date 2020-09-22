package com.techgentsia.ecomexample.orderrms.entity;

import com.techgentsia.ecomexample.orderrms.models.OrderStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public @Data
@Table(name = "orders")
class Order extends DBTimestamps implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @GenericGenerator(name="order_id",strategy = "com.techgentsia.ecomexample.orderrms.core.OrderIdGenerator")
    @GeneratedValue(generator = "order_id")
    private String orderId;
    private UUID productId;
    private UUID customerId;
    private int quantity = 1;
    private BigDecimal unitPrice = BigDecimal.valueOf(0);
    private BigDecimal totalPrice = BigDecimal.valueOf(0);
    private OrderStatus orderStatus = OrderStatus.INITIATED;
    public void calculateTotal(){
        totalPrice = unitPrice.multiply(new BigDecimal(quantity));
    }
}
