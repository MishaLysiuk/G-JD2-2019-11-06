package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.*;

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
    private Date startDate;
    @Column
    private Date endDate;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Speciality.class)
    private ISpeciality speciality;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Degree.class)
    private IDegree degree;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class)
    private ICity city;
    @Column
    private String address;

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
    public ISpeciality getSpeciality() {
        return speciality;
    }

    @Override
    public void setSpeciality(ISpeciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public IDegree getDegree() {
        return degree;
    }

    @Override
    public void setDegree(IDegree degree) {
        this.degree = degree;
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
}
