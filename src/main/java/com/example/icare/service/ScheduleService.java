package com.example.icare.service;

import com.example.icare.dto.AccountDTO;
import com.example.icare.dto.LoginDTO;
import com.example.icare.dto.ScheduleDTO;
import com.example.icare.sco.ScheduleSCO;

import java.util.List;

public interface ScheduleService {

    public List<ScheduleDTO> getAllByAccountId(ScheduleSCO scheduleSCO);
    public ScheduleDTO  save(ScheduleDTO scheduleDTO);


}
