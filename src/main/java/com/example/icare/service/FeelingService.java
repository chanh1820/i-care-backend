package com.example.icare.service;

import com.example.icare.dto.FeelingDTO;
import com.example.icare.dto.ScheduleDTO;
import com.example.icare.sco.FeelingSCO;
import com.example.icare.sco.ScheduleSCO;

import java.util.List;

public interface FeelingService {

    public List<FeelingDTO> getAllByAccountId(FeelingSCO feelingSCO);
    public FeelingDTO  save(FeelingDTO feelingDTO);


}
