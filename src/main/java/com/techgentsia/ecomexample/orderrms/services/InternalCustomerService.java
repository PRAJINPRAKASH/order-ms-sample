package com.techgentsia.ecomexample.orderrms.services;

import com.techgentsia.ecomexample.orderrms.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.techgentsia.ecomexample.orderrms.constants.InternalURLs.CUSTOMER_URL;

@Service
public class InternalCustomerService {
    @Autowired
    RestTemplate restTemplate;

    public void customerNotExists()  {
        restTemplate.getForObject(CUSTOMER_URL,Customer.class);
    }
}
