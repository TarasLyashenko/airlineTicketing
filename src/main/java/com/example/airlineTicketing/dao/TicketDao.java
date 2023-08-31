package com.example.airlineTicketing.dao;

import com.example.airlineTicketing.entity.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketDao extends CrudRepository<Ticket, Long>
{
    @Query("SELECT t FROM Ticket t WHERE t.customer.login = :login")
    List<Ticket> findTicketByLogin(String login);
}
