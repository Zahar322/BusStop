package com.service.serviceImpl;


import com.entity.Timetable;
import com.repo.TimetableRepo;
import com.service.TimetableService;
import com.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.sql.Time;
import java.util.*;

@Service
public class TimetableServiceImpl implements TimetableService {

    @Autowired
    private TimetableRepo timetableRepo;

    @Autowired
    private List<Validator> validators;


    @Override
    @Transactional
    public void deleteByCompanyNameAndArrivalTimeAndDepartureTime(String companyName, Date arrivalTime, Date departureTime) {
         timetableRepo.deleteByCompanyNameAndArrivalTimeAndDepartureTime(companyName, arrivalTime, departureTime);
    }

    @Override
    public List<Timetable> findAllByOrderByDepartureTime() {
        return timetableRepo.findAllByOrderByDepartureTime();
    }

    @Override
    @Transactional
    public Iterable<Timetable> saveAll(List<Timetable> timetables) {
        return timetableRepo.saveAll(timetables);
    }

    @Override
    public List<Timetable> findAllByOrderByCompanyNameDescDepartureTime() {
        return timetableRepo.findAllByOrderByCompanyNameDescDepartureTime();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        timetableRepo.deleteById(id);
    }

    @Override
    public List<Timetable> getFinalTimetables() {
        List<Timetable> timetables=timetableRepo.findAllByOrderByDepartureTime();
        for(Validator validator:validators){
            timetables=validator.getValidTimetables(timetables);
        }
        return timetables;
    }

}
