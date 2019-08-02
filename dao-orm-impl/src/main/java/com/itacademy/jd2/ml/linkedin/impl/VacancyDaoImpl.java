package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IVacancyDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.filter.VacancyFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Vacancy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VacancyDaoImpl extends AbstractDaoImpl<IVacancy,Integer> implements IVacancyDao {

    protected VacancyDaoImpl() {
        super(Vacancy.class);
    }

    @Override
    public List<IVacancy> find(VacancyFilter filter) {
        return null;
    }

    @Override
    public IVacancy createEntity() {
        Vacancy vacancy = new Vacancy();
        return vacancy;
    }
}
