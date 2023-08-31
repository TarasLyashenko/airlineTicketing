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

    private String generateRandomCode(int length)
    {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
