package com.spring.nyuko.springfile.service.schedule;


import com.spring.nyuko.springfile.model.Schedule;
import com.spring.nyuko.springfile.repository.schedule.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ScheduleServiceImp implements ScheduleService {
    @Autowired private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> findAll(){
        return (List<Schedule>) scheduleRepository.findAll();
    }
}
