package com.itacademy.jd2.ml.linkedin.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;

import java.util.Date;

public class UserPortfolio extends BaseEntity implements IUserPortfolio {

    private String name;

    private Date created;

    private Date updated;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }

    @Override
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "UserPortfolio{" +
                "name='" + name + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
