package com.itacademy.jd2.ml.linkedin.entity.table;

import com.itacademy.jd2.ml.linkedin.entity.enums.Role;

import java.util.Date;
import java.util.Set;

public interface IUserAccount extends IBaseEntity {
    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    Role getRole();

    void setRole(Role role);

    String getFirstName();

    void setFirstName(String firstName);

    Set<IEducation> getEducations();

    void setEducations(Set<IEducation> educations);

    Set<ICourse> getCourses();

    void setCourses(Set<ICourse> courses);

    Set<IWorkExperience> getWorkExperiences();

    void setWorkExperiences(Set<IWorkExperience> workExperiences);

    Set<ISkill> getSkills();

    void setSkills(Set<ISkill> skills);

    String getLastName();

    void setLastName(String lastName);

    Date getBirthday();

    void setBirthday(Date birthday);

    String getJobTitle();

    void setJobTitle(String jobTitle);

    String getContactInfo();

    void setContactInfo(String contactInfo);

    ILanguage getMotherTongue();

    void setMotherTongue(ILanguage motherTongue);
}
