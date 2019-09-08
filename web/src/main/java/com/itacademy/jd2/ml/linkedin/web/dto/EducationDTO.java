package com.itacademy.jd2.ml.linkedin.web.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class EducationDTO {

    private Integer id;
    private String university;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @NotNull
    private Integer specialityId;
    private String  specialityName;
    @NotNull
    private Integer degreeId;
    private String  degreeName;
    private String address;

}
