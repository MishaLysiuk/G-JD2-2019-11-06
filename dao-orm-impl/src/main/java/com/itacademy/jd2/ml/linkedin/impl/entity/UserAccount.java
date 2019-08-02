package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class UserAccount extends BaseEntity implements IUserAccount {

    @Column
    private String email;
    @Column
    private String password;
    @Column
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
}
