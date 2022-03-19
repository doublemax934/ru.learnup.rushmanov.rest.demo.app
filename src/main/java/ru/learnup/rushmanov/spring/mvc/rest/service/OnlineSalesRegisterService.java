package ru.learnup.rushmanov.spring.mvc.rest.service;

import ru.learnup.rushmanov.spring.mvc.rest.entity.TheatricalPerformance;
import ru.learnup.rushmanov.spring.mvc.rest.entity.Ticket;

import java.util.List;

public interface OnlineSalesRegisterService {

    public List<TheatricalPerformance> getAllPerformances();

    public void saveNewPerformance(TheatricalPerformance performance);

    public TheatricalPerformance getPerformance(int id);

    public void deletePerformance (int id);

    public List<Ticket> getAllTickets(String title);

    public Ticket getTicket(int id);

    public void buyTicket(int id);

    public void refundTicket(int id);


}
