package com.itacademy.jd2.ml.linkedin.entity.table;

public interface ICountry extends IBaseEntity {
    Integer getNameId();

    void setNameId(Integer nameId);

    IRegion getRegion();

    void setRegion(IRegion region);
}
