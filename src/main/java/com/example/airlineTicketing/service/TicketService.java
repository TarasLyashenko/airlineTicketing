package com.example.airlineTicketing.service;

import com.example.airlineTicketing.entity.Ticket;

public interface TicketService
{
    void saveTicket(Ticket ticket);

    String seeAllTicket(String login);

    String checkTicket(String code);

    void findTicketByFlight(String flightCode);
}
