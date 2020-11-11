package com.xinyu.restApiJpa.models;

import javax.persistence.*;


@Entity(name = "CLIENT")
public class Client {

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

    protected Client(){

    }

    public Client(String firstName, String lastName, String phoneNumber, String address, Long account_id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.account_id = account_id;
    }

    public Long getId() {
        return id;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
