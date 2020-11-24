package com.xinyu.restApiJpa.models;


import java.time.LocalDate;

//This object1 class is used for one Post API Only. api: "/findopenschedule"
public class Object1 {

    private Long account_id;

    private Long employee_id;

    private java.time.LocalDate date;

    public Object1(Long account_id, LocalDate date, Long employee_id) {
        this.account_id = account_id;
        this.date = date;
        this.employee_id = employee_id;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }


    public Long getEmployee_id(){ return employee_id;}

    public void setEmployee_id(Long employee_id){ this.employee_id = employee_id;}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
