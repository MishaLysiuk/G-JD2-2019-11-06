package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IUserLanguageDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserLanguage;
import com.itacademy.jd2.ml.linkedin.filter.UserLanguageFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.UserLanguage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserLanguageDaoImpl extends AbstractDaoImpl<IUserLanguage,Integer> implements IUserLanguageDao {
    protected UserLanguageDaoImpl() {
        super(UserLanguage.class);
    }

    @Override
    public List<IUserLanguage> find(UserLanguageFilter filter) {
        return null;
    }

    @Override
    public IUserLanguage createEntity() {
        return null;
    }
}
