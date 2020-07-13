package com.TOSAD.Reparatie.DAO;

import com.TOSAD.Reparatie.Domain.BusinessRuleColumns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessRuleColumnsDAO {
    
    @Autowired
    BusinessRuleColumnsRepository businessRuleColumnsRepository;

    public List<BusinessRuleColumns> findAll() {
        return businessRuleColumnsRepository.findAll();
    }

    public BusinessRuleColumns findById(Long id) {
        return businessRuleColumnsRepository.getOne(id);
    }

    public BusinessRuleColumns save(BusinessRuleColumns businessRuleColumns) {
        return businessRuleColumnsRepository.save(businessRuleColumns);
    }

    public void delete(BusinessRuleColumns businessRuleColumns) {
        businessRuleColumnsRepository.delete(businessRuleColumns);
    }
}
