package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.UserPortfolio;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.filter.UserPortfolioFilter;
import com.itacademy.jd2.ml.linkedin.util.PreparedStatementAction;
import com.itacademy.jd2.ml.linkedin.util.SQLExecutionException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
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
    public void update(IUserPortfolio entity) {
        executeStatement(new PreparedStatementAction<IUserPortfolio>(
                String.format("update %s set first_name=?, updated=? where id=?", getTableName())) {
            @Override
            public IUserPortfolio doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getFirstName());
                pStmt.setObject(2, entity.getUpdated(), Types.TIMESTAMP);
                pStmt.setInt(3, entity.getId());

                pStmt.executeUpdate();
                return entity;
            }
        });
    }

    @Override
    public void save(IUserPortfolio... entities) {
        try (Connection c = getConnection()) {
            c.setAutoCommit(false);
            try {

                for (IUserPortfolio entity : entities) {
                    PreparedStatement pStmt = c.prepareStatement(
                            String.format("insert into %s (name, created, updated) values(?,?,?)", getTableName()),
                            Statement.RETURN_GENERATED_KEYS);

                    pStmt.setString(1, entity.getFirstName());
                    pStmt.setObject(2, entity.getCreated(), Types.TIMESTAMP);
                    pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);

                    pStmt.executeUpdate();

                    final ResultSet rs = pStmt.getGeneratedKeys();
                    rs.next();
                    final int id = rs.getInt("id");

                    rs.close();
                    pStmt.close();
                    entity.setId(id);
                }

                // the same should be done in 'update' DAO method
                c.commit();
            } catch (final Exception e) {
                c.rollback();
                throw new RuntimeException(e);
            }

        } catch (final SQLException e) {
            throw new SQLExecutionException(e);
        }
    }

    @Override
    public List<IUserPortfolio> find(UserPortfolioFilter filter) {
        final StringBuilder sqlTile = new StringBuilder("");
        appendSort(filter, sqlTile);
        appendPaging(filter, sqlTile);
        return executeFindQuery(sqlTile.toString());
    }

    @Override
    public long getCount(UserPortfolioFilter filter) {
        return executeCountQuery("");
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
