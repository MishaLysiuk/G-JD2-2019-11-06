package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguageLevel;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserLanguage;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class UserLanguage extends BaseEntity implements IUserLanguage {

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Language.class)
    private ILanguage language;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = LanguageLevel.class)
    private ILanguageLevel level;
    @Transient
    private IUserAccount user;

    @Override
    public ILanguage getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(ILanguage language) {
        this.language = language;
    }

    @Override
    public ILanguageLevel getLevel() {
        return level;
    }

    @Override
    public void setLevel(ILanguageLevel level) {
        this.level = level;
    }

    @Override
    public IUserAccount getUser() {
        return user;
    }

    @Override
    public void setUser(IUserAccount user) {
        this.user = user;
    }
}
