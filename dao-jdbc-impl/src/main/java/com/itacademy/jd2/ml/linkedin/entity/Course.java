package com.itacademy.jd2.ml.linkedin.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Course extends BaseEntity implements ICourse {

    private Set<IUserPortfolio> users = new HashSet<>();

    private String name;

    private ICompany company;

    private Date start;

    private Date end;

    private Integer finalResult;

    @Override
    public Set<IUserPortfolio> getUsers() {
        return users;
    }

    @Override
    public void setUsers(Set<IUserPortfolio> users) {
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
    public Integer getFinalResult() {
        return finalResult;
    }

    @Override
    public void setFinalResult(Integer finalResult) {
        this.finalResult = finalResult;
    }

    @Override
    public String toString() {
        return "Course{" +
                "users=" + users +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", start=" + start +
                ", end=" + end +
                ", finalResult=" + finalResult +
                '}';
    }
}
