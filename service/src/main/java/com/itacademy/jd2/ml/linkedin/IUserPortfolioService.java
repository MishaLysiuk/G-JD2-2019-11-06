package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.filter.UserPortfolioFilter;

import java.util.List;

public interface IUserPortfolioService {
    IUserPortfolio get(Integer id);

    List<IUserPortfolio> getAll();

    void save(IUserPortfolio entity);

    void save(IUserPortfolio... entities);

    void delete(Integer id);

    void deleteAll();

    IUserPortfolio createEntity();

    List<IUserPortfolio> find(UserPortfolioFilter filter);

    long getCount(UserPortfolioFilter filter);
}
