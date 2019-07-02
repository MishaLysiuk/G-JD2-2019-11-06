package com.itacademy.jd2.ml.linkedin.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;

import java.util.Date;

public class Course extends BaseEntity implements ICourse {

    private IUserPortfolio userPortfolio;

    private String name;

    private ICompany company;

    private Date start;

    private Date end;

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

    @Override
    public String toString() {
        return "Course{" +
                "userPortfolio=" + userPortfolio +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", start=" + start +
                ", end=" + end +
                ", finalResult=" + finalResult +
                '}';
    }
}
