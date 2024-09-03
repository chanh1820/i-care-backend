package com.example.icare.service.impl;

import com.example.icare.constant.MessageConstant;
import com.example.icare.dto.AccountDTO;
import com.example.icare.dto.LoginDTO;
import com.example.icare.dto.ScheduleDTO;
import com.example.icare.entity.AccountEntity;
import com.example.icare.entity.ScheduleEntity;
import com.example.icare.exception.BusinessRuntimeException;
import com.example.icare.mapper.AccountMapper;
import com.example.icare.mapper.ScheduleMapper;
import com.example.icare.repository.AccountRepository;
import com.example.icare.repository.ScheduleRepository;
import com.example.icare.sco.ScheduleSCO;
import com.example.icare.service.AccountService;
import com.example.icare.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ScheduleServiceImpl implements ScheduleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    ScheduleMapper scheduleMapper;


    @Override
    public List<ScheduleDTO> getAllByAccountId(ScheduleSCO scheduleSCO) {
        Optional<List<ScheduleEntity>> optional = scheduleRepository.findAllByAccountId(scheduleSCO.getAccountId());
        return optional.map(scheduleEntities -> scheduleMapper.toDTOs(scheduleEntities)).orElse(null);
    }

    @Override
    public ScheduleDTO save(ScheduleDTO scheduleDTO) {
        return scheduleMapper.toDTO(scheduleRepository.save(scheduleMapper.toEntity(scheduleDTO)));
    }
}
