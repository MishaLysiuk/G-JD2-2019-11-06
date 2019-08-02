package com.itacademy.jd2.ml.linkedin.entity.table;

public interface ISkill extends IBaseEntity {
    String getName();

    void setName(String name);

    IUserAccount getUser();

    void setUser(IUserAccount user);

    IGroup getGroup();

    void setGroup(IGroup group);
}
