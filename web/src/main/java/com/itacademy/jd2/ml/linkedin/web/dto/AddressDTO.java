package com.itacademy.jd2.ml.linkedin.web.dto;

import com.itacademy.jd2.ml.linkedin.entity.table.ICity;

public class AddressDTO {

    private Integer id;
    private String address;
    private ICity city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ICity getCity() {
        return city;
    }

    public void setCity(ICity city) {
        this.city = city;
    }
}
