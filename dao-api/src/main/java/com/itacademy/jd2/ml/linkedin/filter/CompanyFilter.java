package com.itacademy.jd2.ml.linkedin.filter;

public class CompanyFilter extends AbstractFilter {

    private Integer loggedCompanyId;

    public Integer getLoggedUserId() {
        return loggedCompanyId;
    }

    public void setLoggedUserId(Integer loggedUserId) {
        this.loggedCompanyId = loggedUserId;
    }
}
