package ru.learnup.rushmanov.spring.mvc.rest.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.learnup.rushmanov.spring.mvc.rest.entity.TheatricalPerformance;
import ru.learnup.rushmanov.spring.mvc.rest.entity.Ticket;

import java.util.List;

@Repository
public class TheatricalPerformanceDAOImpl implements TheatricalPerformanceDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TheatricalPerformance> getAllPerformances() {
        Session session = sessionFactory.getCurrentSession();
        List<TheatricalPerformance> allPerformance = session.createQuery("from TheatricalPerformance",
                TheatricalPerformance.class).getResultList();


        return allPerformance;
    }

    @Override
    public void saveNewPerformance(TheatricalPerformance performance) {
        Session session = sessionFactory.getCurrentSession();
        performance.setTicketList(performance.getTitle(),performance.getTicketPrice1(),
                performance.getTicketPrice2(), performance.getTicketPrice3(), null);
        session.saveOrUpdate (performance);

    }



    @Override
    public TheatricalPerformance getPerfomance(int id) {
        Session session = sessionFactory.getCurrentSession();
        TheatricalPerformance performance = session.get(TheatricalPerformance.class, id);
        return performance;
    }

    @Override
    public void deletePerformance(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from TheatricalPerformance " +
                "where id =:performanceid")
                .setParameter("performanceid", id)
                .executeUpdate();
    }

}
