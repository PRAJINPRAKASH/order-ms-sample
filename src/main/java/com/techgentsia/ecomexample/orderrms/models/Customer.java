package com.techgentsia.ecomexample.orderrms.models;

import com.techgentsia.ecomexample.orderrms.entity.DBTimestamps;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

public @Data
class Customer extends DBTimestamps implements Serializable {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String img;
}

