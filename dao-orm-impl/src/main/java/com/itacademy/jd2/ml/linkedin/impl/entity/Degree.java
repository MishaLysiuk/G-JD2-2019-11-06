package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IDegree;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Degree extends BaseEntity implements IDegree {

    @Column
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
