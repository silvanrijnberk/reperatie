package com.TOSAD.Reparatie.DAO;

import com.TOSAD.Reparatie.Domain.BusinessRuleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessRuleTableDAO {

    @Autowired
    BusinessRuleTableRepository businessRuleTableRepository;

    public List<BusinessRuleTable> findAll() {
        return businessRuleTableRepository.findAll();
    }

    public BusinessRuleTable findById(Long id) {
        return businessRuleTableRepository.getOne(id);
    }

    public BusinessRuleTable save(BusinessRuleTable businessRuleTable) {
        return businessRuleTableRepository.save(businessRuleTable);
    }

    public void delete(BusinessRuleTable businessRuleTable) {
        businessRuleTableRepository.delete(businessRuleTable);
    }
}
