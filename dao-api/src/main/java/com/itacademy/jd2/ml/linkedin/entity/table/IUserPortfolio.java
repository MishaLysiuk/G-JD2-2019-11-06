package com.itacademy.jd2.ml.linkedin.entity.table;

import java.util.Date;

public interface IUserPortfolio extends IBaseEntity{

    String getFirstName();

    void setFirstName(String name);

    Date getCreated();

    void setCreated(Date created);

    Date getUpdated();

    void setUpdated(Date updated);

    String toString();
}
