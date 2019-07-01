package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IUserPortfolioDao;
import com.itacademy.jd2.ml.linkedin.IUserPortfolioService;
import com.itacademy.jd2.ml.linkedin.UserPortfolioDaoImpl;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.filter.UserPortfolioFilter;

import java.util.Date;
import java.util.List;

public class UserPortfolioServiceImpl implements IUserPortfolioService {

    private IUserPortfolioDao dao = new UserPortfolioDaoImpl();

    @Override
    public IUserPortfolio createEntity() {
        return dao.createEntity();
    }

    @Override
    public void save(final IUserPortfolio entity) {
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
    public void save(IUserPortfolio... entities) {
        Date modified = new Date();
        for (IUserPortfolio entity : entities) {

            entity.setUpdated(modified);
            entity.setCreated(modified);
        }

        dao.save(entities);
    }

    @Override
    public IUserPortfolio get(final Integer id) {
        final IUserPortfolio entity = dao.get(id);
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
    public List<IUserPortfolio> getAll() {
        final List<IUserPortfolio> all = dao.selectAll();
        return all;
    }



    @Override
    public List<IUserPortfolio> find(UserPortfolioFilter filter) {
        return dao.find(filter);
    }

    @Override
    public long getCount(UserPortfolioFilter filter) {
        return dao.getCount(filter);
    }
}
