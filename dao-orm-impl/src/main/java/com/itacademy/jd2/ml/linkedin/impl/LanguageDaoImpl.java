package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ILanguageDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.filter.LanguageFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Language;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanguageDaoImpl extends AbstractDaoImpl<ILanguage,Integer> implements ILanguageDao {
    protected LanguageDaoImpl() {
        super(Language.class);
    }

    @Override
    public List<ILanguage> find(LanguageFilter filter) {
        return null;
    }

    @Override
    public ILanguage createEntity() {
        Language language = new Language();
        return language;
    }
}
