package com.itacademy.jd2.ml.linkedin.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroup;
import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;

public class Skill extends BaseEntity implements ISkill {

    private String name;

    private IUserPortfolio userPortfolio;

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

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", userPortfolio=" + userPortfolio +
                ", group=" + group +
                '}';
    }
}
