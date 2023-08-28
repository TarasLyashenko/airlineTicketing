package com.example.airlineTicketing.service.impl;

import com.example.airlineTicketing.dao.FlightDao;
import com.example.airlineTicketing.entity.Flight;
import com.example.airlineTicketing.enumFlight.FlightStatus;
import com.example.airlineTicketing.service.FlightService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FlightServiceImpl implements FlightService
{
    @Resource
    private FlightDao flightDao;

    @Override
    public void saveFlight(Flight flight)
    {
        if (flight.getCode() == null)
        {
            String codeFlight = generateRandomCode(6);
            flight.setCode(codeFlight);
        }
        flightDao.save(flight);
    }

    @Override
    public String seeAllFlight()
    {

        StringBuilder responseBuilder = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

        Iterable<Flight> all = flightDao.findAll();
        for (Flight flight : all)
        {
            String code = flight.getCode();
            LocalDateTime departureTime = flight.getDepartureTime();
            String formattedDate = departureTime.format(formatter);
            String departureCity = flight.getDepartureCity();
            String destinationCity = flight.getDestinationCity();
            FlightStatus status = flight.getStatus();

            responseBuilder.
                    append(code).append(" ").
                    append(formattedDate).append(" ").
                    append(departureCity).append(" ").
                    append(destinationCity).append(" ").
                    append(status).append("\n");
        }
        return responseBuilder.toString();
    }

    @Override
    public Flight findByCode(String code)
    {
        Flight byCode = flightDao.findByCode(code);
        return byCode;

    }

    private String generateRandomCode(int length)
    {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
