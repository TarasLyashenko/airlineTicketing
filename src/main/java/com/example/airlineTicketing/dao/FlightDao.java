package com.example.airlineTicketing.dao;

import com.example.airlineTicketing.entity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDao extends CrudRepository<Flight, Long>
{
    Flight findByCode(String code);
}
