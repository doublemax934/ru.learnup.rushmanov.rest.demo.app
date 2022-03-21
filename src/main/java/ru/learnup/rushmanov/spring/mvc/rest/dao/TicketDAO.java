package ru.learnup.rushmanov.spring.mvc.rest.dao;

import ru.learnup.rushmanov.spring.mvc.rest.entity.TheatricalPerformance;
import ru.learnup.rushmanov.spring.mvc.rest.entity.Ticket;


import java.util.List;

public interface TicketDAO {

    public List<Ticket> getAllTickets(int id);

    public Ticket buyTicket(int id);

    public Ticket refundTicket(int id);

    public Ticket getTicket(int id);

}