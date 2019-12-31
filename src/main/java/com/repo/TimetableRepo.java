package com.repo;

import com.entity.Timetable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TimetableRepo extends CrudRepository<Timetable,Integer> {

    void deleteByCompanyNameAndArrivalTimeAndDepartureTime(String companyName, Date arrivalTime, Date departureTime);

    List<Timetable> findAllByOrderByDepartureTime();

    List<Timetable> findAllByOrderByArrivalTime();



    List<Timetable> findAllByOrderByCompanyNameDescDepartureTime();

    List<Timetable> findAllByOrderByDepartureTimeAscArrivalTime();

}
