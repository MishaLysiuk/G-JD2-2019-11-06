package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.filter.UserPortfolioFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface IUserPortfolioService {
    IUserPortfolio get(Integer id);

    List<IUserPortfolio> getAll();

    @Transactional
    void save(IUserPortfolio entity);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    IUserPortfolio createEntity();

    List<IUserPortfolio> find(UserPortfolioFilter filter);

    long getCount(UserPortfolioFilter filter);
}
