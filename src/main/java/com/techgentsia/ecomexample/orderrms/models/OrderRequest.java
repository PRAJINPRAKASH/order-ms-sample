package com.techgentsia.ecomexample.orderrms.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import static com.techgentsia.ecomexample.orderrms.constants.MessageConstants.PRODUCT_ID_VALIDATION;

@Data
@NoArgsConstructor
public class OrderRequest {
    @NotBlank(message = PRODUCT_ID_VALIDATION)
    private String productId;
    private int quantity = 1;
}
