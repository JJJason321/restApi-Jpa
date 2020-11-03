package com.xinyu.restApiJpa.repositorys;

import com.xinyu.restApiJpa.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
