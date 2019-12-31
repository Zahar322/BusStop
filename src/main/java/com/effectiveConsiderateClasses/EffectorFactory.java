package com.effectiveConsiderateClasses;

import com.entity.Timetable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EffectorFactory {

    private List<Timetable> effectiveList;

    public EffectorFactory(){
        effectiveList=new ArrayList<>();
    }

    public Effector createEffector(){
        return new EffectorEqualInterval();
    }

    public List<Timetable> getEffectiveList() {
        return effectiveList;
    }
}
