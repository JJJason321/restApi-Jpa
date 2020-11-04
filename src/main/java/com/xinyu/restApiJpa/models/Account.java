package com.xinyu.restApiJpa.models;

import org.hibernate.boot.model.relational.Namespace;

import java.util.Objects;

import javax.persistence.*;

@Entity(name = "ACCOUNT")
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ISADMIN")
    private boolean admin;

    @Column(name = "ISEMPLOYEE")
    private boolean employee;

    @Column(name = "ISCLIENT")
    private boolean client;

    protected Account(){}

    public Account(String username, String password, boolean admin, boolean employee, boolean client){
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.employee = employee;
        this.client = client;
    }

    public Long getId(){
        return this.id;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isClient() {
        return client;
    }

    public boolean isEmployee() {
        return employee;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public void setEmployee(boolean employee) {
        this.employee = employee;
    }

    public void setUsername(String username){this.username = username;}

    public void setPassword(String password){this.password = password;}

    public void setId(Long id){
        this.id = id;
    }

}
