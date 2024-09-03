package com.example.icare.mapper;

import com.example.icare.dto.ScheduleDTO;
import com.example.icare.entity.ScheduleEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ScheduleMapper extends GeneralMapper<ScheduleEntity, ScheduleDTO>{

}
