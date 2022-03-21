package ru.learnup.rushmanov.spring.mvc.rest.dao;

import ru.learnup.rushmanov.spring.mvc.rest.entity.TheatricalPerformance;

import java.util.List;

public interface TheatricalPerformanceDAO {

    public List<TheatricalPerformance> getAllPerformances();

    public void saveNewPerformance(TheatricalPerformance performance);

    public TheatricalPerformance getPerfomance(int id);

    public void deletePerformance(int id);



}
