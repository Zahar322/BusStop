package com.service;

import com.entity.Timetable;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public interface TimetableService {

    void deleteByCompanyNameAndArrivalTimeAndDepartureTime(String companyName, Date arrivalTime, Date departureTime);

    void deleteTimetable(Timetable timetable);

    List<Timetable> findAllByOrderByDepartureTime();

    List<Timetable> findAllByOrderByCompanyNameDescDepartureTime();

    Iterable<Timetable> saveAll(List<Timetable> timetables);

    void deleteById(int id);

    List<Timetable> getFinalTimetables();

}
