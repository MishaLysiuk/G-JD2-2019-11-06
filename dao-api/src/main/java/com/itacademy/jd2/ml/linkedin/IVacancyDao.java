package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.filter.VacancyFilter;

import java.util.List;

public interface IVacancyDao extends IDao<IVacancy, Integer> {

    List<IVacancy> find(VacancyFilter filter);

    List<IVacancy> findByCreatorId(Integer creatorId);

    long getCount(VacancyFilter filter);

    IVacancy getFullInfo(Integer id);

    List<IVacancy> findByCompany(String compamyName);

    List<IVacancy> findByJobTitle(String jobTitle);

    List<IVacancy> searchByJobTitle(String jobTitle);

    List<IVacancy> findByCityId(Integer cityId);

}
