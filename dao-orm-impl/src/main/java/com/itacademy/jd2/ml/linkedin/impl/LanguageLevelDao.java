package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ILanguageLevelDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguageLevel;
import com.itacademy.jd2.ml.linkedin.filter.LanguageLevelFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.LanguageLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanguageLevelDao extends AbstractDaoImpl<ILanguageLevel, Integer> implements ILanguageLevelDao {
    protected LanguageLevelDao() {
        super(LanguageLevel.class);
    }

    @Override
    public List<ILanguageLevel> find(LanguageLevelFilter filter) {
        return null;
    }

    @Override
    public ILanguageLevel createEntity() {
        LanguageLevel languageLevel = new LanguageLevel();
        return languageLevel;
    }
}
