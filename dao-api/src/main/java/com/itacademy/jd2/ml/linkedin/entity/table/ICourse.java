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

    Date getStart();

    void setStart(Date start);

    Date getEnd();

    void setEnd(Date end);

    Integer getFinalResult();

    void setFinalResult(Integer finalResult);
}
