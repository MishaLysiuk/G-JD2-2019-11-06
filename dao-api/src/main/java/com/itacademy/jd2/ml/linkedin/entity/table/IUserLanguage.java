package com.itacademy.jd2.ml.linkedin.entity.table;

public interface IUserLanguage extends IBaseEntity {

    ILanguage getLanguage();

    void setLanguage(ILanguage language);

    ILanguageLevel getLevel();

    void setLevel(ILanguageLevel level);

    IUserAccount getUser();

    void setUser(IUserAccount user);
}
