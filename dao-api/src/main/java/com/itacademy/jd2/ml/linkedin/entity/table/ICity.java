package com.itacademy.jd2.ml.linkedin.entity.table;

public interface ICity extends IBaseEntity {
    Integer getNameId();

    void setNameId(Integer nameId);

    ICountry getCountry();

    void setCountry(ICountry country);
}
