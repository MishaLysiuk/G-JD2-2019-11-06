package com.itacademy.jd2.ml.linkedin.entity.table;

import java.util.Date;
import java.util.Set;

public interface IWorkExperience extends IBaseEntity {

    Set<IUserAccount> getUsers();

    void setUsers(Set<IUserAccount> users);

    String getJobTitle();

    void setJobTitle(String jobTitle);

    Date getStart();

    void setStart(Date start);

    Date getEnd();

    void setEnd(Date end);

    IAddress getAddress();

    void setAddress(IAddress address);

    ICompany getCompany();

    void setCompany(ICompany company);
}
