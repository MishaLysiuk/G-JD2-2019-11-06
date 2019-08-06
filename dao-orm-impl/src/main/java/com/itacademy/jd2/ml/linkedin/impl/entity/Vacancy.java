package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IAddress;
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
    private Boolean active;
    @Column
    private Integer industryId;
    @Column
    private Integer positionId;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Company.class)
    private ICompany company;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Address.class)
    private IAddress address;
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
    public Boolean getActive() {
        return active;
    }

    @Override
    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public Integer getIndustryId() {
        return industryId;
    }

    @Override
    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    @Override
    public Integer getPositionId() {
        return positionId;
    }

    @Override
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
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
    public IAddress getAddress() {
        return address;
    }

    @Override
    public void setAddress(IAddress address) {
        this.address = address;
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
