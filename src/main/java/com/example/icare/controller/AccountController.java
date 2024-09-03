package com.example.icare.controller;

import com.example.icare.dto.AccountDTO;
import com.example.icare.dto.LoginDTO;
import com.example.icare.dto.api.ResponseDTO;
import com.example.icare.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
    @RequestMapping("/account")
public class AccountController {
    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseDTO<AccountDTO> login(@RequestBody LoginDTO loginDTO) {
        logger.info("Start login with {}", loginDTO);
        ResponseDTO<AccountDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setData(accountService.login(loginDTO));
        logger.info("End login");
        return responseDTO;
    }

    @PostMapping("/registry")
    public ResponseDTO<AccountDTO> registry(@RequestBody AccountDTO accountDTO) {
        logger.info("Start registry {}", accountDTO);
        ResponseDTO<AccountDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setData(accountService.registry(accountDTO));
        logger.info("End registry");
        return responseDTO;
    }
}
