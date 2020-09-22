package com.techgentsia.ecomexample.orderrms.models;

public enum OrderStatus {
    INITIATED("Order Initiated"),
    PROGRESSING("Order Processing"),
    COMPLETED("Order Completed");
    private final String name;
    OrderStatus(String name) {
        this.name =name;
    }
}
