package com.TOSAD.Reparatie.DAO;

import com.TOSAD.Reparatie.Domain.AttributeCompareRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeCompareRuleDAO {

    @Autowired
    AttributeCompareRuleRepository attributeCompareRuleRepository;

    public AttributeCompareRule save(AttributeCompareRule attributeCompareRule) {
        return attributeCompareRuleRepository.save(attributeCompareRule);
    }

    public List<AttributeCompareRule> findAll() {
        return attributeCompareRuleRepository.findAll();
    }

    public AttributeCompareRule findById(Long id) {
        return attributeCompareRuleRepository.getOne(id);
    }

    public void delete(AttributeCompareRule address) {
        attributeCompareRuleRepository.delete(address);
    }
}
