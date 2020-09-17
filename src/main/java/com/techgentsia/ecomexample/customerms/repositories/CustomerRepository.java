package com.techgentsia.ecomexample.customerms.repositories;

import com.techgentsia.ecomexample.customerms.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Customer findOneByEmail(String name);

}
