package com.itacademy.jd2.ml.linkedin.filter;

public class CourseFilter extends AbstractFilter {
    private Integer loggedCourseId;

    public Integer getLoggedCourseId() {
        return loggedCourseId;
    }

    public void setLoggedCourseId(Integer loggedCourseId) {
        this.loggedCourseId = loggedCourseId;
    }
}
