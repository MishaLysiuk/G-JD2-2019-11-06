package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.filter.UserPortfolioFilter;

import java.util.List;

public interface IUserPortfolioDao extends IDao<IUserPortfolio, Integer> {

    void save(IUserPortfolio... entities);

    List<IUserPortfolio> find(UserPortfolioFilter filter); // skip


    long getCount(UserPortfolioFilter filter); // skip

}
