package com.itacademy.jd2.ml.linkedin.entity.table;

public interface IVacancy extends IBaseEntity {

    IUserAccount getCreator();

    void setCreator(IUserAccount creator);

    String getJobTitle();

    void setJobTitle(String jobTitle);

    ICompany getCompany();

    void setCompany(ICompany company);

    ICity getCity();

    void setCity(ICity city);

    String getAddress();

    void setAddress(String address);

    String getContactInfo();

    void setContactInfo(String contactInfo);
}
