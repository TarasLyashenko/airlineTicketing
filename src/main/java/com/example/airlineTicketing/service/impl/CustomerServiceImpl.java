package com.example.airlineTicketing.service.impl;

import com.example.airlineTicketing.dao.CustomerDao;
import com.example.airlineTicketing.entity.Customer;
import com.example.airlineTicketing.service.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Resource
    private CustomerDao customerDao;

    @Override
    public void saveCustomer(Customer customer)
    {
        customerDao.save(customer);
    }

    @Override
    public String seeAllCustomers()
    {
        StringBuilder responseBuilder = new StringBuilder();

        Iterable<Customer> customers = customerDao.findAll();
        for (Customer customer : customers)
        {


            String surname = customer.getSurname();
            String name = customer.getName();
            String patronymic = customer.getPatronymic();
            String passport = customer.getPassport();
            String phoneNumber = customer.getPhoneNumber();
            String login = customer.getLogin();

            responseBuilder.
                    append(surname).append(" ").
                    append(name).append(" ").
                    append(patronymic).append(" ").
                    append(passport).append(" ").
                    append(phoneNumber).append(" ").
                    append(login).append("\n");
        }
        return responseBuilder.toString();
    }
}
