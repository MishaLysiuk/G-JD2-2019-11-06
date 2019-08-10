package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.filter.LanguageFilter;

import java.util.List;

public interface ILanguageService {
    ILanguage createEntity();

    void save(ILanguage entity);

    ILanguage get(Integer id);

    void delete(Integer id);

    void deleteAll();

    List<ILanguage> getAll();

    List<ILanguage> find(LanguageFilter filter);
}
