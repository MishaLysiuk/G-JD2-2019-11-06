package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IAddress;
import com.itacademy.jd2.ml.linkedin.entity.table.ICity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Address extends BaseEntity implements IAddress {

    @Column
    private String address;
    @Transient
    private ICity city;

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public ICity getCity() {
        return city;
    }

    @Override
    public void setCity(ICity city) {
        this.city = city;
    }
}
