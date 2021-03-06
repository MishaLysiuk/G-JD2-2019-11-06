package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IVacancyDao;
import com.itacademy.jd2.ml.linkedin.IVacancyService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.filter.VacancyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VacancyServiceImpl implements IVacancyService {
    
    private IVacancyDao dao;

    @Autowired
    public VacancyServiceImpl(IVacancyDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public IVacancy createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final IVacancy entity) {
        final Date modifedOn = new Date();
        entity.setUpdated(modifedOn);
        if (entity.getId() == null) {
            entity.setCreated(modifedOn);
            dao.insert(entity);
        } else {
            dao.update(entity);
        }
    }


    @Override
    public IVacancy get(final Integer id) {
        final IVacancy entity = dao.get(id);
        return entity;
    }

    @Override
    public void delete(final Integer id) {
        dao.delete(id);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public List<IVacancy> getAll() {
        final List<IVacancy> all = dao.selectAll();
        return all;
    }

    @Override
    public List<IVacancy> find(VacancyFilter filter) {
        return dao.find(filter);
    }

    @Override
    public List<IVacancy> findByCreatorId(Integer creatorId) {
        return dao.findByCreatorId(creatorId);
    }

    @Override
    public long getCount(VacancyFilter filter) {
        return dao.getCount(filter);
    }

    @Override
    public IVacancy getFullInfo(final Integer id) {
        final IVacancy entity = dao.getFullInfo(id);
        return entity;
    }

    @Override
    public List<IVacancy> findByCompany(String compamyName) {
        return dao.findByCompany(compamyName);
    }

    @Override
    public List<IVacancy> findByJobTitle(String jobTitle) {
        return dao.findByJobTitle(jobTitle);
    }

    @Override
    public List<IVacancy> searchByJobTitle(String jobTitle) {
        return dao.searchByJobTitle(jobTitle);
    }

    @Override
    public List<IVacancy> findByCityId(Integer cityId) {
        return dao.findByCityId(cityId);
    }

}
