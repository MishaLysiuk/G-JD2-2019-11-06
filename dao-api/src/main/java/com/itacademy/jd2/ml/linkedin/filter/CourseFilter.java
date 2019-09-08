package com.itacademy.jd2.ml.linkedin.filter;

public class CourseFilter extends AbstractFilter {

    private Integer loggedUserId;

    private String name;

    public Integer getLoggedUserId() {
        return loggedUserId;
    }

    public void setLoggedUserId(Integer loggedUserId) {
        this.loggedUserId = loggedUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
