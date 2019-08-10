package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguageLevel;
import com.itacademy.jd2.ml.linkedin.filter.LanguageLevelFilter;

import java.util.List;

public interface ILanguageLevelService {
    ILanguageLevel createEntity();

    void save(ILanguageLevel entity);

    ILanguageLevel get(Integer id);

    void delete(Integer id);

    void deleteAll();

    List<ILanguageLevel> getAll();

    List<ILanguageLevel> find(LanguageLevelFilter filter);
}
