package com.example.icare.repository;

import com.example.icare.entity.AccountEntity;
import com.example.icare.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer>{

    List<UserInfoEntity> findByAccountId(int accountId);

}
