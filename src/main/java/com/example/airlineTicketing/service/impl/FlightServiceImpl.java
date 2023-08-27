package com.example.airlineTicketing.service.impl;

import com.example.airlineTicketing.dao.FlightDao;
import com.example.airlineTicketing.entity.Flight;
import com.example.airlineTicketing.service.FlightService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService
{
    @Resource
    private FlightDao flightDao;

    @Override
    public void saveFlight(Flight flight)
    {
        String codeFlight = generateRandomCode(6);
        flight.setCode(codeFlight);
        flightDao.save(flight);
    }

    private String generateRandomCode(int length)
    {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
