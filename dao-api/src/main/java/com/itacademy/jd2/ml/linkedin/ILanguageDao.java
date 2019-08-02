package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.filter.LanguageFilter;

import java.util.List;

public interface ILanguageDao extends IDao<ILanguage, Integer> {

    List<ILanguage> find(LanguageFilter filter);

}
