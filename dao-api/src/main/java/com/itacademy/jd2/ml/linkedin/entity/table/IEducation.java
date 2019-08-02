package com.itacademy.jd2.ml.linkedin.entity.table;

import java.util.Date;

public interface IEducation extends IBaseEntity {


    IUserAccount getUser();

    void setUser(IUserAccount user);

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

    IAddress getAddress();

    void setAddress(IAddress address);
}
