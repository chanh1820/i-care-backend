package com.example.icare.controller;

import com.example.icare.dto.UserInfoDTO;
import com.example.icare.dto.api.ResponseDTO;
import com.example.icare.mapper.UserInfoMapper;
import com.example.icare.sco.UserInfoSCO;
import com.example.icare.service.UserInfoService;
import com.example.icare.util.ObjectMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    private Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @PostMapping("/get")
    public ResponseDTO<UserInfoDTO> getUserInfoByAccountId(@RequestBody UserInfoSCO userInfoSCO) {
        logger.info("Start getUserInfoByAccountId with {}", userInfoSCO);
        ResponseDTO<UserInfoDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setData(userInfoService.getUserInfoByAccountId(userInfoSCO));
        logger.info("End getUserInfoByAccountId");
        return responseDTO;
    }

    @PostMapping("/save")
    public ResponseDTO<UserInfoDTO> saveUserInfo(@RequestBody UserInfoDTO userInfoDTO) {
        logger.info("Start saveUserInfo {}", ObjectMapperUtil.writeValueAsString(userInfoMapper.toEntity(userInfoDTO)));
        ResponseDTO<UserInfoDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setData(userInfoService.save(userInfoDTO));
        logger.info("End saveUserInfo");
        return responseDTO;
    }
}
