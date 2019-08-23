package com.itacademy.jd2.ml.linkedin.web.dto;

import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;

public class CountryDTO {

    private Integer id;
    private String name;
    private IRegion country;

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

    public IRegion getCountry() {
        return country;
    }

    public void setCountry(IRegion country) {
        this.country = country;
    }
}
