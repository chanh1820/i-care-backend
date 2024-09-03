package com.example.icare.repository;

import com.example.icare.entity.ScheduleEntity;
import com.example.icare.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer>{

    Optional<List<ScheduleEntity>> findAllByAccountId(Integer accountId);
}
