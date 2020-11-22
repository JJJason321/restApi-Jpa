package com.xinyu.restApiJpa.models;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity(name = "SCHEDULE")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "WORK_DATE")
    private java.sql.Date date;

    @Column(name = "START_WORK_TIME")
    private java.sql.Time startTime;

    @Column(name = "END_WORK_TIME")
    private java.sql.Time endTime;

    protected Schedule(){}

    public Schedule(Long employeeId, Date date, Time startTime, Time endTime) {
        this.employeeId = employeeId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
