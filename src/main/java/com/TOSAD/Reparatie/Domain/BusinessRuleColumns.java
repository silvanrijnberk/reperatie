package com.TOSAD.Reparatie.Domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "businessRuleColumns")
@EntityListeners(AuditingEntityListener.class)
public class BusinessRuleColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "columns")
    private String columns;

    @Column(name = "businessRuleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "businessRule_id", nullable = false, foreignKey = @ForeignKey(name = "businessRuleColumns_businessRule_ibfk"))
    private BusinessRule businessRule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public BusinessRule getBusinessRule() {
        return businessRule;
    }

    public void setBusinessRule(BusinessRule businessRule) {
        this.businessRule = businessRule;
    }
}
