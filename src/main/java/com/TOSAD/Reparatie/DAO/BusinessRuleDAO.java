package com.TOSAD.Reparatie.DAO;

import com.TOSAD.Reparatie.Domain.BusinessRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessRuleDAO {

    @Autowired
    BusinessRuleRepository businessRuleRepository;

    public List<BusinessRule> findAll() {
        return businessRuleRepository.findAll();
    }

    public BusinessRule findById(Long id) {
        return businessRuleRepository.getOne(id);
    }

    public BusinessRule save(BusinessRule businessRule) {
        return businessRuleRepository.save(businessRule);
    }

    public void delete(BusinessRule businessRule) {
        businessRuleRepository.delete(businessRule);
    }
}
