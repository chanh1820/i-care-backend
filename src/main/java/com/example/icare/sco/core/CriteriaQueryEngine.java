package com.example.icare.sco.core;

import com.example.icare.constant.DBConstant;
import com.example.icare.sco.BaseSCO;
import com.example.icare.sco.dto.SearchNumberDTO;
import com.example.icare.sco.dto.SearchTextDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriteriaQueryEngine{

    private CriteriaBuilder builder;

    private List<Predicate> predicates;

    private Root root;

    public CriteriaQueryEngine appendSearchText(SearchTextDTO condition, String fieldName) {
        if(ObjectUtils.isEmpty(condition)){
            return this;
        }
        if(StringUtils.isNoneEmpty((condition.getLike()))){
            predicates.add(builder.like(root.get(fieldName), "%" + condition.getLike() + "%"));
        }
        if(StringUtils.isNoneEmpty((condition.getEqual()))){
            predicates.add(builder.equal(root.get(fieldName), condition.getEqual()));
        }
        if(CollectionUtils.isNotEmpty(condition.getIn())){
            predicates.add(root.get(fieldName).in(condition.getIn()));
        }
        return this;
    }

    public CriteriaQueryEngine appendJoinedSearchText(SearchTextDTO condition, String fieldName, Join joined) {
        if(ObjectUtils.isEmpty(condition)){
            return this;
        }
        if(StringUtils.isNoneEmpty((condition.getLike()))){
            predicates.add(builder.like(joined.get(fieldName), "%" + condition.getLike() + "%"));
        }
        if(StringUtils.isNoneEmpty((condition.getEqual()))){
            predicates.add(builder.equal(joined.get(fieldName), condition.getEqual()));
        }
        if(CollectionUtils.isNotEmpty(condition.getIn())){
            predicates.add(joined.get(fieldName).in(condition.getIn()));
        }
        return this;
    }


    public CriteriaQueryEngine appendDeleteFlag(Boolean deleteFlag) {
        if(ObjectUtils.isEmpty(deleteFlag)){
            predicates.add(builder.equal(root.get("deleteFlag"), true));
        }else {
            predicates.add(builder.equal(root.get("deleteFlag"), deleteFlag));
        }
        return this;
    }




//    public CriteriaQueryEngine appendSearchNumber(SearchNumberDTO condition, String fieldName,int numberType, Class<Integer> clas) {
//        if(ObjectUtils.isEmpty(condition)){
//            return this;
//        }
//        Object convertedValue = convertToObject(condition.getEqual(), numberType);
//
//        if(ObjectUtils.isNotEmpty(condition.getEqual())){
//            predicates.add(builder.greaterThanOrEqualTo(root.get(fieldName), convertToObject(condition.getEqual(), numberType)));
//        }
//        if(ObjectUtils.isNotEmpty((condition.getEqual()))){
//            predicates.add(builder.equal(root.get(fieldName), condition.getEqual()));
//        }
//        if(ObjectUtils.isNotEmpty(condition.getIn())){
//            predicates.add(root.get(fieldName).in(condition.getIn()));
//        }
//        return this;
//    }

//    protected <T> T convertToObject(final Number value, int numberType) {
//        Object result = null;
//        if (value != null) {
//            switch (numberType) {
//                case DBConstant.INTEGER_TYPE:
//                    result = (T) Integer.valueOf(value.intValue());
//                    break;
//                case DBConstant.LONG_TYPE:
//                    result = (T) Long.valueOf(value.longValue());
//                    break;
//                case DBConstant.BIGDECIMAL_TYPE:
//                    result = (T) BigDecimal.valueOf(value.doubleValue());
//                    break;
//                default:
//                    result = (T) value;
//            }
//        }
//        return result;
//    }
}
