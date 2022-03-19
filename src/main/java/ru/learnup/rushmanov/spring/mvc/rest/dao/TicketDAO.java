package ru.learnup.rushmanov.spring.mvc.rest.dao;

import ru.learnup.rushmanov.spring.mvc.rest.entity.Ticket;


import java.util.List;

public interface TicketDAO {

    public List<Ticket> getAllTickets(String title);

    public void buyTicket(int id);

    public void refundTicket(int id);

    public Ticket getTicket(int id);
}
