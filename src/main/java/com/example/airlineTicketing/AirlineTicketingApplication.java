package com.example.airlineTicketing;

import com.example.airlineTicketing.dao.FlightDao;
import com.example.airlineTicketing.entity.Flight;
import com.example.airlineTicketing.enumFlight.FlightStatus;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class AirlineTicketingApplication implements CommandLineRunner
{
    @Resource
    private FlightDao flightDao;

    public static void main(String[] args)
    {
        SpringApplication.run(AirlineTicketingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        Flight flight = new Flight();
        flight.setStatus(FlightStatus.OK);
        flight.setDepartureTime(LocalDateTime.now());
        flight.setDepartureCity("Moscow");
        flight.setDestinationCity("Kazan");
        flightDao.save(flight);
    }
}
