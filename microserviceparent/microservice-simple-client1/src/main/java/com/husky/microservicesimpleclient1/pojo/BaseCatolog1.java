package com.husky.microservicesimpleclient1.pojo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "base_catalog1")
public class BaseCatolog1 implements Serializable {
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BaseCatolog1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
