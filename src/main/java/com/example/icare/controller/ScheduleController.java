package com.example.icare.controller;

import com.example.icare.dto.ScheduleDTO;
import com.example.icare.dto.api.ResponseDTO;
import com.example.icare.mapper.ScheduleMapper;
import com.example.icare.sco.ScheduleSCO;
import com.example.icare.service.ScheduleService;
import com.example.icare.util.ObjectMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private Logger logger = LoggerFactory.getLogger(ScheduleController.class);

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ScheduleMapper scheduleMapper;


    @PostMapping("/getall")
    public ResponseDTO<List<ScheduleDTO>> getScheduleList(@RequestBody ScheduleSCO scheduleSCO) {
        logger.info("Start getScheduleList with {}", scheduleSCO);
        ResponseDTO<List<ScheduleDTO>> responseDTO = new ResponseDTO<>();
        responseDTO.setData(scheduleService.getAllByAccountId(scheduleSCO));
        logger.info("End getScheduleList");
        return responseDTO;
    }

    @PostMapping("/save")
    public ResponseDTO<ScheduleDTO> saveSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        logger.info("Start saveSchedule {}", ObjectMapperUtil.writeValueAsString(scheduleMapper.toEntity(scheduleDTO)));
        ResponseDTO<ScheduleDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setData(scheduleService.save(scheduleDTO));
        logger.info("End saveSchedule");
        return responseDTO;
    }
}
