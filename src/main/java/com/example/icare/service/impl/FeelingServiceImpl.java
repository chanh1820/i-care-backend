package com.example.icare.service.impl;

import com.example.icare.dto.FeelingDTO;
import com.example.icare.dto.ScheduleDTO;
import com.example.icare.entity.FeelingEntity;
import com.example.icare.entity.ScheduleEntity;
import com.example.icare.mapper.FeelingMapper;
import com.example.icare.mapper.ScheduleMapper;
import com.example.icare.repository.FeelingRepository;
import com.example.icare.repository.ScheduleRepository;
import com.example.icare.sco.FeelingSCO;
import com.example.icare.sco.ScheduleSCO;
import com.example.icare.service.FeelingService;
import com.example.icare.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FeelingServiceImpl implements FeelingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeelingServiceImpl.class);

    @Autowired
    FeelingRepository feelingRepository;

    @Autowired
    FeelingMapper feelingMapper;


    @Override
    public List<FeelingDTO> getAllByAccountId(FeelingSCO feelingSCO) {
        Optional<List<FeelingEntity>> optional = feelingRepository.findAllByAccountId(feelingSCO.getAccountId());
        return optional.map(feelingEntities -> feelingMapper.toDTOs(feelingEntities)).orElse(null);
    }

    @Override
    public FeelingDTO save(FeelingDTO feelingDTO) {
        return feelingMapper.toDTO(feelingRepository.save(feelingMapper.toEntity(feelingDTO)));
    }
}
