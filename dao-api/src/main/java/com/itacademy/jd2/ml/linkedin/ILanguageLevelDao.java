package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguageLevel;
import com.itacademy.jd2.ml.linkedin.filter.LanguageLevelFilter;

import java.util.List;

public interface ILanguageLevelDao extends IDao<ILanguageLevel, Integer> {

    List<ILanguageLevel> find(LanguageLevelFilter filter);

}
