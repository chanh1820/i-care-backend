package com.example.icare.service;

import com.example.icare.dto.AccountDTO;
import com.example.icare.dto.LoginDTO;
import com.example.icare.dto.UserInfoDTO;
import com.example.icare.sco.UserInfoSCO;

public interface UserInfoService {

    public UserInfoDTO getUserInfoByAccountId(UserInfoSCO userInfoSCO);

    public UserInfoDTO save(UserInfoDTO userInfoDTO);


}
