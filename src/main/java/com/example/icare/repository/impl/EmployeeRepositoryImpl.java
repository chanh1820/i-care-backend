//package com.example.icare.repository.impl;
//
//import com.example.icare.entity.old.EmployeeEntity;
//import com.example.icare.entity.old.JobEntity;
//import com.example.icare.repository.EmployeeRepositoryCustom;
//import com.example.icare.sco.EmployeeSCO;
//import com.example.icare.sco.core.CriteriaQueryEngine;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Join;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//@Transactional
//public class EmployeeRepositoryImpl extends BaseRepositoryImpl<EmployeeEntity, Long> implements EmployeeRepositoryCustom {
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    @Transactional
//    public List<EmployeeEntity> searchEmployee(EmployeeSCO employeeSCO) {
//        TypedQuery<EmployeeEntity> typedQuery = createCriteriaQuery(employeeSCO);
//        List<EmployeeEntity>  result = (List<EmployeeEntity>) findByCriteria(typedQuery, employeeSCO);
//        return result;
//    }
//
//    private TypedQuery<EmployeeEntity> createCriteriaQuery(EmployeeSCO employeeSCO) {
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<EmployeeEntity> query = builder.createQuery(EmployeeEntity.class);
//        Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
//        List<Predicate> predicates = new ArrayList<>();
//
//        Join<EmployeeEntity, JobEntity> jobJoin = root.join("jobEntity");
//
//        CriteriaQueryEngine criteriaQueryEngine
//                = new CriteriaQueryEngine(builder, predicates, root)
//                            .appendSearchText(employeeSCO.getEmail(), "email")
//                            .appendSearchText(employeeSCO.getFirstName(), "firstName")
//                            .appendJoinedSearchText(employeeSCO.getJobName(), "jobName", jobJoin)
//                            .appendDeleteFlag(employeeSCO.getDeleteFlag());
//
//        predicates = criteriaQueryEngine.getPredicates();
//        query.where(predicates.toArray(new Predicate[0]));
//
//        return em.createQuery(query);
//    }
//}
