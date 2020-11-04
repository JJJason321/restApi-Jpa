package com.xinyu.restApiJpa.repositorys;

import com.xinyu.restApiJpa.models.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeServiceRepository extends JpaRepository<EmployeeService, Long> {
}
