package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Course extends BaseEntity implements ICourse {

    @JoinTable(name = "course_2_user", joinColumns = {@JoinColumn(name = "course_id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_id")})
    @ManyToMany(targetEntity = UserAccount.class, fetch = FetchType.LAZY)
    private Set<IUserAccount> users = new HashSet<>();
    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Company.class)
    private ICompany company;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private Integer finalResult;

    @Override
    public Set<IUserAccount> getUsers() {
        return users;
    }

    @Override
    public void setUsers(Set<IUserAccount> users) {
        this.users = users;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public Integer getFinalResult() {
        return finalResult;
    }

    @Override
    public void setFinalResult(Integer finalResult) {
        this.finalResult = finalResult;
    }
}
