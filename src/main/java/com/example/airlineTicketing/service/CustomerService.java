package com.example.airlineTicketing.service;

import com.example.airlineTicketing.entity.Customer;

public interface CustomerService
{
    void saveCustomer(Customer customer);

    String seeAllCustomers();

    Customer findByLogin(String login);
}
