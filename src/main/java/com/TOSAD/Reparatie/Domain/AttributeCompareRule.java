package com.TOSAD.Reparatie.Domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "attributecomparerule")
@EntityListeners({AuditingEntityListener.class})
public class AttributeCompareRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long RULEID;

    private String SCRIPTCODE;

    private String BUSINESSRULENAME;

    private String RULETYPE;

    private String COMPAREVALUE;

    private String OPERATOR;

    private String COLUMNVALUE;

    private String TABLEVALUE;

    private String EXCEPTION;

    public Long getRULEID() {
        return RULEID;
    }

    public String getSCRIPTCODE() {
        return SCRIPTCODE;
    }

    public void setSCRIPTCODE(String SCRIPTCODE) {
        this.SCRIPTCODE = SCRIPTCODE;
    }

    public String getBUSINESSRULENAME() {
        return BUSINESSRULENAME;
    }

    public void setBUSINESSRULENAME(String BUSINESSRULENAME) {
        this.BUSINESSRULENAME = BUSINESSRULENAME;
    }

    public String getRULETYPE() {
        return RULETYPE;
    }

    public void setRULETYPE(String RULETYPE) {
        this.RULETYPE = RULETYPE;
    }

    public String getCOMPAREVALUE() {
        return COMPAREVALUE;
    }

    public void setCOMPAREVALUE(String COMPAREVALUE) {
        this.COMPAREVALUE = COMPAREVALUE;
    }

    public String getOPERATOR() {
        return OPERATOR;
    }

    public void setOPERATOR(String OPERATOR) {
        this.OPERATOR = OPERATOR;
    }

    public String getCOLUMNVALUE() {
        return COLUMNVALUE;
    }

    public void setCOLUMNVALUE(String COLUMNVALUE) {
        this.COLUMNVALUE = COLUMNVALUE;
    }

    public String getTABLEVALUE() {
        return TABLEVALUE;
    }

    public void setTABLEVALUE(String TABLEVALUE) {
        this.TABLEVALUE = TABLEVALUE;
    }

    public String getEXCEPTION() {
        return EXCEPTION;
    }

    public void setEXCEPTION(String EXCEPTION) {
        this.EXCEPTION = EXCEPTION;
    }
}