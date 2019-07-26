package com.itacademy.jd2.ml.linkedin.entity.table;

public interface ISkill extends IBaseEntity {
    String getName();

    void setName(String name);

    IUserPortfolio getUserPortfolio();

    void setUserPortfolio(IUserPortfolio userPortfolio);

    IGroup getGroup();

    void setGroup(IGroup group);
}
