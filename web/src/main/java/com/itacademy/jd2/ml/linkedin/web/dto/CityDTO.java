package com.itacademy.jd2.ml.linkedin.web.dto;

import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;

public class CityDTO {

    private Integer id;
    private String name;
    private ICountry country;

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

    public ICountry getCountry() {
        return country;
    }

    public void setCountry(ICountry country) {
        this.country = country;
    }
}
