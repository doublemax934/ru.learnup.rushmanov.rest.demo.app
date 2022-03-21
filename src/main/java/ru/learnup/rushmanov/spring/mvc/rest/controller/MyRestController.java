package ru.learnup.rushmanov.spring.mvc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.learnup.rushmanov.spring.mvc.rest.entity.TheatricalPerformance;
import ru.learnup.rushmanov.spring.mvc.rest.entity.Ticket;
import ru.learnup.rushmanov.spring.mvc.rest.exception_handling.NoSuchPerformanceException;
import ru.learnup.rushmanov.spring.mvc.rest.exception_handling.PerformanceIncorrectData;
import ru.learnup.rushmanov.spring.mvc.rest.service.OnlineSalesRegisterService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private OnlineSalesRegisterService onlineSalesRegisterService;

    @GetMapping("/performances")
    public List<TheatricalPerformance> showAllPerformances() {
        List<TheatricalPerformance> allPerformance = onlineSalesRegisterService.getAllPerformances();
        return allPerformance;
    }

    @GetMapping("/performances/{id}")
    public TheatricalPerformance getPerformance(@PathVariable int id) {
        TheatricalPerformance performance = onlineSalesRegisterService.getPerformance(id);
        if (performance == null) {
            throw new NoSuchPerformanceException("There is no performance with ID= " + id + " in Database");
        }
        return performance;
    }

    @PostMapping("/performances")
    public TheatricalPerformance addNewPerformance(@RequestBody TheatricalPerformance performance) {
        onlineSalesRegisterService.saveNewPerformance(performance);
        return performance;
    }

    @PutMapping("/performances")
    public TheatricalPerformance updatePerformence(@RequestBody TheatricalPerformance performance) {
        onlineSalesRegisterService.saveNewPerformance(performance);
        return performance;
    }

    @DeleteMapping("/performances/{id}")
    public String deletePerformance(@PathVariable int id) {
        TheatricalPerformance performance = onlineSalesRegisterService.getPerformance(id);
        if (performance == null) {
            throw new NoSuchPerformanceException("There is no performance with ID= " + id + " in Database");
        }
        onlineSalesRegisterService.deletePerformance(id);
        return "Performance with ID " + id + " was deleted";
    }

    @GetMapping("/performances/Ticket/{id}")
    public List<Ticket> showAllTickets(@PathVariable int id) {
        List<Ticket> allTickets = onlineSalesRegisterService.getAllTickets(id);
        return allTickets;
    }

    @GetMapping("/performances/Ticket/Buy/{id}")
    public String buyTicket(@PathVariable int id) {
        Ticket ticket = onlineSalesRegisterService.getTicket(id);
        onlineSalesRegisterService.buyTicket(id);
        return "The ticket was purchased successfully " + ticket;
    }

    @GetMapping("/performances/Ticket/Refund/{id}")
    public String refundTicket(@PathVariable int id) {
        Ticket ticket = onlineSalesRegisterService.getTicket(id);
        onlineSalesRegisterService.refundTicket(id);
        return "The ticket was return successfully " + ticket;
    }


}
