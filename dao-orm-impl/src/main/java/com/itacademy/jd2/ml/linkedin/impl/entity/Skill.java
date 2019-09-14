package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroupSkill;
import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Skill extends BaseEntity implements ISkill {

    @Column
    private String name;

    @ManyToMany(targetEntity = UserAccount.class, fetch = FetchType.LAZY, mappedBy = "skills")
    private Set<IUserAccount> users = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = GroupSkill.class)
    private IGroupSkill group;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Set<IUserAccount> getUsers() {
        return users;
    }

    @Override
    public void setUsers(Set<IUserAccount> users) {
        this.users = users;
    }

    @Override
    public IGroupSkill getGroup() {
        return group;
    }

    @Override
    public void setGroup(IGroupSkill group) {
        this.group = group;
    }
}
