package com.example.airlineTicketing.service.impl;

import com.example.airlineTicketing.dao.TicketDao;
import com.example.airlineTicketing.entity.Ticket;
import com.example.airlineTicketing.service.TicketService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService
{
    @Resource
    private TicketDao ticketDao;

    @Override
    public void saveTicket(Ticket ticket)
    {
        if (ticket.getCode() == null)
        {
            String codeTicket = generateRandomCode(5);
            ticket.setCode(codeTicket);
        }
        ticketDao.save(ticket);
    }

    @Override
    public String seeAllTicket(String login)
    {
        StringBuilder responseBuilder = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

        List<Ticket> ticketByLogin = ticketDao.findTicketByLogin(login);
        for (Ticket tickets : ticketByLogin)
        {
            String name = tickets.getCustomer().getName();
            String surname = tickets.getCustomer().getSurname();
            String patronymic = tickets.getCustomer().getPatronymic();
            String fullName = surname + " " + name + " " + patronymic;
            LocalDateTime departureTime = tickets.getDepartureTime();
            String formattedDate = departureTime.format(formatter);
            String code = tickets.getCode();

            responseBuilder.
                    append(fullName).append("  Ваш самолет отправляется: ").
                    append(formattedDate).append(" Ваш номер билета: ").
                    append(code).append("\n");
        }
        return responseBuilder.toString();
    }

    @Override
    public String checkTicket(String code)
    {
        StringBuilder responseBuilder = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        Ticket byCode = ticketDao.findByCode(code);
        if (byCode == null)
        {
            String message = "Билета с таким кодом в системе нет";
            responseBuilder.append(message);
            return responseBuilder.toString();
        }
        else
        {
            String message = "Билет действителен. ";
            String surname = byCode.getCustomer().getSurname();
            String name = byCode.getCustomer().getName();
            String patronymic = byCode.getCustomer().getPatronymic();
            String departureCity = byCode.getFlight().getDepartureCity();
            String destinationCity = byCode.getFlight().getDestinationCity();
            LocalDateTime departureTime = byCode.getDepartureTime();
            String formattedDate = departureTime.format(formatter);

            responseBuilder.
                    append(message).append(" ").
                    append(surname).append(" ").
                    append(name).append(" ").
                    append(patronymic).append(" Из: ").
                    append(departureCity).append(".  В: ").
                    append(destinationCity).append("  Когда: ").
                    append(formattedDate).append("\n");
        }
        return responseBuilder.toString();
    }

    @Override
    public void findTicketByFlight(String flightCode)
    {
        List<Ticket> ticketByFlight = ticketDao.findTicketByFlight(flightCode);
        for (Ticket ticket : ticketByFlight)
        {
            System.out.println("Уважаемый(ая), " + ticket.getCustomer().getName() +
                    " , к сожалению ваш рейс " + ticket.getFlight().getCode() +
                    "  был отменен");
        }
    }

    private String generateRandomCode(int length)
    {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
