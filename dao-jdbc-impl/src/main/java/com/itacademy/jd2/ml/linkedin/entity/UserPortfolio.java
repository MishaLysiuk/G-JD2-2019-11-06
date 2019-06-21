package com.itacademy.jd2.ml.linkedin.entity;

import com.itacademy.jd2.ml.linkedin.IUserPortfolio;

public class UserPortfolio extends BaseEntity implements IUserPortfolio {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserPortfolio{" +
                "name='" + name + '\'' +
                '}';
    }
}
