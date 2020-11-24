
package com.xinyu.restApiJpa.models;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;


@Entity(name = "APPOINTMENT")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "APPOINTMENT_DATE")
    private java.sql.Date Date;

    @Column(name = "START_TIME")
    private java.sql.Time startTime;

    @Column(name = "END_TIME")
    private java.sql.Time endTime;

    @Column(name = "SERVICE_ID")
    private Long serviceId;

    public Appointment(){

    }

    public Appointment(java.sql.Date date, java.sql.Time startTime, java.sql.Time endTime, Long serviceId){
        this.Date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.serviceId = serviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
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

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}


