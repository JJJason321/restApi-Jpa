package com.xinyu.restApiJpa.models;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Object2 {

    private Long accountProvider;

    private Long accountReceiver;

    private java.time.LocalDate date;

    private java.sql.Time startTime;

    private java.sql.Time endTime;

    public Object2(Long accountProvider, Long accountReceiver, LocalDate date, Time startTime, Time endTime) {
        this.accountProvider = accountProvider;
        this.accountReceiver = accountReceiver;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getAccountProvider() {
        return accountProvider;
    }

    public void setAccountProvider(Long accountProvider) {
        this.accountProvider = accountProvider;
    }

    public Long getAccountReceiver() {
        return accountReceiver;
    }

    public void setAccountReceiver(Long accountReceiver) {
        this.accountReceiver = accountReceiver;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
