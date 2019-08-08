package com.itacademy.jd2.ml.linkedin.entity.table;

import java.util.Set;

public interface ISkill extends IBaseEntity {

    String getName();

    void setName(String name);

    Set<IUserAccount> getUsers();

    void setUsers(Set<IUserAccount> users);

    IGroupSkill getGroup();

    void setGroup(IGroupSkill group);
}
