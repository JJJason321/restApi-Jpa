package com.xinyu.restApiJpa.repositorys;

import com.xinyu.restApiJpa.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

        @Query("SELECT a FROM APPOINTMENT a where SERVICE_ID = 1")
        List<Appointment> getAppointmentByAccountId();

        @Query("SELECT a FROM APPOINTMENT a WHERE (a.id) in (?1)")
        List<Appointment> getAppointmentByOneId(List<Long> id);

        @Query(value = "SELECT * FROM APPOINTMENT a WHERE (a.id) in (?1) and (a.APPOINTMENT_DATE) = (?2)", nativeQuery = true)
        List<Appointment> getAppointmentByOneIdAndDate(List<Long> id, LocalDate date);
}
