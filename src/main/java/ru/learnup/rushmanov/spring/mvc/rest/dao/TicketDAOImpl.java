package ru.learnup.rushmanov.spring.mvc.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.learnup.rushmanov.spring.mvc.rest.entity.TheatricalPerformance;
import ru.learnup.rushmanov.spring.mvc.rest.entity.Ticket;

import java.util.List;



@Repository
public class TicketDAOImpl implements TicketDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Ticket> getAllTickets(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<Ticket> allTickets = session.createQuery("from Ticket " +
                        "where theatricalPerformanceId =:ID")
                .setParameter("ID", id)
                .getResultList();

        return allTickets;
    }

    @Override
    public Ticket buyTicket(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Ticket set status = 'sold'" +
                "where id =:ID")
                .setParameter("ID", id)
                .executeUpdate();
        Ticket ticket = session.get(Ticket.class, id);
        return ticket;
    }

    @Override
    public Ticket refundTicket(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Ticket set status = 'on sale'" +
                        "where id =:ID")
                .setParameter("ID", id)
                .executeUpdate();
        Ticket ticket = session.get(Ticket.class, id);
        return ticket;
    }

    @Override
    public Ticket getTicket(int id) {
        Session session = sessionFactory.getCurrentSession();
        Ticket ticket = session.get(Ticket.class, id);
        return ticket;
    }


}
