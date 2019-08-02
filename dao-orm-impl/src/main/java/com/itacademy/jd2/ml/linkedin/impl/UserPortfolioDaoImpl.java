package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IUserPortfolioDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.filter.UserPortfolioFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.UserPortfolio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserPortfolioDaoImpl extends AbstractDaoImpl<IUserPortfolio,Integer> implements IUserPortfolioDao {

    protected UserPortfolioDaoImpl(){
        super(UserPortfolio.class);
    }

    @Override
    public List<IUserPortfolio> find(UserPortfolioFilter filter) {
        return null;
    }

    @Override
    public long getCount(UserPortfolioFilter filter) {
        return 0;
    }

    @Override
    public IUserPortfolio createEntity() {
        UserPortfolio userPortfolio = new UserPortfolio();
        return userPortfolio;
    }
}
