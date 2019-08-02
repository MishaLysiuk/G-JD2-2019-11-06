package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserLanguage;
import com.itacademy.jd2.ml.linkedin.filter.UserLanguageFilter;

import java.util.List;

public interface IUserLanguageDao extends IDao<IUserLanguage, Integer> {

    List<IUserLanguage> find(UserLanguageFilter filter);

}
