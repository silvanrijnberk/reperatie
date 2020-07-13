package com.TOSAD.Reparatie.Domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "businessRuleTable")
@EntityListeners(AuditingEntityListener.class)
public class BusinessRuleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Tables")
    private String table;

    @Column(name = "businessRuleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "businessRule_id", nullable = false, foreignKey = @ForeignKey(name = "businessRuleTable_businessRule_ibfk"))
    private BusinessRule businessRule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public BusinessRule getBusinessRule() {
        return businessRule;
    }

    public void setBusinessRule(BusinessRule businessRule) {
        this.businessRule = businessRule;
    }
}
