package com.example.icare.mapper;

import com.example.icare.dto.FeelingDTO;
import com.example.icare.dto.ScheduleDTO;
import com.example.icare.entity.FeelingEntity;
import com.example.icare.entity.ScheduleEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface FeelingMapper extends GeneralMapper<FeelingEntity, FeelingDTO>{

}
