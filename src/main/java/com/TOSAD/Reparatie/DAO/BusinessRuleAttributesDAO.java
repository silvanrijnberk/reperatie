package com.TOSAD.Reparatie.DAO;

import com.TOSAD.Reparatie.Domain.BusinessRuleAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessRuleAttributesDAO {

    @Autowired
    BusinessRuleAttributesRepository businessRuleAttributesRepository;

    public List<BusinessRuleAttributes> findAll() {
        return businessRuleAttributesRepository.findAll();
    }

    public BusinessRuleAttributes findById(Long id) {
        return businessRuleAttributesRepository.getOne(id);
    }

    public BusinessRuleAttributes save(BusinessRuleAttributes businessRuleAttributes) {
        return businessRuleAttributesRepository.save(businessRuleAttributes);
    }

    public void delete(BusinessRuleAttributes businessRuleAttributes) {
        businessRuleAttributesRepository.delete(businessRuleAttributes);
    }
}
