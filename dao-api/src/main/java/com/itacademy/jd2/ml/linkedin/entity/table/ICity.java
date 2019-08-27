package com.itacademy.jd2.ml.linkedin.entity.table;

public interface ICity extends IBaseEntity {

    String getName();

    void setName(String name);

    ICountry getCountry();

    void setCountry(ICountry country);
}
