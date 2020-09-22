package com.techgentsia.ecomexample.orderrms.core;

import org.springframework.data.keyvalue.core.IdentifierGenerator;
import org.springframework.data.util.TypeInformation;

import java.security.SecureRandom;

public class OrderIdGenerator implements IdentifierGenerator {

    private final static String label = "ORD";
    private final static SecureRandom sr = new SecureRandom();


    @Override
    public <T> T generateIdentifierOfType(TypeInformation<T> typeInformation) {
        long val = sr.nextLong();
        return (T) (label + Long.toString(Math.abs(val), Character.MAX_RADIX));
    }
}