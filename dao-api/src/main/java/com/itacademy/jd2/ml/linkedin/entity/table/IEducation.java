package com.itacademy.jd2.ml.linkedin.entity.table;

import java.util.Date;
import java.util.Set;

public interface IEducation extends IBaseEntity {

    Set<IUserAccount> getUsers();

    void setUsers(Set<IUserAccount> users);

    String getUniversity();

    void setUniversity(String university);

    Date getStart();

    void setStart(Date start);

    Date getEnd();

    void setEnd(Date end);

    String getSpeciality();

    void setSpeciality(String speciality);

    String getDegree();

    void setDegree(String degree);

    ICity getCity();

    void setCity(ICity city);

    String getAddress();

    void setAddress(String address);
}
