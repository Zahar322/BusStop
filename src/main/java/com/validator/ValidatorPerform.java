package com.validator;

import com.entity.Timetable;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ValidatorPerform implements Validator {

    private static final Long hour=3600000L;

    @Override
    public List<Timetable> getValidTimetables(List<Timetable> invalidList) {
        List<Integer> notPerform=new ArrayList<>();
        for(Timetable currentTimetable:invalidList){
            setNewDay(currentTimetable);
        }
        List<Timetable> performTimetables=new ArrayList<>(invalidList);
        for(int i=0;i<invalidList.size();i++) {
            for(int j=0;j<invalidList.size();j++) {
                if(isPerformed(invalidList.get(i),invalidList.get(j))) {
                    notPerform.add(j);
                }
            }
        }
        if(!notPerform.isEmpty()) {
            for(int i=0;i<notPerform.size();i++) {
                Timetable removeServices= invalidList.get(notPerform.get(i));
                performTimetables.remove(removeServices);
            }
            return performTimetables;
        }
        return performTimetables;
    }

    private boolean isPerformed(Timetable previous, Timetable next) {
        if(isPerformedByDateFrom(previous,next) || isPerformedByDateTo(previous,next) || isPerformedByDateRange(previous,next)) {
            return true;
        }
        return false;
    }
    private boolean isPerformedByDateFrom(Timetable previous, Timetable next) {
        if(previous.getDepartureTime().equals(next.getDepartureTime()) && previous.getArrivalTime().compareTo(next.getArrivalTime())<0) {
            return true;
        }
        return false;
    }
    private boolean isPerformedByDateTo(Timetable previous, Timetable next) {
        if(previous.getArrivalTime().equals(next.getArrivalTime()) && previous.getDepartureTime().compareTo(next.getDepartureTime())>0) {
            return true;
        }
        return false;
    }
    private boolean isPerformedByDateRange(Timetable previous, Timetable next) {
        if(previous.getDepartureTime().getTime()>next.getDepartureTime().getTime() && previous.getArrivalTime().compareTo(next.getArrivalTime())<0) {
            return true;
        }
        return false;
    }
    private void setNewDay(Timetable currentTimetable){
        if(currentTimetable.getArrivalTime().getTime()-currentTimetable.getDepartureTime().getTime()<0){
            currentTimetable.setArrivalTime(new Date(currentTimetable.getArrivalTime().getTime()+hour*24));
        }

    }
}
