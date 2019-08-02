package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

@Entity
public class Course extends BaseEntity implements ICourse {

    @Transient
    private IUserPortfolio userPortfolio;
    @Column
    private String name;
    @Transient
    private ICompany company;
    @Column
    private Date start;
    @Column
    private Date end;
    @Column
    private Integer finalResult;

    @Override
    public IUserPortfolio getUserPortfolio() {
        return userPortfolio;
    }

    @Override
    public void setUserPortfolio(IUserPortfolio userPortfolio) {
        this.userPortfolio = userPortfolio;
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
}
