package com.itacademy.jd2.ml.linkedin.entity.table;

public interface IAddress extends IBaseEntity {
    String getAddress();

    void setAddress(String address);

    ICity getCity();

    void setCity(ICity city);
}
