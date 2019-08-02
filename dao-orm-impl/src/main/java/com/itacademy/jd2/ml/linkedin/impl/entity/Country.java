package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Country extends BaseEntity implements ICountry {

    @Column
    private Integer nameId;
    @Transient
    private IRegion region;

    @Override
    public Integer getNameId() {
        return nameId;
    }

    @Override
    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    @Override
    public IRegion getRegion() {
        return region;
    }

    @Override
    public void setRegion(IRegion region) {
        this.region = region;
    }
}
