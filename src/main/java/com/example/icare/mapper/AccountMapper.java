package com.example.icare.mapper;

import com.example.icare.dto.AccountDTO;
import com.example.icare.entity.AccountEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AccountMapper extends GeneralMapper<AccountEntity, AccountDTO>{

}
