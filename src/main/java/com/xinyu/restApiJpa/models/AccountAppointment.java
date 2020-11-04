package com.xinyu.restApiJpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "ACCOUNT_APPOINTMENT")
public class AccountAppointment {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "APPOINTMENT_ID")
    private Long appointmentId;

    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    protected AccountAppointment(){}

    public AccountAppointment(Long appointmentId, Long accountId) {
        this.appointmentId = appointmentId;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
