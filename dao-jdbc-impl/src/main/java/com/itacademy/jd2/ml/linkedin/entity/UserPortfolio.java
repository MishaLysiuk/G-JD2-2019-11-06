package com.itacademy.jd2.ml.linkedin.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;

public class UserPortfolio extends BaseEntity implements IUserPortfolio {

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "UserPortfolio{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}
