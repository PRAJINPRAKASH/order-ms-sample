package com.techgentsia.ecomexample.customerms.models;

import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;

    public AuthResponse(String jwt) {
        this.jwt =jwt;
    }
}
