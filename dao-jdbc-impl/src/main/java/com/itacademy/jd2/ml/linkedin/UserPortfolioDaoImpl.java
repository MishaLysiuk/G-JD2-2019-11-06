package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.UserPortfolio;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.filter.UserPortfolioFilter;

import java.util.List;

public class UserPortfolioDaoImpl extends AbstractDaoImpl<IUserPortfolio, Integer> implements IUserPortfolioDao {

    @Override
    protected String getTableName() {
        return "user_portfolio";
    }

    @Override
    public IUserPortfolio createEntity() {
        return new UserPortfolio();
    }

    @Override
    public void update(IUserPortfolio iUserPortfolio) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void insert(IUserPortfolio iUserPortfolio) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<IUserPortfolio> find(UserPortfolioFilter filter) {
        return null;
    }

    @Override
    public long getCount(UserPortfolioFilter filter) {
        return 0;
    }
}
