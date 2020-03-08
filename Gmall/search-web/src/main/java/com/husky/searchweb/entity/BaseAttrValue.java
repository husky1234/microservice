package com.husky.searchweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "base_attr_value")
public class BaseAttrValue {
    @Id
    private Long id;
    @Column(name = "value_name")
    private String valueName;
    @Column(name = "attr_id")
    private Long attrId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    @Override
    public String toString() {
        return "BaseAttrValue{" +
                "id=" + id +
                ", valueName='" + valueName + '\'' +
                ", attrId=" + attrId +
                '}';
    }
}
