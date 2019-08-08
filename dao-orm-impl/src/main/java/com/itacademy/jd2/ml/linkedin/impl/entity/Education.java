package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IAddress;
import com.itacademy.jd2.ml.linkedin.entity.table.IEducation;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Education extends BaseEntity implements IEducation {

    @JoinTable(name = "education_2_user", joinColumns = {@JoinColumn(name = "education_id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_id")})
    @ManyToMany(targetEntity = UserAccount.class, fetch = FetchType.LAZY)
    private Set<IUserAccount> users = new HashSet<>();
    @Column
    private String university;
    @Column
    private Date start;
    @Column
    private Date end;
    @Column
    private String speciality;
    @Column
    private String degree;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Address.class)
    private IAddress address;

    @Override
    public Set<IUserAccount> getUsers() {
        return users;
    }

    @Override
    public void setUsers(Set<IUserAccount> users) {
        this.users = users;
    }

    @Override
    public String getUniversity() {
        return university;
    }

    @Override
    public void setUniversity(String university) {
        this.university = university;
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
    public String getSpeciality() {
        return speciality;
    }

    @Override
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String getDegree() {
        return degree;
    }

    @Override
    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public IAddress getAddress() {
        return address;
    }

    @Override
    public void setAddress(IAddress address) {
        this.address = address;
    }
}
