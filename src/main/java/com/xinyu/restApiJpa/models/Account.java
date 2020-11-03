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

    protected Account(){}

    public Account(String username, String password){
        this.username = username;
        this.password = password;
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

    public void setUsername(String username){this.username = username;}

    public void setPassword(String password){this.password = password;}

    public void setId(Long id){
        this.id = id;
    }

}
