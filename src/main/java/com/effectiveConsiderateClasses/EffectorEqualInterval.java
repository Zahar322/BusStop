package com.effectiveConsiderateClasses;

import com.entity.Timetable;
import org.springframework.beans.factory.annotation.Autowired;

public class EffectorEqualInterval implements Effector {

    @Autowired
    private EffectorFactory effectorFactory;

    @Override
    public boolean getEffectiveTimetable(Timetable previous, Timetable next) {
//        if(previous.getDepartureTime().equals(next.getDepartureTime())&&previous.getArrivalTime().equals(next.getArrivalTime())){
//            if(previous.getCompanyName().equals("Posh")){
//                effectorFactory.getEffectiveList().add(previous);
//                return previous;
//            }else {
//                effectorFactory.getEffectiveList().add(next);
//                return next;
//            }
//        }
//        if(previous.getDepartureTime().equals(next.getDepartureTime())){
//            if(previous.getArrivalTime().compareTo(next.getArrivalTime())<0){
//                timetables.get(i+1).setArrivalTime(null);
//
//            }else{
//                timetables.get(timetables.indexOf(previous)).setArrivalTime(null);
//                previous=next;
//
//            }
//
//        }
//        if(previous.getArrivalTime().equals(next.getArrivalTime())){
//            if(previous.getDepartureTime().compareTo(next.getDepartureTime())<0){
//                timetables.get(timetables.indexOf(previous)).setArrivalTime(null);
//                previous=next;
//
//            }else{
//                timetables.get(i+1).setArrivalTime(null);
//
//            }
//
//        }
        return false;
    }
}
