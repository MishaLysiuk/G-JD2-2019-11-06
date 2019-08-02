package com.itacademy.jd2.ml.linkedin.entity.table;

import com.itacademy.jd2.ml.linkedin.entity.enums.Role;

public interface IUserAccount extends IBaseEntity{
    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    Role getRoleId();

    void setRoleId(Role roleId);
}
