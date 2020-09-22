package com.techgentsia.ecomexample.orderrms.models;

import com.techgentsia.ecomexample.orderrms.entity.DBTimestamps;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public @Data
@NoArgsConstructor
class Product extends DBTimestamps implements Serializable {
    private UUID id;
    private String name;
    private String description;
    private String img;
    private BigDecimal price = BigDecimal.valueOf(0);

}
