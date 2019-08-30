package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ICompanyDao;
import com.itacademy.jd2.ml.linkedin.ICompanyService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.filter.CompanyFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService {

    private ICompanyDao dao;

    @Autowired
    public CompanyServiceImpl(ICompanyDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public ICompany createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final ICompany entity) {
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
    public ICompany get(final Integer id) {
        final ICompany entity = dao.get(id);
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
    public List<ICompany> getAll() {
        final List<ICompany> all = dao.selectAll();
        return all;
    }



    @Override
    public List<ICompany> find(CompanyFilter filter) {
        return dao.find(filter);
    }

    @Override
    public long getCount(CompanyFilter filter) {
        return dao.getCount(filter);
    }

    @Override
    public List<ICompany> findByName(String name) {
        List<ICompany> companies = dao.findByName(name);
        return companies;
    }


}
