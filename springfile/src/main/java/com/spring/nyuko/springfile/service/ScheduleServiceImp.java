package com.spring.nyuko.springfile.service;


import ch.qos.logback.core.model.Model;
import com.spring.nyuko.springfile.model.Schedule;
import com.spring.nyuko.springfile.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ScheduleServiceImp implements ScheduleService{
    @Autowired private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> findAll(){
        return (List<Schedule>) scheduleRepository.findAll();
    }
}
