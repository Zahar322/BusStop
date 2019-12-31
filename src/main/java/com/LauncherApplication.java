package com;
import com.entity.Timetable;
import com.repo.TimetableRepo;
import com.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Time;
import java.util.List;


@SpringBootApplication
public class LauncherApplication implements CommandLineRunner {

    @Autowired
    private  TimetableService timetableService;

    private static final Long hour=3600000L;

    private static final Time time=new Time(hour);

    @Autowired
    private TimetableRepo timetableRepo;

    public static void main(String [] args){
        SpringApplication.run(LauncherApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        List<Timetable> timetableList=timetableService.findAllByOrderByCompanyNameDescDepartureTime();
        timetableList.removeIf(item->{
            Time interval=new Time(item.getArrivalTime().getTime()-item.getDepartureTime().getTime());
            if(interval.compareTo(time)>0){
                return true;
            }else return false;
        });
        for(Timetable timetable:timetableList){
//            System.out.println(new Time(timetable.getArrivalTime().getTime()-timetable.getDepartureTime().getTime()));
            System.out.println(timetable);
        }
    }
}
