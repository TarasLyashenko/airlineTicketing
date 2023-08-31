package com.example.airlineTicketing.service.impl;

import com.example.airlineTicketing.dao.TicketDao;
import com.example.airlineTicketing.entity.Ticket;
import com.example.airlineTicketing.service.TicketService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

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

    private String generateRandomCode(int length)
    {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
