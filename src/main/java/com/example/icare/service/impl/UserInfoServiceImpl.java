package com.example.icare.service.impl;

import com.example.icare.dto.UserInfoDTO;
import com.example.icare.entity.UserInfoEntity;
import com.example.icare.mapper.UserInfoMapper;
import com.example.icare.repository.UserInfoRepository;
import com.example.icare.sco.UserInfoSCO;
import com.example.icare.service.UserInfoService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    UserInfoMapper userInfoMapper;


    @Override
    public UserInfoDTO getUserInfoByAccountId(UserInfoSCO userInfoSCO) {
        List<UserInfoEntity> userInfoEntities = userInfoRepository.findByAccountId(userInfoSCO.getAccountId());
        if(CollectionUtils.isNotEmpty(userInfoEntities)){
            return userInfoMapper.toDTO(userInfoEntities.get(userInfoEntities.size()-1));
        }
        return null;
    }

    @Override
    public UserInfoDTO save(UserInfoDTO userInfoDTO) {
        return userInfoMapper.toDTO(userInfoRepository.save(userInfoMapper.toEntity(userInfoDTO)));
    }
}
