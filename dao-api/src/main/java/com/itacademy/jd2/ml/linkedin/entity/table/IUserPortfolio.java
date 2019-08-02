package com.itacademy.jd2.ml.linkedin.entity.table;

import java.util.Date;

public interface IUserPortfolio{

    Integer getId();

    void setId(Integer id);

    String getFirstName();

    void setFirstName(String name);

    String getLastName();

    void setLastName(String lastName);

    Date getBirthday();

    void setBirthday(Date birthday);

    Integer getIndustryId();

    void setIndustryId(Integer industryId);

    Integer getPositionId();

    void setPositionId(Integer positionId);

    String getContactInfo();

    void setContactInfo(String contactInfo);

    String getMotherTongue();

    void setMotherTongue(String motherTongue);

    Date getCreated();

    void setCreated(Date created);

    Date getUpdated();

    void setUpdated(Date updated);
}
