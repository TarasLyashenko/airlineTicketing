package com.example.airlineTicketing.dao;

import com.example.airlineTicketing.entity.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDao extends CrudRepository<Flight, Long>
{
    Flight findByCode(String code);

    @Query("SELECT f FROM Flight f WHERE status NOT IN ('FLEW', 'CANCELED')")
    List<Flight> findFlightNoFlew();
}
