package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Region extends BaseEntity implements IRegion {

    @Column
    private Integer nameId;

    @Override
    public Integer getNameId() {
        return nameId;
    }

    @Override
    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }
}
