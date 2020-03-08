package com.husky.searchweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "base_attr_info")
public class BaseAttrInfo implements Serializable {
    @Id
    private Long id;
    @Column(name = "attr_name")
    private String attrName;
    @Column(name = "catalog3_id")
    private Long catalog3Id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Long getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(Long catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    @Override
    public String toString() {
        return "BaseAttrInfo{" +
                "id=" + id +
                ", attrName='" + attrName + '\'' +
                ", catalog3Id=" + catalog3Id +
                '}';
    }
}
