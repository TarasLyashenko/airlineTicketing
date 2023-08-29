package com.example.airlineTicketing.dao;

import com.example.airlineTicketing.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Long>
{
}
