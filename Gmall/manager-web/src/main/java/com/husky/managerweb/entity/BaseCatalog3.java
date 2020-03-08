package com.husky.managerweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "base_catalog3")
public class BaseCatalog3 {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "catalog2_id")
    private Long catalog2Id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCatalog2Id() {
        return catalog2Id;
    }

    public void setCatalog2Id(Long catalog2Id) {
        this.catalog2Id = catalog2Id;
    }

    @Override
    public String toString() {
        return "BaseCatalog3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catalog1Id=" + catalog2Id +
                '}';
    }
}
