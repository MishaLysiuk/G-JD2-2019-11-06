package com.itacademy.jd2.ml.linkedin.entity.table;

import java.util.Date;

public interface IWorkExperience extends IBaseEntity {
    void setUserPortfolio(IUserPortfolio userPortfolio);

    Integer getIndustryId();

    void setIndustryId(Integer industryId);

    Integer getPositionId();

    void setPositionId(Integer positionId);

    Date getStart();

    void setStart(Date start);

    Date getEnd();

    void setEnd(Date end);

    IAddress getAddress();

    void setAddress(IAddress address);

    ICompany getCompany();

    void setCompany(ICompany company);
}
