package com.example.icare.repository;

import com.example.icare.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer>{

    List<AccountEntity> findByUsername(String userName);

}
