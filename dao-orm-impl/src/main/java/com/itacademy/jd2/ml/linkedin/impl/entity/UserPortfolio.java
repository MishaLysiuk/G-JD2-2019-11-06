package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class UserPortfolio extends BaseEntity implements IUserPortfolio {

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Date birthday;
    @Column
    private Integer industryId;
    @Column
    private Integer positionId;
    @Column
    private String contactInfo;
    @Column
    private String motherTongue;

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Date getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String getMotherTongue() {
        return motherTongue;
    }

    @Override
    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }
}
