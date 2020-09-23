package com.techgentsia.ecomexample.orderrms.core;


import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class OrderIdGenerator  {

    private final static String label = "ORD-";
    private final static SecureRandom sr = new SecureRandom();

    public String generate() {
        int val = sr.nextInt(10_000000);
        return  (label + System.currentTimeMillis() + val);
    }
}