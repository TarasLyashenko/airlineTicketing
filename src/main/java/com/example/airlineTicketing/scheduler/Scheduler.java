package com.example.airlineTicketing.scheduler;

import com.example.airlineTicketing.entity.Flight;
import com.example.airlineTicketing.enumFlight.FlightStatus;
import com.example.airlineTicketing.service.FlightService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class Scheduler
{
    @Resource
    private FlightService flightService;

    @Scheduled(fixedDelay = 5000)
    public void startFlightCheckTask()
    {
        List<Flight> flights = flightService.seeAllExceptFlew();

        LocalDateTime currentTime = LocalDateTime.now();
        for (Flight flight : flights)
        {
            if (currentTime.isAfter(flight.getDepartureTime()))
            {
                flight.setStatus(FlightStatus.FLEW);
            }
        }
    }
}


