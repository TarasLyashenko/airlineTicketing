package com.example.ticketing;

import com.example.ticketing.it.TicketOffice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args)
    {
        TicketOffice ticketOffice = new TicketOffice();
        ticketOffice.printTickets();
    }
}
