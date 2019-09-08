package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.enums.Role;
import com.itacademy.jd2.ml.linkedin.entity.table.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Indexed
public class UserAccount extends BaseEntity implements IUserAccount {

    @Column
    private String email;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String firstName;

    @Column
    private String lastName;

    @ManyToMany(targetEntity = Education.class, fetch = FetchType.LAZY, mappedBy = "users")
    private Set<IEducation> educations = new HashSet<>();

    @ManyToMany(targetEntity = Course.class, fetch = FetchType.LAZY, mappedBy = "users")
    private Set<ICourse> courses = new HashSet<>();

    @ManyToMany(targetEntity = WorkExperience.class, fetch = FetchType.LAZY, mappedBy = "users")
    private Set<IWorkExperience> workExperiences = new HashSet<>();

    @ManyToMany(targetEntity = Skill.class, fetch = FetchType.LAZY, mappedBy = "users")
    private Set<ISkill> skills = new HashSet<>();

    @Column
    private Date birthday;

    @Column
    private String jobTitle;

    @Column
    private String contactInfo;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Language.class)
    private ILanguage motherTongue;

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public Set<IEducation> getEducations() {
        return educations;
    }

    @Override
    public void setEducations(Set<IEducation> educations) {
        this.educations = educations;
    }

    @Override
    public Set<ICourse> getCourses() {
        return courses;
    }

    @Override
    public void setCourses(Set<ICourse> courses) {
        this.courses = courses;
    }

    @Override
    public Set<IWorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    @Override
    public void setWorkExperiences(Set<IWorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }

    @Override
    public Set<ISkill> getSkills() {
        return skills;
    }

    @Override
    public void setSkills(Set<ISkill> skills) {
        this.skills = skills;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Date getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public ILanguage getMotherTongue() {
        return motherTongue;
    }

    @Override
    public void setMotherTongue(ILanguage motherTongue) {
        this.motherTongue = motherTongue;
    }
}
