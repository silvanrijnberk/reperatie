package com.TOSAD.Reparatie.Services;

import com.TOSAD.Reparatie.Domain.AttributeCompareRule;
import com.TOSAD.Reparatie.DAO.AttributeCompareRuleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class WebService {

    @Autowired
    AttributeCompareRuleDAO attributeCompareRuleDAO;

//    Save An AttributeCompareRule
    @PostMapping("/attributecomparerule")
    public AttributeCompareRule createAttributeCompareRule(@Valid @RequestBody AttributeCompareRule attributeCompareRule) {
        return attributeCompareRuleDAO.save(attributeCompareRule);
    }

//    Find All AttributeCompareRules
    @GetMapping("/attributecomparerules")
    public List<AttributeCompareRule> getAllAttributeCompareRules() {
        return attributeCompareRuleDAO.findAll();
    }

//    Find AttributeCompareRule By Id
    @GetMapping("/attributecomparerule/{id}")
    public ResponseEntity<AttributeCompareRule> getAttributeCompareRuleById(@PathVariable(value = "id") Long id) {
        AttributeCompareRule attributeCompareRule = attributeCompareRuleDAO.findById(id);

        if (attributeCompareRule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(attributeCompareRule);
    }

//    Delete AttributeCompareRule By Id
    @DeleteMapping("/attributecomparerule/{id}")
    public ResponseEntity<AttributeCompareRule> deleteAttributeCompareRule(@PathVariable(value = "id") Long id) {
        AttributeCompareRule attributeCompareRule = attributeCompareRuleDAO.findById(id);

        if (attributeCompareRule == null) {
            return ResponseEntity.notFound().build();
        }
        attributeCompareRuleDAO.delete(attributeCompareRule);

        return ResponseEntity.ok().body(attributeCompareRule);
    }
    @PutMapping(value = "/attributecomparerule/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttributeCompareRule> updateAttributeCompareRule(@PathVariable(value = "id") Long AttributeCompareRuleId, @Valid @RequestBody AttributeCompareRule AttributeCompareRuleDetails) {
        AttributeCompareRule attributeCompareRule = attributeCompareRuleDAO.findById(AttributeCompareRuleId);

        if (attributeCompareRule == null) {
            return ResponseEntity.notFound().build();
        }

        attributeCompareRule.setBUSINESSRULENAME(AttributeCompareRuleDetails.getBUSINESSRULENAME());
        attributeCompareRule.setCOLUMNVALUE(AttributeCompareRuleDetails.getCOLUMNVALUE());
        attributeCompareRule.setCOMPAREVALUE(AttributeCompareRuleDetails.getCOMPAREVALUE());
        attributeCompareRule.setEXCEPTION(AttributeCompareRuleDetails.getEXCEPTION());
        attributeCompareRule.setOPERATOR(AttributeCompareRuleDetails.getOPERATOR());
        attributeCompareRule.setRULETYPE(AttributeCompareRuleDetails.getRULETYPE());
        attributeCompareRule.setSCRIPTCODE(AttributeCompareRuleDetails.getSCRIPTCODE());
        attributeCompareRule.setTABLEVALUE(AttributeCompareRuleDetails.getTABLEVALUE());

        AttributeCompareRule attributeCompareRuleUpdate = attributeCompareRuleDAO.save(attributeCompareRule);

        return ResponseEntity.ok().body(attributeCompareRuleUpdate);
    }
}
