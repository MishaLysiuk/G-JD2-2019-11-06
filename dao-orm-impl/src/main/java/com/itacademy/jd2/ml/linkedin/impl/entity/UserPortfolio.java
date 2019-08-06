package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserPortfolio implements IUserPortfolio {

    @Id
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY, optional = false, targetEntity = UserAccount.class)
    @PrimaryKeyJoinColumn
    private IUserAccount userAccount;
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
    @Column(updatable = false)
    private Date created;
    @Column
    private Date updated;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public IUserAccount getUserAccount() {
        return userAccount;
    }

    @Override
    public void setUserAccount(IUserAccount userAccount) {
        this.userAccount = userAccount;
    }

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

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }

    @Override
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
