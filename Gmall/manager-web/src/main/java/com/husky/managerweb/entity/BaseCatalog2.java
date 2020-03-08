package com.husky.managerweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "base_catalog2")
public class BaseCatalog2 {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "catalog1_id")
    private Long catalog1Id;

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

    public Long getCatalog1Id() {
        return catalog1Id;
    }

    public void setCatalog1Id(Long catalog1Id) {
        this.catalog1Id = catalog1Id;
    }

    @Override
    public String toString() {
        return "BaseCatalog2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catalog1Id=" + catalog1Id +
                '}';
    }
}
