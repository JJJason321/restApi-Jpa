package com.xinyu.restApiJpa.repositorys;

import com.xinyu.restApiJpa.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    /*
    @Query( value = "SELECT a FROM SCHEDULE a WHERE a.WORK_DATE = (?1)", nativeQuery = true)
    List<Schedule> getScheduleByDate(Date date);
    */

    @Query( value = "SELECT * FROM SCHEDULE AS a WHERE (a.EMPLOYEE_ID) = (?1)", nativeQuery = true)
    List<Schedule> findScheduleById(Long id);

    @Query( value = "SELECT * FROM (SELECT * FROM SCHEDULE AS a WHERE a.WORK_DATE = (?2)) AS a WHERE (a.EMPLOYEE_ID) = (?1)", nativeQuery = true)
    List<Schedule> findScheduleByIdDate(Long id, LocalDate date);

}
