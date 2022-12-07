package com.spring.nyuko.springfile.repository.schedule;

import com.spring.nyuko.springfile.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
}
