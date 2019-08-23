package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguageLevel;
import com.itacademy.jd2.ml.linkedin.filter.LanguageLevelFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface ILanguageLevelService {
    ILanguageLevel createEntity();

    @Transactional
    void save(ILanguageLevel entity);

    ILanguageLevel get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    List<ILanguageLevel> getAll();

    List<ILanguageLevel> find(LanguageLevelFilter filter);
}
