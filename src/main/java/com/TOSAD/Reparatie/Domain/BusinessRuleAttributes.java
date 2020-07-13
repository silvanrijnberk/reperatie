package com.TOSAD.Reparatie.Domain;

import javax.persistence.*;

@Entity
@Table(name = "businessRuleAttributes")
public class BusinessRuleAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "attributes")
    private String attributes;

    @Column(name = "businessRuleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "businessRule_id", nullable = false, foreignKey = @ForeignKey(name = "businessRuleAttribute_businessRule_ibfk"))
    private BusinessRule businessRule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public BusinessRule getBusinessRule() {
        return businessRule;
    }

    public void setBusinessRule(BusinessRule businessRule) {
        this.businessRule = businessRule;
    }
}
