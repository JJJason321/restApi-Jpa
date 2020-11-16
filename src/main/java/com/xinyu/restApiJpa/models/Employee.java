package com.xinyu.restApiJpa.models;

import java.util.Objects;

import javax.persistence.*;

@Entity(name= "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String lastName;

    @Column(name="PHONENUMBER")
    private String phoneNumber;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="ACCOUNT_ID")
    private Long account_id;

    protected Employee(){}

    public Employee(String firstname, String lastName, String phoneNumber, String address, Long account_id){
        this.firstName = firstname;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.account_id = account_id;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }
}
