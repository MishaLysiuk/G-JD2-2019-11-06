package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.entity.table.IWorkExperience;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class WorkExperience extends BaseEntity implements IWorkExperience {

    @JoinTable(name = "experience_2_user", joinColumns = {@JoinColumn(name = "experience_id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_id")})
    @ManyToMany(targetEntity = UserAccount.class, fetch = FetchType.LAZY)
    private Set<IUserAccount> users = new HashSet<>();
    @Column
    private String jobTitle;
    @Column
    private Date start;
    @Column
    private Date end;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class)
    private ICity city;
    @Column
    private String address;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Company.class)
    private ICompany company;

    @Override
    public Set<IUserAccount> getUsers() {
        return users;
    }

    @Override
    public void setUsers(Set<IUserAccount> users) {
        this.users = users;
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
    public ICompany getCompany() {
        return company;
    }

    @Override
    public void setCompany(ICompany company) {
        this.company = company;
    }
}
