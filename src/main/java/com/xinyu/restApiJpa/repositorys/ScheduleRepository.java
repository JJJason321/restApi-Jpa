package com.xinyu.restApiJpa.repositorys;

import com.xinyu.restApiJpa.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
