package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.UserAccount;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.UserAccountFilter;
import com.itacademy.jd2.ml.linkedin.util.PreparedStatementAction;
import com.itacademy.jd2.ml.linkedin.util.StatementAction;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class UserAccountDaoImpl extends AbstractDaoImpl<IUserAccount, Integer> implements IUserAccountDao {

    @Override
    protected String getTableName() {
        return "user_account";
    }

    @Override
    public IUserAccount createEntity() {
        return new UserAccount();
    }


    @Override
    public void insert(IUserAccount entity) {

        executeStatement(new PreparedStatementAction<IUserAccount>(
                String.format("insert into %s (email, password, role_id, created, updated) values(?,?,?,?,?)", getTableName()), true) {
            @Override
            public IUserAccount doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getEmail());
                pStmt.setString(2, entity.getPassword());
                pStmt.setInt(3, entity.getRoleId());
                pStmt.setObject(4, entity.getCreated(), Types.TIMESTAMP);
                pStmt.setObject(5, entity.getUpdated(), Types.TIMESTAMP);

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
    public void update(IUserAccount entity) {
        executeStatement(new PreparedStatementAction<IUserAccount>(
                String.format("update %s set email=?, password=?, role_id=?, updated=? where id=?", getTableName())) {
            @Override
            public IUserAccount doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getEmail());
                pStmt.setString(2, entity.getPassword());
                pStmt.setInt(3, entity.getRoleId());
                pStmt.setObject(4, entity.getUpdated(), Types.TIMESTAMP);
                pStmt.setInt(5, entity.getId());

                pStmt.executeUpdate();
                return entity;
            }
        });
    }


    @Override
    public void save(IUserAccount... entities) {

    }

    @Override
    public List<IUserAccount> find(UserAccountFilter filter) {
        final StringBuilder sqlTile = new StringBuilder("");
        appendSort(filter, sqlTile);
        appendPaging(filter, sqlTile);
        return executeFindQuery(sqlTile.toString());
    }

    @Override
    public long getCount(UserAccountFilter filter) {
        return 0;
    }

    @Override
    protected IUserAccount parseRow(final ResultSet resultSet) throws SQLException {
        final IUserAccount entity = createEntity();
        entity.setId((Integer) resultSet.getObject("id"));
        entity.setEmail(resultSet.getString("email"));
        entity.setPassword(resultSet.getString("password"));
        entity.setRoleId((Integer) resultSet.getObject("role_id"));
        entity.setCreated(resultSet.getTimestamp("created"));
        entity.setUpdated(resultSet.getTimestamp("updated"));
        return entity;
    }

    @Override
    public IUserAccount findByEmail(String email) {
        StatementAction<IUserAccount> action = (statement) -> {
            statement.executeQuery(String.format("select * from user_account where email='%s'", email));

            final ResultSet resultSet = statement.getResultSet();

            final boolean hasNext = resultSet.next();
            IUserAccount result = null;
            if (hasNext) {
                result = parseRow(resultSet);
            }

            resultSet.close();
            return result;
        };
        IUserAccount entityById = executeStatement(action);
        return entityById;
    }
}
