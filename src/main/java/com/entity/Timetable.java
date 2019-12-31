package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

@Entity
public class Timetable  {

    @Id
    @GeneratedValue
    private int id;

    private String companyName;


    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
    private Date departureTime;


    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
    private Date arrivalTime;

    public Timetable() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return Objects.equals(companyName, timetable.companyName) &&
                Objects.equals(departureTime, timetable.departureTime) &&
                Objects.equals(arrivalTime, timetable.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, departureTime, arrivalTime);
    }
}
