package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Vacancy extends BaseEntity implements IVacancy {

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
    private IUserAccount creator;
    @Column
    private String jobTitle;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Company.class)
    private ICompany company;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class)
    private ICity city;
    @Column
    private String address;
    @Column
    private String description;
    @Column
    private String contactInfo;

    @Override
    public IUserAccount getCreator() {
        return creator;
    }

    @Override
    public void setCreator(IUserAccount creator) {
        this.creator = creator;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public ICompany getCompany() {
        return company;
    }

    @Override
    public void setCompany(ICompany company) {
        this.company = company;
    }

    @Override
    public ICity getCity() {
        return city;
    }

    @Override
    public void setCity(ICity city) {
        this.city = city;
    }


    @Override
    public String getAddress() {
        return address;
    }


    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
