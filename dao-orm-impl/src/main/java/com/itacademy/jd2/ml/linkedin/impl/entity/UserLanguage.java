package com.itacademy.jd2.ml.linkedin.impl.entity;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguageLevel;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserLanguage;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class UserLanguage extends BaseEntity implements IUserLanguage {

    @Transient
    private ILanguage language;
    @Transient
    private ILanguageLevel level;
    @Transient
    private IUserPortfolio userPortfolio;

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
    public IUserPortfolio getUserPortfolio() {
        return userPortfolio;
    }

    @Override
    public void setUserPortfolio(IUserPortfolio userPortfolio) {
        this.userPortfolio = userPortfolio;
    }
}
