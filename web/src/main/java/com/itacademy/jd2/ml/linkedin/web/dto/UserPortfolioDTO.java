package com.itacademy.jd2.ml.linkedin.web.dto;

import javax.validation.constraints.Size;
import java.util.Date;

public class UserPortfolioDTO {

    private Integer id;
    private Date created;
    private Date updated;
    @Size(min = 1, max = 50)
    private String firstName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
