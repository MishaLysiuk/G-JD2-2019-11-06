package com.itacademy.jd2.ml.linkedin.entity.table;

public interface IVacancy extends IBaseEntity {
    IUserPortfolio getCreator();

    void setCreator(IUserPortfolio creator);

    Boolean getActive();

    void setActive(Boolean active);

    Integer getIndustryId();

    void setIndustryId(Integer industryId);

    Integer getPositionId();

    void setPositionId(Integer positionId);

    ICompany getCompany();

    void setCompany(ICompany company);

    IAddress getAddress();

    void setAddress(IAddress address);

    String getContactInfo();

    void setContactInfo(String contactInfo);
}
