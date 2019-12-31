package com.service.serviceImpl;

import com.entity.Timetable;
import com.repo.TimetableRepo;
import com.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.sql.Time;
import java.util.*;

@Service
public class TimetableServiceImpl implements TimetableService {

    @Autowired
    private TimetableRepo timetableRepo;

    private static final Long hour=3600000L;

    private static final Time time=new Time(hour);

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
    public List<Timetable> getTestList() {
        List<Timetable> timetables=timetableRepo.findAllByOrderByArrivalTime();
        timetables.removeIf(item->{
            Time interval=new Time(item.getArrivalTime().getTime()-item.getDepartureTime().getTime());
            if(interval.compareTo(time)>0){
                return true;
            }else return false;
        });

        return timetables;
    }

    @Override
    public List<Timetable> findAllByOrderByDepartureTimeArrivalTime() {
        return timetableRepo.findAllByOrderByDepartureTimeAscArrivalTime() ;
    }
}
