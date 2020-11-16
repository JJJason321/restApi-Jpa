package com.xinyu.restApiJpa.repositorys;

import com.xinyu.restApiJpa.models.Client;
import com.xinyu.restApiJpa.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{


    @Query("SELECT a FROM EMPLOYEE a WHERE (a.account_id) = (?1)")
    Employee getEmployeeByAccountId(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE EMPLOYEE a SET (a.firstName) = (?1), (a.lastName) = (?2), (a.phoneNumber) = (?3), (a.address) = (?4) WHERE (a.account_id) = (?5)", nativeQuery = true )
    void updateEmployeeInfo(String firstName, String lastName, String phoneNumber, String address, Long account_id);




}
