package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguageLevel;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LanguageLevel extends BaseEntity implements ILanguageLevel {

    @Column
    private String name;
    @Column
    private Integer priority;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getPriority() {
        return priority;
    }

    @Override
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
