package com.itacademy.jd2.ml.linkedin.entity.table;

import java.util.Date;
import java.util.Set;

public interface ICourse extends IBaseEntity {

    Set<IUserAccount> getUsers();

    void setUsers(Set<IUserAccount> users);

    String getName();

    void setName(String name);

    ICompany getCompany();

    void setCompany(ICompany company);

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    Integer getFinalResult();

    void setFinalResult(Integer finalResult);
}
