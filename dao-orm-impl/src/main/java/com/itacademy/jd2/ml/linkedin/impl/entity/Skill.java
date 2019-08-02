package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroup;
import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Skill extends BaseEntity implements ISkill {

    @Column
    private String name;

    @Transient
    private IUserAccount user;

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
    public IUserAccount getUser() {
        return user;
    }

    @Override
    public void setUser(IUserAccount user) {
        this.user = user;
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
