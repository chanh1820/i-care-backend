package com.example.icare.service.impl;

import com.example.icare.constant.MessageConstant;
import com.example.icare.constant.MessageEnum;
import com.example.icare.dto.AccountDTO;
import com.example.icare.dto.LoginDTO;
import com.example.icare.entity.AccountEntity;
import com.example.icare.exception.BusinessRuntimeException;
import com.example.icare.mapper.AccountMapper;
import com.example.icare.repository.AccountRepository;
import com.example.icare.service.AccountService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;


    @Override
    @Transactional
    public AccountDTO login(LoginDTO loginDTO) {
        List<AccountEntity> accountEntities = accountRepository.findByUsername(loginDTO.getUsername());
        if(CollectionUtils.isEmpty(accountEntities)){
            throw new BusinessRuntimeException(MessageEnum.ERR_ACCOUNT_NOT_FOUND);
        }

        AccountDTO accountDTO = accountMapper.toDTO(accountEntities.get(0));
        if(!accountDTO.getPassword().equals(loginDTO.getPassword())){
            throw new BusinessRuntimeException(MessageEnum.ERR_PASS_WORD_NOT_MACTH);
        }
        return accountDTO;
    }

    @Override
    public AccountDTO registry(AccountDTO accountDTO) {
        List<AccountEntity> accountEntities = accountRepository.findByUsername(accountDTO.getUsername());

        if(CollectionUtils.isNotEmpty(accountEntities)){
            throw new BusinessRuntimeException(MessageEnum.ERR_ACCOUNT_EXISTING);
        }
        accountRepository.save(accountMapper.toEntity(accountDTO));
        AccountEntity result = accountRepository.save(accountMapper.toEntity(accountDTO));
        return accountMapper.toDTO(result);
    }

}
