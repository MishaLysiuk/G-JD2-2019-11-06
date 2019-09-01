package com.itacademy.jd2.ml.linkedin.entity.table;

import com.itacademy.jd2.ml.linkedin.entity.enums.Role;

import java.util.Date;

public interface IUserAccount extends IBaseEntity {
    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    Role getRole();

    void setRole(Role role);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    Date getBirthday();

    void setBirthday(Date birthday);

    String getJobTitle();

    void setJobTitle(String jobTitle);

    String getContactInfo();

    void setContactInfo(String contactInfo);

    String getMotherTongue();

    void setMotherTongue(String motherTongue);
}
