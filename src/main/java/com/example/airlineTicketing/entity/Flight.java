package com.example.airlineTicketing.entity;

import com.example.airlineTicketing.enumFlight.FlightStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Flight
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String departureCity;
    private String destinationCity;
    private LocalDateTime departureTime;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;

}
