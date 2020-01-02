package com;


import com.entity.Timetable;
import com.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/rest",produces = "application/json")
public class RestApplicationController {

    @Autowired
    private TimetableService timetableService;

    @GetMapping("/orderByDepartureTime")
    public List<Timetable> findAllByOrderByDepartureTime(){
        return timetableService.findAllByOrderByDepartureTime();
    }

    @GetMapping("/getFinalTimetables")
    public List<Timetable> getFinalTimetables(){
        return timetableService.getFinalTimetables();
    }


    @PostMapping("/save")
    public Iterable<Timetable> saveAll(@RequestBody List<Timetable> timetables) {

        return timetableService.saveAll(timetables);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable int id){
        timetableService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public void deleteByCompanyNameAndBothTimes(String companyName, Date arrivalDate, Date departureDate){
        timetableService.deleteByCompanyNameAndArrivalTimeAndDepartureTime(companyName, arrivalDate, departureDate);
    }

    @GetMapping("/orderByCompanyNameAndDepartureTime")
    public List<Timetable> findAllByOrderByCompanyNameDescDepartureTime(){
        return timetableService.findAllByOrderByCompanyNameDescDepartureTime();
    }
}
