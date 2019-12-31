package com.effectiveConsiderateClasses;

import com.entity.Timetable;

public class EffectorNotEqualInterval implements Effector {

    @Override
    public boolean getEffectiveTimetable(Timetable previous, Timetable next) {
        return false;
    }
}
