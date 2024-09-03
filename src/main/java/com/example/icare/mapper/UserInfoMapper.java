package com.example.icare.mapper;

import com.example.icare.dto.UserInfoDTO;
import com.example.icare.entity.UserInfoEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserInfoMapper extends GeneralMapper<UserInfoEntity, UserInfoDTO>{

}
