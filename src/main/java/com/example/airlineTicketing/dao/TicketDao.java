package com.example.airlineTicketing.dao;

import com.example.airlineTicketing.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDao extends CrudRepository<Ticket, Long>
{

}
