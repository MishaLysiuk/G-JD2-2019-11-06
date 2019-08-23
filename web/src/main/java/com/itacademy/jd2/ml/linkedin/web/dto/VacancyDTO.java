package com.itacademy.jd2.ml.linkedin.web.dto;

import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;


public class VacancyDTO {

    private Integer id;
    private IUserAccount creator;
    private String jobTitle;
    private ICompany company;
    private String companyName;
    private ICity city;
    private String address;
    private String contactInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IUserAccount getCreator() {
        return creator;
    }

    public void setCreator(IUserAccount creator) {
        this.creator = creator;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public ICompany getCompany() {
        return company;
    }

    public void setCompany(ICompany company) {
        this.company = company;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public ICity getCity() {
        return city;
    }

    public void setCity(ICity city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
