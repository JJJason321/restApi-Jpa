package com.xinyu.restApiJpa.repositorys;

import com.xinyu.restApiJpa.models.AccountAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountAppointmentRepository extends JpaRepository<AccountAppointment, Long> {

    @Query("SELECT appointmentId FROM ACCOUNT_APPOINTMENT a WHERE (a.accountId) = (?1)")
    List<Long> findAppointmentIdByAccountId(Long id);


}
