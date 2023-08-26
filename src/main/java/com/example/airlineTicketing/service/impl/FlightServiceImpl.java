package com.example.airlineTicketing.service.impl;

import com.example.airlineTicketing.dao.FlightDao;
import com.example.airlineTicketing.entity.Flight;
import com.example.airlineTicketing.service.FlightService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService
{
    @Resource
    private FlightDao flightDao;

    @Override
    public void saveFlight(Flight flight)
    {
        flightDao.save(flight);
    }
}
