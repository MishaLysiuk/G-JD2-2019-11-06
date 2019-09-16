package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.filter.VacancyFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface IVacancyService {
    IVacancy createEntity();

    @Transactional
    void save(IVacancy entity);

    IVacancy get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    List<IVacancy> getAll();

    List<IVacancy> find(VacancyFilter filter);

    List<IVacancy> findByCreatorId(Integer creatorId);

    long getCount(VacancyFilter filter);

    IVacancy getFullInfo(Integer id);

    List<IVacancy> findByCompany(String compamyName);

    List<IVacancy> findByJobTitle(String jobTitle);

    @Transactional
    List<IVacancy> searchByJobTitle(String jobTitle);

    List<IVacancy> findByCityId(Integer cityId);
}
