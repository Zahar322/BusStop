package com.validator;

import com.entity.Timetable;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.List;

@Component
public class ValidatorOneHourLimit implements Validator {

    private static final Long hour=3600000L;

    private static final Time time=new Time(hour);

    @Override
    public List<Timetable> getValidTimetables(List<Timetable> invalidList) {
        invalidList.removeIf(item->{
            Time interval=new Time(item.getArrivalTime().getTime()-item.getDepartureTime().getTime());
            if(interval.compareTo(time)>0){
                return true;
            }else return false;
        });
        return invalidList;
    }
}
