package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IAddress;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.entity.table.IWorkExperience;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

@Entity
public class WorkExperience extends BaseEntity implements IWorkExperience {

    @Transient
    private IUserAccount user;
    @Column
    private Integer industryId;
    @Column
    private Integer positionId;
    @Column
    private Date start;
    @Column
    private Date end;
    @Transient
    private IAddress address;
    @Transient
    private ICompany company;

    @Override
    public IUserAccount getUser() {
        return user;
    }

    @Override
    public void setUser(IUserAccount user) {
        this.user = user;
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
    public Date getStart() {
        return start;
    }

    @Override
    public void setStart(Date start) {
        this.start = start;
    }

    @Override
    public Date getEnd() {
        return end;
    }

    @Override
    public void setEnd(Date end) {
        this.end = end;
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
    public ICompany getCompany() {
        return company;
    }

    @Override
    public void setCompany(ICompany company) {
        this.company = company;
    }
}
