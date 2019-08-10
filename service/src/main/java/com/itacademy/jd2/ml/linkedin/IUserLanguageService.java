package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserLanguage;
import com.itacademy.jd2.ml.linkedin.filter.UserLanguageFilter;

import java.util.List;

public interface IUserLanguageService {
    IUserLanguage createEntity();

    void save(IUserLanguage entity);

    IUserLanguage get(Integer id);

    void delete(Integer id);

    void deleteAll();

    List<IUserLanguage> getAll();

    List<IUserLanguage> find(UserLanguageFilter filter);
}
