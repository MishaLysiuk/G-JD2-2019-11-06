package com.itacademy.jd2.ml.linkedin.entity.table;

import java.util.Date;
import java.util.Set;

public interface IWorkExperience extends IBaseEntity {

    Set<IUserAccount> getUsers();

    void setUsers(Set<IUserAccount> users);

    String getJobTitle();

    void setJobTitle(String jobTitle);

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    ICity getCity();

    void setCity(ICity city);

    String getAddress();

    void setAddress(String address);

    ICompany getCompany();

    void setCompany(ICompany company);
}
