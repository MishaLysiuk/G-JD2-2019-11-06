package com.itacademy.jd2.ml.linkedin.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroup;

public class Group extends BaseEntity implements IGroup {

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
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }
}
