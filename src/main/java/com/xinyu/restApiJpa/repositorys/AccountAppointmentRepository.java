package com.xinyu.restApiJpa.repositorys;

import com.xinyu.restApiJpa.models.AccountAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountAppointmentRepository extends JpaRepository<AccountAppointment, Long> {
}
