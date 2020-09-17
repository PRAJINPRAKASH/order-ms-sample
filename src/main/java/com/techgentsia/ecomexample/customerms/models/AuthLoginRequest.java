package com.techgentsia.ecomexample.customerms.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthLoginRequest {
    private String email;
    private String password;
}
