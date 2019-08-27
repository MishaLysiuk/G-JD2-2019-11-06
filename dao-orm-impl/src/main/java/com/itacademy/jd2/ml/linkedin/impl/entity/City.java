package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class City extends BaseEntity implements ICity {

    @Column
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
    private ICountry country;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ICountry getCountry() {
        return country;
    }

    @Override
    public void setCountry(ICountry country) {
        this.country = country;
    }
}
