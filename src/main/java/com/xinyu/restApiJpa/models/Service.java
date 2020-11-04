package com.xinyu.restApiJpa.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "SERVICE")
public class Service {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String serviceName;

    @Column(name = "Description")
    private String serviceDescription;

    protected Service(){

    }

    public Service(String serviceName, String serviceDescription) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}
