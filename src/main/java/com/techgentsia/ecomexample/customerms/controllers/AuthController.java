package com.techgentsia.ecomexample.customerms.controllers;

import com.techgentsia.ecomexample.customerms.entity.Customer;
import com.techgentsia.ecomexample.customerms.models.AuthLoginRequest;
import com.techgentsia.ecomexample.customerms.models.AuthResponse;
import com.techgentsia.ecomexample.customerms.services.CustomerService;
import com.techgentsia.ecomexample.customerms.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.techgentsia.ecomexample.customerms.constants.AuthConstants.USER_ROLE;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerService customerService;


    @PostMapping("/register")
    public ResponseEntity<Customer> register(@Valid @RequestBody Customer customer) {
        customer.setRoles(USER_ROLE);
        final Customer user = customerService.createCustomer(customer);
        return ResponseEntity.ok().body(user);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthLoginRequest authLoginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authLoginRequest.getEmail(),
                authLoginRequest.getPassword()));
        final Customer customer = customerService.getCustomerByEmail(authLoginRequest.getEmail());
        return ResponseEntity.ok().body(new AuthResponse(jwtTokenUtil.generateToken(customer)));
    }
}
