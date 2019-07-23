package com.itacademy.jd2.ml.linkedin.entity.table;

public interface IUserAccount extends IBaseEntity {
    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    Integer getRoleId();

    void setRoleId(Integer role_id);
}
