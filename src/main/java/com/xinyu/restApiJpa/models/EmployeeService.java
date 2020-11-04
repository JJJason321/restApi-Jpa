package com.xinyu.restApiJpa.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "EMPLOYEE_SERVICE")
public class EmployeeService {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Employee_ID")
    private Long employeeId;

    @Column(name = "SERVICE_ID")
    private Long serviceId;

    protected EmployeeService(){

    }

    public EmployeeService(Long employeeId, Long serviceId) {
        this.employeeId = employeeId;
        this.serviceId = serviceId;
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

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}
