package com.itacademy.jd2.ml.linkedin.entity.table;

import java.util.Date;

public interface ICompany extends IBaseEntity {

    void setName(String name);

    String getName();

    Date getCreated();

    void setCreated(Date created);

    Date getUpdated();

    void setUpdated(Date updated);

    String toString();
}
