package com.example.icare.controller;

import com.example.icare.dto.FeelingDTO;
import com.example.icare.dto.ScheduleDTO;
import com.example.icare.dto.api.ResponseDTO;
import com.example.icare.mapper.FeelingMapper;
import com.example.icare.mapper.ScheduleMapper;
import com.example.icare.sco.FeelingSCO;
import com.example.icare.sco.ScheduleSCO;
import com.example.icare.service.FeelingService;
import com.example.icare.service.ScheduleService;
import com.example.icare.util.ObjectMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/feeling")
public class FeelingController {
    private Logger logger = LoggerFactory.getLogger(FeelingController.class);

    @Autowired
    private FeelingService feelingService;

    @Autowired
    private FeelingMapper feelingMapper;


    @PostMapping("/getall")
    public ResponseDTO<List<FeelingDTO>> getFeelingList(@RequestBody FeelingSCO feelingSCO) {
        logger.info("Start getFeelingList with {}", feelingSCO);
        ResponseDTO<List<FeelingDTO>> responseDTO = new ResponseDTO<>();
        responseDTO.setData(feelingService.getAllByAccountId(feelingSCO));
        logger.info("End getFeelingList");
        return responseDTO;
    }

    @PostMapping("/save")
    public ResponseDTO<FeelingDTO> saveFeeling(@RequestBody FeelingDTO feelingDTO) {
        logger.info("Start saveFeeling {}", ObjectMapperUtil.writeValueAsString(feelingMapper.toEntity(feelingDTO)));
        ResponseDTO<FeelingDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setData(feelingService.save(feelingDTO));
        logger.info("End saveFeeling");
        return responseDTO;
    }
}
