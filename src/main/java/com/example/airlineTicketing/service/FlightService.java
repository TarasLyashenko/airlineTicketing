package com.example.airlineTicketing.service;

import com.example.airlineTicketing.entity.Flight;

import java.util.List;

public interface FlightService
{
    void saveFlight(Flight flight);

    String seeAllFlight();

    Flight findByCode(String code);

    List<Flight> seeAllExceptFlew();
}
