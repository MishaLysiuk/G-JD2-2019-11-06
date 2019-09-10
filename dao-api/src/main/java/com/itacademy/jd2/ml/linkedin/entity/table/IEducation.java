package com.itacademy.jd2.ml.linkedin.entity.table;

import java.util.Date;
import java.util.Set;

public interface IEducation extends IBaseEntity {

    Set<IUserAccount> getUsers();

    void setUsers(Set<IUserAccount> users);

    String getUniversity();

    void setUniversity(String university);

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    ISpeciality getSpeciality();

    void setSpeciality(ISpeciality speciality);

    IDegree getDegree();

    void setDegree(IDegree degree);

    ICity getCity();

    void setCity(ICity city);

    String getAddress();

    void setAddress(String address);
}
