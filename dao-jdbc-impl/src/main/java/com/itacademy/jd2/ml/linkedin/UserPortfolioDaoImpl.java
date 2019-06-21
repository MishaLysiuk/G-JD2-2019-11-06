package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.UserPortfolio;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.filter.UserPortfolioFilter;
import com.itacademy.jd2.ml.linkedin.util.PreparedStatementAction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
    public void insert(IUserPortfolio entity) {

        executeStatement(new PreparedStatementAction<IUserPortfolio>(
                String.format("insert into %s (first_name, created, updated) values(?,?,?)", getTableName()), true) {
            @Override
            public IUserPortfolio doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getFirstName());
                pStmt.setObject(2, entity.getCreated(), Types.TIMESTAMP);
                pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);

                pStmt.executeUpdate();

                final ResultSet rs = pStmt.getGeneratedKeys();
                rs.next();
                final int id = rs.getInt("id");

                rs.close();

                entity.setId(id);
                return entity;
            }
        });

    }

    @Override
    public List<IUserPortfolio> find(UserPortfolioFilter filter) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public long getCount(UserPortfolioFilter filter) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    protected IUserPortfolio parseRow(final ResultSet resultSet) throws SQLException {
        final IUserPortfolio entity = createEntity();
        entity.setId((Integer) resultSet.getObject("id"));
        entity.setFirstName(resultSet.getString("first_name"));
        entity.setCreated(resultSet.getTimestamp("created"));
        entity.setUpdated(resultSet.getTimestamp("updated"));
        return entity;
    }
}
