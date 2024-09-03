package com.example.icare.service;

import com.example.icare.dto.AccountDTO;
import com.example.icare.dto.LoginDTO;

public interface AccountService {

    public AccountDTO login(LoginDTO loginDTO);
    public AccountDTO registry(AccountDTO accountDTO);


}
