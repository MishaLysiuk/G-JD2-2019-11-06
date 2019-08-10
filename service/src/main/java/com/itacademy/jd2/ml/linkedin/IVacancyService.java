package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.filter.VacancyFilter;

import java.util.List;

public interface IVacancyService {
    IVacancy createEntity();

    void save(IVacancy entity);

    IVacancy get(Integer id);

    void delete(Integer id);

    void deleteAll();

    List<IVacancy> getAll();

    List<IVacancy> find(VacancyFilter filter);
}
