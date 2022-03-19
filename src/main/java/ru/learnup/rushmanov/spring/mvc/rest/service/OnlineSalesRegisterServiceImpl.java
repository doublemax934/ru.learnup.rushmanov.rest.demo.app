package ru.learnup.rushmanov.spring.mvc.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.rushmanov.spring.mvc.rest.dao.TheatricalPerformanceDAO;
import ru.learnup.rushmanov.spring.mvc.rest.dao.TicketDAO;
import ru.learnup.rushmanov.spring.mvc.rest.entity.TheatricalPerformance;
import ru.learnup.rushmanov.spring.mvc.rest.entity.Ticket;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OnlineSalesRegisterServiceImpl implements OnlineSalesRegisterService{
    @Autowired
    private TheatricalPerformanceDAO theatricalPerformanceDAO;
    @Autowired
    private TicketDAO ticketDAO;

    @Override
    @Transactional
    public List<TheatricalPerformance> getAllPerformances() {
        return theatricalPerformanceDAO.getAllPerformances();
    }

    @Override
    @Transactional
    public void saveNewPerformance(TheatricalPerformance performance) {
        theatricalPerformanceDAO.saveNewPerformance(performance);
    }

    @Override
    @Transactional
    public TheatricalPerformance getPerformance(int id) {
        return theatricalPerformanceDAO.getPerfomance(id);
    }

    @Override
    @Transactional
    public void deletePerformance(int id) {
        theatricalPerformanceDAO.deletePerformance(id);
    }

    @Override
    @Transactional
    public List<Ticket> getAllTickets(String title) {
        return ticketDAO.getAllTickets(title);
    }

    @Override
    @Transactional
    public Ticket getTicket(int id) {
        return ticketDAO.getTicket(id);
    }

    @Override
    @Transactional
    public void buyTicket(int id) {
        ticketDAO.buyTicket(id);
    }

    @Override
    @Transactional
    public void refundTicket(int id) {
        ticketDAO.refundTicket(id);
    }


}
