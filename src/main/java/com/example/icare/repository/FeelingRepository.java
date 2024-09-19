package com.example.icare.repository;

import com.example.icare.entity.FeelingEntity;
import com.example.icare.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeelingRepository extends JpaRepository<FeelingEntity, Integer>{

    Optional<List<FeelingEntity>> findAllByAccountId(Integer accountId);
}
