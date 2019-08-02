package com.itacademy.jd2.ml.linkedin.entity.table;

import java.util.Date;

public interface IUserPortfolio extends IBaseEntity{

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
}
