package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.filter.LanguageFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface ILanguageService {
    ILanguage createEntity();

    @Transactional
    void save(ILanguage entity);

    ILanguage get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    List<ILanguage> getAll();

    List<ILanguage> find(LanguageFilter filter);
}
