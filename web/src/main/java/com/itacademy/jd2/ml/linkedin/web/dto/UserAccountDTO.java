package com.itacademy.jd2.ml.linkedin.web.dto;

import com.itacademy.jd2.ml.linkedin.entity.enums.Role;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class UserAccountDTO {

    private Integer id;
    @Size(min = 1, max = 50)
    private String email;
    @Size(min = 1, max = 50)
    private String password;
    private Role role;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String jobTitle;
    private String contactInfo;
    @NotNull
    private Integer motherTongueId;
    private String motherTongueName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role roleId) {
        this.role = roleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Integer getMotherTongueId() {
        return motherTongueId;
    }

    public void setMotherTongueId(Integer motherTongueId) {
        this.motherTongueId = motherTongueId;
    }

    public String getMotherTongueName() {
        return motherTongueName;
    }

    public void setMotherTongueName(String motherTongueName) {
        this.motherTongueName = motherTongueName;
    }
}
