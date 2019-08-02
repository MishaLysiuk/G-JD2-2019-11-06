package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroup;
import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Skill extends BaseEntity implements ISkill {

    @Column
    private String name;

    @Transient
    private IUserPortfolio userPortfolio;

    @Transient
    private IGroup group;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public IUserPortfolio getUserPortfolio() {
        return userPortfolio;
    }

    @Override
    public void setUserPortfolio(IUserPortfolio userPortfolio) {
        this.userPortfolio = userPortfolio;
    }

    @Override
    public IGroup getGroup() {
        return group;
    }

    @Override
    public void setGroup(IGroup group) {
        this.group = group;
    }
}
