package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;

import javax.persistence.*;

@Entity
public class Country extends BaseEntity implements ICountry {

    @Column
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Region.class)
    private IRegion region;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
