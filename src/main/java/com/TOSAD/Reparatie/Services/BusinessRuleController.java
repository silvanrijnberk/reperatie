package com.TOSAD.Reparatie.Services;

import com.TOSAD.Reparatie.DAO.BusinessRuleDAO;
import com.TOSAD.Reparatie.Domain.BusinessRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/busenessRules")
public class BusinessRuleController {

    @Autowired
    BusinessRuleDAO businessRuleDAO;

//    get all business rules
    @GetMapping("")
    public List<BusinessRule> findAll() {
        return businessRuleDAO.findAll();
    }

//    get one business rule by id
    @GetMapping("/{id}")
    public BusinessRule findById(@PathVariable(name = "id") Long businessRuleId) {
        return businessRuleDAO.findById(businessRuleId);
    }

}
