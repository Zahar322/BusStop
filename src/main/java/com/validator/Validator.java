package com.validator;

import com.entity.Timetable;

import java.util.List;

public interface Validator {

    List<Timetable> getValidTimetables(List<Timetable> invalidList);
}
