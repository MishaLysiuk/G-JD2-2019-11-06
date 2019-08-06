package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.enums.Role;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;

import javax.persistence.*;

@Entity
public class UserAccount extends BaseEntity implements IUserAccount {

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "model", targetEntity = UserPortfolio.class)
    private IUserPortfolio userPortfolio;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private Role roleId;

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
    public Role getRoleId() {
        return roleId;
    }

    @Override
    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
}
