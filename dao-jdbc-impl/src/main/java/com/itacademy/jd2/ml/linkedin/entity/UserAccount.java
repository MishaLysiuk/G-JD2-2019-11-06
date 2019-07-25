package com.itacademy.jd2.ml.linkedin.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;

public class UserAccount extends BaseEntity implements IUserAccount {

    private String email;
    private String password;
    private Integer roleId;

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Integer getRoleId() {
        return roleId;
    }

    @Override
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
