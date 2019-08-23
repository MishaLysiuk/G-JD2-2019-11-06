package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserLanguage;
import com.itacademy.jd2.ml.linkedin.filter.UserLanguageFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface IUserLanguageService {
    IUserLanguage createEntity();

    @Transactional
    void save(IUserLanguage entity);

    IUserLanguage get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    List<IUserLanguage> getAll();

    List<IUserLanguage> find(UserLanguageFilter filter);
}
