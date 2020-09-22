package com.techgentsia.ecomexample.orderrms.services;

import com.techgentsia.ecomexample.orderrms.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.techgentsia.ecomexample.orderrms.constants.InternalURLs.PRODUCT_URL;

@Service
public class InternalProductService {
    @Autowired
    RestTemplate restTemplate;

    public Product getProductById(String productId){
        Product product
                =  restTemplate.getForObject(String.format(PRODUCT_URL, productId),
                Product.class);
        return product;
    }
}
