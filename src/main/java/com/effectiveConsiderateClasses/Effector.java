package com.effectiveConsiderateClasses;

import com.entity.Timetable;

public interface Effector {

    boolean getEffectiveTimetable(Timetable previous,Timetable next);
}
