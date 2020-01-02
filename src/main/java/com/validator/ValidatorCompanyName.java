package com.validator;

import com.entity.Timetable;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidatorCompanyName implements Validator {

    @Override
    public List<Timetable> getValidTimetables(List<Timetable> invalidList) {
        List<Timetable> validList=new ArrayList<>();
        for(Timetable previous:invalidList){
            for(Timetable next:invalidList){
                if(previous.getDepartureTime().equals(next.getDepartureTime())
                && previous.getArrivalTime().equals(next.getArrivalTime())
                        && !previous.getCompanyName().equals(next.getCompanyName())){
                    if(next.getCompanyName().equals("Grotty")){
                        validList.add(next);
                    }
                }
            }
        }
        invalidList.removeAll(validList);
        return invalidList;
    }


}
